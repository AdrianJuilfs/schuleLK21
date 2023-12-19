package clientServer.echo.echo5;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeseThread extends Thread {

    private JTextArea txtA;
    private InputStreamReader in;

    public LeseThread(InputStreamReader in, JTextArea txtA) {
        this.txtA = txtA;
        this.in = in;

    }


    @Override
    public void run() {
        super.run();
        int zeichen;
        try {
            while ((zeichen = in.read()) != -1) {
                if ((char) zeichen != '$') {
                    txtA.append("" + (char) zeichen);
                } else {
                    txtA.append(System.lineSeparator());
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
