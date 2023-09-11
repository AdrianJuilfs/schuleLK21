package klassenUndObjekte.Hunde;

import hilfe.HJFrame;

import javax.swing.*;
import java.awt.*;

public class Hunde1 extends HJFrame {
    // globale Variablen
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private static final Color BACKGROUND = Color.WHITE;
    private static final Color FOREGROUND = Color.BLACK;
    private int i;
    private Hund testOpfer1;
    private Hund testOpfer2;
    private Hund testOpfer3;
    private Hund testOpfer4;

    public Hunde1(final String title) {
        super(WIDTH, HEIGHT, BACKGROUND, FOREGROUND, title);
        // eigene Initialisierung
        testOpfer1 = new Hund(50, 50, Color.GREEN);
        testOpfer2 = new Hund(80, 80, Color.darkGray);
        testOpfer3 = new Hund(120, 120, Color.YELLOW);
        testOpfer4 = new Hund(200, 200, Color.GREEN);
        Timer timer = new Timer(300, this);
        timer.start();
        int i;


    }

    @Override
    public void myPaint(Graphics g) {
        // wird aufgerufen, wenn das Fenster neu gezeichnet wird
        testOpfer1.stehen(g);
        if (i++ % 2 == 0) {
            testOpfer1.springen(g);
            testOpfer1.x += 30;
            testOpfer1.wedeln = true;

            testOpfer2.springen(g);
            testOpfer2.x += 30;
            testOpfer2.wedeln = true;
        } else {
            testOpfer1.wedeln = false;
            testOpfer1.stehen(g);
            testOpfer1.x += 30;

            testOpfer2.stehen(g);
            testOpfer2.x += 30;
            testOpfer2.wedeln = false;
        }
        if (testOpfer1.x > 500) {
            testOpfer1.x = 0;
        }
        if (testOpfer2.x > 500) {
            testOpfer2.x = 0;
        }
        g.drawString("Es gibt " + Hund.getAnzahlHunde() + " Hunde", 0, 400);
    }

    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Hunde1 anwendung = new Hunde1("Hunde1");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}