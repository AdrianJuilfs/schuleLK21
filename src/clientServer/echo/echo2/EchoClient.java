package clientServer.echo.echo2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class EchoClient extends JFrame {

    private JPanel contentPane;
    private JTextField txtServer;
    private JTextField txtVerbindung;
    private JTextField txtNachricht;
    private JTextArea txtA;
    private InputStreamReader in;
    private OutputStreamWriter out;
    private LeseThread lt;
    private Socket s;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EchoClient frame = new EchoClient();
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
    public EchoClient() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        txtServer = new JTextField();
        txtServer.setBounds(104, 0, 214, 21);
        contentPane.add(txtServer);
        txtServer.setColumns(10);

        txtVerbindung = new JTextField();
        txtVerbindung.setEditable(false);
        txtVerbindung.setBounds(104, 31, 214, 21);
        contentPane.add(txtVerbindung);
        txtVerbindung.setColumns(10);

        txtNachricht = new JTextField();
        txtNachricht.setEditable(false);
        txtNachricht.setBounds(104, 64, 214, 21);
        contentPane.add(txtNachricht);
        txtNachricht.setColumns(10);

        JButton btnVerbinden = new JButton("Verbinden");
        btnVerbinden.addActionListener(e -> verbinden());
        btnVerbinden.setBounds(335, -3, 103, 27);
        contentPane.add(btnVerbinden);

        JButton btnTrennen = new JButton("Trennen");
        btnTrennen.addActionListener(e -> trennen());
        btnTrennen.setBounds(335, 28, 103, 27);
        contentPane.add(btnTrennen);

        JButton btnSenden = new JButton("Senden");
        btnSenden.addActionListener(e -> senden());
        btnSenden.setBounds(335, 61, 103, 27);
        contentPane.add(btnSenden);

        JLabel lblVerbindung = new JLabel("Verbindung:");
        lblVerbindung.setBounds(12, 33, 92, 17);
        contentPane.add(lblVerbindung);

        JLabel lblServer = new JLabel("Server:");
        lblServer.setBounds(41, 2, 63, 17);
        contentPane.add(lblServer);

        JLabel lblNachricht = new JLabel("Nachricht:");
        lblNachricht.setBounds(22, 66, 74, 17);
        contentPane.add(lblNachricht);

        txtA = new JTextArea();
        txtA.setBounds(12, 95, 426, 156);
        contentPane.add(txtA);
    }

    private void trennen() {
    }

    private void verbinden() {
    }

    private void senden() {
    }
}
