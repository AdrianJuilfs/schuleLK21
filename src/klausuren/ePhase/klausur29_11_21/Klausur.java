package klausuren.ePhase.klausur29_11_21;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

public class Klausur extends JFrame {

	private JPanel contentPane;

	public Klausur() {
		super("Adrian");
		createGUI();
	}

	// Willkommen (Beispiel)
	void willkommen() {
		String name = JOptionPane.showInputDialog(this, "Wie heißt du?");
		JOptionPane.showMessageDialog(this, "Hallo " + name + "!");
		JOptionPane.showMessageDialog(this, "Viel Erfolg bei der Klausur!");
	}

	void aufg2() {
		// Aufgabe 2
		String alterString = JOptionPane.showInputDialog(this, "Wie alt bist du?");
		int alter = Integer.parseInt(alterString);
		if (alter < 21 && alter > 15) {
			JOptionPane.showMessageDialog(this, "In Ordnung");
		} else {
			JOptionPane.showMessageDialog(this, "Das glaube ich dir nicht");
		}
	}

	long fakultaet(int n) {
		long ergebnis = 1;
		for (int i = 1; i <= n; i++) {
			ergebnis = ergebnis * i;
		}
		return ergebnis;
	}

	void aufg3() {
		// Aufgabe 3
		// ich muss einbetten von (in Java zumindest) Methoden noch lernen
		String zahlString = JOptionPane.showInputDialog(this, "Gib mir ne Zahl");
// My: Der String muss noch in einen Integer-Wert umgewandelt werden!
//     Nächste Zeile von mir eingefügt
// ==> trägt bei zur Gesamtbewertung
		int n = Integer.parseInt(zahlString);
// My: Die gegebene Methode fakultaet() liefert als Rückgabewert einen Wert vom Datentyp long!
//     Nächste Zeile von mir korrigiert
// ==> trägt bei zur Gesamtbewertung
//		int n = fakultaet(ergebnis);
		long ergebnis = fakultaet(n);

// My: Nächste Zeilen von mir korrigiert.
// ==> trägt bei zur Gesamtbewertung
//		JOptionPane.showMessageDialog();
		JOptionPane.showMessageDialog(this, "Die Fakultät von " + n + " ist " + ergebnis);
// My: Gesamtbewertung
// ==> 2 von 6 Punkten
	}

	// hier einfügen: Methode fakultaet2()
	// ich muss einbetten von Methoden (in Java zumindest) noch lernen
// My: Parameterliste der Methode fakultaet2() von mir korrigiert.
//     Siehe Kommentar unten.
// ==> trägt bei zur Gesamtbewertung
//	long fakultaet2(long fakultaet, long anfangsfakultaet) {
	long fakultaet2(long fakultaet) {
// My: Du versuchst in der nächsten Zeile eine lokale Variable anfangsfakultaet
//     zu deklarieren. Aber du hattest bereits einen Parameter mit genau diesem
//     Namen. Dieser Parameter macht tatsächlich keinen Sinn (als Parameter).
//     Die lokale Variable anfangsfakultaet ist im Übrigen unnötig. Du deklarierst 
//     sie zwar, aber benutzt sie dann gar nicht.
//     Ich habe die Parameterliste deiner Methode korrigiert.
// ==> trägt bei zur Gesamtbewertung
		long i = fakultaet, anfangsfakultaet = fakultaet;
		fakultaet = 1;
		while (i > 0) {
			fakultaet = fakultaet * i;
			i = i - 1;
		}
		return fakultaet;
	}

	void aufg4() {
		// Aufgabe 4
		long anfangsfakultaet, fakultaet;
		String fakultaetString = JOptionPane.showInputDialog(this, "Gib eine Zahl an");
		fakultaet = Long.parseLong(fakultaetString);
// My: Statt die Methode fakultaet2() zu benutzen, programmierst du die Berechnung der Fakultät
//     hier erneut.
//     Hier sehe ich jetzt auch, wozu du die Variable anfangsfakultaet "brauchst". Wobei du sie
//     nicht wirklich brauchst, denn du hättest dafür ja die bereits existierende Variable 
//     fakultaetString benutzen können!
// ==> trägt bei zur Gesamtbewertung
		long i = fakultaet;
		anfangsfakultaet = fakultaet;
		fakultaet = 1;
		while (i > 0) {
			fakultaet = fakultaet * i;
			i = i - 1;
		}
		JOptionPane.showMessageDialog(this, "die Faklutät von " + anfangsfakultaet + " ist " + fakultaet);
// Gesamtbewertung
// ==> 4 von 8 Punkten
	}

	// hier einfügen: Methode schaltjahr()
	// ich muss einbetten von Methoden (in Java zumindest) noch lernen

	void aufg5() {
		// Aufgabe 5
		String jahrString = JOptionPane.showInputDialog(this, "Gib mir ne Jahreszahl");
		int jahr = Integer.parseInt(jahrString);
		if (jahr % 4 == 0) {
			JOptionPane.showMessageDialog(this, "Das Jahr " + jahr + "Ist ein schaltjahr");
		} else {
			JOptionPane.showMessageDialog(this, "Das Jahr " + jahr + "Ist kein schaltjahr");
		}
// ==> 4 von 8 Punkten (5a) - Abzug, weil nicht als Methode implementiert!
// ==> 6 von 6 Punkten (5b)
// ==> Aufgabenteile 5c und 5d nicht bearbeitet
	}

	void createGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 266, 236);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnWillkommen = new JButton("Willkommen");
		btnWillkommen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				willkommen();
			}
		});
		btnWillkommen.setBounds(12, 12, 228, 25);
		contentPane.add(btnWillkommen);

		JButton btnAufgabe1 = new JButton("Aufgabe 2: Alter");
		btnAufgabe1.setHorizontalAlignment(SwingConstants.LEFT);
		btnAufgabe1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				aufg2();
			}
		});
		btnAufgabe1.setBounds(12, 49, 228, 25);
		contentPane.add(btnAufgabe1);

		JButton btnAufgabe2 = new JButton("Aufgabe 3: Fakultät (for)");
		btnAufgabe2.setHorizontalAlignment(SwingConstants.LEFT);
		btnAufgabe2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				aufg3();
			}
		});
		btnAufgabe2.setBounds(12, 86, 228, 25);
		contentPane.add(btnAufgabe2);

		JButton btnAufgabe3 = new JButton("Aufgabe 4: Fakultät (while)");
		btnAufgabe3.setHorizontalAlignment(SwingConstants.LEFT);
		btnAufgabe3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				aufg4();
			}
		});
		btnAufgabe3.setBounds(12, 123, 228, 25);
		contentPane.add(btnAufgabe3);

		JButton btnAufgabe4 = new JButton("Aufgabe 5: Schaltjahr");
		btnAufgabe4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				aufg5();
			}
		});
		btnAufgabe4.setHorizontalAlignment(SwingConstants.LEFT);
		btnAufgabe4.setBounds(12, 160, 228, 25);
		contentPane.add(btnAufgabe4);

		setVisible(true);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Klausur frame = new Klausur();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
