package guiKomponente;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Einkaufsliste extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    DefaultListModel<String> eintraege = new DefaultListModel<String>();
    JList<String> list = new JList<String>(eintraege);
    private String eintrag;
    private int doppelpunktIndex;
    private boolean loeschen = false;
    private int zaehler;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Einkaufsliste frame = new Einkaufsliste();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public Einkaufsliste() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 37, 416, 178);
        contentPane.add(scrollPane);
        scrollPane.setViewportView(list);


        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        textField = new JTextField();
        textField.setBounds(12, 0, 321, 29);
        contentPane.add(textField);
        textField.setColumns(10);

        JButton btnHinzufgen = new JButton("Hinzufügen");
        btnHinzufgen.addActionListener(e -> hinzufuegen());
        btnHinzufgen.setBounds(335, 1, 103, 27);
        contentPane.add(btnHinzufgen);

        JButton btnLoeschen = new JButton("Löschen");
        btnLoeschen.addActionListener(e -> loeschen());
        btnLoeschen.setBounds(335, 224, 103, 27);
        contentPane.add(btnLoeschen);

        JButton btnAlleEinerArtLoeschen = new JButton("Alle einer Art löschen");
        btnAlleEinerArtLoeschen.addActionListener(e -> alleLoeschen());
        btnAlleEinerArtLoeschen.setBounds(12, 227, 194, 27);
        contentPane.add(btnAlleEinerArtLoeschen);
    }

    protected void alleLoeschen() {
        zaehler = -1;
        int index = list.getSelectedIndex();
        int anzahlEintraege = eintraege.getSize();
        eintrag = eintraege.getElementAt(index);
        if (eintrag.contains(":")) {
            for (int x = 0; x < anzahlEintraege; x++) {
                zaehler++;
                doppelpunktIndex = eintrag.indexOf(":");
                String substring = eintrag.substring(0, doppelpunktIndex);
                String eintrag2 = eintraege.getElementAt(zaehler);
                if (eintrag2.contains(":")) {
                    doppelpunktIndex = eintrag2.indexOf(":");
                    String substring2 = eintrag2.substring(0, doppelpunktIndex);
                    System.out.println("substring 1 " + substring + " substring 2 " + substring2);
                    if (substring.equals(substring2)) {
                        loeschen = true;
                        removeEintrag(loeschen);
                    } else {
                        System.out.println("What");
                        loeschen = false;
                    }
                } else {
                    System.out.println("What2");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nothing to do");
        }
    }

    protected void removeEintrag(boolean loeschen) {
        if (loeschen) {
            eintraege.removeElementAt(zaehler);
            zaehler--;
        } else {
            zaehler++;
        }
    }

    protected void loeschen() {
        int index = list.getSelectedIndex();
        eintraege.removeElementAt(index);
    }

    protected void hinzufuegen() {
        eintraege.addElement(textField.getText());
    }
}
