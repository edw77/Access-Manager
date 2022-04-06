package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bdd.ProfilDAO;
import model.Profil;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class FrameModifierP extends JFrame {
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameModifierP frame = new FrameModifierP();
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
	public FrameModifierP() {
		this.setTitle("Menu Profils : Modifier");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBounds(0, 0, 344, 391);
		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		getContentPane().add(panel);
		
		Button button = new Button("Modifier le profil");
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241, 57, 83));
		button.setBounds(455, 317, 257, 42);
		getContentPane().add(button);
		
		
		JLabel lblNomDuProfil = new JLabel(" Nom du profil");
		lblNomDuProfil.setBounds(354, 52, 91, 14);
		getContentPane().add(lblNomDuProfil);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(455, 194, 257, 21);
		getContentPane().add(comboBox_1);
		
		JLabel lblLhoraireDuLieu = new JLabel("L'horaire d'ouverture");
		lblLhoraireDuLieu.setBounds(354, 233, 100, 14);
		getContentPane().add(lblLhoraireDuLieu);
		
		JLabel lblLieux = new JLabel("Lieux");
		lblLieux.setBounds(358, 197, 91, 14);
		getContentPane().add(lblLieux);
		
		Button button_1 = new Button("Back");
		button_1.setBounds(350, 10, 70, 22);
		getContentPane().add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				FrameGerer fGerer = new FrameGerer();
				dispose();
				fGerer.setVisible(true);
			}
		});
		
		JLabel lblLhoraireDeFermeture = new JLabel("L'horaire de fermeture");
		lblLhoraireDeFermeture.setBounds(354, 275, 108, 14);
		getContentPane().add(lblLhoraireDeFermeture);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(470, 219, 246, 28);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(469, 272, 257, 28);
		getContentPane().add(textField_2);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(455, 49, 257, 21);
		getContentPane().add(comboBox_1_1);
		
		JLabel lblNouveauNom = new JLabel("Nouveau nom");
		lblNouveauNom.setBounds(354, 158, 100, 14);
		getContentPane().add(lblNouveauNom);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(455, 144, 246, 28);
		getContentPane().add(textField);
		
		ProfilDAO con = new ProfilDAO();
		ArrayList<Profil> listeProfil = con.getList();
		String[] profils = new String[listeProfil.size()];
		for(int i = 0; i < listeProfil.size(); i++ ) {
			profils[i] = listeProfil.get(i).getNomProfil();
			comboBox_1_1.addItem(profils[i]);
		}
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane warning = new JOptionPane();
				for(int i = 0; i < listeProfil.size(); i++ ) {
					if(listeProfil.get(i).getNomProfil().equals(comboBox_1_1.getSelectedItem())) {
						listeProfil.get(i).setNomProfil(textField.getText());
						warning.showMessageDialog( null,listeProfil.get(i).getNomProfil() + " a été modifié", 
							      "Success", JOptionPane.WARNING_MESSAGE);
						con.update(listeProfil.get(i));
						comboBox_1_1.removeAllItems();
						for(int j = 0; j < listeProfil.size(); j++ ) {
							profils[j] = listeProfil.get(j).getNomProfil();
							comboBox_1_1.addItem(profils[j]);
						}
					}
				}
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 760, 486);
	}
}
