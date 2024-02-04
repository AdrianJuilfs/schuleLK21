package clientServer.rechentrainer.server.server2;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Random;

public class ServerThread extends Thread {

    private Socket s;
    private InputStreamReader in;
    private OutputStreamWriter out;
    private char c;
    private int zeichen;
    private String aufgabe;
    private String meldung;
    private String name;
    private Random zufall;
    private String loesung;

    public ServerThread(Socket s) {
        this.s = s;
        try {
            in = new InputStreamReader(s.getInputStream(), "UTF-8");
            out = new OutputStreamWriter(s.getOutputStream(), "UTF-8");
            zufall = new Random();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        try {
            nameEinlesen();
            for (int i = 0; i < 5; i++) {
                aufgabeStellen();
                aufRichtigeLösungWarten();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void aufRichtigeLösungWarten() throws IOException {
        String empfangen = "";
        System.out.println("hi");
        while (!empfangen.equals(loesung)) {
            while ((zeichen = in.read()) != '$') {
                c = (char) zeichen;
                empfangen += c;
            }
            System.out.println(empfangen);
        }
    }

    private void aufgabeStellen() throws IOException {
        int nummer1 = zufall.nextInt(8) + 1;
        int nummer2 = zufall.nextInt(90);
        out.write("?" + nummer1 + " * " + nummer2 + "$");
        out.flush();
        loesung = (nummer1 * nummer2) + "";
    }

    private void nameEinlesen() throws IOException {
        while ((zeichen = in.read()) != '$') {
            c = (char) zeichen;
            name += c;
        }
    }
}
