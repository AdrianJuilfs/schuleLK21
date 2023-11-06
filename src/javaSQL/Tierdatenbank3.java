package javaSQL;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tierdatenbank3 extends JFrame {

	private JPanel contentPane;
	private JTextField tfTiernummer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tierdatenbank3 frame = new Tierdatenbank3();
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
	public Tierdatenbank3() {
		createGUI();
}

	private void createGUI() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 179);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tiernummer:");
		lblNewLabel.setBounds(22, 48, 124, 17);
		contentPane.add(lblNewLabel);
		
		tfTiernummer = new JTextField();
		tfTiernummer.setBounds(118, 46, 114, 21);
		contentPane.add(tfTiernummer);
		tfTiernummer.setColumns(10);
		
		JButton btnLoeschen = new JButton("Löschen");
		btnLoeschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				leoschen();
			}
		});
		btnLoeschen.setBounds(276, 43, 101, 27);
		contentPane.add(btnLoeschen);
	}
	
private void leoschen() {
	// TODO Auto-generated method stub
	
}}
