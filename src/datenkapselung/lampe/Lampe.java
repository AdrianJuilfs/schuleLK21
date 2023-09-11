package datenkapselung.lampe;

import java.awt.*;

public class Lampe {
    private Color farbe = Color.BLUE;
    private int x = 50;
    private int y = 50;
    private boolean anAus = false;

    public Lampe(int x, int y, Color farbe) {
        this.x = x;
        this.y = y;
        this.farbe = farbe;
        this.anAus = anAus;
    }

    public void zeichnen(Graphics g) {

        if (anAus) {
            g.setColor(farbe);
            g.fillOval(x, y, 20, 20);
            //anAus = !anAus;
        } else {
            g.setColor(Color.GRAY);
            g.fillOval(x, y, 20, 20);
            //anAus = !anAus;
        }
    }

    public void an() {
        anAus = true;
    }

    public void aus() {
        anAus = false;
    }

}
