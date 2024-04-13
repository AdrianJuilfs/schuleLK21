package clientServer.dateiinhalte.server;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DateiinhalteServer extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DateiinhalteServer frame = new DateiinhalteServer();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public DateiinhalteServer() {
        createGUI();
        verbinden();
    }

    private void verbinden() {
        // TODO Auto-generated method stub

    }

    private void createGUI() {
        // TODO Auto-generated method stub
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
    }

}
