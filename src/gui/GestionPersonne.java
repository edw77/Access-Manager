package gui;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class GestionPersonne extends JPanel {
	private JTable table;
	
	private SupprimerPersonne suppPers;
	private CreerPersonne crePers;

	/**
	 * Create the panel.
	 */
	public GestionPersonne() {
		setLayout(null);
		JPanel panel = new JPanel();
		
		JButton btnNewButton = new JButton("Cr\u00E9er");
		
		btnNewButton.setBounds(320, 35, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modifier");
		btnNewButton_1.setBounds(320, 99, 89, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Supprimer");
		btnNewButton_2.setBounds(320, 166, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CardLayout cl = (CardLayout)(panel.getLayout());
				cl.show(panel,"Supprimer Personne");
								
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panel.getLayout());
				cl.show(panel,"Creer Personne");
				
			}
		});
		
		add(btnNewButton_2);
		
		
		panel.setBounds(10, 11, 296, 278);
		add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		JPanel panel_liste = new JPanel();
		panel.add(panel_liste, "Liste");
		panel_liste.setLayout(null);
		
		suppPers = new SupprimerPersonne();
		
		panel.add(suppPers, "Supprimer Personne");
		panel.add(crePers, "Creer Personne");
		
		table = new JTable();
		table.setBounds(10, 0, 270, 278);
		panel_liste.add(table);
		
		JButton btnListe = new JButton("Liste");
		btnListe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(panel.getLayout());
				cl.show(panel,"Liste");
			}
		});
		btnListe.setBounds(320, 227, 89, 23);
		add(btnListe);

	}
}
