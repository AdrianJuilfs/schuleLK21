package arrays.zahlen;

import hilfe.HJFrame;

import java.awt.*;

public class ZahlenAnwendungsFenster extends HJFrame {
    // globale Variablen
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private static final Color BACKGROUND = Color.WHITE;
    private static final Color FOREGROUND = Color.BLACK;
    private int zahl = 100;
    private int x = 50;
    private int y = 50;
    int[][] zahlArray = new int[10][10];


    public ZahlenAnwendungsFenster(final String title) {
        super(WIDTH, HEIGHT, BACKGROUND, FOREGROUND, title);
        // eigene Initialisierung
        for (int k = 0; k <= 9; k++) {
            for (int i = 0; i <= 9; i++) {
                zahlArray[i][k] = zahl;
                zahl++;
            }
        }
    }

    @Override
    public void myPaint(Graphics g) {
        // wird aufgerufen, wenn das Fenster neu gezeichnet wird
        for (int x = 0; x < zahlArray.length; x++) {
			for (int y = 0; y < zahlArray[0].length; y++) {
				g.drawString("" + zahlArray[x][y], x * 40 + 30, y * 40 + 50);
			}
		}
    }

    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ZahlenAnwendungsFenster anwendung = new ZahlenAnwendungsFenster("ZahlenAnwendungsFenster");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}