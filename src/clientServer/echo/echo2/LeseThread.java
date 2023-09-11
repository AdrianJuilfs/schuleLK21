package clientServer.echo.echo2;

import javax.swing.*;
import java.io.InputStreamReader;

public class LeseThread extends Thread {
    private InputStreamReader in;
    private JTextArea txtA;
    public LeseThread(InputStreamReader in, JTextArea txtA) {
        this.in = in;
        this.txtA = txtA;
    }

    @Override
    public void run() {
        try {
            int zeichen;
            while ((zeichen = in.read()) != -1) {
                txtA.append(""+(char)zeichen+System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
