package wiederholung.baelle;

import hilfe.HJFrame;

import javax.swing.*;
import java.awt.*;

public class BallAnwendung extends HJFrame {
    // globale Variablen
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    private static final Color BACKGROUND = Color.BLACK;
    private static final Color FOREGROUND = Color.WHITE;
    private Ball ball;
    private Ball ball2;
    private Ball ball3;
    private Ball ball4;
    private Ball ball5;
    private Ball ball6;
    private Ball ball7;
    private Ball ball8;
    private Timer timer;

    public BallAnwendung(final String title) {
        super(WIDTH, HEIGHT, BACKGROUND, FOREGROUND, title);
        // eigene Initialisierung
        ball = new Ball(Color.RED);
        ball2 = new Ball(Color.GREEN);
        ball3 = new Ball(Color.RED);
        ball4 = new Ball(Color.GREEN);
        ball5 = new Ball(Color.RED);
        ball6 = new Ball(Color.GREEN);
        ball7 = new Ball(Color.RED);
        ball8 = new Ball(Color.GREEN);
        timer = new Timer(10,this);
        timer.start();
    }

    @Override
    public void myPaint(Graphics g) {
        // wird aufgerufen, wenn das Fenster neu gezeichnet wird
        ball.zeichnen(g);
        ball2.zeichnen(g);
        ball3.zeichnen(g);
        ball4.zeichnen(g);
        ball5.zeichnen(g);
        ball6.zeichnen(g);
        ball7.zeichnen(g);
        ball8.zeichnen(g);

    }

    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BallAnwendung anwendung = new BallAnwendung("BallAnwendung");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}