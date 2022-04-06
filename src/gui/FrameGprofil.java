package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameGprofil extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameGprofil frame = new FrameGprofil();
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
	public FrameGprofil() {
		setTitle("Profils : Gestion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.controlDkShadow);
		panel.setBounds(10, 11, 150, 381);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 11, 130, 50);
		panel.add(panel_1);
		
		JButton btnGrer = new JButton("G\u00E9rer");
		btnGrer.setForeground(Color.BLACK);
		btnGrer.setFont(new Font("Dialog", Font.BOLD, 13));
		btnGrer.setBackground(Color.LIGHT_GRAY);
		btnGrer.setBounds(27, 11, 74, 26);
		panel_1.add(btnGrer);
		btnGrer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				@SuppressWarnings("unused")
				FrameGerer fGerer = new FrameGerer();
				dispose();
				fGerer.setVisible(true);
			}
		});
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				@SuppressWarnings("unused")
				MenuIHM menu = new MenuIHM();
				dispose();
				menu.getFrame().setVisible(true);
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 13));
		btnNewButton.setBackground(SystemColor.controlDkShadow);
		btnNewButton.setBounds(29, 353, 89, 23);
		panel.add(btnNewButton);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(10, 77, 130, 50);
		panel.add(panel_1_1);
		
		JButton btnNewButton_1_1 = new JButton("Lister");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				@SuppressWarnings("unused")
				ListeProfils liste = new ListeProfils();
				liste.setVisible(true);
			}
		});
		btnNewButton_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1.setFont(new Font("Dialog", Font.BOLD, 13));
		btnNewButton_1_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1_1.setBounds(27, 11, 74, 26);
		panel_1_1.add(btnNewButton_1_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBounds(10, 138, 130, 50);
		panel.add(panel_1_2);
		
		JButton btnNewButton_1_2 = new JButton("Rechercher");
		btnNewButton_1_2.setForeground(Color.BLACK);
		btnNewButton_1_2.setFont(new Font("Dialog", Font.BOLD, 13));
		btnNewButton_1_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1_2.setBounds(10, 11, 110, 26);
		panel_1_2.add(btnNewButton_1_2);
	}

}
