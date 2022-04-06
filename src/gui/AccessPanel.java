package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccessPanel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccessPanel frame = new AccessPanel(true);
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
	public AccessPanel(boolean access) {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 337);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Button button = new Button("OK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241, 57, 83));
		button.setBounds(150, 260, 131, 28);
		contentPane.add(button);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 125, 434, 59);
		panel.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.5f));
		
		
		JLabel granted = new JLabel("Acc\u00E8s autoris\u00E9");
		granted.setFont(new Font("Times New Roman", Font.ITALIC, 30));
		granted.setForeground(new Color(0, 255, 0));
		
		
		JLabel grantedImg = new JLabel("");
		grantedImg.setIcon(new ImageIcon(AccessPanel.class.getResource("/images/acces_granted.PNG")));
		grantedImg.setBounds(134, 0, 149, 287);
		
		
		
		JPanel refused = new JPanel();
		refused.setBounds(0, 111, 434, 79);
		refused.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.5f));
		
		
		JLabel lblNewLabel_1 = new JLabel("Acc\u00E8s refus\u00E9");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 30));
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		refused.add(lblNewLabel_1);
		
		JLabel refusedImg = new JLabel("");
		refusedImg.setIcon(new ImageIcon(AccessPanel.class.getResource("/images/access_unauthorized.PNG")));
		refusedImg.setBounds(140, 0, 151, 290);
		
		
		if(access) {
			contentPane.add(panel);
			contentPane.add(grantedImg);
			panel.add(granted);
		}
		else {
			contentPane.add(refused);
			contentPane.add(refusedImg);
		}
	}
}
