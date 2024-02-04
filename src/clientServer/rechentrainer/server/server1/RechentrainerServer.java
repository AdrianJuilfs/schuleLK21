package clientServer.rechentrainer.server.server1;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RechentrainerServer extends JFrame {

    private JPanel contentPane;
    private JTextField tfVerbindungen;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RechentrainerServer frame = new RechentrainerServer();
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
    public RechentrainerServer() {
        createGUI();
        HauptThread ht = new HauptThread();
        ht.start();
    }

    private void createGUI() {
        // TODO Auto-generated method stub
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 397, 85);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblAnzahlVerbindungen = new JLabel("Anzahl Verbindungen");
        lblAnzahlVerbindungen.setBounds(12, 12, 126, 17);
        contentPane.add(lblAnzahlVerbindungen);

        tfVerbindungen = new JTextField();
        tfVerbindungen.setEditable(false);
        tfVerbindungen.setBounds(193, 10, 114, 21);
        contentPane.add(tfVerbindungen);
        tfVerbindungen.setColumns(10);
    }
}
