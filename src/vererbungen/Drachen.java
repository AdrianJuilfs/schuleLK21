package vererbungen;

import hilfe.HZeichnen;

import java.awt.*;

public class Drachen {

    private int x;
    private int y;
    private Color farbe = Color.GREEN;

    public Drachen(int x, int y, Color farbe) {
        this.x = x;
        this.y = y;
        this.farbe = farbe;
    }

    public void zeichnen(Graphics g, HZeichnen h) {
        g.setColor(farbe);
        h.fillDreieck(g, x, y + 40, x + 40, y, x + 80, y + 40);
    }
}
