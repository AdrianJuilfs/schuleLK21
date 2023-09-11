package guiKomponente;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FahneImWind extends JFrame {

	private JPanel contentPane;
	private boolean links = true;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FahneImWind frame = new FahneImWind();
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
	public FahneImWind() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel zeichenflaeche = new JPanel() {
			@Override
			public void paintComponent(Graphics g)  {
				super.paintComponent(g);
				g.fillRect(100, 100, 10, 60);
				g.setColor(Color.RED);
				if(links) {
					g.fillRect(110, 100, 70, 30);	
				} else {
					g.fillRect(30,100,70,30);
				}
			}
		};
		zeichenflaeche.setBounds(12, 0, 189, 251);
		contentPane.add(zeichenflaeche);
		
		JCheckBox chckbxWindVonLinks = new JCheckBox("Wind von Links");
		chckbxWindVonLinks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				links = !links;
				repaint();
			}
		});
		chckbxWindVonLinks.setBounds(250, 104, 192, 42);
		contentPane.add(chckbxWindVonLinks);
	}
}
