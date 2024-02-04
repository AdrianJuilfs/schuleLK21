package clientServer.rechentrainer.server.server1;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Random;

public class ClientThread extends Thread {

    private Socket s;
    private InputStreamReader in;
    private OutputStreamWriter out;
    private int zeichen;
    private char c;
    private String name = "";
    private String loesung;
    Random zufall = new Random();

    public ClientThread(Socket s) {
        this.s = s;
        try {
            in = new InputStreamReader(s.getInputStream(), "UTF-8");
            out = new OutputStreamWriter(s.getOutputStream(), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void run() {
        try {
            nameEinlesen();
            for (int i = 0; i < 5; i++) {
                aufgabeStellen();
                AufRichtigeLösungWarten();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void nameEinlesen() throws IOException {
        while ((zeichen = in.read()) != '$') {
            c = (char) zeichen;
            name += c;
        }
    }

    private void aufgabeStellen() throws IOException {
        int zahl1 = zufall.nextInt(8) + 2;
        int zahl2 = zufall.nextInt(90) + 1;
        loesung = (zahl1 * zahl2) + "";
        out.write("?" + zahl1 + " * " + zahl2 + "$");
        out.flush();
    }

    private void AufRichtigeLösungWarten() throws IOException {
        String empfangen = "";
        while (!empfangen.equals(loesung)) {
            while ((zeichen = in.read()) != '$') {
                c = (char) zeichen;
                empfangen += c;
            }

        }
    }

}
