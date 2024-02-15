package schueler.lk21.adrianJuilfs.klausur240205;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class RelativeMasseUmrechner extends JFrame {

	private JPanel contentPane;
	private JTextField tfServer;
	protected JTextField tfRuhemasse;
	protected JTextField tfRelmasse;
	protected JTextField tfLichtgeschwindigkeit;
	private Socket s;
	private boolean relOrRuhe;
	private JButton btnTrennen;
	private JButton btnKonvertieren;
	private JButton btnVerbinden;
	protected InputStreamReader in;
	protected OutputStreamWriter out;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelativeMasseUmrechner frame = new RelativeMasseUmrechner();
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
	public RelativeMasseUmrechner() {
		createGUI();
	}

	private void createGUI() {
		setTitle("Adrian");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tfServer = new JTextField();
		tfServer.setBounds(96, 11, 86, 20);
		contentPane.add(tfServer);
		tfServer.setColumns(10);

		btnVerbinden = new JButton("Verbinden");
		btnVerbinden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verbinden();
			}
		});
		btnVerbinden.setBounds(234, 10, 89, 23);
		contentPane.add(btnVerbinden);

		btnTrennen = new JButton("Trennen");
		btnTrennen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trennen();
			}
		});
		btnTrennen.setEnabled(false);
		btnTrennen.setBounds(335, 10, 89, 23);
		contentPane.add(btnTrennen);

		btnKonvertieren = new JButton("konvertieren");
		btnKonvertieren.setEnabled(false);
		btnKonvertieren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				konvertieren();
			}
		});
		btnKonvertieren.setBounds(134, 203, 103, 23);
		contentPane.add(btnKonvertieren);

		tfRuhemasse = new JTextField();
		tfRuhemasse.setBounds(21, 204, 89, 20);
		contentPane.add(tfRuhemasse);
		tfRuhemasse.setColumns(10);

		tfRelmasse = new JTextField();
		tfRelmasse.setBounds(247, 204, 117, 20);
		contentPane.add(tfRelmasse);
		tfRelmasse.setColumns(10);

		tfLichtgeschwindigkeit = new JTextField();
		tfLichtgeschwindigkeit.setBounds(298, 105, 86, 20);
		contentPane.add(tfLichtgeschwindigkeit);
		tfLichtgeschwindigkeit.setColumns(10);

		JLabel lblNewLabel = new JLabel("Geschwindigkeit in prozent der Lichgeschwindigkeit:");
		lblNewLabel.setBounds(21, 108, 267, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Server:");
		lblNewLabel_1.setBounds(21, 14, 46, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("kg");
		lblNewLabel_2.setBounds(374, 207, 46, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Ruhemasse");
		lblNewLabel_3.setBounds(21, 179, 149, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Relativistische Masse");
		lblNewLabel_4.setBounds(247, 179, 137, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_2_1 = new JLabel("kg");
		lblNewLabel_2_1.setBounds(120, 207, 46, 14);
		contentPane.add(lblNewLabel_2_1);
	}

	private void verbinden() {
		try {
			s = new Socket(tfServer.getText(), 12321);
			in = new InputStreamReader(s.getInputStream(), "UTF-8");
			out = new OutputStreamWriter(s.getOutputStream(), "UTF-8");
			btnVerbinden.setEnabled(false);
			btnTrennen.setEnabled(true);
			btnKonvertieren.setEnabled(true);
			LeseThread lt = new LeseThread(this);
			lt.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void trennen() {
		try {
			s.close();
			btnTrennen.setEnabled(false);
			btnVerbinden.setEnabled(true);
			btnKonvertieren.setEnabled(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void konvertieren() {
		try {
			String relmasse = tfRelmasse.getText();
			String ruhemasse = tfRuhemasse.getText();
			String c = tfLichtgeschwindigkeit.getText();
			String lichtgeschwindigkeit = tfLichtgeschwindigkeit.getText();
			if (c.length() != 0) {
				if (relmasse.length() == 0) {
					if (ruhemasse.length() == 0) {
						JOptionPane.showMessageDialog(this, "gib eine Masse an");
					} else {
						out.write("N" + lichtgeschwindigkeit + "#" + ruhemasse + "?");
						out.flush();
					}
				} else {
// My: Hierhin komst du, wenn das Textfeld für die Geschwindigkeit nicht leer und das Textfeld
//     für die Ruhemasse ebenfalls nicht leer ist.
//	   Es fehlt noch der Test, ob das Textfeld für die relativistische Masse leer ist - ansonsten
//     darf keine Nachricht an den Server geschickt werden (statt dessen müsste der Benutzer über 
//     einen Dialog informiert werden).
// ==> 1 Punkt Abzug (2b)
					out.write("R" + lichtgeschwindigkeit + "#" + relmasse + "?");
					out.flush();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void masseSenden(String masse) {
		if (!relOrRuhe) {

		} else {

		}
	}

}
