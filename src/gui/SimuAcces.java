package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import java.awt.Button;
import java.awt.Color;
import bdd.*;
import model.*;
import java.util.ArrayList;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;




public class SimuAcces extends JPanel {
	
	
	private JTextField textField;
	private JComboBox areaCb;
	private JComboBox badgeCb;
	private JComboBox cbJours;
	
	private JSpinner minSpinner;
	private JSpinner hourSpinner;
	
	private String[] listeJours = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"};
	
	private Button button;
	
	private boolean state;
	private boolean state2;
	
	private boolean[] choiceMade;
	
	private Lieu selectedLieu;
	private Badge selectedBadge;
	
	private ArrayList<Lieu> listeLieu;
	private ArrayList<Badge> listeBadge;

	public void enable2() {
		choiceMade[0] = false;
		choiceMade[1] = choiceMade[0];
		
		//Remplissage des comboBox
		if(!state) {
			areaCb.removeAllItems();
			badgeCb.removeAllItems();
		}
		
		
		
		BadgeDAO con = new BadgeDAO();
		listeBadge = con.getList();
		LieuDAO con2 = new LieuDAO();
		listeLieu = con2.getList();
		
		
		for(int i = 0; i < listeBadge.size(); i++ )
			badgeCb.addItem(listeBadge.get(i).getId());
		
		for(int i = 0; i < listeLieu.size(); i++ )
			areaCb.addItem(listeLieu.get(i).getNomLieu());
		
		state = !state;
	}
	
