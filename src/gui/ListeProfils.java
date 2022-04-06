package gui;
import model.*;
import javax.swing.table.*;
import bdd.*;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JTable;

public class ListeProfils extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListeProfils frame = new ListeProfils();
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
	public ListeProfils() {
		
		this.setTitle("Liste des profils");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JComboBox comboBox_1_1 = new JComboBox();
		ProfilDAO con = new ProfilDAO();
		ArrayList<Profil> listeProfil = con.getList();
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
		contentPane.add(table, BorderLayout.CENTER);
		
		
	}

}
