package clientServer.rechentrainer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class RechentrainerClient extends JFrame {

    private JPanel contentPane;
    private JTextField tfVerbinden;
    private JTextField tfName;
    protected JTextField tfAufgabe;
    private JTextField tfLoesung;
    private JLabel lblAufgabe;
    private JLabel lblLsung;
    private JButton btnStarten;
    private JButton btnLoesung;
    private InputStreamReader in;
    private OutputStreamWriter out;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RechentrainerClient frame = new RechentrainerClient();
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
    public RechentrainerClient() {
        createGUI();
    }

    private void verbinden() {
        try {
            Socket s = new Socket(tfVerbinden.getText(), 33333);
            in = new InputStreamReader(s.getInputStream(), "UTF-8");
            out = new OutputStreamWriter(s.getOutputStream(), "UTF-8");
            Lesethread lt = new Lesethread(this, in);
            lt.start();
            out.write(tfName.getText() + '$');
            out.flush();
            btnStarten.setEnabled(false);
            btnLoesung.setEnabled(true);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Keine Verbindung möglich");
        }

    }

    private void loesungSenden() {
        try {
            out.write(tfLoesung.getText() + '$');
            out.flush();
            tfLoesung.setText("");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    private void createGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        tfVerbinden = new JTextField();
        tfVerbinden.setBounds(85, 12, 114, 21);
        contentPane.add(tfVerbinden);
        tfVerbinden.setColumns(10);

        tfName = new JTextField();
        tfName.setBounds(85, 45, 114, 21);
        contentPane.add(tfName);
        tfName.setColumns(10);

        tfAufgabe = new JTextField();
        tfAufgabe.setEditable(false);
        tfAufgabe.setBounds(85, 148, 114, 21);
        contentPane.add(tfAufgabe);
        tfAufgabe.setColumns(10);

        tfLoesung = new JTextField();
        tfLoesung.setBounds(85, 178, 114, 21);
        contentPane.add(tfLoesung);
        tfLoesung.setColumns(10);

        JLabel lblServer = new JLabel("Server: ");
        lblServer.setBounds(9, 14, 58, 17);
        contentPane.add(lblServer);

        JLabel lblName = new JLabel("Name: ");
        lblName.setBounds(9, 47, 58, 17);
        contentPane.add(lblName);

        lblAufgabe = new JLabel("Aufgabe:");
        lblAufgabe.setBounds(9, 150, 58, 17);
        contentPane.add(lblAufgabe);

        lblLsung = new JLabel("Lösung:");
        lblLsung.setBounds(9, 180, 58, 17);
        contentPane.add(lblLsung);

        btnStarten = new JButton("starten");
        btnStarten.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                verbinden();
            }
        });
        btnStarten.setBounds(294, 42, 144, 27);
        contentPane.add(btnStarten);

        btnLoesung = new JButton("Lösung senden");
        btnLoesung.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loesungSenden();
            }
        });
        btnLoesung.setEnabled(false);
        btnLoesung.setBounds(294, 175, 144, 27);
        contentPane.add(btnLoesung);
    }
}
