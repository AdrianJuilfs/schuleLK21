package klassenUndObjekte.Blumen;

import hilfe.HJFrame;

import javax.swing.*;
import java.awt.*;

public class Blume1 extends HJFrame {
    // globale Variablen
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private static final Color BACKGROUND = Color.WHITE;
    private static final Color FOREGROUND = Color.BLACK;
    private Blume testopfer1;
    private Blume testopfer2;
    private Blume testopfer3;
    private Blume testopfer4;
    private Blume testopfer5;
    private Blume testopfer6;
    private Blume testopfer7;
    private Blume testopfer8;
    private Blume testopfer9;
    private Blume testopfer10;
    private Blume testopfer11;
    private Blume testopfer12;
    private Timer timer;

    public Blume1(final String title) {
        super(WIDTH, HEIGHT, BACKGROUND, FOREGROUND, title);
        // eigene Initialisierun
        testopfer1 = new Blume(50, 350);
        testopfer2 = new Blume(10, 300);
        testopfer3 = new Blume(200, 400);
        testopfer4 = new Blume(250, 250);
        testopfer5 = new Blume(400, 600);
        testopfer6 = new Blume(300, 280);
        testopfer7 = new Blume(500, 350);
        testopfer8 = new Blume(420, 300);
        testopfer9 = new Blume(340, 400);
        testopfer10 = new Blume(280, 250);
        testopfer11 = new Blume(120, 600);
        testopfer12 = new Blume(370, 280);
        Timer timer = new Timer(10, this);
        timer.start();
    }

    @Override
    public void myPaint(Graphics g) {
        // wird aufgerufen, wenn das Fenster neu gezeichnet wird
        testopfer1.zeichnen(g);
        testopfer2.zeichnen(g);
        testopfer3.zeichnen(g);
        testopfer4.zeichnen(g);
        testopfer5.zeichnen(g);
        testopfer6.zeichnen(g);
        testopfer7.zeichnen(g);
        testopfer8.zeichnen(g);
        testopfer9.zeichnen(g);
        testopfer10.zeichnen(g);
        testopfer11.zeichnen(g);
        testopfer12.zeichnen(g);

    }

    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Blume1 anwendung = new Blume1("Blume1");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}