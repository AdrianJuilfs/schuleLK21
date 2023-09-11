package dateizugriffe;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.*;

public class Notizbuch extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    DefaultListModel<String> notizbuch = new DefaultListModel<String>();
    JList<String> list = new JList(notizbuch);

    private final JLabel lblNotizbuch = new JLabel("Notizbuch");

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Notizbuch frame = new Notizbuch();
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
    public Notizbuch() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnSpeichern = new JButton("Speichern");
        btnSpeichern.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                speichern();
            }
        });
        btnSpeichern.setHorizontalAlignment(SwingConstants.LEFT);
        btnSpeichern.setBounds(328, 233, 100, 30);
        contentPane.add(btnSpeichern);

        textField = new JTextField();
        textField.setBounds(93, 238, 223, 21);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblHinzufgen = new JLabel("Hinzufügen:");
        lblHinzufgen.setBounds(12, 240, 93, 17);
        contentPane.add(lblHinzufgen);

        JButton btnNotizbuchLschen = new JButton("Notizbuch Löschen");
        btnNotizbuchLschen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                allesLoeschen();
            }
        });
        btnNotizbuchLschen.setBounds(272, 203, 156, 27);
        contentPane.add(btnNotizbuchLschen);

        JButton btnMakiertenEintragLschen = new JButton("Makierten Eintrag löschen");
        btnMakiertenEintragLschen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                einsLoeschen();
            }
        });
        btnMakiertenEintragLschen.setBounds(63, 203, 197, 27);
        contentPane.add(btnMakiertenEintragLschen);


        list.setBounds(12, 29, 406, 162);
        contentPane.add(list);
        lblNotizbuch.setFont(new Font("Dialog", Font.BOLD, 18));
        lblNotizbuch.setBounds(173, 0, 121, 35);
        contentPane.add(lblNotizbuch);

        JLabel lblNewLabel = new JLabel("Inhalt:");
        lblNewLabel.setBounds(22, 11, 59, 17);
        contentPane.add(lblNewLabel);
        lesen();
    }

    protected void lesen() {
        int zeichen;
        String leer = "";
        URL url = getClass().getResource("notizen.txt");
        notizbuch.clear();
        if (url == null) {
            JOptionPane.showMessageDialog(this, "Nix Datei digga!");
            return;
        }
        try (InputStream is = new FileInputStream(url.getFile());
             InputStreamReader in = new InputStreamReader(is, "UTF-8")) {
            while ((zeichen = in.read()) != -1) {
                if (((char) zeichen) != '$') {
                    leer += (char) zeichen;
                } else {
                    notizbuch.addElement(leer);
                    leer = "";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void schreiben() {
        URL url = getClass().getResource("notizen.txt");
        if (url == null) {
            JOptionPane.showMessageDialog(this, "Keine Notiz-Datei gefunden!");
            return;
        }
        try (OutputStream os = new FileOutputStream(url.getFile(), false);
             OutputStreamWriter out = new OutputStreamWriter(os, "UTF-8")) {
            for (int i = 0; i < notizbuch.getSize(); i++) {
                out.write(notizbuch.get(i) + "$");
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        lesen();
    }

    protected void allesLoeschen() {
        notizbuch.clear();
    }

    protected void einsLoeschen() {
        int index = list.getSelectedIndex();
        if (index != -1) {
            notizbuch.removeElementAt(index);
            schreiben();
        } else {
            JOptionPane.showMessageDialog(this, "Kein Eintrag ausgewählt");
        }
    }

    protected void speichern() {
        notizbuch.addElement(textField.getText());
        schreiben();
    }
}
