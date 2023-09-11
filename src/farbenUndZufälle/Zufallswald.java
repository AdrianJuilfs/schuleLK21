package farbenUndZufälle;

import hilfe.HJFrame;

import java.awt.*;
import java.util.Random;

public class Zufallswald extends HJFrame {
    // globale Variablen
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private static final Color BACKGROUND = Color.WHITE;
    private static final Color FOREGROUND = Color.BLACK;

    public Zufallswald(final String title) {
        super(WIDTH, HEIGHT, BACKGROUND, FOREGROUND, title);
        // eigene Initialisierung

    }

    public void baum(int x, int y, Graphics g) {
        Color baumKrone = new Color(0, 100, 0);
        g.setColor(baumKrone);
        g.fillOval(x, y, 50, 50);
        Color baumstamm = new Color(139, 90, 43);
        g.setColor(baumstamm);
        g.fillRect(x + 20, y + 50, 10, 50);
    }

    @Override
    public void myPaint(Graphics g) {
        // wird aufgerufen, wenn das Fenster neu gezeichnet wird
        for (int i = 0; i < 50; i++) {
            Random zufallsgenerator = new Random();
            int zufallx = zufallsgenerator.nextInt(450);
            int zufally = zufallsgenerator.nextInt(450);
            baum(zufallx, zufally, g);
        }

    }

    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Zufallswald anwendung = new Zufallswald("zufallswald");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}