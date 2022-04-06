package gui;

import javax.swing.JPanel;
import model.*;
import bdd.*;
import model.Profil;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionBadge extends JPanel {
	private CreerProfil creer;
	private JTable table;
	private JTable table_1;
	


	/**
	 * Create the panel.
	 */
	public GestionBadge() {
		
		table = new JTable();
		table.setBounds(10, 11, 286, 278);
		
		JButton btnNewButton = new JButton("Creer");
		btnNewButton.setBounds(326, 32, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreerBadges cBadges = new CreerBadges();
				cBadges.setVisible(true);
				cBadges.enable();
			}
		});
		setLayout(null);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Supprimer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1.setBounds(326, 114, 89, 23);
		add(btnNewButton_1);
		
		
		
		BadgeDAO con = new BadgeDAO();
		ArrayList<Badge> listeBadge = con.getList();
		Object[][] data = new Object[listeBadge.size()+1][2];
		
		data[0][0] = "Numéro du badge";
		data[0][1] = "Personne associée";
		for(int i = 0; i < listeBadge.size(); i++ ) {
			data[i+1][0] = listeBadge.get(i).getId();
			data[i+1][1] = listeBadge.get(i).getPersonne().getNom() + "  " + listeBadge.get(i).getPersonne().getPrenom();
			
		}
		
		String[] headers = {"Numéro du badge","Personne associée"};

		table_1 = new JTable(data,headers);
		table_1.setBounds(10, 11, 306, 278);
		add(table_1);
	}
	
	public void loadTable() {
		
		table.removeAll();
		
		BadgeDAO con = new BadgeDAO();
		ArrayList<Badge> listeBadge = con.getList();
		Object[][] data = new Object[listeBadge.size()+1][50];
		
		data[0][0] = "Numéro du badge";
		data[0][1] = "Personne associée";
		for(int i = 0; i < listeBadge.size(); i++ ) {
			data[i+1][0] = listeBadge.get(i).getId();
			data[i+1][1] = listeBadge.get(i).getPersonne().getNom() + listeBadge.get(i).getPersonne().getPrenom();
			
		}
		
		String[] headers = {"Numéro du badge","Personne associée"};
		table = new JTable(data,headers);
	}
}
