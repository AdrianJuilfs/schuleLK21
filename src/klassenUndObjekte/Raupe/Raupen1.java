package klassenUndObjekte.Raupe;

import hilfe.HJFrame;

import javax.swing.*;
import java.awt.*;

public class Raupen1 extends HJFrame {
    // globale Variablen
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private static final Color BACKGROUND = Color.WHITE;
    private static final Color FOREGROUND = Color.BLACK;
    private Raupe testopfer1;

    public Raupen1(final String title) {
        super(WIDTH, HEIGHT, BACKGROUND, FOREGROUND, title);
        // eigene Initialisierung
        testopfer1 = new Raupe(50, 50, Color.YELLOW, 3);
        Timer timer = new Timer(300, this);
        timer.start();
    }

    @Override
    public void myPaint(Graphics g) {
        // wird aufgerufen, wenn das Fenster neu gezeichnet wird
        testopfer1.zeichnen(g, true);
    }

    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Raupen1 anwendung = new Raupen1("Raupen1");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}