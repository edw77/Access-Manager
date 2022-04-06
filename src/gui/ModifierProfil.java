package gui;

import bdd.*;
import model.*;

import javax.swing.*;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;

import model.Profil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JSpinner;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModifierProfil extends JPanel {
	private JTextField textField_2;
	
	private Button button;
	private Button button2;
	private JComboBox comboBox_1;
	private JComboBox comboBox_1_1;
	private JComboBox cbJours;
	
	private JSpinner h1;
	private JSpinner h2;
	private JSpinner mn1;
	private JSpinner mn2;
	
	//Etat des CheckBox
	private boolean state;
	private boolean state3;
	
	//Etat de la ComboBox
	private boolean state2;
	
	private int numeroLieu;
	
	private Profil profilSelected;

	private String[] listeJours = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"};
	
	
	private ArrayList<Profil> listeProfil;
	
	public void enable(ArrayList<Profil> liste) {
		this.listeProfil = liste;
		numeroLieu = -1;
		
		profilSelected = liste.get(0);
		
		ProfilDAO con = new ProfilDAO();
		LieuDAO con2 = new LieuDAO();
		
		//Remplissage ComboBox
		ArrayList<String> profils = new ArrayList<String>();
		for(int i = 0; i < listeProfil.size(); i++ ) {
			comboBox_1_1.setEnabled(true);
			profils.add(listeProfil.get(i).getNomProfil());
			comboBox_1_1.addItem(profils.get(i));
		}
		
		comboBox_1_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(state2) {
					comboBox_1.setEnabled(true);
					comboBox_1.removeAllItems();
					if(!state3) {
						cbJours.setEnabled(true);
					}
					String selection = comboBox_1_1.getSelectedItem().toString();
					
					for(int i = 0; i < listeProfil.size(); i++ ) {
						if(selection.equals(listeProfil.get(i).getNomProfil())) {
							profilSelected = listeProfil.get(i);
							for(int j=0; j < listeProfil.get(i).getListeLieu().size(); j++) {
								comboBox_1.addItem(listeProfil.get(i).getListeLieu().get(j).getNomLieu());
								numeroLieu = j;
							}
						}
					}
				}
				
			}
		});
		
		cbJours.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				for(int i = 0; i < listeJours.length; i++ ) {
					if(listeJours[i].equals(cbJours.getSelectedItem())) {
						
						h1.setValue(Integer.valueOf(profilSelected.getListeHoraire().get(numeroLieu).getHoraire(i)[0].getHeure()));
						h2.setValue(Integer.valueOf(profilSelected.getListeHoraire().get(numeroLieu).getHoraire(i)[1].getHeure()));
						mn1.setValue(Integer.valueOf(profilSelected.getListeHoraire().get(numeroLieu).getHoraire(i)[0].getMinute()));
						mn2.setValue(Integer.valueOf(profilSelected.getListeHoraire().get(numeroLieu).getHoraire(i)[1].getMinute()));
						
					}
				}
				
			}
		});
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane warning = new JOptionPane();
				if((!state && textField_2.getText().isEmpty())) {
					warning.showMessageDialog( null,"Empty textfield for the new name !", 
						      "Success", JOptionPane.WARNING_MESSAGE);
				}
				else {
					for(int i = 0; i < listeProfil.size(); i++ ) {
						if(listeProfil.get(i).getNomProfil().equals(comboBox_1_1.getSelectedItem())) {
							if(!state)
								listeProfil.get(i).setNomProfil(textField_2.getText());
							if(!state3) {
								Heure[] newHours = new Heure[2];
								newHours[0] = new Heure(Integer.parseInt(mn1.getValue().toString()),Integer.parseInt(h1.getValue().toString()));
								newHours[1] = new Heure(Integer.parseInt(mn2.getValue().toString()),Integer.parseInt(h2.getValue().toString()));
								for(int j = 0; j < listeJours.length; j++ ) {
									if(listeJours[j].equals(cbJours.getSelectedItem())) {
										listeProfil.get(i).getListeHoraire().get(numeroLieu).setHoraire(newHours,j);
										break;
									}
									}
							}
								
							warning.showMessageDialog( null,listeProfil.get(i).getNomProfil() + " a été modifié", 
								      "Warning", JOptionPane.WARNING_MESSAGE);
							con.update(listeProfil.get(i));
							state2 = false;
							comboBox_1_1.removeAllItems();
							for(int j = 0; j < listeProfil.size(); j++ ) {
								profils.add(listeProfil.get(j).getNomProfil());
								comboBox_1_1.addItem(profils.get(j));
							}
							state2 = true;
							break;
						}	
					}
				}
				
			}
		});
	}
	
	/**
	 * Create the panel.
	 */
	public ModifierProfil() {
		setLayout(null);
		
		
		state = true;
		state2 = true;
		state3 = true;
		
		button = new Button("Modifier le profil");
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241, 57, 83));
		button.setBounds(170, 270, 212, 28);
		add(button);
		
		button2 = new Button("+  L I E U");
		button2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddLieu add = new AddLieu(profilSelected);
				add.setVisible(true);
				
				while(add.isActive()) {
					
				}
				
				if(state2) {
					comboBox_1.setEnabled(true);
					comboBox_1.removeAllItems();
					if(!state3) {
						cbJours.setEnabled(true);
					}
					String selection = comboBox_1_1.getSelectedItem().toString();
					
					for(int i = 0; i < listeProfil.size(); i++ ) {
						if(selection.equals(listeProfil.get(i).getNomProfil())) {
							profilSelected = listeProfil.get(i);
							for(int j=0; j < listeProfil.get(i).getListeLieu().size(); j++) {
								comboBox_1.addItem(listeProfil.get(i).getListeLieu().get(j).getNomLieu());
								numeroLieu = j;
							}
						}
					}
				}
			}
		});
		button2.setForeground(Color.WHITE);
		button2.setBackground(new Color(241, 57, 83));
		button2.setBounds(408, 79, 73, 21);
		add(button2);
		
		
		
		JLabel lblLhoraireDeFermeture = new JLabel("Horaire de fermeture");
		lblLhoraireDeFermeture.setBounds(80, 194, 108, 14);
		add(lblLhoraireDeFermeture);
		
		JLabel lblLhoraireDuLieu = new JLabel("Horaire d'ouverture");
		lblLhoraireDuLieu.setBounds(80, 166, 100, 14);
		add(lblLhoraireDuLieu);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(125, 79, 257, 21);
		add(comboBox_1);
		
		JLabel lblLieux = new JLabel("Lieux accessibles");
		lblLieux.setBounds(24, 82, 91, 14);
		add(lblLieux);
		
		JLabel lblNouveauNom = new JLabel("Nouveau nom");
		lblNouveauNom.setBounds(32, 40, 100, 14);
		add(lblNouveauNom);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(128, 33, 246, 28);
		add(textField_2);
		
		comboBox_1_1 = new JComboBox();
		
		comboBox_1_1.setBounds(128, 8, 257, 21);
		add(comboBox_1_1);
		
		JLabel lblChoixDuProfil = new JLabel("Choix du profil");
		lblChoixDuProfil.setBounds(15, 11, 100, 14);
		add(lblChoixDuProfil);
		
		SpinnerModel hmodel = new SpinnerNumberModel(1, 0, 22, 1);
		SpinnerModel hmodel2 = new SpinnerNumberModel(1, 0, 22, 1);
		SpinnerModel mnmodel = new SpinnerNumberModel(1, 0, 59, 1);
		SpinnerModel mnmodel2 = new SpinnerNumberModel(1, 0, 59, 1);
		
		h1 = new JSpinner(hmodel);
		h1.setBounds(216, 163, 42, 20);
		add(h1);
		
		h2 = new JSpinner(hmodel2);
		h2.setBounds(216, 191, 42, 20);
		add(h2);
		
		JLabel lblNewLabel = new JLabel("h");
		lblNewLabel.setBounds(268, 166, 46, 14);
		add(lblNewLabel);
		
		JLabel lblMn = new JLabel("mn");
		lblMn.setBounds(384, 194, 46, 14);
		add(lblMn);
		
		mn1 = new JSpinner(mnmodel);
		mn1.setBounds(324, 163, 42, 20);
		add(mn1);
		
		mn2 = new JSpinner(mnmodel2);
		mn2.setBounds(324, 191, 42, 20);
		add(mn2);
		
		JLabel lblNewLabel_1 = new JLabel("h");
		lblNewLabel_1.setBounds(268, 194, 46, 14);
		add(lblNewLabel_1);
		
		JLabel lblMn_1 = new JLabel("mn");
		lblMn_1.setBounds(384, 166, 46, 14);
		add(lblMn_1);
		
		cbJours = new JComboBox();
		
		cbJours.addItem("Lundi");
		cbJours.addItem("Mardi");
		cbJours.addItem("Mercredi");
		cbJours.addItem("Jeudi");
		cbJours.addItem("Vendredi");
		cbJours.addItem("Samedi");
		cbJours.setBounds(160, 131, 148, 21);
		add(cbJours);
		
		comboBox_1_1.setEnabled(false);
		comboBox_1.setEnabled(false);
		cbJours.setEnabled(false);
		textField_2.setEnabled(false);
		
		JCheckBox chbx = new JCheckBox("Changer le nom ?");
		chbx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setEnabled(state);
				state = !state;
			}
		});
		chbx.setBounds(380, 37, 148, 21);
		add(chbx);
		
		JCheckBox chbx2 = new JCheckBox("Changer les horaires ?");
		chbx2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbJours.setEnabled(state3);
				state3 = !state3;
			}
		});
		chbx2.setBounds(333, 130, 148, 21);
		add(chbx2);

	}
	
	public void reload() {
		ProfilDAO con = new ProfilDAO();
		listeProfil = con.getList();
		
		revalidate();
		repaint();
	
		
	}
}