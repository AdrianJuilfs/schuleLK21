package clientServer.rechentrainer.server.server2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RechentrainerServer extends JFrame {

    private JPanel contentPane;

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
        serverStarten();
    }

    private void serverStarten() {
        // TODO Auto-generated method stub
        ClientThread ct = new ClientThread();
        ct.start();
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
