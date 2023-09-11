package farbenUndZufälle;

import hilfe.HJFrame;

import java.awt.*;
import java.util.Random;

public class Diagonale extends HJFrame {
    // globale Variablen
    private static final int WIDTH = 520;
    private static final int HEIGHT = 520;
    private static final Color BACKGROUND = Color.BLACK;
    private static final Color FOREGROUND = Color.BLACK;

    public Diagonale(final String title) {
        super(WIDTH, HEIGHT, BACKGROUND, FOREGROUND, title);
        // eigene Initialisierung

    }

    @Override
    public void myPaint(Graphics g) {
        // wird aufgerufen, wenn das Fenster neu gezeichnet wird
        int x = 10;
        int y = 460;
        Random zufallsgenerator = new Random();
        g.setColor(Color.GREEN);
        for (int i = 0; i < 10; i++) {
            int zufallfarbe = zufallsgenerator.nextInt(3);
            switch (zufallfarbe) {
                case 0:
                    g.setColor(Color.GREEN);
                    break;
                case 1:
                    g.setColor(Color.RED);
                    break;
                case 2:
                    g.setColor(Color.YELLOW);
            }
            g.fillRect(x, y, 50, 50);
            x = x + 50;
            y = y - 50;
        }

    }

    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Diagonale anwendung = new Diagonale("diagonale");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}