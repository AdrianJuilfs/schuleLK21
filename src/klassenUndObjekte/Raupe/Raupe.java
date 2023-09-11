package klassenUndObjekte.Raupe;

import java.awt.*;

public class Raupe {
    private int x;
    private int y;
    private int geschwindigkeit;
    private Color color;


    public Raupe(int x, int y, Color color, int v) {
        this.x = x;
        this.y = y;
        this.color = color;
        geschwindigkeit = v;
    }

    public void zeichnen(Graphics g, boolean bewegen) {
        g.setColor(color);
        g.fillOval(x, y, 20, 20);
        g.fillRect(x + 10, y, 60, 20);
        g.fillOval(x + 60, y, 20, 20);
        if (bewegen) {
            langeraupe(g);
            langeraupe(g);
            langeraupe(g);
            kurzeRaupe(g);
            kurzeRaupe(g);
            kurzeRaupe(g);
        }
    }

    private void kurzeRaupe(Graphics g) {
        g.fillOval(x, y, 20, 20);
        g.fillRect(x + 10, y, 30, 20);
        g.fillOval(x + 30, y, 20, 20);
        x = x + geschwindigkeit;
    }

    private void langeraupe(Graphics g) {
        g.fillOval(x, y, 20, 20);
        g.fillRect(x + 10, y, 60, 20);
        g.fillOval(x + 60, y, 20, 20);
    }

    public void bewegen(Graphics g) {
        zeichnen(g, true);

    }
}