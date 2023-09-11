package klausuren.klausur09_05_22;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.Timer;

import hilfe.*;

public class SmileyAnwendung extends HJFrame {
	// globale Variablen
	private static final int WIDTH = 800;
	private static final int HEIGHT = 300;
	private static final Color BACKGROUND = Color.BLUE;
	private static final Color FOREGROUND = Color.BLACK;
	Smiley simp1 = new Smiley(30, 50);
	Smiley simp2 = new Smiley(150, 210);
	Smiley simp3 = new Smiley(300, 150);
	Smiley simp4 = new Smiley(400, 30);
	Smiley simp5 = new Smiley(600, 190);
	Smiley simp6 = new Smiley(700, 70);
	Timer timer;

	public SmileyAnwendung(final String title) {
		super(WIDTH, HEIGHT, BACKGROUND, FOREGROUND, title);
		Timer timer = new Timer(100, this);
		timer.start();
	}

	@Override
	public void myPaint(Graphics g) {
		// wird aufgerufen, wenn das Fenster neu gezeichnet wird
		simp1.zeichnen(g);
		simp2.zeichnen(g);
		simp3.zeichnen(g);
		simp4.zeichnen(g);
		simp5.zeichnen(g);
		simp6.zeichnen(g);
	}

	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SmileyAnwendung anwendung = new SmileyAnwendung("Adrian");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}