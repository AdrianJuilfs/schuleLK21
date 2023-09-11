package klassenUndObjekte.Blumen;

import java.awt.*;

public class Blume {
    private int x;
    private int y;
    static private int anzahl;
    private int verwelkt = 0;
    private Color farbe;


    public Blume(int x, int y) {
        this.x = x;
        this.y = y;
        anzahl++;
        switch (anzahl % 3) {
            case 0:
                farbe = Color.RED;
                break;
            case 1:
                farbe = Color.CYAN;
                break;
            case 2:
                farbe = Color.BLUE;
        }
    }

    public void zeichnen(Graphics g) {
        if (y > 100) {
            g.setColor(Color.YELLOW);
            g.fillOval(x + 20, y + 20, 20, 20);
            g.setColor(Color.GREEN);
            g.fillRect(x + 29, y + 40, 3, 99999);
            g.setColor(farbe);
            if (verwelkt < 200) {
                g.fillOval(x + 20, y, 20, 20);
                g.fillOval(x, y + 20, 20, 20);
                g.fillOval(x + 40, y + 20, 20, 20);
                g.fillOval(x + 20, y + 40, 20, 20);
                if (y > 100) {
                    y--;

                } else {
                    verwelkt++;
                }
            }
        }
    }
}
