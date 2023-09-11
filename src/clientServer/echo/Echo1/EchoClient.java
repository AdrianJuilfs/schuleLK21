package clientServer.echo.Echo1;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class EchoClient extends JFrame {

    private JPanel contentPane;
    private JTextField tftVerbinden;
    private JTextField tftSenden;

    public JTextArea textArea = new JTextArea();
    private InputStreamReader in;
    private OutputStreamWriter out;
    private LeseThread lT;
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
        createGUI();
    }

    private void createGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        tftVerbinden = new JTextField();
        tftVerbinden.setBounds(12, 12, 291, 32);
        contentPane.add(tftVerbinden);
        tftVerbinden.setColumns(10);

        tftSenden = new JTextField();
        tftSenden.setBounds(12, 45, 291, 32);
        contentPane.add(tftSenden);
        tftSenden.setColumns(10);

        JButton btnVerbinden = new JButton("Verbinden");
        btnVerbinden.addActionListener(e -> verbinden());
        btnVerbinden.setBounds(315, 14, 103, 27);
        contentPane.add(btnVerbinden);

        JButton btnSenden = new JButton("Senden");
        btnSenden.addActionListener(e -> senden());
        btnSenden.setBounds(315, 47, 103, 27);
        contentPane.add(btnSenden);

        textArea.setBounds(22, 89, 396, 120);
        contentPane.add(textArea);
        textArea.setEditable(false);

        JButton btnTrennen = new JButton("Trennen");
        btnTrennen.addActionListener(e -> trennen());
        btnTrennen.setBounds(182, 221, 103, 27);
        contentPane.add(btnTrennen);
    }

    private void trennen() {
        System.out.println("fuß");
    }

    private void senden() {
        try {
            String test = tftSenden.getText();
            out.write(test + System.lineSeparator());
            out.flush();
        } catch (IOException e) {
            throw new RuntimeException("Warnung: "+e);
        }
    }

    private void verbinden() {
        try {
            Socket s;
            s = new Socket(tftVerbinden.getText(), 2222);
            in = new InputStreamReader(s.getInputStream(), "UTF-8");
            out = new OutputStreamWriter(s.getOutputStream(), "UTF-8");
            LeseThread lt = new LeseThread(in, textArea);
            lt.start();
            System.out.println("it werks");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
