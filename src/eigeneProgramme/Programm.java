package eigeneProgramme;

import hilfe.HJFrame;

import javax.swing.*;
import java.awt.*;

public class Programm extends HJFrame {
    // globale Variablen
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private static final Color BACKGROUND = Color.BLACK;
    private static final Color FOREGROUND = Color.WHITE;

    public Programm(final String title) {
        super(WIDTH, HEIGHT, BACKGROUND, FOREGROUND, title);
        // eigene Initialisierung

    }

    public void gespenst(Graphics g, int x, int y) {
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, 50, 50);
        g.setColor(Color.BLACK);
        g.fillOval(x, y, 10, 10);
        g.fillOval(x, y, 10, 10);
        g.fillOval(x, y, 30, 10);
    }

    public void myPaint(Graphics g) {
        // wird au
        //    }
        //
        //    @Overridefgerufen, wenn das Fenster neu gezeichnet wird
        String xint = JOptionPane.showInputDialog(this, "was is x?");
        gespenst(g, 12, 12);
        String yint = JOptionPane.showInputDialog(this, "was is y?");
    }

    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Programm anwendung = new Programm("Programm");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}