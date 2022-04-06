package gui;

import bdd.*;
import javax.swing.JOptionPane;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AuthIHM {

	private JFrame frmAuthentification;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AuthIHM window = new AuthIHM();
					window.frmAuthentification.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AuthIHM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAuthentification = new JFrame();
		frmAuthentification.setTitle("Authentification");
		frmAuthentification.getContentPane().setBackground(Color.WHITE);
		frmAuthentification.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 316, 410);
		frmAuthentification.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(10, 95, 306, 146);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(AuthIHM.class.getResource("/images/logo_esig.png")));
		
		Button button = new Button("Log in");
		button.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			
			//When the login button is clicked on, the app verify if the username and password match with those on the database
			// and let him or not enter the app
			public void mouseClicked(MouseEvent e) {
				button.setEnabled(false);
				UserDAO con = new UserDAO();
				JOptionPane warning = new JOptionPane();
				String username = textField.getText();
				String password = passwordField.getText();
				if(con.authentification(username,password) == true) {
					@SuppressWarnings("unused")
					// A new instance of the menu is created here, and the old page is disposed of
					MenuIHM menu = new MenuIHM();
					frmAuthentification.dispose();
					menu.getFrame().setVisible(true);
				}
				else {
					warning.showMessageDialog( null, "Wrong password or username", 
					      "Access refused", JOptionPane.WARNING_MESSAGE);
					button.setEnabled(true);
				}
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241, 57, 83));
		button.setBounds(448, 301, 201, 53);
		frmAuthentification.getContentPane().add(button);
		
		textField = new JTextField();
		textField.setBounds(433, 117, 221, 27);
		frmAuthentification.getContentPane().add(textField);
		textField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(433, 142, 221, 2);
		frmAuthentification.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(433, 207, 221, 2);
		frmAuthentification.getContentPane().add(separator_1);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(333, 123, 74, 14);
		frmAuthentification.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(333, 193, 74, 14);
		frmAuthentification.getContentPane().add(lblPassword);
		
		JLabel lblNewLabel_2 = new JLabel("Authentification");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(485, 28, 116, 46);
		frmAuthentification.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBackground(Color.WHITE);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(433, 182, 221, 27);
		frmAuthentification.getContentPane().add(passwordField);
		frmAuthentification.setBounds(100, 100, 790, 448);
		frmAuthentification.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
