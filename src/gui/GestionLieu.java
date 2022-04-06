package gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.CardLayout;

public class GestionLieu extends JPanel {

	/**
	 * Create the panel.
	 */
	public GestionLieu() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 136, 300);
		add(panel);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(15, 120, 121, 34);
		panel.add(btnSupprimer);
		
		JButton btnCrerUnNouveau = new JButton("Cr\u00E9er");
		btnCrerUnNouveau.setBounds(15, 30, 121, 34);
		panel.add(btnCrerUnNouveau);
		
		JButton btnNewButton = new JButton("Modifier");
		btnNewButton.setBounds(15, 75, 121, 34);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(136, 0, 420, 371);
		add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));

	}

}
