package eigeneProgramme;

import hilfe.HJFrame;

import java.awt.*;

public class geschachteltekreise extends HJFrame {
    // globale Variablen
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private static final Color BACKGROUND = Color.WHITE;
    private static final Color FOREGROUND = Color.BLACK;


    public geschachteltekreise(final String title) {
        super(WIDTH, HEIGHT, BACKGROUND, FOREGROUND, title);
        // eigene Initialisierung

    }

    public void deinemudda(Graphics g, int x, int y) {

        g.fillOval(y + 4, x + 6, 100, 100);
        g.setColor(Color.WHITE);
        g.fillOval(y + 6, x + 9, 90, 90);
        g.setColor(Color.BLACK);
        g.fillOval(y + 8, x + 12, 80, 80);
        g.setColor(Color.WHITE);
        g.fillOval(y + 10, x + 15, 70, 70);
        g.setColor(Color.BLACK);
        g.fillOval(y + 12, x + 18, 60, 60);
        g.setColor(Color.WHITE);
        g.fillOval(y + 14, x + 21, 50, 50);
        g.setColor(Color.BLACK);
        g.fillOval(y + 16, x + 24, 40, 40);
        g.setColor(Color.WHITE);
        g.fillOval(y + 18, x + 27, 30, 30);
        g.setColor(Color.BLACK);
        g.fillOval(y + 20, x + 30, 20, 20);

    }

    @Override
    public void myPaint(Graphics g) {
        // wird aufgerufen, wenn das Fenster neu gezeichnet wird
        deinemudda(g, 50, 50);

    }


    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    geschachteltekreise anwendung = new geschachteltekreise("geschachteltekreise");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
