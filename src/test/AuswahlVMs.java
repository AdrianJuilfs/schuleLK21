package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.net.*;
import java.io.*;

public class AuswahlVMs extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AuswahlVMs frame = new AuswahlVMs();
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
	public AuswahlVMs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(5, 5, 0, 0));
		
		try {
			URL url = getClass().getResource("config.txt");
			OutputStream fileOut = new FileOutputStream(URLDecoder.decode(url.getFile(),"UTF-8"));
			OutputStreamWriter out = new OutputStreamWriter(fileOut, "UTF-8");
			InputStream fileIn = new FileInputStream(URLDecoder.decode(url.getFile(),"UTF-8"));
			InputStreamReader in = new InputStreamReader(fileIn, "UTF-8");
			
			int zeichen;
			String zahl = "0";
			int anzahlButtons;
			
			while ((zeichen = in.read()) != ';') {
				zahl = zahl + (char) zeichen;
			}
			anzahlButtons = Integer.parseInt(zahl);
			for (int i = 0; i<= anzahlButtons; i++) {
				JButton btnNewButton = new JButton();
				contentPane.add(btnNewButton);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
