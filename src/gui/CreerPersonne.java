package gui;

import java.awt.BorderLayout;
import model.*;
import bdd.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Button;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreerPersonne extends JPanel {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	

	/**
	 * Create the frame.
	 */
	public CreerPersonne() {
		setBounds(100, 100, 450, 300);
		setBorder(new EmptyBorder(5, 5, 5, 5));setLayout(null);
		
		Button button = new Button("Cr\u00E9er la personne");
		
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241, 57, 83));
		button.setBounds(262, 185, 162, 36);
		add(button);
		
		
		textField = new JTextField();
		textField.setBounds(75, 32, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(75, 90, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(230, 60, 118, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(10, 35, 46, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prenom");
		lblNewLabel_1.setBounds(10, 93, 46, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Date de naissance");
		lblNewLabel_2.setBounds(230, 35, 142, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("format DD-MM-YYYY seulement !");
		lblNewLabel_3.setBounds(230, 93, 194, 14);
		add(lblNewLabel_3);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Personne newPers = new Personne(0,textField.getText(),textField_1.getText(),textField_2.getText(),null);
				PersonDAO con = new PersonDAO();
				
				con.add(newPers);
				JOptionPane warning = new JOptionPane();
				warning.showMessageDialog( null," La personne "+ newPers.getPrenom() + " " + newPers.getNom() + " a été créée ", 
					      "Success", JOptionPane.WARNING_MESSAGE);
				
			}
		});
	}
}
