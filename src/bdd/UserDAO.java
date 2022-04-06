package bdd;

import java.sql.*;
import java.util.ArrayList;

import model.Horaire;
import model.Lieu;
import model.Profil;

/**
 * Classe d'acces aux donnees contenues dans la table Utilisateur
 * 
 * @author Groupe 4
 * @version 1.0
 * */

public class UserDAO extends ConnectionDAO {
	
	
	/**
	 * Constructor
	 * 
	 */
	public UserDAO() {
		super();
	}
	
	/**
	 * Authentification method to compare the input data to the ones on the databse
	 * @param username the username the user want to connect with
	 * @param passw the password the user want to connect with
	 * @return returnValue whether or not the acces can be granted
	 */
	public boolean authentification(String username, String passw) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean returnValue = false;

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			
			//Chargement des pr
			ps = con.prepareStatement("SELECT motdepasse FROM Utilisateur WHERE identifiant = ?");
			ps.setString(1, username);

			// on execute la requete
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String pass = rs.getString("motdepasse");
				if(pass.equals(passw))
					returnValue = true;
				else
					returnValue = false;
			}
			
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du rs, du preparedStatement et de la connexion
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignore) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
			
		}
		return returnValue;
	}
	
}
