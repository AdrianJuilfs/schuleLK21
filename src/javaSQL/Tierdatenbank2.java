package javaSQL;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tierdatenbank2 extends JFrame {

	private JPanel contentPane;
	private JTextField tfID;
	private JTextField tfTierart;
	private JTextField tfGeburtstag;
	private JTextField tfGeschlecht;
	private JTextField tfName;
	private JTextField tfTodestag;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JButton btnzurueck;
	private JButton btnVor;
	private int tierId;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tierdatenbank2 frame = new Tierdatenbank2();
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
	public Tierdatenbank2() {
		createGUI();
		datenbankenAbfrage();
		}

	private void datenbankenAbfrage() {
		try {
				conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/haustier"
					+ "?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true",
					"root","root");
				stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
					
			String abfrage = "SELECT * FROM tier where tier_id = 1111";
			System.out.println(abfrage);
			rs = stmt.executeQuery(abfrage);
			vor();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void vor() {
		try {
			if (rs.next()) {
				anzeigen();
				checkStatusButtons();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
	private void zurueck() {
		try {
			if (rs.previous()) {
				anzeigen();
				checkStatusButtons();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
	private void anzeigen() {
		try {
			String tierId = rs.getString("tier_id");
			String tierart = rs.getString("tierart");
			String geburtstag = rs.getString("geburtstag");
			String name = rs.getString("name");
			String geschlecht = rs.getString("geschlecht");
			String todestag = rs.getString("todestag");
			tfID.setText(tierId);
			tfTierart.setText(tierart);
			tfName.setText(name);
			tfGeburtstag.setText(geburtstag);
			tfName.setText(name);
			tfGeschlecht.setText(geschlecht);
			tfTodestag.setText(todestag);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void checkStatusButtons() {
		try {
			if (rs.isFirst()) {
				btnzurueck.setEnabled(false);
			} else {
				btnzurueck.setEnabled(true);
			}
			if (rs.isLast()) {
				btnVor.setEnabled(false);
			} else {
				btnVor.setEnabled(true);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	private void createGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfID = new JTextField();
		tfID.setEditable(false);
		tfID.setBounds(72, 52, 114, 21);
		contentPane.add(tfID);
		tfID.setColumns(10);
		
		tfTierart = new JTextField();
		tfTierart.setEditable(false);
		tfTierart.setBounds(72, 97, 114, 21);
		contentPane.add(tfTierart);
		tfTierart.setColumns(10);
		
		tfGeburtstag = new JTextField();
		tfGeburtstag.setEditable(false);
		tfGeburtstag.setBounds(85, 143, 101, 21);
		contentPane.add(tfGeburtstag);
		tfGeburtstag.setColumns(10);
		
		tfGeschlecht = new JTextField();
		tfGeschlecht.setEditable(false);
		tfGeschlecht.setBounds(293, 97, 114, 21);
		contentPane.add(tfGeschlecht);
		tfGeschlecht.setColumns(10);
		
		tfName = new JTextField();
		tfName.setEditable(false);
		tfName.setBounds(293, 52, 114, 21);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		tfTodestag = new JTextField();
		tfTodestag.setEditable(false);
		tfTodestag.setBounds(293, 143, 114, 21);
		contentPane.add(tfTodestag);
		tfTodestag.setColumns(10);
		
		btnzurueck = new JButton("Zurück");
		btnzurueck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zurueck();
			}
		});
		btnzurueck.setBounds(85, 201, 101, 27);
		contentPane.add(btnzurueck);
		
		btnVor = new JButton("Vor");
		btnVor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vor();
			}
		});
		btnVor.setBounds(306, 201, 101, 27);
		contentPane.add(btnVor);
		
		JLabel lblNewLabel = new JLabel("id: ");
		lblNewLabel.setBounds(50, 54, 58, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tierart: ");
		lblNewLabel_1.setBounds(12, 99, 58, 17);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Geburtstag: ");
		lblNewLabel_2.setBounds(12, 145, 73, 17);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Name: ");
		lblNewLabel_3.setBounds(233, 54, 58, 17);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Geschlecht:");
		lblNewLabel_4.setBounds(218, 99, 73, 17);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Todestag: ");
		lblNewLabel_5.setBounds(218, 145, 73, 17);
		contentPane.add(lblNewLabel_5);
		
	}
}
