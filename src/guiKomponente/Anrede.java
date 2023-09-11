package guiKomponente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class Anrede extends JFrame {

	private JPanel contentPane;
	private JTextField nameEingabe;
	private JTextField ausgabe;
	private boolean maennlich = true;
	private String name;
	private String gender;
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Anrede frame = new Anrede();
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
	public Anrede() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nameEingabe = new JTextField();
		nameEingabe.setBounds(82, 12, 114, 21);
		contentPane.add(nameEingabe);
		nameEingabe.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(25, 12, 72, 21);
		contentPane.add(lblName);
		
		JCheckBox chckbxWeiblich = new JCheckBox("Weiblich");
		chckbxWeiblich.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maennlich = !maennlich;
				
			}
		});
		chckbxWeiblich.setBounds(204, 10, 87, 25);
		contentPane.add(chckbxWeiblich);
		
		JButton btnAuswerten = new JButton("Auswerten");
		btnAuswerten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameSchreiben();
			}
		});
		btnAuswerten.setBounds(299, 9, 98, 27);
		contentPane.add(btnAuswerten);
		
		ausgabe = new JTextField();
		ausgabe.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				
			}
		});
		ausgabe.setEditable(false);
		ausgabe.setBounds(35, 45, 362, 21);
		contentPane.add(ausgabe);
		ausgabe.setColumns(10);
	}

	protected void nameSchreiben() {
		// TODO Auto-generated method stub
		name = nameEingabe.getText();
		if(maennlich) {
			gender = "Herr";
		} else {
			gender = "Frau";
		}
		ausgabe.setText("Hallo "+ gender + " " + name);
	}
}
