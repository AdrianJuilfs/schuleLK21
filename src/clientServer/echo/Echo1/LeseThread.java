package clientServer.echo.Echo1;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeseThread extends Thread {
    private JTextArea textArea;
    private InputStreamReader in;

    public LeseThread(InputStreamReader in, JTextArea textArea) {
        this.in = in;
        this.textArea = textArea;

    }

    @Override
    public void run() {
        int zeichen;
        try {
            while ((zeichen = in.read()) != -1) {
                textArea.append("" + (char) zeichen);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
