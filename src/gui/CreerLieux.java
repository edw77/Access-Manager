package gui;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import bdd.ProfilDAO;
import model.Profil;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.JSpinner;

public class CreerLieux extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private Button button;
	private ArrayList<Lieu> listeLieu;
	
	private JSpinner h1;
	private JSpinner h2;
	private JSpinner mn1;
	private JSpinner mn2;
	
	
	
	public void enable(ArrayList<Lieu> listeLieu) {
		this.listeLieu = listeLieu ;
		
		//Chargement de la liste des noms des lieux
		
		ArrayList<String> Lieux = new ArrayList<String>();
		for(int i = 0; i < listeLieu.size(); i++ ) {
			Lieux.add(listeLieu.get(i).getNomLieu());
		}
		
		cbJours.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
			}
		});
		
		//Action du boutton
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane warning = new JOptionPane();
				if (textField.getText().equals("") || Lieux.contains("textField.getText()")) {
					warning.showMessageDialog( null, "You have to enter a name for the new Area !", 
						      "Warning", JOptionPane.WARNING_MESSAGE);
				}
				else {
					LieuDAO con = new LieuDAO();
					con.add(new Lieu(textField.getText()));
					warning.showMessageDialog( null, textField.getText() + " a été ajouté à la liste des Lieux", 
						      "Success", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}
	

	/**
	 * Create the panel.
	 */
	public CreerLieux() {
		setLayout(null);
		
		JLabel lblNomDuLieu = new JLabel(" Nom du lieu");
		lblNomDuLieu.setBounds(22, -14, 91, 78);
		add(lblNomDuLieu);
		
		JLabel lblEmplacement = new JLabel("Emplacement");
		lblEmplacement.setBounds(22, 35, 91, 78);
		add(lblEmplacement);
		
		JLabel lblNombreDaccs = new JLabel("nombre d'acc\u00E8s");
		lblNombreDaccs.setBounds(22, 86, 91, 67);
		add(lblNombreDaccs);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(142, 11, 257, 28);
		add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(142, 60, 257, 28);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(142, 111, 257, 28);
		add(textField_2);
		
		Button button = new Button("Cr\u00E9er le lieu");
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241, 57, 83));
		button.setBounds(102, 220, 257, 42);
		add(button);
		
		JLabel lblEmplacement_1_1 = new JLabel("horaire d'ouverture");
		lblEmplacement_1_1.setBounds(22, 124, 127, 78);
		add(lblEmplacement_1_1);
		
		SpinnerModel hmodel = new SpinnerNumberModel(1, 0, 22, 1);
		SpinnerModel mnmodel = new SpinnerNumberModel(1, 0, 59, 1);
		
		h1 = new JSpinner(hmodel);
		h1.setBounds(160, 226, 42, 20);
		h1.
		add(h1);
		
		h2 = new JSpinner(hmodel);
		h2.setBounds(160, 265, 42, 20);
		add(h2);
		
		JLabel lblNewLabel = new JLabel("h");
		lblNewLabel.setBounds(212, 229, 46, 14);
		add(lblNewLabel);
		
		JLabel lblMn = new JLabel("mn");
		lblMn.setBounds(328, 268, 46, 14);
		add(lblMn);
		
		mn1 = new JSpinner(mnmodel);
		mn1.setBounds(268, 226, 42, 20);
		add(mn1);
		
		mn2 = new JSpinner(mnmodel);
		mn2.setBounds(268, 265, 42, 20);
		add(mn2);
		
		JLabel lblNewLabel_1 = new JLabel("h");
		lblNewLabel_1.setBounds(212, 268, 46, 14);
		add(lblNewLabel_1);
		
		JLabel lblMn_1 = new JLabel("mn");
		lblMn_1.setBounds(328, 229, 46, 14);
		add(lblMn_1);
		
		cbJours = new JComboBox();
		
		cbJours.addItem("Lundi");
		cbJours.addItem("Mardi");
		cbJours.addItem("Mercredi");
		cbJours.addItem("Jeudi");
		cbJours.addItem("Vendredi");
		cbJours.addItem("Samedi");
		cbJours.setBounds(174, 194, 148, 21);
		add(cbJours);


	}

}
