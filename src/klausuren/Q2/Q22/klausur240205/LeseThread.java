package klausuren.Q2.Q22.klausur240205;

import javax.swing.*;
import java.io.IOException;

public class LeseThread extends Thread {

	
	private RelativeMasseUmrechner main;
	private char c;
	private int zeichen;

	public LeseThread(RelativeMasseUmrechner rmu) {
		this.main = rmu;
	}
	

	@Override
	public void run()  {
		try {
			while((zeichen = main.in.read()) != -1) {
				c = (char) zeichen;
				switch (c) {
				case 'R':
					ruheMasseErmittelt();
// My: Das return ist "teuer": damit beendest du die Methode. In diesem Fall die run()
//     Methode. Und somit beendest du auch gleich den LeseThread. Was natürlich bitter ist,
//     da dein Client anschließend keine weiteren Daten vom Server liest ...
//     break statt return wäre richtig gewesen!
//     Nächste Zeile (und auch die folgenden Fälle) von mir entsprechend korrigiert.
// ==> 2-Punkte-Abzug (2c)
//					return;
					break;
				case 'N':
					relativeMasseErmittelt();
//					return;
					break;
				case '!':
					nichtLesbar();
//					return;
					break;
				case '#':
					negativeMasse();
//					return;
					break;
				case '&':
					cNichtVon0Bis100();
//					return;
					break;
				case '?':
					unbekannterBefehl();
//					return;
					break;
// My: Nicht von der Aufgabenstellung gefordert, aber trotzdem empfehlenswert: Ein default
//     um unerwartete Kommunikation bzw. Kommunikationsfehler erkennen zu können.
//     Nächste zwei Zeilen von mir eingefügt.
// → kein Punktabzug - nur als Verbesserungsvorschlag gemeint.
				default:
					System.out.println("DAS SOLLTE NICHT PASSIEREN");	
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	


	private void relativeMasseErmittelt() throws IOException {
		main.tfRuhemasse.setText(masse());
	}


	private void ruheMasseErmittelt() throws IOException {
		main.tfRelmasse.setText(masse());
	}
	
// My: Das gefällt mir! Und ich wäre zugegebener Maßen nicht darauf gekommen.
//     Diese Funktionalität in eine eigene Methode auszulagern und dann in den Methoden
//     relativeMasseErmittelt() und ruheMasseErmittelt() aufzurufen.
	private String masse() throws IOException {
		String masse = "";
		while ((zeichen = main.in.read()) != '!') {
			masse += (char) zeichen;
		}
		return masse;
	}
	
	private void cNichtVon0Bis100() {
		JOptionPane.showMessageDialog(main, "Die eingegebene Lichtgewschindigkeit in % ist nicht zwischen 0 - 100");
	}


	private void negativeMasse() {
		JOptionPane.showMessageDialog(main, "Es wurde eine negative Masse eingegeben");
	}


	private void nichtLesbar() {
		JOptionPane.showMessageDialog(main, "Eine der Eingegebenen Zahlen ist nicht lesbar");
	}

	private void unbekannterBefehl() {
		JOptionPane.showMessageDialog(main, "Unbekannter Befehl gesendet");
	}
}
