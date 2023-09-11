package wiederholung.baelle;

import java.awt.*;

public class Ball {
    private int x;
    private int y;
    private int breite;
    private Color farbe;
    private int zaehler;
    private static int baelle;
    private boolean rechts = true;
    private int hinHer;

    public Ball(Color farbe) {
        x = 25;
        x = x + baelle * 50;
        y = 250;
        breite = 50;
        this.farbe = farbe;
        baelle++;
    }

    public void zeichnen(Graphics g) {
        g.setColor(farbe);
        if (rechts) {
            x = x + 2;
            if (x >= 425) {
                rechts = false;
            }
            if(zaehler++ == 2){
                g.fillOval(x, y, breite, breite);
            } else {
                y = 250 - (int) Math.sqrt(40000-(x-225)*(x-225));
                g.fillOval(x, y, breite, breite);
                zaehler = 0;
            }

        } else {
            x = x - 2;
            if (x <= 25) {
                rechts = true;
            }
            y = 250 + (int) Math.sqrt(40000-(x-225)*(x-225));
            g.fillOval(x, y, breite, breite);
        }

    }
}
