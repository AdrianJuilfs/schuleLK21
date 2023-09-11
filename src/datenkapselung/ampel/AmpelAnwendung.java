package datenkapselung.ampel;

import hilfe.HJFrame;

import javax.swing.*;
import java.awt.*;

public class AmpelAnwendung extends HJFrame {
    // globale Variablen
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private static final Color BACKGROUND = Color.WHITE;
    private static final Color FOREGROUND = Color.BLACK;
    private Ampel lennart;
    Timer timer;

    public AmpelAnwendung(final String title) {
        super(WIDTH, HEIGHT, BACKGROUND, FOREGROUND, title);
        // eigene Initialisierung
        lennart = new Ampel(50, 50);
        Timer timer = new Timer(600, this);
        timer.start();

    }

    @Override
    public void myPaint(Graphics g) {
        // wird aufgerufen, wenn das Fenster neu gezeichnet wird
        lennart.zeichnen(g);
    }

    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AmpelAnwendung anwendung = new AmpelAnwendung("AmpelAnwendung");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
