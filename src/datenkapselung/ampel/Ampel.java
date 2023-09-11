package datenkapselung.ampel;

import datenkapselung.lampe.Lampe;

import java.awt.*;

public class Ampel {
    private int x;
    private int y;
    private int zaehler;
    private Lampe lennart1;
    private Lampe lennart2;
    private Lampe lennart3;


    public Ampel(int x, int y) {
        this.x = x;
        this.y = y;

        lennart1 = new Lampe(x + 5, y + 10, Color.RED);
        lennart2 = new Lampe(x + 5, y + 35, Color.YELLOW);
        lennart3 = new Lampe(x + 5, y + 60, Color.GREEN);

    }

    public void zeichnen(Graphics g) {
        g.fillRect(x, y, 30, 90);
        lennart1.zeichnen(g);
        lennart2.zeichnen(g);
        lennart3.zeichnen(g);
        lennart1.an();
        lennart2.an();
        lennart3.an();
    }

}