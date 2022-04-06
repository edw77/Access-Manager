package gui;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;

import bdd.ProfilDAO;
import model.Profil;
import java.awt.Color;
import javax.swing.border.MatteBorder;

public class ListeProfil extends JPanel {

	private JTable table;
	
	private ArrayList<Profil> listeProfil;
	
	public void enable(ArrayList<Profil> liste) {
		this.listeProfil = liste;
		
		
		ProfilDAO con = new ProfilDAO();
		Object[][] data = new Object[listeProfil.size()+1][50];
		
		data[0][0] = "Nom du profil";
		data[0][1] = "Lieux accessibles";
		for(int i = 0; i < listeProfil.size(); i++ ) {
			data[i+1][0] = listeProfil.get(i).getNomProfil();
			data[i+1][1] = "Aucun lieux accessibles";
			if(!listeProfil.get(i).getListeLieu().isEmpty()) {
				data[i+1][1] = "";
			}
			for(int j = 0; j < listeProfil.get(i).getListeLieu().size(); j++) {
				data[i+1][1] = data[i+1][1] + " , " + listeProfil.get(i).getListeLieu().get(j).getNomLieu();
			}
		}
		
		String[] headers = {"Nom du profil","Lieux Accessibles"}; 
		table = new JTable(data,headers);
		
		this.removeAll();
		this.add(table);
	}
	
	/**
	 * Create the panel.
	 */
	public ListeProfil() {
		setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 0, 0)));
		table.setBackground(new Color(70, 130, 180));
		this.add(table);
	}

}