	public void enable() {
		choiceMade[0] = false;
		choiceMade[1] = choiceMade[0];
		
		//Remplissage des comboBox
		if(!state) {
			areaCb.removeAllItems();
			badgeCb.removeAllItems();
		}
		
		
		
		BadgeDAO con = new BadgeDAO();
		ArrayList<Badge> listeBadge = con.getList();
		LieuDAO con2 = new LieuDAO();
		ArrayList<Lieu> listeLieu = con2.getList();
		
		
		for(int i = 0; i < listeBadge.size(); i++ )
			badgeCb.addItem(listeBadge.get(i).getId());
		
		for(int i = 0; i < listeLieu.size(); i++ )
			areaCb.addItem(listeLieu.get(i).getNomLieu());
		
		state = !state;
		
		
		
	}
	
	
	
	
	/**
	 * Create the panel.
	 */
	public SimuAcces() {
		
		choiceMade = new boolean[2];
		
		
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel areaIcon = new JLabel("");
		areaIcon.setIcon(new ImageIcon(SimuAcces.class.getResource("/images/area.png")));
		areaIcon.setBounds(304, 31, 64, 70);
		add(areaIcon);
		
		JLabel badgeIcon = new JLabel("");
		badgeIcon.setIcon(new ImageIcon(SimuAcces.class.getResource("/images/badge.png")));
		badgeIcon.setBounds(27, 31, 64, 70);
		add(badgeIcon);
		
		JLabel personIcon = new JLabel("");
		personIcon.setIcon(new ImageIcon(SimuAcces.class.getResource("/images/person.png")));
		personIcon.setBounds(27, 112, 64, 70);
		add(personIcon);
		
		badgeCb = new JComboBox();
		
		badgeCb.setBounds(117, 57, 124, 22);
		add(badgeCb);
		
		areaCb = new JComboBox();
		
		areaCb.setBounds(406, 57, 124, 22);
		add(areaCb);
		
		JLabel hourIcon = new JLabel("New label");
		hourIcon.setIcon(new ImageIcon(SimuAcces.class.getResource("/images/times.jpg")));
		hourIcon.setBounds(304, 112, 64, 70);
		add(hourIcon);
		
		SpinnerModel hmodel = new SpinnerNumberModel(1, 0, 23, 1);
		SpinnerModel mnmodel = new SpinnerNumberModel(1, 0, 59, 1);
		
		hourSpinner = new JSpinner(hmodel);
		hourSpinner.setBounds(406, 169, 46, 20);
		add(hourSpinner);
		
		minSpinner = new JSpinner(mnmodel);
		minSpinner.setBounds(406, 194, 46, 20);
		add(minSpinner);
		
		JLabel hour = new JLabel("h");
		hour.setBounds(484, 169, 46, 14);
		add(hour);
		
		JLabel minutes = new JLabel("mn");
		minutes.setBounds(484, 194, 46, 14);
		add(minutes);
		
		JLabel badgeHeader = new JLabel("Selectionnez un badge");
		badgeHeader.setBounds(117, 31, 177, 14);
		add(badgeHeader);
		
		JLabel personHeader = new JLabel("Ce badge est associ\u00E9 \u00E0 :");
		personHeader.setBounds(117, 108, 177, 14);
		add(personHeader);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(117, 133, 124, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel timeHeader = new JLabel("Heure de la tentative d'acc\u00E8s");
		timeHeader.setBounds(406, 112, 202, 14);
		add(timeHeader);
		
		button = new Button("Lancer la simulation");
		
		button.setForeground(new Color(0, 0, 255));
		button.setBackground(new Color(241, 57, 83));
		button.setBounds(199, 236, 212, 28);
		button.setEnabled(false);
		add(button);
		
		JLabel areaHeader = new JLabel("Selectionnez le lieu o\u00F9 acc\u00E9der");
		areaHeader.setBounds(406, 32, 202, 14);
		add(areaHeader);
		
		cbJours = new JComboBox();
		cbJours.setBounds(406, 136, 124, 22);
		add(cbJours);
		
		cbJours.addItem("Lundi");
		cbJours.addItem("Mardi");
		cbJours.addItem("Mercredi");
		cbJours.addItem("Jeudi");
		cbJours.addItem("Vendredi");
		cbJours.addItem("Samedi");
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		add(panel);
		panel.setLayout(null);
		
		state = true;
		
		//Changement de badge dans la comboBox
				badgeCb.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						//Activation ou non du bouton de test
						if(areaCb.getSelectedItem() != null) {
							choiceMade[1] = true;
							
							if(choiceMade[0] && choiceMade[1])
								button.setEnabled(true);
							for(int i = 0; i < listeBadge.size(); i++ )
								if(areaCb.getSelectedItem() != null) {
									if(listeBadge.get(i).getId() == Integer.parseInt(badgeCb.getSelectedItem().toString()))
										selectedBadge = listeBadge.get(i);
								}
								
							textField.setText(selectedBadge.getPersonne().getPrenom() + " " + selectedBadge.getPersonne().getNom());
						}
						}
						
				});
				
				//Activation ou non du bouton de test
				areaCb.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						if(areaCb.getSelectedItem() != null) {
							choiceMade[0] = true;
							for(int i = 0; i < listeLieu.size(); i++ ) {
								if(areaCb.getSelectedItem() != null) {
									if(listeLieu.get(i).getNomLieu().equals(areaCb.getSelectedItem().toString()))
										selectedLieu = listeLieu.get(i);
								}
								
							}
								
							if(choiceMade[0] && choiceMade[1])
								button.setEnabled(true);
						}
						}
						
				});
				
				//Action du bouton de test
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int numJour = -1;
						boolean access = false;
						
						for(int i = 0; i < listeJours.length; i++) {
							if(cbJours.getSelectedItem().toString().equals(listeJours[i])) {
								numJour = i;
							}
						}
						
						for(int j = 0; j < selectedBadge.getPersonne().getProfil().getListeLieu().size(); j++) {
							if(selectedBadge.getPersonne().getProfil().getListeLieu().get(j).getId() == selectedLieu.getId()) {
								String test1 = hourSpinner.getValue().toString();
								String test2 = minSpinner.getValue().toString();
								int hour = Integer.parseInt(hourSpinner.getValue().toString());
								int min = Integer.parseInt(minSpinner.getValue().toString());
								
								Heure[] ouvFerm = selectedBadge.getPersonne().getProfil().getListeHoraire().get(j).getHoraire(numJour);
								
								if( hour >= ouvFerm[0].getHeure() && hour <= ouvFerm[1].getHeure() ) {
									if(hour == ouvFerm[0].getHeure()) {
										if(min < ouvFerm[0].getMinute())
											access = false;
									}
									else if( hour == ouvFerm[1].getHeure()) {
										if(min > ouvFerm[1].getMinute())
											access = false;
									}
									access = true;
								}
								
							}
							break;
						}
						
						AccessPanel accessP = new AccessPanel(access);
						accessP.setVisible(true);
						
					}
				});
	}
	
}
