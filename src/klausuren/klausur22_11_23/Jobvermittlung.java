package klausuren.klausur22_11_23;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Jobvermittlung extends JFrame {

	private JPanel contentPane;
	private JTextField tfPersonNr;
	private JTextField tfVorname;
	private JTextField tfNachname;
	private JTextField tfTelefonnr;
// My Warum hast du das Statement Objekt static deklariert? 
// ==> kein Punktabzug, weil unschädlich.
	private static Statement stmt;
	private DefaultListModel<String> jobs = new DefaultListModel<String>();
	private DefaultListModel<String> vertretung = new DefaultListModel<String>();
	private JList<String> listVertretung = new JList<String>(vertretung);
	private JList<String> listJobs = new JList<String>(jobs);
	private int personenNr;
	private Connection conn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jobvermittlung frame = new Jobvermittlung();
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
	public Jobvermittlung() {
		try {
			datenbankVerbindung();
			ResultSet rs;
			String statement = "SELECT * FROM person";
			rs = stmt.executeQuery(statement);
			if (!rs.next()) {
// My: Das ist eine elegante Lösung für 2f. Da bin ich gar nicht drauf gekommen! Obwohl sie durchaus
//     naheliegend ist!
				JOptionPane.showMessageDialog(this, "Es sind keine Personen in der Datenbank");
				conn.close();
			} else {
				createGUI();
				naechstePerson();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void datenbankVerbindung() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/jobvermittlung"
					+ "?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true", "root", "root");
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void aenderungSpeichern() {
		try {
			String vorname = tfVorname.getText();
			String nachname = tfNachname.getText();
			String telefonnr = tfTelefonnr.getText();
			String statement = "UPDATE person SET vorname = '" + vorname + "', nachname = '" + nachname
					+ "', telefonnr = '" + telefonnr + "' WHERE person_id = " + personenNr;
			stmt.executeUpdate(statement);
// My: Du überprüfst den Erfolg gar nicht!! Dazu hättest du den Rückgabewert von executeUpdate()
//     untersuchen müssen. Bitte mit der Musterlösung vergleichen!
// ==> 1 Punkt Abzug (2c)
			JOptionPane.showMessageDialog(this, "Erflgreich geändert");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Es wurde nicht  ERfolgreich geändert");
			e.printStackTrace();
		}
	}

	private void naechstePerson() {
		try {
			String statement;
			personenNr++;
			if (personenNr == 0) {
				naechstePerson();
				statement = "SELECT * FROM person, angestellt, firma WHERE person_id = " + personenNr
						+ " AND person_id = angestellt_person_id " + "AND firma_id = angestellt_firma_id AND";
			} else if (personenNr >= 1000) {
				personenNr = 1;
				naechstePerson();
			}
			statement = "SELECT * FROM person, angestellt, firma WHERE person_id = " + personenNr
					+ " AND person_id = angestellt_person_id " + "AND firma_id = angestellt_firma_id";
			System.out.println(statement);
			ResultSet rs = stmt.executeQuery(statement);
			if (rs.next()) {
				System.out.println(statement);
				tfPersonNr.setText(personenNr + "");
				updateGUI();
			} else {
				naechstePerson();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void laden() {
		try {
			getPersonenNr();
// My: Nächste Zeile von mir angepasst
//			System.out.println(personenNr + "");
			System.out.println("laden(): personenNr = " + personenNr);
			String statement = "SELECT * FROM person, firma, angestellt WHERE person_id = " + personenNr
					+ " AND angestellt_person_id = " + personenNr + " AND angestellt_firma_id = firma_id";
			ResultSet rs = stmt.executeQuery(statement);
			updateGUI();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void updateGUI() {
		try {
			String statement = "SELECT * FROM person, firma, angestellt WHERE person_id = " + personenNr
					+ " AND angestellt_person_id = " + personenNr + " AND angestellt_firma_id = firma_id";
			System.out.println(statement);
			ResultSet rs = stmt.executeQuery(statement);
			if (rs.next()) {
				String getVorname = rs.getString("vorname");
				String getNachname = rs.getString("nachname");
				String getTelefonNr = rs.getString("Telefonnr");

				tfVorname.setText(getVorname);
				tfNachname.setText(getNachname);
				tfTelefonnr.setText(getTelefonNr);

				getJobs();
				getVertretung();
			} else {
				tfVorname.setText("");
				tfNachname.setText("");
				tfTelefonnr.setText("");
				jobs.clear();
				vertretung.clear();
				JOptionPane.showMessageDialog(this, "Es existiert keine Person mit der angegebenen Nummer.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void getVertretung() {
		try {
			vertretung.clear();
			String statement = "SELECT * FROM person pAngezeigt, person pVertretung, angestellt aAngezeigt, angestellt aVertretung "
					+ "WHERE pAngezeigt.person_id = aAngezeigt.angestellt_person_id "
					+ "AND pVertretung.person_id = aVertretung.angestellt_person_id "
					+ "AND aAngezeigt.job = aVertretung.job "
					+ "AND pAngezeigt.person_id = " + personenNr + " "
					+ "AND pAngezeigt.vorname != pVertretung.vorname "
					+ "AND pAngezeigt.nachname != pVertretung.nachname";
			System.out.println(statement);
			ResultSet rs = stmt.executeQuery(statement);
			while (rs.next()) {
				String vorname = rs.getString("pVertretung.vorname");
				String nachname = rs.getString("pVertretung.nachname");
				String job = rs.getString("aVertretung.job");

				vertretung.addElement(vorname + " " + nachname + " (" + job + ")");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void getJobs() {
		try {
			String statement = "SELECT * FROM person, angestellt, firma WHERE person_id = " + personenNr
					+ " AND person_id = angestellt_person_id " + "AND firma_id = angestellt_firma_id";
			ResultSet rs = stmt.executeQuery(statement);
			jobs.clear();
			while (rs.next()) {
				String job = rs.getString("job");
				String firma = rs.getString("name");
				jobs.addElement(job + " bei " + firma);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void getPersonenNr() {
		String nummerString = tfPersonNr.getText();
// My: Nächste Zeile von mir angepasst
//		System.out.println(nummerString);
		System.out.println("getPersonenNr(): " + nummerString);
		if (nummerString.equals("")) {
			JOptionPane.showMessageDialog(this, "Es existiert keine Person mit der angegebenen Nummer.");
// Nächste Zeile von mir hier eingefügt. Dies wurde wegen der folgenden "Verschiebeaktion" nötig.
			return;
		} else {
			for (int i = 0; i < nummerString.length(); i++) {
				if (Character.isLetter(nummerString.charAt(i))) {
					JOptionPane.showMessageDialog(this, "Es existiert keine Person mit der angegebenen Nummer.");
// My: Die folgende Zeile darf nicht in diesem if-Zweig stehen. Ansonstenveränderst du die
//     globale Variable pernonenNr nicht, wenn in dem Textfeld tatsächlich eine ganze Zahl angegeben war.
//     Deshalb funktionierte deine Methode laden() nicht, wenn man in das Textfeld von Hand eine andere Person (person_id)
//     eingetragen hat.
//     Nächste Zeile deshalb von mir verschoben.
// ==> 1 Punkt Abzug (2b)
					personenNr = Integer.parseInt(tfPersonNr.getText());
					return;
				}
			}
		}
// My: Nächste Zeile von mir hier hin verschoben (siehe Kommentar oben)
		personenNr = Integer.parseInt(tfPersonNr.getText());
	}

	private void createGUI() {
		setTitle("Adrian");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("PersonNr: ");
		lblNewLabel.setBounds(10, 26, 75, 21);
		contentPane.add(lblNewLabel);

		tfPersonNr = new JTextField();
		tfPersonNr.setBounds(84, 26, 37, 20);
		contentPane.add(tfPersonNr);
		tfPersonNr.setColumns(10);

		JButton btnLaden = new JButton("Laden");
		btnLaden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				laden();
			}
		});
		btnLaden.setBounds(131, 25, 83, 23);
		contentPane.add(btnLaden);

		JButton btnNaechstePerson = new JButton("Nächste Person");
		btnNaechstePerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				naechstePerson();
			}
		});
		btnNaechstePerson.setBounds(273, 25, 137, 23);
		contentPane.add(btnNaechstePerson);

		tfVorname = new JTextField();
		tfVorname.setBounds(77, 116, 120, 20);
		contentPane.add(tfVorname);
		tfVorname.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Vorname: ");
		lblNewLabel_1.setBounds(10, 119, 75, 14);
		contentPane.add(lblNewLabel_1);

		tfNachname = new JTextField();
		tfNachname.setBounds(273, 116, 112, 20);
		contentPane.add(tfNachname);
		tfNachname.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Nachname:");
		lblNewLabel_2.setBounds(207, 119, 68, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Telefonnr:");
		lblNewLabel_3.setBounds(10, 169, 75, 14);
		contentPane.add(lblNewLabel_3);

		tfTelefonnr = new JTextField();
		tfTelefonnr.setBounds(77, 166, 120, 20);
		contentPane.add(tfTelefonnr);
		tfTelefonnr.setColumns(10);

		JButton btnAenderungSpeichern = new JButton("Änderung Speichern");
		btnAenderungSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aenderungSpeichern();
			}
		});
		btnAenderungSpeichern.setBounds(223, 165, 162, 23);
		contentPane.add(btnAenderungSpeichern);

		listJobs.setBounds(10, 236, 400, 141);
		contentPane.add(listJobs);

		listVertretung.setBounds(10, 415, 400, 121);
		contentPane.add(listVertretung);

		JLabel lblNewLabel_4 = new JLabel("Jobs:");
		lblNewLabel_4.setBounds(10, 211, 46, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Mögliche Vertretung: ");
		lblNewLabel_5.setBounds(10, 390, 152, 14);
		contentPane.add(lblNewLabel_5);
	}
}
