package guiKomponente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class FarbenMischen extends JFrame {

	private JPanel contentPane;
	private JTextField txtRot;
	private JTextField txtBlau;
	private JTextField txtGruen;
	private int rot;
	private int gruen;
	private int blau;
	private boolean farbWechsel = false;
	private Color hintergrund = new Color(255,0,0);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FarbenMischen frame = new FarbenMischen();
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
	public FarbenMischen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 169);
		contentPane = new JPanel();
		contentPane.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(farbWechsel) {
					rot = Integer.parseInt(txtRot.getText());
					gruen = Integer.parseInt(txtGruen.getText());
					blau = Integer.parseInt(txtBlau.getText());
					hintergrund = new Color(rot,gruen,blau);
					contentPane.setBackground(hintergrund);
				}
			}
		});
		contentPane.setBackground(new Color(222,222,222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Farben Mischen");
		lblNewLabel.setBounds(12, 12, 133, 33);
		contentPane.add(lblNewLabel);
		
		txtRot = new JTextField();
		txtRot.setBounds(48, 40, 72, 21);
		contentPane.add(txtRot);
		txtRot.setColumns(10);
		
		txtBlau = new JTextField();
		txtBlau.setBounds(310, 40, 72, 21);
		contentPane.add(txtBlau);
		txtBlau.setColumns(10);
		
		txtGruen = new JTextField();
		txtGruen.setBounds(168, 40, 72, 21);
		contentPane.add(txtGruen);
		txtGruen.setColumns(10);
		
		JLabel lblGrn = new JLabel("Grün");
		lblGrn.setBounds(138, 42, 59, 17);
		contentPane.add(lblGrn);
		
		JLabel lblBlau = new JLabel("Blau");
		lblBlau.setBounds(281, 42, 59, 17);
		contentPane.add(lblBlau);
		
		JLabel lblRot = new JLabel("Rot");
		lblRot.setBounds(22, 42, 59, 17);
		contentPane.add(lblRot);
		
		JButton btnAendern = new JButton("Hintergrund ändern");
		btnAendern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				farbWechsel();
			}
		});
		btnAendern.setBounds(122, 73, 186, 27);
		contentPane.add(btnAendern);
	}

	protected void farbWechsel() {
		// TODO Auto-generated method stub
			rot = Integer.parseInt(txtRot.getText());
			gruen = Integer.parseInt(txtGruen.getText());
			blau = Integer.parseInt(txtBlau.getText());
			hintergrund = new Color(rot,gruen,blau);
			contentPane.setBackground(hintergrund);
	}
}
