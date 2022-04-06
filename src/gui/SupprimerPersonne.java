package gui;

import javax.swing.JPanel;

import bdd.PersonDAO;
import model.Personne;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SupprimerPersonne extends JPanel {
	private ArrayList<Personne> listePersonne;
	private Button button;
	private JComboBox comboBox_1_1;
	private boolean close;
	
	public void enable() {
		PersonDAO con = new PersonDAO();
		this.listePersonne = con.getListNoProfil();
		
		
		//Chargement de la liste des personnes et remplissage de la ComboBox
		
		ArrayList<String> personnes = new ArrayList<String>();
		for(int i = 0; i < listePersonne.size(); i++ ) {
			personnes.add(listePersonne.get(i).getNom());
			comboBox_1_1.addItem(personnes.get(i));
		}
		
		
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane warning = new JOptionPane();
				String selection = comboBox_1_1.getSelectedItem().toString();
				PersonDAO con = new PersonDAO();
				for(int i = 0; i<personnes.size(); i++) {
					if(selection.equals(personnes.get(i))) {
						con.delete(listePersonne.get(i));
						personnes.remove(i);
						comboBox_1_1.removeItem(listePersonne.get(i).getNom());
						warning.showMessageDialog( null,listePersonne.get(i).getNom() + " a été supprimé à la liste des Personnes", 
							      "Success", JOptionPane.WARNING_MESSAGE);
					}
					
				}
				
			}
		});
	}
	
	

	/**
	 * Create the panel.
	 */
	public SupprimerPersonne() {
		setLayout(null);
		
		 close = false;
		
		JLabel lblNom = new JLabel("selectionner une personne");
		lblNom.setBounds(21, 11, 127, 78);
		add(lblNom);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(184, 39, 221, 22);
		add(comboBox);
		
		Button button = new Button("Supprimer la personne");
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241, 57, 83));
		button.setBounds(98, 95, 257, 42);
		add(button);
		
		Button button_1 = new Button("Retour");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close = true;
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(Color.BLUE);
		button_1.setBounds(98, 190, 257, 42);
		add(button_1);

	}


}
