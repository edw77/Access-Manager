package gui;

import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import bdd.ProfilDAO;
import model.Profil;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreerProfil extends JPanel {
	private JTextField textField;
	private Button button;
	private ArrayList<Profil> listeProfil;
	
	public void enable(ArrayList<Profil> listeProfil) {
		this.listeProfil = listeProfil;
		
		//Chargement de la liste des noms des profils
		
		ArrayList<String> profils = new ArrayList<String>();
		for(int i = 0; i < listeProfil.size(); i++ ) {
			profils.add(listeProfil.get(i).getNomProfil());
		}
		
		//Action du boutton
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane warning = new JOptionPane();
				if (textField.getText().equals("") || profils.contains("textField.getText()")) {
					warning.showMessageDialog( null, "You have to enter a name for the new Profile !\nAlso, make sure the name is not already taken !", 
						      "Warning", JOptionPane.WARNING_MESSAGE);
				}
				else {
					ProfilDAO con = new ProfilDAO();
					con.add(new Profil(textField.getText()));
					warning.showMessageDialog( null, textField.getText() + " a été ajouté à la liste des Profils", 
						      "Success", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}
	

	
	
	/**
	 * Create the panel.
	 */
	public CreerProfil() {
		setLayout(null);
		
		JLabel lblNomDuProfil = new JLabel(" Nom du profil");
		lblNomDuProfil.setBounds(35, 48, 91, 78);
		add(lblNomDuProfil);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(136, 69, 257, 28);
		add(textField);
		
		
		button = new Button("Cr\u00E9er le profil");
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241, 57, 83));
		button.setBounds(136, 212, 257, 42);
		add(button);

	}
}
