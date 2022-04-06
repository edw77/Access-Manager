package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bdd.*;
import model.*;

import java.util.ArrayList;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JTable;
import java.awt.Button;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddLieu extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private boolean state = false;

	/**
	 * Create the frame.
	 */
	public AddLieu(Profil profil) {
		
		this.setTitle("Ajouter un lieu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel profilname = new JLabel("//");
		profilname.setForeground(Color.BLACK);
		profilname.setBackground(Color.BLACK);
		profilname.setFont(new Font("Times New Roman", Font.BOLD, 24));
		profilname.setBounds(272, 10, 152, 43);
		contentPane.add(profilname);
		profilname.setText(profil.getNomProfil());
		LieuDAO con = new LieuDAO();
		ArrayList<Lieu> liste = con.getList();
	
		
		Object[][] data = new Object[liste.size()+1][2];
		
		data[0][0] = "Lieux inaccessibles";
		data[0][1] = "Emplacement";

		for(int i = 0; i < liste.size(); i++ ) {
			boolean present = false;
			for(int j = 0; j < profil.getListeLieu().size(); j++) {
				if(liste.get(i).getId() == profil.getListeLieu().get(j).getId()) {
					present = true;
					break;
				}
					
			}
			if(!present) {
				data[i+1][0] = liste.get(i).getNomLieu();
				data[i+1][1] = liste.get(i).getEmplacement();
			}
			else {
				liste.remove(i);
				i = i - 1;
			}
			
		}
		
		String[] headers = {"Lieux inaccessibles","Emplacement"};
		contentPane.setLayout(null);
		table = new JTable(data,headers);
		table.setBounds(10, 10, 211, 240);
		
		
		contentPane.add(table);
		
		Button button = new Button("Ajouter le lieu selectionn\u00E9");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nomLieu = table.getValueAt(table.getSelectedRow(),table.getSelectedColumn()).toString();
				
				for(int i = 0; i < liste.size(); i++) {
					if(nomLieu.equals(liste.get(i).getNomLieu()) || nomLieu.equals(liste.get(i).getEmplacement())) {
						LieuDAO con = new LieuDAO();
						con.setAcces(profil,liste.get(i));
						JOptionPane warning = new JOptionPane();
						warning.showMessageDialog( null,"Acces accordé à ce profil. L'horaire d'ouverture est défini de 8h30 à 18h30 par défaut", 
									      "Succes", JOptionPane.WARNING_MESSAGE);
						dispose();
					}
				}
			}
		});
		button.setBounds(272, 103, 152, 41);
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241, 57, 83));
		contentPane.add(button);
		
		Button button_1 = new Button("Retour");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(Color.BLUE);
		button_1.setBounds(272, 193, 152, 41);
		contentPane.add(button_1);
		
		
		
	}
	
	public void loadTable(Profil profil) {
		
		if(state) {
			this.remove(table);
		}
		
		LieuDAO con = new LieuDAO();
		ArrayList<Lieu> liste = con.getList();
	
		
		Object[][] data = new Object[liste.size()+1][50];
		
		data[0][0] = "Lieux inaccessibles";
		data[0][1] = "Emplacement";
		for(int i = 0; i < liste.size(); i++ ) {
			boolean present = false;
			for(int j = 0; j < profil.getListeLieu().size(); j++) {
				if(liste.get(i).getId() == profil.getListeLieu().get(j).getId())
					present = true;
			}
			if(!present) {
				data[i+1][0] = liste.get(i).getNomLieu();
				data[i+1][1] = liste.get(i).getEmplacement();
			}
			
		}
		
		String[] headers = {"Lieux inaccessibles","Emplacement"}; 
		this.table = new JTable(data,headers);
		table.setBounds(0, 259, 202, -259);
		
		
		getContentPane().add(this.table);
		state = true;
	}
}
