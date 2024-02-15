package klausuren.ePhase.klausur09_05_22;


import java.awt.*;
import java.util.Iterator;

public class Smiley {
	private int x;
	private int y;
// My: Das ist der richtige Lösungsansatz für die Bonusaufgabe (Klassenvariable)
	static private int zaehler;
	private boolean zwinkern = false;

	public Smiley(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void zeichnen(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval(x, y, 80, 80);
		g.setColor(Color.BLACK);
// My: So klappt das mit dem Zwinern von jedem dritten Smiley allerdings nur zufällig!
//     Und nur deshalb, weil du eine durch drei teilbare Anzahl von Smileys hast.
//     Wenn du es mal mit 5 oder 7 Smileys versuchst wirst du es sehen.
//     Bitte mit der Musterlösung vergleichen.
// ==> 3 von 6 Punkten (Bonusaufgabe)
		if (zaehler++ % 3 == 0) {
			if (zwinkern) {
				g.drawOval(x + 20, y + 20, 10, 10);
				g.fillOval(x + 50, y + 20, 10, 10);
				g.fillOval(x + 20, y + 50, 40, 10);
				bewegen(g);
				zwinkern = !zwinkern;
			} else {
				g.fillOval(x + 20, y + 20, 10, 10);
				g.drawOval(x + 50, y + 20, 10, 10);
				g.fillOval(x + 20, y + 50, 40, 10);
				bewegen(g);
				zwinkern = !zwinkern;
			}
		} else {
			g.fillOval(x + 20, y + 20, 10, 10);
			g.fillOval(x + 50, y + 20, 10, 10);
			g.fillOval(x + 20, y + 50, 40, 10);
			bewegen(g);
		}
	}

	private boolean nachUnten() {
		if (oben()) {
			return true;
		} else {
			return false;
		}
	}

	private boolean oben() {
		if (y >= 25) {
			return true;
		} else {
			return false;
		}
	}

	private boolean unten() {
		if (y <= 220) {
			return true;
		} else {
			return false;
		}
	}

// My: Diese Teilaufgabe war wirklich schwer!
//     Bitte mit der Musterlösung vergleichen
// ==> 4 von 6 Punkten
	private void bewegen(Graphics g) {
		if (nachUnten()) {
			y = y - 1;
		} else {
			if (y < 25) {
				y = y + 1;
			} else {
				y = y - 1;
			}
		}
	}
}