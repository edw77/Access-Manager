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
import java.awt.Button;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameSuppP extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameSuppP frame = new FrameSuppP();
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
	public FrameSuppP() {
		this.setTitle("Menu Profils : Supprimer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 434);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.BLACK);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 283, 391);
		contentPane.add(panel);
		
		Button button = new Button("Supprimer le profil");

		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241, 57, 83));
		button.setBounds(380, 294, 257, 42);
		contentPane.add(button);
		
		JComboBox comboBox_1_1 = new JComboBox();
		
		ProfilDAO con = new ProfilDAO();
		ArrayList<Profil> listeProfil = con.getList();
		String[] profils = new String[listeProfil.size()];
		for(int i = 0; i < listeProfil.size(); i++ ) {
			profils[i] = listeProfil.get(i).getNomProfil();
			comboBox_1_1.addItem(profils[i]);
		}
		
		comboBox_1_1.setBounds(416, 111, 257, 21);
		
		
		contentPane.add(comboBox_1_1);
		
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane warning = new JOptionPane();
				String selection = comboBox_1_1.getSelectedItem().toString();
				ProfilDAO con = new ProfilDAO();
				for(int i = 0; i<listeProfil.size(); i++) {
					if(selection.equals(profils[i])) {
						con.delete(listeProfil.get(i));
						comboBox_1_1.removeItem(listeProfil.get(i).getNomProfil());
						warning.showMessageDialog( null,listeProfil.get(i).getNomProfil() + " a été supprimé à la liste des Profils", 
							      "Success", JOptionPane.WARNING_MESSAGE);
					}
					
				}
				
			}
		});
		
		JLabel lblSlectionnerUnProfil = new JLabel("S\u00E9lectionner un profil");
		lblSlectionnerUnProfil.setBounds(291, 114, 115, 14);
		contentPane.add(lblSlectionnerUnProfil);
		
		Button button_1 = new Button("Back");
		button_1.setBounds(291, 10, 70, 22);
		contentPane.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				FrameGerer fGerer = new FrameGerer();
				dispose();
				fGerer.setVisible(true);
			}
		});
	}

}
