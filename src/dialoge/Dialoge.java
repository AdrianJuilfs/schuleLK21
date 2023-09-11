package dialoge;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dialoge extends JFrame {

    private JPanel contentPane;

    public Dialoge() {
        super("dialoge");
        createGUI();
    }

    private void createGUI() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 351, 340);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnAufg1 = new JButton("Aufgabe 1: Zahl zwischen 1 und 100?");
        btnAufg1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                aufg1();
            }
        });
        btnAufg1.setBounds(12, 12, 320, 25);
        contentPane.add(btnAufg1);

        JButton btnAufg2 = new JButton("Aufgabe 2: Zahl kleiner als 10 oder größer als 20?");
        btnAufg2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                aufg2();
            }
        });
        btnAufg2.setBounds(12, 49, 320, 25);
        contentPane.add(btnAufg2);

        JButton btnAufg3 = new JButton("Aufgabe 3: Gerade Zahl?");
        btnAufg3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                aufg3();
            }
        });
        btnAufg3.setBounds(12, 86, 320, 25);
        contentPane.add(btnAufg3);

        JButton btnAufg4 = new JButton("Aufgabe 4: Punkte --> Note");
        btnAufg4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                aufg4();
            }
        });
        btnAufg4.setBounds(12, 123, 320, 25);
        contentPane.add(btnAufg4);

        JButton btnAufgabeMathetrainer = new JButton("Aufgabe 5: Mathe-Trainer");
        btnAufgabeMathetrainer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                aufg5();
            }
        });
        btnAufgabeMathetrainer.setBounds(12, 160, 320, 25);
        contentPane.add(btnAufgabeMathetrainer);

        JButton btnAufg6 = new JButton("Aufgabe 6: x² + p·x + q = 0 lösen");
        btnAufg6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                aufg6();
            }
        });
        btnAufg6.setBounds(12, 197, 320, 25);
        contentPane.add(btnAufg6);

        JButton btnAufg7 = new JButton("Aufgabe 7: Body Maß Index");
        btnAufg7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                aufg7();
            }
        });
        btnAufg7.setBounds(12, 234, 320, 25);
        contentPane.add(btnAufg7);

        JButton btnAufg8 = new JButton("Aufgabe 8: Niedersachsenticket");
        btnAufg8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                aufg8();
            }
        });
        btnAufg8.setBounds(12, 271, 320, 25);
        contentPane.add(btnAufg8);
    }

    private boolean zwischen1und100(int zahl) {
        // Aufgabe 1
        if (zahl <= 100 && zahl >= 1) {
            return true;
        } else {
            return false;
        }
    }

    private void aufg1() {
        // Aufgabe 1
        try {
            String zahlString = JOptionPane.showInputDialog("Gib ne zahl an alla");
            int zahl = Integer.parseInt(zahlString);
            if (zwischen1und100(zahl)) {
                JOptionPane.showMessageDialog(this, " zahl liegt zwischen 1 und 100");
            } else {
                JOptionPane.showMessageDialog(this, "zahl liegt nicht zwischen 1 und 100");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Es muss eine Ziffer eingegeben werden");
        }

    }

    private boolean kleinerals10odergroesserals20(double zahl) {
        if (zahl <= 10.0 || zahl >= 20.0) {
            return true;
        } else {
            return false;
        }
    }


    private void aufg2() {
        // Aufgabe 2
        try {
            String zahlString = JOptionPane.showInputDialog("Gib ne zahl an alla");
            double zahl = Double.parseDouble(zahlString);
            if (kleinerals10odergroesserals20(zahl)) {
                JOptionPane.showMessageDialog(this, " zahl ist kleiner als 10 oder größer als 20");
            } else {
                JOptionPane.showMessageDialog(this, "zahl liegt zwischen 10 und 20");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Es muss eine Ziffer eingegeben werden");
        }

    }

    private boolean gradezahl(int zahl) {
        if (zahl % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    private void aufg3() {
        // Aufgabe 3
        String zahlString = JOptionPane.showInputDialog("Gib ne zahl an alla");
        int zahl = Integer.parseInt(zahlString);
        if (gradezahl(zahl)) {
            JOptionPane.showMessageDialog(this, " is grade digga");
        } else {
            JOptionPane.showMessageDialog(this, "nah mate try again");
        }
    }

    private String notenumrechnen(String punkte) {
        switch (punkte) {
            case "15":
            case "14":
            case "13":
                return "1";
            case "12":
            case "11":
            case "10":
                return "2";
            case "9":
            case "8":
            case "7":
                return "3";
            case "6":
            case "5":
            case "4":
                return "4-";
            case "3":
            case "2":
            case "1":
                return "5-";
            case "0":
                return "6";
            default:
                return "-1";


        }
    }

    private void aufg4() {
        // Aufgabe 4
        String stringnote;
        while ((stringnote = JOptionPane.showInputDialog("Gib ne zahl an alla")) != null) {
            JOptionPane.showMessageDialog(this, "Das entspricht der note" + notenumrechnen(stringnote));
        }
    }


    private void aufg5() {
        // Aufgabe 5
        int ergebnis = 0;
        for (int zahl1 = 5; zahl1 < 7; zahl1++) {
            for (int zahl2 = 7; zahl2 < 9; zahl2++) {
                while (ergebnis != zahl1 * zahl2) {
                    String ergebnissString = JOptionPane.showInputDialog(this, zahl1 + "*" + zahl2);
                    ergebnis = Integer.parseInt(ergebnissString);
                    if (ergebnis == zahl1 * zahl2) {
                        JOptionPane.showMessageDialog(this, "Right boiiiii");
                    } else {
                        JOptionPane.showMessageDialog(this, "Wixxer ur wrong");
                    }
                }
            }
        }
    }

    private void aufg6() {
        // Aufgabe 6
        String eingabe;
        eingabe = JOptionPane.showInputDialog(this, "gib mir p alla");
        double p = Double.parseDouble(eingabe);
        eingabe = JOptionPane.showInputDialog(this, "gib mir q alla");
        double q = Double.parseDouble(eingabe);
        double minusPHalbe = -p / 2;
        double unterDerWurzel = Math.pow(p / 2, 2) - q;
        double wurzel = Math.sqrt(unterDerWurzel);
        if (unterDerWurzel < 0) {
            JOptionPane.showMessageDialog(this, "no lösung kek");
        } else if (unterDerWurzel == 0) {
            JOptionPane.showMessageDialog(this, "x=" + minusPHalbe);
        } else {
            double x1 = minusPHalbe + wurzel;
            double x2 = minusPHalbe - wurzel;
            JOptionPane.showMessageDialog(this, "x = " + x1 + " oder x = " + x2);
        }
    }

    private void aufg7() {
        // Aufgabe 7
        double bmi, groesse, gewicht;
        String eingabe;
        eingabe = JOptionPane.showInputDialog(this, "gib deine größe in metern alla");
        groesse = Double.parseDouble(eingabe);
        eingabe = JOptionPane.showInputDialog(this, "wie fett biste? kg only");
        gewicht = Double.parseDouble(eingabe);
        bmi = gewicht / Math.pow(groesse, 2);
        if (bmi < 18.5) {
            JOptionPane.showMessageDialog(this, "du bist nen lauch " + bmi);
        } else if (bmi > 25) {
            JOptionPane.showMessageDialog(this, "du bist zu fett " + bmi);
        } else {
            JOptionPane.showMessageDialog(this, "glück gehabt du hast nen BMI von: " + bmi);
        }
    }

    private void aufg8() {
        // Aufgabe 8

    }


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Dialoge frame = new Dialoge();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
