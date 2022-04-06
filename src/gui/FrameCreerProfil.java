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

public class FrameCreerProfil {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameCreerProfil window = new FrameCreerProfil();
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
	public FrameCreerProfil() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Menu Profil : Creer");
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
		
		Button button = new Button("Cr\u00E9er le profil");
		ProfilDAO con = new ProfilDAO();
		ArrayList<Profil> listeProfil = con.getList();
		ArrayList<String> profils = new ArrayList<String>();
		for(int i = 0; i < listeProfil.size(); i++ ) {
			profils.add(listeProfil.get(i).getNomProfil());
		}
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane warning = new JOptionPane();
				if (textField.getText().equals("") || profils.contains("textField.getText()")) {
					warning.showMessageDialog( null, "You have to enter a name for the new Profile !\nAlso, make sure the name is not already taken !", 
						      "Warning", JOptionPane.WARNING_MESSAGE);
				}
				else {
					con.add(new Profil(textField.getText()));
					warning.showMessageDialog( null, textField.getText() + " a été ajouté à la liste des Profils", 
						      "Success", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241, 57, 83));
		button.setBounds(455, 317, 257, 42);
		frame.getContentPane().add(button);
		
		textField = new JTextField();
		textField.setBounds(455, 174, 257, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNomDuProfil = new JLabel(" Nom du profil");
		lblNomDuProfil.setBounds(354, 181, 91, 14);
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
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 760, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
