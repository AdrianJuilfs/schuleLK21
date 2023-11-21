package langzeitKlausur;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExklusivReise extends JFrame {

	private JPanel contentPane;
	private JTextField tfVorname;
	private JTextField tfNachname;
	private JTextField tfAnzahlReisende;
	private JButton btnReiseBuchen;	
	private JScrollPane scrollPane;
	private JLabel lblVonDerPerson;
	private JLabel lblVorname;
	private JLabel lblNachname;
	private JLabel lblAnzahlReisendePersonen;
	private JScrollPane scrollPane_1;
	private JList listVerfuegbar = new JList();
	private JList listGebucht = new JList();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExklusivReise frame = new ExklusivReise();
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
	public ExklusivReise() {
		createGUI();
	}

	private void createGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVerfgbareReisen = new JLabel("Verfügbare Reisen:");
		lblVerfgbareReisen.setBounds(24, 31, 128, 17);
		contentPane.add(lblVerfgbareReisen);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 60, 576, 113);
		contentPane.add(scrollPane);
		
		
		scrollPane.setViewportView(listVerfuegbar);
		
		tfVorname = new JTextField();
		tfVorname.setBounds(98, 237, 114, 21);
		contentPane.add(tfVorname);
		tfVorname.setColumns(10);
		
		tfNachname = new JTextField();
		tfNachname.setBounds(357, 237, 114, 21);
		contentPane.add(tfNachname);
		tfNachname.setColumns(10);
		
		JButton btnReiseListe = new JButton("Reiseliste");
		btnReiseListe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnReiseListe.setBounds(544, 234, 101, 27);
		contentPane.add(btnReiseListe);
		
		tfAnzahlReisende = new JTextField();
		tfAnzahlReisende.setBounds(236, 291, 114, 21);
		contentPane.add(tfAnzahlReisende);
		tfAnzahlReisende.setColumns(10);
		
		btnReiseBuchen = new JButton("Markierte Reise buchen");
		btnReiseBuchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buchen();
				}});
		btnReiseBuchen.setBounds(400, 288, 182, 27);
		contentPane.add(btnReiseBuchen);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(41, 333, 579, 100);
		contentPane.add(scrollPane_1);
		
		
		scrollPane_1.setViewportView(listGebucht);
		
		lblVonDerPerson = new JLabel("Von der Person gebucht Reisen:");
		lblVonDerPerson.setBounds(59, 315, 212, 17);
		contentPane.add(lblVonDerPerson);
		
		lblVorname = new JLabel("Vorname:");
		lblVorname.setBounds(22, 239, 58, 17);
		contentPane.add(lblVorname);
		
		lblNachname = new JLabel("Nachname:");
		lblNachname.setBounds(266, 239, 73, 17);
		contentPane.add(lblNachname);
		
		lblAnzahlReisendePersonen = new JLabel("Anzahl reisende Personen:");
		lblAnzahlReisendePersonen.setBounds(44, 293, 212, 17);
		contentPane.add(lblAnzahlReisendePersonen);
	
	}
	private void buchen() {
		
	}
}
