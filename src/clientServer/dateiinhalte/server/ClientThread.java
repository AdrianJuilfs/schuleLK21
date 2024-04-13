package clientServer.dateiinhalte.server;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.net.URLDecoder;

import static java.lang.System.in;
import static java.lang.System.out;

public class ClientThread extends Thread {
    private Socket s;
    private static int GEHEIM_MODUS_AN = 2;
    private static int NORMALER_MODUS = 1;
    private int zustand = 1;
    private InputStreamReader inNet;
    private InputStreamReader inFile;
    private OutputStreamWriter outNet;
    private OutputStreamWriter outFile;
    private String name;
    private static Object monitor;

    public ClientThread(Socket s) {
        this.s = s;
        try {
            inNet = new InputStreamReader(s.getInputStream(), "UTF-8");
            outNet = new OutputStreamWriter(s.getOutputStream(), "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        int zeichen;
        char c;
        try {
            while ((zeichen = inNet.read()) != -1) {
                c = (char) zeichen;
                switch (c) {
                    case '$':
                        passwortEinlesen();
                        break;
                    case '%':
                        geheimerModusAus();
                        break;
                    case '#':
                        passwortAendern();
                        break;
                    default:
                        if (Character.isLowerCase(c)) {
                            dateiSenden(c);
                        }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void geheimerModusAus() throws IOException {
        zustand = NORMALER_MODUS;
        outNet.write("Geheimermodus deaktiviert \n");
    }

    private void passwortAendern() throws IOException {
        URL url = getClass().getResource("passwort.txt");
        OutputStream fileOut = new FileOutputStream(URLDecoder.decode(url.getFile(), "UTF-8"));
        OutputStreamWriter outFile = new OutputStreamWriter(fileOut, "UTF-8");
        String neuesPasswort = "";
        int zeichen;
        if (zustand == GEHEIM_MODUS_AN) {
            synchronized (monitor) {
                while ((zeichen = in.read()) != '#') {
                    neuesPasswort += (char) zeichen;
                }
                outFile.write(neuesPasswort);
                out.flush();
            }
        }
    }

    private void passwortEinlesen() {
        int zeichen;
        char c;
        String clientPW = "";
        String filePW = "";
        URL url = getClass().getResource("passwort.txt");
        try (
                InputStream fileOut = new FileInputStream(URLDecoder.decode(url.getFile(), "UTF-8"));
                InputStreamReader inFile = new InputStreamReader(fileOut, "UTF-8");) {
            while ((zeichen = inNet.read()) != '$') {
                c = (char) zeichen;
                clientPW += c;
            }
            while ((zeichen = inFile.read()) != -1) {
                c = (char) zeichen;
                filePW += c;
            }
            if (filePW.equals(clientPW)) {
                zustand = GEHEIM_MODUS_AN;
                outNet.write("Geheimermodus an \n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void dateiSenden(char c) throws IOException {
        if (zustand == GEHEIM_MODUS_AN) {
            URL url = getClass().getResource(c + ".txt");
            String dateiInhalt = "";
            int zeichen;
            try (InputStream fileOut = new FileInputStream(URLDecoder.decode(url.getFile(), "UTF-8"));
                 InputStreamReader inFile = new InputStreamReader(fileOut, "UTF-8");) {
                while ((zeichen = inFile.read()) != -1) {
                    dateiInhalt += (char) zeichen + "";
                }
                outNet.write(dateiInhalt);
                outNet.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            outNet.write("Bro du nix haben Rechte");
            outNet.flush();
        }
    }
}