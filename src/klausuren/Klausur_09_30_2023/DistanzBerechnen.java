package klausuren.Klausur_09_30_2023;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;
import java.net.URLDecoder;

public class DistanzBerechnen extends JFrame {

    private JPanel contentPane;
    private JTextField txtAnzahlKilometer;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DistanzBerechnen frame = new DistanzBerechnen();
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
    public DistanzBerechnen() {
        createGUI();
    }

    protected void createGUI() {
        setTitle("Adrian");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnBerechnen = new JButton("Kilometerleistung Berechnen");
        btnBerechnen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                berechnen();
            }
        });
        btnBerechnen.setBounds(46, 45, 349, 23);
        contentPane.add(btnBerechnen);

        JLabel lblNewLabel = new JLabel("Summe der gefahrenen Kilometer: ");
        lblNewLabel.setBounds(10, 154, 248, 23);
        contentPane.add(lblNewLabel);

        txtAnzahlKilometer = new JTextField();
        txtAnzahlKilometer.setEditable(false);
        txtAnzahlKilometer.setText("wow, such empty");
        txtAnzahlKilometer.setBounds(268, 155, 115, 20);
        contentPane.add(txtAnzahlKilometer);
        txtAnzahlKilometer.setColumns(10);
    }

    protected void berechnen() {
        URL url = getClass().getResource("daten.csv"); // import java.net.URL
        InputStream fileIn;
        double gesamtDouble = 0.0;
        try {
            int zeichen;
            String leer = "";
            fileIn = new FileInputStream(URLDecoder.decode(url.getFile(), "UTF-8"));
            InputStreamReader in = new InputStreamReader(fileIn, "UTF-8");
            while ((zeichen = in.read()) != -1) {
                if (((char) zeichen) != ';') {
//					System.out.println(zeichen);
                    leer += (char) zeichen;

                } else {
                    double leerDouble = Double.parseDouble(leer);
                    gesamtDouble += leerDouble;
                    leer = "";
                }
            }
//			System.out.println(gesamtDouble);
            String gesamtString = "" + gesamtDouble;
            txtAnzahlKilometer.setText(gesamtString + " km");

            URL url2 = getClass().getResource("ergebnis.txt"); // import java.net.URL
            OutputStream fileOut = new FileOutputStream(URLDecoder.decode(url2.getFile(), "UTF-8"));
            OutputStreamWriter out = new OutputStreamWriter(fileOut, "UTF-8");
            out.write("");
            out.write(gesamtString);
            out.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
