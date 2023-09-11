package wiederholung.kette;

import hilfe.HJFrame;

import javax.swing.*;
import java.awt.*;


public class KreisAnwendung extends HJFrame {
    // globale Variablen
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private static final Color BACKGROUND = Color.BLACK;
    private static final Color FOREGROUND = Color.WHITE;
    private Kette krise;
    private Kette krise2;
    private Kette krise3;
    private Timer timer;

    public KreisAnwendung(final String title) {
        super(WIDTH, HEIGHT, BACKGROUND, FOREGROUND, title);
        // eigene Initialisierung
        //kris = new Kreis(50, 50, Color.BLUE);
        krise = new Kette(180, 100, Color.RED);
        krise2 = new Kette(50, 250, Color.BLUE);
        krise3 = new Kette(300, 250, Color.GREEN);
        timer = new Timer(500, this);
        timer.start();
    }

    @Override
    public void myPaint(Graphics g) {
        // wird aufgerufen, wenn das Fenster neu gezeichnet wird
        krise.zeichnen(g);
        krise2.zeichnen(g);
        krise3.zeichnen(g);
    }

    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    KreisAnwendung anwendung = new KreisAnwendung("KreisAnwendung");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}