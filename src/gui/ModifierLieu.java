package gui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Button;
import java.awt.Color;
import javax.swing.JSpinner;

public class ModifierLieu extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	
	private Button button;
	private Button button2;
	private JComboBox comboBox_1;
	private JComboBox comboBox_1_1;
	private JComboBox cbJours;
	
	

	/**
	 * Create the panel.
	 */
	public ModifierLieu() {
		setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(150, 28, 221, 22);
		add(comboBox);
		
		JLabel lblNomDuLieu = new JLabel(" Nom du lieu");
		lblNomDuLieu.setBounds(10, 0, 91, 78);
		add(lblNomDuLieu);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(136, 61, 257, 28);
		add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(136, 115, 257, 28);
		add(textField_1);
		
		JLabel lblEmplacement = new JLabel("New Emplacement");
		lblEmplacement.setBounds(10, 36, 91, 78);
		add(lblEmplacement);
		
		JLabel lblEmplacement_1 = new JLabel("New nombre d'acc\u00E8s");
		lblEmplacement_1.setBounds(10, 89, 106, 78);
		add(lblEmplacement_1);
		
		Button button = new Button("Modifier le lieu");
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241, 57, 83));
		button.setBounds(114, 225, 257, 42);
		add(button);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(158, 164, 45, 20);
		add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(213, 164, 45, 20);
		add(spinner_1);
		
		JSpinner spinner_1_1 = new JSpinner();
		spinner_1_1.setBounds(268, 164, 45, 20);
		add(spinner_1_1);
		
		JSpinner spinner_1_2 = new JSpinner();
		spinner_1_2.setBounds(323, 164, 48, 20);
		add(spinner_1_2);
		
		JLabel lblEmplacement_1_1 = new JLabel("New horaire d'ouverture");
		lblEmplacement_1_1.setBounds(10, 135, 127, 78);
		add(lblEmplacement_1_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(150, 195, 45, 20);
		add(spinner_2);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(213, 195, 45, 20);
		add(spinner_3);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setBounds(268, 195, 45, 20);
		add(spinner_4);
		
		JSpinner spinner_5 = new JSpinner();
		spinner_5.setBounds(323, 195, 45, 20);
		add(spinner_5);
		
		JLabel lblEmplacement_1_1_1 = new JLabel("New horaire de fermeture");
		lblEmplacement_1_1_1.setBounds(10, 167, 127, 78);
		add(lblEmplacement_1_1_1);

	}
}
