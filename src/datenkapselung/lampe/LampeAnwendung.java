package datenkapselung.lampe;

import hilfe.HJFrame;

import javax.swing.*;
import java.awt.*;

public class LampeAnwendung extends HJFrame {
    // globale Variablen
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private static final Color BACKGROUND = Color.WHITE;
    private static final Color FOREGROUND = Color.BLACK;
    private Timer timer;
    private Lampe opfer1;


    public LampeAnwendung(final String title) {
        super(WIDTH, HEIGHT, BACKGROUND, FOREGROUND, title);
        // eigene Initialisierung
        timer = new Timer(200, this);
        timer.start();
        opfer1 = new Lampe(50, 50, Color.green);
    }

    @Override
    public void myPaint(Graphics g) {
        // wird aufgerufen, wen n das Fenster neu gezeichnet wird
        opfer1.zeichnen(g);


    }

    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LampeAnwendung anwendung = new LampeAnwendung("LampeAnwendung");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}