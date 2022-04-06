package gui;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.JPanel;

import java.util.Calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.*;
import java.awt.*;

import bdd.ProfilDAO;
import bdd.PersonDAO;
import model.Profil;
import model.Personne;

public class CreerPersonnes extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private Button button;
	private ArrayList<Personne> listePersonne;
	
	public void enable(ArrayList<Personne> listePersonne) {
		this.listePersonne = listePersonne;
		
		//Chargement de la liste des noms des personnes
		
		ArrayList<String> personnes = new ArrayList<String>();
		for(int i = 0; i < listePersonne.size(); i++ ) {
			personnes.add(listePersonne.get(i).getNom());
		}
		
		//Action du boutton
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane warning = new JOptionPane();
						if (textField.getText().equals("") || personnes.contains("textField.getText()")) {
							warning.showMessageDialog( null, "You have to enter a name for the new Person !", 
								      "Warning", JOptionPane.WARNING_MESSAGE);
						}
						else {
							PersonDAO con = new PersonDAO();
							con.add(new Personne(textField.getText()));
							warning.showMessageDialog( null, textField.getText() + " a été ajouté à la liste des Personnes", 
								      "Success", JOptionPane.WARNING_MESSAGE);
						}
					}
				});
			}

	/**
	 * Create the panel.
	 */
	public CreerPersonnes() {
		setLayout(null);
		
		Button button = new Button("Cr\u00E9er la personne");
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241, 57, 83));
		button.setBounds(109, 221, 257, 42);
		add(button);
		
		
		 
		
		
		JLabel lblNom = new JLabel(" Nom");
		lblNom.setBounds(10, 11, 91, 78);
		add(lblNom);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom");
		lblPrnom.setBounds(10, 63, 91, 78);
		add(lblPrnom);
		
		JLabel lblDateDeNaissance = new JLabel("Date de naissance");
		lblDateDeNaissance.setBounds(10, 117, 91, 78);
		add(lblDateDeNaissance);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(128, 40, 257, 28);
		add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(128, 92, 257, 28);
		add(textField_1);
		
		JDatePickerImpl datePicker = new JDatePickerImpl(null, null);
		datePicker.setBounds(169, 160, 82, -19);
		add(datePicker);
		
		 UtilDateModel model = new UtilDateModel();
	      //model.setDate(20,04,2014);
	     JDatePanelImpl datePanel = new JDatePanelImpl(model, null);

	}
}
