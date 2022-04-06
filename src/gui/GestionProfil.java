package gui;

import javax.swing.JPanel;

import bdd.ProfilDAO;
import model.Profil;

import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class GestionProfil extends JPanel {

	private CreerProfil creer;
	private ModifierProfil modifier;
	private SupprimerProfil supprimer;
	private ListeProfil liste;
	private AssocProfil assos;
	
	private ArrayList<Profil> listeProfils;
	
	public ArrayList<Profil> getListeProfils(){
		return listeProfils;
	}
	
	public void loadListeProfils() {
		ProfilDAO con = new ProfilDAO();
		listeProfils = con.getList();
	}
	
	
	/**
	 * Create the panel.
	 */
	public GestionProfil() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 136, 300);
		add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Modifier");
		btnNewButton.setBounds(15, 75, 121, 34);
		panel.add(btnNewButton);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(15, 120, 121, 34);
		panel.add(btnSupprimer);
		
		JButton btnAssocier = new JButton("Associer");
		btnAssocier.setBounds(15, 165, 121, 34);
		panel.add(btnAssocier);
		
		JButton btnListeDesProfils = new JButton("Liste des profils");
		btnListeDesProfils.setBounds(15, 210, 121, 34);
		panel.add(btnListeDesProfils);
		
		JButton btnCrerUnNouveau = new JButton("Cr\u00E9er");
		btnCrerUnNouveau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCrerUnNouveau.setBounds(15, 30, 121, 34);
		panel.add(btnCrerUnNouveau);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(136, 0, 522, 371);
		add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		
		JLabel img1 = new JLabel("");
		img1.setIcon(new ImageIcon(MenuIHM.class.getResource("/images/icons8-edit-profile-64.png")));
		
		
		creer = new CreerProfil();
		modifier = new ModifierProfil();
		supprimer = new SupprimerProfil();
		liste = new ListeProfil();
		assos = new AssocProfil();
		
		panel_1.add(img1);
		panel_1.add(creer, "CreerProfil");
		panel_1.add(liste, "ListeProfil");
		panel_1.add(modifier, "ModifierProfil");
		panel_1.add(supprimer, "SupprimerProfil");
		panel_1.add(assos, "AssocierProfil");
		
		btnListeDesProfils.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadListeProfils();
				liste.enable(listeProfils);
				
				CardLayout cl = (CardLayout)(panel_1.getLayout());
				cl.show(panel_1,"ListeProfil");
				
				
			}
		});
		
		btnCrerUnNouveau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadListeProfils();
				creer.enable(listeProfils);
				
				CardLayout cl = (CardLayout)(panel_1.getLayout());
				cl.show(panel_1,"CreerProfil");
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadListeProfils();
				modifier.enable(listeProfils);
				
				CardLayout cl = (CardLayout)(panel_1.getLayout());
				cl.show(panel_1,"ModifierProfil");
			}
		});
		
		btnAssocier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadListeProfils();
				assos.enable(listeProfils);
				
				CardLayout cl = (CardLayout)(panel_1.getLayout());
				cl.show(panel_1,"AssocierProfil");
			}
		});
		
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadListeProfils();
				supprimer.enable(listeProfils);
				
				CardLayout cl = (CardLayout)(panel_1.getLayout());
				cl.show(panel_1,"SupprimerProfil");
			}
		});

	}
}
