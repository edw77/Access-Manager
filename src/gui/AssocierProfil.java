package gui;

import java.util.ArrayList;
import model.*;
import bdd.*;
import javax.swing.JOptionPane;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JList;
import java.awt.Choice;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class AssocierProfil {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AssocierProfil window = new AssocierProfil();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Getter for the attribute frame
	 */
	public JFrame getFrame() {
		return frame;
	}
	
	/**
	 * Create the application.
	 */
	public AssocierProfil() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Associer un profil à une personne");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 344, 391);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrameCreerProfil.class.getResource("/images/logo_esig.png")));
		lblNewLabel.setBounds(20, 82, 324, 187);
		panel.add(lblNewLabel);
		
		Button button = new Button("Associer ");
		ProfilDAO con = new ProfilDAO();
		PersonDAO con2 = new PersonDAO();
		ArrayList<Profil> listeProfil = con.getList();
		ArrayList<Personne> listePersonne = con2.getList();
		ArrayList<String> profils = new ArrayList<String>();
		ArrayList<String> personnes = new ArrayList<String>();
		
		
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241, 57, 83));
		button.setBounds(455, 317, 257, 42);
		frame.getContentPane().add(button);
		
		JLabel lblNomDuProfil = new JLabel(" Nom du profil");
		lblNomDuProfil.setBounds(354, 59, 91, 14);
		frame.getContentPane().add(lblNomDuProfil);
		
		Button button_1 = new Button("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				FrameGerer fGerer = new FrameGerer();
				frame.dispose();
				fGerer.setVisible(true);
			}
		});
		button_1.setBounds(356, 10, 70, 22);
		frame.getContentPane().add(button_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(510, 155, 140, 22);
		frame.getContentPane().add(comboBox);
		
		JLabel lblAssocier = new JLabel("Associer \u00E0...");
		lblAssocier.setBounds(354, 159, 91, 14);
		frame.getContentPane().add(lblAssocier);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(510, 59, 140, 22);
		frame.getContentPane().add(comboBox_1);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 760, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		for(int i = 0; i < listeProfil.size(); i++ ) {
			profils.add(listeProfil.get(i).getNomProfil());
			comboBox_1.addItem(profils.get(i));
		}
		
		for(int i = 0; i < listePersonne.size(); i++ ) {
			personnes.add(listePersonne.get(i).getNom());
			comboBox.addItem(personnes.get(i));
		}
		
		
		button.addActionListener(new ActionListener() {
			JOptionPane warning = new JOptionPane();
			public void actionPerformed(ActionEvent e) {
				if (comboBox_1.getSelectedIndex() == -1 || comboBox.getSelectedIndex() == -1) {
					warning.showMessageDialog( null," One or more fields are empty !", 
						      "WARNING", JOptionPane.WARNING_MESSAGE);
				}
				
				else {
					String selection1 = comboBox_1.getSelectedItem().toString();
					String selection2 = comboBox.getSelectedItem().toString();
					int idPersonne = -1;
					int idProfil = -1;
					for(int i = 0; i<listeProfil.size(); i++) {
						if(selection1.equals(profils.get(i))) {
							idProfil = i;
						}
					}
						
					for(int i = 0; i<listePersonne.size(); i++) {
						if(selection2.equals(personnes.get(i))) {
								idPersonne = i;
							}
					}
					con.associate(listeProfil.get(idProfil), listePersonne.get(idPersonne));
					warning.showMessageDialog( null,personnes.get(idPersonne) + " has now the profile "+ profils.get(idProfil), 
						      "WARNING", JOptionPane.WARNING_MESSAGE);
					}
				}
		});
	}
}
