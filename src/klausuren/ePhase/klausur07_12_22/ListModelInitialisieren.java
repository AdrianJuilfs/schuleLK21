package klausuren.ePhase.klausur07_12_22;

import javax.swing.DefaultListModel;

public class ListModelInitialisieren {
	
	private DefaultListModel<String> listModel = new DefaultListModel<String>();
	
	private String[] eintraegeFuerListModel = {"Geld: Sponsoren werben", 
            "Sekundärmission: OpenCV kennen lernen",
            "Energie-Management: Konzept für Batterieversorgung entwickeln",
            "Geld: Buchhaltung",
            "Sonstige Technik: GPS",
            "Energie-Management: Energiebedarf testen/abschätzen",
            "Geld: Budget-Planung",
            "Energie-Management: Vergleich Raspberry 2 B vs. Raspberry Pi A+",
            "Sekundärmission: Prototyp entwickeln",
            "Öffentlichkeitsarbeit: Videos auf Youtube?",
            "Öffentlichkeitsarbeit: Kontakt zu Presse und Rundfunk/Fernsehen",
            "Energie-Management: Laufzeit maximieren",
            "Sonstige Technik: RTC",
            "Bergungssystem: Buzzer",
            "Sekundärmission: C#, Python und Java testen",
            "Primärmission: BMP180 an Raspberry Pi testen",
            "Kommunikation: geeignetes Funkmodul finden",
            "Sekundärmission: Rechenaufwand abschätzen",
            "Sekundärmission: Speicherbedarf abschätzen",
            "Kommunikation: Antenne testen und ggf. verbessern",
            "Öffentlichkeitsarbeit: Blog führen",
            "Sekundärmission: Software auf Raspberry Pi 2 und Raspberry Pi A+ testen",
            "Kommunikation: Bodenstation"};
	
	public ListModelInitialisieren() {
		for (String eintrag: eintraegeFuerListModel) {
			listModel.addElement(eintrag);
		}
	}
}
