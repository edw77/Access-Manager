package gui;

import javax.swing.JPanel;

import bdd.PersonDAO;
import bdd.ProfilDAO;
import model.Personne;
import model.Profil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AssocProfil extends JPanel {

	private Button button;
	private JComboBox cbNomProfil;
	private JComboBox cbPersonne;
	
	
	public void enable(ArrayList<Profil> listeProfil) {
		
		ProfilDAO con = new ProfilDAO();
		PersonDAO con2 = new PersonDAO();
		ArrayList<Personne> listePersonne = con2.getList();
		
		//Remplissage des ComboBox
		for(int i = 0; i < listeProfil.size(); i++ ) {
			cbNomProfil.addItem(listeProfil.get(i).getNomProfil());
		}
		
		for(int i = 0; i < listePersonne.size(); i++ ) {
			cbPersonne.addItem(listePersonne.get(i).getNom() + " " + listePersonne.get(i).getPrenom());
		}
		
		button.addActionListener(new ActionListener() {
			JOptionPane warning = new JOptionPane();
			public void actionPerformed(ActionEvent e) {
				if (cbPersonne.getSelectedIndex() == -1 || cbNomProfil.getSelectedIndex() == -1) {
					warning.showMessageDialog( null," One or more fields are empty !", 
						      "WARNING", JOptionPane.WARNING_MESSAGE);
				}
				
				else {
					String selection1 = cbNomProfil.getSelectedItem().toString();
					String selection2 = cbPersonne.getSelectedItem().toString();
					int idPersonne = -1;
					int idProfil = -1;
					for(int i = 0; i<listeProfil.size(); i++) {
						if(selection1.equals(listeProfil.get(i).getNomProfil())) {
							idProfil = i;
						}
					}
						
					for(int i = 0; i<listePersonne.size(); i++) {
						if(selection2.equals(listePersonne.get(i).getNom() + " " + listePersonne.get(i).getPrenom())) {
								idPersonne = i;
							}
					}
					con.associate(listeProfil.get(idProfil), listePersonne.get(idPersonne));
					warning.showMessageDialog( null,listePersonne.get(idPersonne).getPrenom() + " " + listePersonne.get(idPersonne).getNom() + " has now the profile "+ listeProfil.get(idProfil).getNomProfil(), 
						      "WARNING", JOptionPane.WARNING_MESSAGE);
					}
				}
		});
		
	}
	
	/**
	 * Create the panel.
	 */
	public AssocProfil() {
		setLayout(null);
		
		JLabel lblAssocier = new JLabel("Associer \u00E0...");
		lblAssocier.setBounds(72, 142, 91, 31);
		add(lblAssocier);
		
		JLabel lblNomDuProfil = new JLabel(" Nom du profil");
		lblNomDuProfil.setBounds(72, 43, 91, 31);
		add(lblNomDuProfil);
		
		cbNomProfil = new JComboBox();
		cbNomProfil.setBounds(228, 43, 140, 31);
		add(cbNomProfil);
		
		cbPersonne = new JComboBox();
		cbPersonne.setBounds(228, 138, 140, 35);
		add(cbPersonne);
		
		button = new Button("Associer ");
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241, 57, 83));
		button.setBounds(92, 248, 257, 42);
		add(button);

	}
}
