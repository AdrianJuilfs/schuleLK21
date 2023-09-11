package dateizugriffe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.awt.event.ActionEvent;

public class ZahlenZaehlen extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    DefaultListModel<String> eingabe = new DefaultListModel<String>();
    JList<String> list = new JList<String>(eingabe);
    private final JButton btnZaehlen = new JButton("Zählen");

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ZahlenZaehlen frame = new ZahlenZaehlen();
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
    public ZahlenZaehlen() {
        setAutoRequestFocus(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        textField = new JTextField();
        textField.setBounds(97, 2, 152, 21);
        contentPane.add(textField);
        textField.setColumns(10);
        btnZaehlen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hinzufuegen();
            }

            protected void hinzufuegen() {
                URL url = getClass().getResource(textField.getText());
                try {
                    InputStream fileIn = new FileInputStream(URLDecoder.decode(url.getFile(), "UTF-8"));
                    InputStreamReader in = new InputStreamReader(fileIn, "UTF-8");
                    char c;
                    int anzahlZiffern = 0;
                    int anzahlGB = 0;
                    int anzahlKB = 0;
                    int anzahlSpace = 0;
                    int anzahlSonstige = 0;
                    int zeichen;
                    while ((zeichen = in.read()) != -1) {
                        c = (char) zeichen;
                        if (Character.isDigit(c)) {
                            anzahlZiffern++;
                        } else if (Character.isUpperCase(c)) {
                            anzahlGB++;
                        } else if (Character.isLowerCase(c)) {
                            anzahlKB++;
                        } else if (Character.isWhitespace(c)) {
                            anzahlSpace++;
                        } else {
                            anzahlSonstige++;
                        }
                        eingabe.clear();
                        eingabe.addElement("Anzahl Ziffern: " + anzahlZiffern);
                        eingabe.addElement("Anzahl Großbuchstaben: " + anzahlGB);
                        eingabe.addElement("Anzahl Kleinbuchhstaben: " + anzahlKB);
                        eingabe.addElement("Anzahl Spaces: " + anzahlSpace);
                        eingabe.addElement("Anzahl Sonstige Zeichen: " + anzahlSonstige);
                        System.out.println(eingabe);
                    }


                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        btnZaehlen.setBounds(317, 0, 99, 21);
        contentPane.add(btnZaehlen);

        JButton button = new JButton("...");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }


        });
        button.setBounds(261, -1, 44, 24);
        contentPane.add(button);

        list.setBounds(50, 35, 352, 189);
        contentPane.add(list);

        JLabel lblDateiname = new JLabel("Dateiname");
        lblDateiname.setBounds(23, 4, 92, 17);
        contentPane.add(lblDateiname);
    }
}
