package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import java.awt.Font;

public class FrameGerer extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameGerer frame = new FrameGerer();
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
	public FrameGerer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Profils : Gestion");
		setBounds(100, 100, 657, 436);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 631, 382);
		panel.setLayout(null);
		panel.setBackground(SystemColor.controlDkShadow);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 28, 140, 53);
		panel.add(panel_1);
		
		JButton btnCrerUnProfil = new JButton("Cr\u00E9er ");
		btnCrerUnProfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				@SuppressWarnings("unused")
				FrameCreerProfil fCreer = new FrameCreerProfil();
				dispose();
				fCreer.getFrame().setVisible(true);
			}
		});
		btnCrerUnProfil.setFont(new Font("Dialog", Font.BOLD, 12));
		btnCrerUnProfil.setBounds(10, 11, 120, 23);
		panel_1.add(btnCrerUnProfil);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(10, 81, 140, 53);
		panel.add(panel_1_1);
		
		JButton btnBack = new JButton("Associer");
		btnBack.setFont(new Font("Dialog", Font.BOLD, 12));
		btnBack.setBounds(10, 11, 120, 23);
		panel_1_1.add(btnBack);
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				@SuppressWarnings("unused")
				AssocierProfil assos = new AssocierProfil();
				dispose();
				assos.getFrame().setVisible(true);
			}
		});
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBounds(10, 134, 140, 53);
		panel.add(panel_1_2);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setFont(new Font("Dialog", Font.BOLD, 12));
		btnModifier.setBounds(10, 11, 120, 23);
		panel_1_2.add(btnModifier);
		
		btnModifier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				@SuppressWarnings("unused")
				FrameModifierP fModif = new FrameModifierP();
				dispose();
				fModif.setVisible(true);
			}
		});
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setLayout(null);
		panel_1_3.setBounds(10, 186, 140, 53);
		panel.add(panel_1_3);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setFont(new Font("Dialog", Font.BOLD, 11));
		btnSupprimer.setBounds(10, 11, 120, 23);
		panel_1_3.add(btnSupprimer);
		btnSupprimer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				@SuppressWarnings("unused")
				FrameSuppP fSupp = new FrameSuppP();
				dispose();
				fSupp.setVisible(true);
			}
		});
		
		
		JPanel panel_1_4 = new JPanel();
		panel_1_4.setLayout(null);
		panel_1_4.setBounds(10, 237, 140, 53);
		panel.add(panel_1_4);
		
		JButton btnChanger = new JButton("Changer");
		btnChanger.setFont(new Font("Dialog", Font.BOLD, 12));
		btnChanger.setBounds(10, 11, 120, 23);
		panel_1_4.add(btnChanger);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNewButton.setBackground(SystemColor.controlDkShadow);
		btnNewButton.setBounds(33, 316, 89, 23);
		panel.add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				@SuppressWarnings("unused")
				FrameGprofil gProfil = new FrameGprofil();
				dispose();
				gProfil.setVisible(true);
			}
		});
	}

}
