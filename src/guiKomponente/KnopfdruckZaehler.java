package guiKomponente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class KnopfdruckZaehler extends JFrame {

	private JPanel contentPane;
	private int zaehler = 0;
	private JLabel lblGedrueckt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KnopfdruckZaehler frame = new KnopfdruckZaehler();
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
	public KnopfdruckZaehler() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnKekse = new JButton("kostenfreie Kekse");
		btnKekse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addKlick();
			}
		});
		
		lblGedrueckt = new JLabel("Der Knopf wurde nicht gedrückt");
		contentPane.add(lblGedrueckt);
		contentPane.add(btnKekse);
	}

	protected void addKlick() {
		zaehler++;
		lblGedrueckt.setText("Klicks: "+zaehler);
		
	} 	
}
