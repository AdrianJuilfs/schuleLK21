package clientServer.rechentrainer.client;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lesethread extends Thread {
    private InputStreamReader in;
    int zeichen;
    private RechentrainerClient main;

    public Lesethread(RechentrainerClient RechentrainerClient, InputStreamReader in) {
        main = RechentrainerClient;
        this.in = in;
    }

    @Override
    public void run() {
        try {
            char c;
            while ((zeichen = in.read()) != -1) {
                c = (char) zeichen;
                switch (c) {
                    case '?':
                        aufgabeLesen(c);
                        break;
                    case '%':
                        meldungLesen(c);
                        break;
                    default:
                        JOptionPane.showMessageDialog(main, "ERROR");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void meldungLesen(char c) throws HeadlessException, IOException {
        String meldung = "";
        while ((c = (char) in.read()) != '$') {
            meldung += c + "";
        }
        JOptionPane.showMessageDialog(main, meldung);
    }

    private void aufgabeLesen(char c) throws IOException {
        String aufgabe = "";
        while ((c = (char) in.read()) != '$') {
            aufgabe += c + "";
            main.tfAufgabe.setText(aufgabe);
        }
    }
}
