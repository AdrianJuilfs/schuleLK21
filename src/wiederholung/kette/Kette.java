package wiederholung.kette;

import java.awt.*;
import java.util.Random;

public class Kette extends Kreis {
    private Kreis kreis1;
    private Kreis kreis2;
    private Kreis kreis3;
    private Kreis kreis4;
    private Kreis kreis5;
    private Kreis kreis6;
    private Random random;
    private int zaehler;


    public Kette(int x, int y, Color farbe) {
        super(x, y, farbe);
        kreis1 = new Kreis(x + 20, y, farbe);
        kreis2 = new Kreis(x + 60, y, farbe);
        kreis3 = new Kreis(x + 80, y + 40, farbe);
        kreis4 = new Kreis(x + 60, y + 80, farbe);
        kreis5 = new Kreis(x + 20, y + 80, farbe);
        kreis6 = new Kreis(x, y + 40, farbe);
        random = new Random();
    }

    public boolean anAus() {
        if (random.nextInt(2) == 1) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void zeichnen(Graphics g) {
        if (anAus()) {
            zaehler = random.nextInt(10) + 5;
        }
        if (zaehler-- > 5) {
            kreis1.zeichnen(g);
            kreis2.zeichnen(g);
            kreis6.zeichnen(g);
            kreis3.zeichnen(g);
            kreis4.zeichnen(g);
            kreis5.zeichnen(g);

        }
    }
}
