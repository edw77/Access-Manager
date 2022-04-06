package gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bdd.BadgeDAO;
import bdd.PersonDAO;
import model.Personne;

public class CreerBadges extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreerBadges frame = new CreerBadges();
					frame.setVisible(true);
					frame.enable();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private boolean state;
	private Button button;
	private JPanel contentPane;
	private JComboBox comboBox;
	
	/**
	 * Create the panel.
	 */
	public CreerBadges() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Liste des personnes sans badge");
		lblNewLabel.setBounds(10, 122, 197, 14);
		contentPane.add(lblNewLabel);
		
		button = new Button("Cr\u00E9er le badge");
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241, 57, 83));
		button.setBounds(262, 166, 162, 36);
		contentPane.add(button);
		
		Button button_1 = new Button("Retour");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color(0, 0, 128));
		button_1.setBounds(10, 163, 151, 39);
		contentPane.add(button_1);
		
		comboBox = new JComboBox();
		comboBox.setBounds(193, 118, 166, 22);
		contentPane.add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(60, 179, 113));
		panel.setBounds(0, 0, 434, 88);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel headerlbl = new JLabel("Choisir une personne \u00E0 qui associer le nouveau badge");
		headerlbl.setBounds(0, 5, 414, 83);
		headerlbl.setForeground(Color.WHITE);
		headerlbl.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		headerlbl.setBackground(Color.BLACK);
		panel.add(headerlbl);
		
		state = false;

	}
	
	public void enable() {
		
		if(state) {
			comboBox.removeAllItems();
		}
		
		PersonDAO con = new PersonDAO();
		BadgeDAO con2 = new BadgeDAO();
		
		ArrayList<Personne> listePersonne = con.getListWithNoBadge();
		
		if(listePersonne.isEmpty()) {
			comboBox.addItem("Vide");
			button.setEnabled(false);
		}
		else {
			for(int i=0; i < listePersonne.size(); i++)
				comboBox.addItem(listePersonne.get(i).getNom());
		}
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedPersonneId = 0;
				
				for(int i=0; i < listePersonne.size(); i++) {
					if(listePersonne.get(i).getNom().equals(comboBox.getSelectedItem().toString())) {
						selectedPersonneId = listePersonne.get(i).getId();
					}
				}
				
				BadgeDAO con = new BadgeDAO();
				con.add(selectedPersonneId);
				
				JOptionPane warning = new JOptionPane();
				warning.showMessageDialog( null," Badge créé ! Il est associé à la personne : " + comboBox.getSelectedItem().toString(), 
					      "Success", JOptionPane.WARNING_MESSAGE);
				dispose();
				
			}
		});
		
	}
}
