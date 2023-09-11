package farbenUndZufälle;

import hilfe.HJFrame;

import java.awt.*;

public class Farbsaeule extends HJFrame {
    // globale Variablen
    private static final int WIDTH = 520;
    private static final int HEIGHT = 520;
    private static final Color BACKGROUND = Color.BLACK;
    private static final Color FOREGROUND = Color.BLACK;

    public Farbsaeule(final String title) {
        super(WIDTH, HEIGHT, BACKGROUND, FOREGROUND, title);
        // eigene Initialisierung

    }

    public void farbsaeule(int x, int y, Graphics g) {
        Color rot = new Color(50, 0, 0);
        for (int i = 0; i < 8; i++) {
            g.setColor(rot);
            g.fillRect(x, y, 100, 50);
            rot = rot.brighter();
            y = y + 50;
        }
    }

    @Override
    public void myPaint(Graphics g) {
        // wird aufgerufen, wenn das Fenster neu gezeichnet wird
        farbsaeule(200, 70, g);
    }

    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Farbsaeule anwendung = new Farbsaeule("farbsaeule");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}