package farbenUndZufälle;

import hilfe.HJFrame;

import java.awt.*;

public class Wald extends HJFrame {
    // globale Variablen
    private static final int WIDTH = 800;
    private static final int HEIGHT = 700;
    private static final Color BACKGROUND = new Color(18, 0, 255);
    private static final Color FOREGROUND = Color.BLACK;

    public Wald(final String title) {
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

    public void baumreihegroß(int baumx, Graphics g) {
        for (int i = 0; i < 5; i++) {
            baum(baumx, 50, g);
            baumx = baumx + 60;
        }
    }

    @Override
    public void myPaint(Graphics g) {
        // wird aufgerufen, wenn das Fenster neu gezeichnet wird
        int y = 220;
        int zaehler = 1;
        int baumx = 100;
        baum(100, 100, g);
        baum(20, 80, g);
        baum(200, 50, g);
        baumreihegroß(400, g);
        for (int o = 0; o < 6; o++) {
            for (int i = 0; i < 15; i++) {
                if (zaehler++ % 6 != 0)
                    baum(baumx, y, g);
                baumx = baumx + 40;
            }
            y = y + 70;
            baumx = baumx - 600;
        }
    }

    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Wald anwendung = new Wald("wald");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}