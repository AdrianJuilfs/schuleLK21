package klausuren.ePhase.klausur07_12_22;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CanSat extends JFrame {

	private JPanel contentPane;
	private JTextField eingabeTF;
	private DefaultListModel<String> eintraege = new DefaultListModel<String>();
// My: So wie bei DefaultListModel, handelt es sich auch bei JList um einen generischen Datentyp. Dieser sollte
//     idealerweise deshalb ebenso parameterisiert werden.
//     Nächste Zeile von mir korrigiert.
// ==> kein Punktabzug (nur als Verbesserungsvorschlag gemeint)
//	private JList list = new JList(eintraege);
	private JList<String> list = new JList<String>(eintraege);
	private int zaehler = 0;

	private String[] eintraegeFuerListModel = { "Geld: Sponsoren werben", "Sekundärmission: OpenCV kennen lernen",
			"Energie-Management: Konzept für Batterieversorgung entwickeln", "Geld: Buchhaltung",
			"Sonstige Technik: GPS", "Energie-Management: Energiebedarf testen/abschätzen", "Geld: Budget-Planung",
			"Energie-Management: Vergleich Raspberry 2 B vs. Raspberry Pi A+", "Sekundärmission: Prototyp entwickeln",
			"Öffentlichkeitsarbeit: Videos auf Youtube?",
			"Öffentlichkeitsarbeit: Kontakt zu Presse und Rundfunk/Fernsehen",
			"Energie-Management: Laufzeit maximieren", "Sonstige Technik: RTC", "Bergungssystem: Buzzer",
			"Sekundärmission: C#, Python und Java testen", "Primärmission: BMP180 an Raspberry Pi testen",
			"Kommunikation: geeignetes Funkmodul finden", "Sekundärmission: Rechenaufwand abschätzen",
			"Sekundärmission: Speicherbedarf abschätzen", "Kommunikation: Antenne testen und ggf. verbessern",
			"Öffentlichkeitsarbeit: Blog führen",
			"Sekundärmission: Software auf Raspberry Pi 2 und Raspberry Pi A+ testen", "Kommunikation: Bodenstation" };

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CanSat frame = new CanSat();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CanSat() {
		setTitle("Adrian");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		eingabeTF = new JTextField();
		eingabeTF.setBounds(10, 11, 266, 20);
		contentPane.add(eingabeTF);
		eingabeTF.setColumns(10);

		JButton hinzufuegenBtn = new JButton("Hinzufügen");
		hinzufuegenBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hinzufuegen();
			}
		});
		hinzufuegenBtn.setBounds(286, 10, 148, 23);
		contentPane.add(hinzufuegenBtn);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 424, 164);
		contentPane.add(scrollPane);

		scrollPane.setViewportView(list);

		JButton sortierenBtn = new JButton("Sortieren");
		sortierenBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sortieren();
			}
		});
		sortierenBtn.setBounds(10, 218, 424, 20);
		contentPane.add(sortierenBtn);

		JButton loeschenBtn = new JButton("Löschen");
		loeschenBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loeschen();
			}
		});
		loeschenBtn.setBounds(10, 249, 424, 20);
		contentPane.add(loeschenBtn);
	}

	protected void hinzufuegen() {
		eintraege.addElement(eingabeTF.getText());
// My: Es ist ungeschickt, dass du die Methode listModelInitialisieren an dieser Stelle aufrufst!
//     So wierd jedesmal, wenn du einen neuen Eintrag hinzufügen willst auch der gesamte Beispieldatensatz erneut mit hinzugefügt!
// ==> 1 Punkt Abzug (2b)
		listModelInitialisieren();
	}

// My: normale Variablen bzw. Objekte und Methoden sollten nach Java Naming Convention mit einem
//     Kleinbuchstaben beginnen und auch an Wortgrenzen Großbuchstaben verwenden (lowerCamelCase).
//     Von mir korrigiert.
// ==> kein Punktabzug - nur als Verbesserungsvorschlag gemeint.
//	private void ListModelInitialisieren() {
	private void listModelInitialisieren() {
		for (String eintrag : eintraegeFuerListModel) {
			eintraege.addElement(eintrag);
		}
	}

	protected void sortieren() {
		int index = list.getSelectedIndex();
		int anzahlEintraege = eintraege.size();
		System.out.println(index + " " + anzahlEintraege);
// My: Es sollte unabhängig davon, ob ein Listeneintrag ausgewählt war oder nicht, sortiert werden!
// ==> trägt bei zur Gesamtbewertung
		if (index > 0) {
			zaehler = index;
			String eintrag = eintraege.elementAt(index);
			if (eintrag.contains(":")) {
				int doppelpunkt = eintrag.indexOf(":");
				for (int i = 0; i < anzahlEintraege; i++) {
// My: Dieses if ergibt keinen Sinn, denn du hast genau diese Bedingung bereits im umgebenden if vorab geprüft!!
// ==> trägt bei zur Gesamtbewertung
					if (eintrag.contains(":")) {
						String substring1 = eintrag.substring(0, doppelpunkt);

						String substring2 = eintraege.elementAt(zaehler).substring(0, doppelpunkt);
// My: Nächste Zeile von mir eingefügt
						System.out.println("sortieren(): " + i + " " + substring1 + " " + substring2);
						if (substring1.equals(substring2)) {
// My: Die Idee hier (nächste drei Zeilen) ist an sich gar nicht so schlecht - aber tatsächlich eine Null-Operation:
//     Du fügst den gelöschten Eintrag wieder genau an der selben Stelle ein! So wird natürlich nichts sortiert!
// ==> trägt bei zur Gesamtbewertung
							String eintrag2 = eintraege.elementAt(zaehler);
							eintraege.removeElementAt(zaehler);
							eintraege.insertElementAt(eintrag2, zaehler);
							zaehler--;
							anzahlEintraege--;
						} else {
							zaehler++;
						}
					} else {
						eintraege.removeElementAt(zaehler);
					}
				}
			} else {
				return;
			}
		}
// My: Gesantbewertung 2d:
// ==> 3 von 10 Punkten
	}

	protected void loeschen() {
		int index = list.getSelectedIndex();
		if (index >= 0) {
			eintraege.removeElementAt(index);
// My: Den else-Zweig hättest du dir hier sparen können. Ist dir klar warum?
// ==> kein Punktabzug
		} else {
			return;
		}
	}
}
