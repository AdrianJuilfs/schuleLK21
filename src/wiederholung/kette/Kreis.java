package wiederholung.kette;

import java.awt.*;

public class Kreis {
    private int x;
    private int y;
    private Color farbe;
    private static int anzahl = 0;
    private int zaehler;

    public Kreis(int x, int y, Color farbe) {
        this.x = x;
        this.y = y;
        this.farbe = farbe;
        zaehler = anzahl;
        anzahl++;
    }

    public void zeichnen(Graphics g) {
        switch (zaehler++ % 6) {
            case 0:
            case 1:
                g.setColor(farbe);
                break;
            case 2:
                g.setColor(Color.ORANGE);
                break;
            case 3:
            case 4:
                g.setColor(farbe);
                break;
            case 5:
                g.setColor(Color.ORANGE);
        }
        g.fillOval(x, y, 40, 40);
    }
}