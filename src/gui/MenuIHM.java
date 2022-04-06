package gui;

import java.awt.Container;
import java.awt.EventQueue;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.Panel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import gui.*
;
import java.awt.CardLayout;public class MenuIHM {

	private JFrame frame;
	private SimuAcces simuAcces;
	private GestionBadge gBadge;
	private GestionPersonne gPersonne;
	private GestionLieu gLieu;
	
	private boolean state;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuIHM window = new MenuIHM();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuIHM() {
		initialize();
	}
	
	/**
	 * Getter for the attribute frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("MENU PRINCIPAL");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 1091, 482);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(105, 105, 105));
		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 0, 287, 444);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panelGperson = new JPanel();
		panelGperson.setBackground(new Color(192, 192, 192));
		panelGperson.setBounds(0, 100, 287, 48);
		panel.add(panelGperson);
		panelGperson.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(MenuIHM.class.getResource("/images/icons8-management-50.png")));
		lblNewLabel_3.setBounds(20, 0, 50, 40);
		panelGperson.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Gestions des personnes");
		
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setBounds(83, 11, 194, 29);
		panelGperson.add(btnNewButton);
		
		JPanel panelGCard = new JPanel();
		panelGCard.setBackground(new Color(192, 192, 192));
		panelGCard.setBounds(0, 148, 287, 56);
		panel.add(panelGCard);
		panelGCard.setLayout(null);
		
		JButton btnGrerLesCartes = new JButton("Gestion des badges");
		btnGrerLesCartes.setFont(new Font("Dialog", Font.BOLD, 13));
		
		
		
		
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon(MenuIHM.class.getResource("/images/icons8-card-exchange-64 (1).png")));
		lblNewLabel_3_1.setBounds(10, 0, 72, 56);
		panelGCard.add(lblNewLabel_3_1);
		btnGrerLesCartes.setBackground(Color.LIGHT_GRAY);
		btnGrerLesCartes.setBounds(85, 11, 192, 29);
		panelGCard.add(btnGrerLesCartes);
		
		JPanel panelGProfil = new JPanel();
		panelGProfil.setBackground(new Color(192, 192, 192));
		panelGProfil.setBounds(0, 201, 287, 62);
		panel.add(panelGProfil);
		panelGProfil.setLayout(null);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("");
		lblNewLabel_3_1_1.setIcon(new ImageIcon(MenuIHM.class.getResource("/images/icons8-edit-profile-64.png")));
		lblNewLabel_3_1_1.setBounds(10, 5, 64, 51);
		panelGProfil.add(lblNewLabel_3_1_1);
		
		JButton btnGrerDesLieux = new JButton("Gestion des profils");

		btnGrerDesLieux.setFont(new Font("Dialog", Font.BOLD, 13));
		btnGrerDesLieux.setBackground(Color.LIGHT_GRAY);
		btnGrerDesLieux.setBounds(84, 11, 193, 29);
		panelGProfil.add(btnGrerDesLieux);
		
		JPanel panelGLieux = new JPanel();
		panelGLieux.setBackground(new Color(192, 192, 192));
		panelGLieux.setBounds(0, 261, 287, 48);
		panel.add(panelGLieux);
		panelGLieux.setLayout(null);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("");
		lblNewLabel_3_1_1_1.setIcon(new ImageIcon(MenuIHM.class.getResource("/images/icons8-building-64.png")));
		lblNewLabel_3_1_1_1.setBounds(8, -5, 64, 48);
		panelGLieux.add(lblNewLabel_3_1_1_1);
		
		JButton btnGrerLesAccs = new JButton("Gestion des lieux");
		
		btnGrerLesAccs.setFont(new Font("Dialog", Font.BOLD, 13));
		btnGrerLesAccs.setBackground(Color.LIGHT_GRAY);
		btnGrerLesAccs.setBounds(82, 11, 195, 29);
		panelGLieux.add(btnGrerLesAccs);
		
		JPanel panelGAcces = new JPanel();
		panelGAcces.setBackground(new Color(192, 192, 192));
		panelGAcces.setBounds(0, 307, 287, 56);
		panel.add(panelGAcces);
		panelGAcces.setLayout(null);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("");
		lblNewLabel_3_1_1_1_1.setIcon(new ImageIcon(MenuIHM.class.getResource("/images/icons8-access-64 (1).png")));
		lblNewLabel_3_1_1_1_1.setBounds(10, 5, 64, 51);
		panelGAcces.add(lblNewLabel_3_1_1_1_1);
		
		JButton btnGrerLesAccs_1 = new JButton("Simulation d'acces");
		
		
		btnGrerLesAccs_1.setFont(new Font("Dialog", Font.BOLD, 13));
		btnGrerLesAccs_1.setBackground(Color.LIGHT_GRAY);
		btnGrerLesAccs_1.setBounds(84, 11, 193, 29);
		panelGAcces.add(btnGrerLesAccs_1);
		
		JPanel panelsignout = new JPanel();
		panelsignout.setBackground(new Color(192, 192, 192));
		panelsignout.setBounds(0, 363, 287, 36);
		panel.add(panelsignout);
		panelsignout.setLayout(null);
		
		JLabel lblNewLabel_3_1_1_1_1_1_1 = new JLabel("");
		lblNewLabel_3_1_1_1_1_1_1.setIcon(new ImageIcon(MenuIHM.class.getResource("/images/icons8-export-24.png")));
		lblNewLabel_3_1_1_1_1_1_1.setBounds(25, 2, 40, 26);
		panelsignout.add(lblNewLabel_3_1_1_1_1_1_1);
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int quit = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment quitter ?", "Quitter ?",
					      JOptionPane.YES_NO_CANCEL_OPTION,
					      JOptionPane.PLAIN_MESSAGE, null);
				if (quit == 0)
					frame.dispose();
			}
		});
		btnSignOut.setFont(new Font("Dialog", Font.BOLD, 13));
		btnSignOut.setBackground(Color.LIGHT_GRAY);
		btnSignOut.setBounds(86, 2, 191, 26);
		panelsignout.add(btnSignOut);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MenuIHM.class.getResource("/images/logo_esig.png")));
		lblNewLabel_1.setBounds(0, 0, 287, 101);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(285, 0, 790, 444);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, "Menu");
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.5f));
		panel_3.setBounds(0, 195, 790, 120);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("WELCOME TO THE MAIN MENU");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 33));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(171, 0, 609, 120);
		panel_3.add(lblNewLabel_2);
		lblNewLabel_2.setBackground(new Color(176, 224, 230));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MenuIHM.class.getResource("/images/esig_bg.jpg")));
		lblNewLabel.setBounds(0, 0, 790, 444);
		panel_2.add(lblNewLabel);
		panel_1.add(new GestionProfil(), "GestionProfil");
		
		simuAcces = new SimuAcces();
		gBadge = new GestionBadge();
		gPersonne = new GestionPersonne();
		gLieu = new GestionLieu();
		
		panel_1.add(simuAcces, "SimuAcces");
		panel_1.add(gBadge, "GestionBadge");
		panel_1.add(gPersonne, "GestionPersonne");
		panel_1.add(gLieu, "GestionLieu");
		
		
		btnGrerDesLieux.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//@SuppressWarnings("unused")
				CardLayout cl = (CardLayout)(panel_1.getLayout());
				cl.show(panel_1,"GestionProfil");
			}
		});
		
		btnGrerLesCartes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout)(panel_1.getLayout());
				cl.show(panel_1,"GestionBadge");
			}
		});
		
		btnGrerLesAccs_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panel_1.getLayout());
				cl.show(panel_1,"SimuAcces");
				if(state) {
					simuAcces.enable();
				}
				else {
					simuAcces.enable2();
					state = false;
				}
				
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panel_1.getLayout());
				cl.show(panel_1,"GestionPersonne");
			}
		});
		
		btnGrerLesAccs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panel_1.getLayout());
				cl.show(panel_1,"GestionLieu");
			}
		});
		CardLayout cl = (CardLayout)(panel_1.getLayout());
		cl.show(panel_1,"Menu");
	}
}
