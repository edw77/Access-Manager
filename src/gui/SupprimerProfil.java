

package gui;

import javax.swing.JPanel;

import bdd.ProfilDAO;
import model.Profil;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class SupprimerProfil extends JPanel {

	private ArrayList<Profil> listeProfil;
	private Button button;
	private JComboBox comboBox_1_1;
	
	public void enable(ArrayList<Profil> liste) {
		this.listeProfil = liste;
		
		
		//Chargement de la liste des profils et remplissage de la ComboBox
		ProfilDAO con = new ProfilDAO();
		ArrayList<String> profils = new ArrayList<String>();
		for(int i = 0; i < listeProfil.size(); i++ ) {
			profils.add(listeProfil.get(i).getNomProfil());
			comboBox_1_1.addItem(profils.get(i));
		}
		
		
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane warning = new JOptionPane();
				String selection = comboBox_1_1.getSelectedItem().toString();
				ProfilDAO con = new ProfilDAO();
				for(int i = 0; i<profils.size(); i++) {
					if(selection.equals(profils.get(i))) {
						con.delete(listeProfil.get(i));
						profils.remove(i);
						comboBox_1_1.removeItem(listeProfil.get(i).getNomProfil());
						warning.showMessageDialog( null,listeProfil.get(i).getNomProfil() + " a été supprimé à la liste des Profils", 
							      "Success", JOptionPane.WARNING_MESSAGE);
					}
					
				}
				
			}
		});
	}
	
	
	/**
	 * Create the panel.
	 */
	public SupprimerProfil() {
		setLayout(null);
		
		button = new Button("Supprimer le profil");
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241, 57, 83));
		button.setBounds(114, 208, 257, 42);
		add(button);
		
		JLabel lblSlectionnerUnProfil = new JLabel("S\u00E9lectionner un profil");
		lblSlectionnerUnProfil.setBounds(25, 28, 115, 14);
		add(lblSlectionnerUnProfil);
		
		comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(150, 25, 257, 21);
		add(comboBox_1_1);

	}
}

