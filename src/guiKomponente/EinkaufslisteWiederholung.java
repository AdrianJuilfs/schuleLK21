package guiKomponente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;

public class EinkaufslisteWiederholung extends JFrame {

	private JPanel contentPane;
	private JTextField eingabeTf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EinkaufslisteWiederholung frame = new EinkaufslisteWiederholung();
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
	public EinkaufslisteWiederholung() {
		initialize();
	}
	private void initialize() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
				setContentPane(contentPane);
		contentPane.setLayout(null);
		
		eingabeTf = new JTextField();
		eingabeTf.setBounds(12, 0, 285, 21);
		contentPane.add(eingabeTf);
		eingabeTf.setColumns(10);
		
		JButton btnAdd = new JButton("Hinzufügen");
		btnAdd.setBounds(309, -3, 119, 27);
		contentPane.add(btnAdd);
		
		JList list = new JList();
		list.setBounds(12, 33, 416, 161);
		contentPane.add(list);
		
		JButton btnAllesEinerArt = new JButton("Alles einer Art Löschen");
		btnAllesEinerArt.setBounds(12, 206, 210, 27);
		contentPane.add(btnAllesEinerArt);
		
		JButton btnLoeschen = new JButton("Löschen");
		btnLoeschen.setBounds(325, 206, 103, 27);
		contentPane.add(btnLoeschen);
	}
}
