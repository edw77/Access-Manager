package bdd;

import java.sql.*;

import java.util.ArrayList;

import model.*;

/**
 * LieuDAO class
 * Used to interact with the "Badge" table on the database
 * @author Group 4
 * @version 1.0
 * */

public class BadgeDAO extends ConnectionDAO {

	/**
	 * Constructor
	 * 
	 */
	public BadgeDAO() {
		super();
	}
	
	public int add(int idPersonne) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, chaque ? represente une valeur
			// a communiquer dans l'insertion.
			// les getters permettent de recuperer les valeurs des attributs souhaites
			ps = con.prepareStatement("INSERT INTO Badge(idBadge,etat,idPersonne) VALUES (badge_seq.nextval,1,?)");
			ps.setInt(1, idPersonne);

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Cet identifiant existe déjà. Ajout impossible !");
			else
				e.printStackTrace();
		} finally {
			// fermeture du preparedStatement et de la connexion
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}
	
	
	/**
	 * Method to get a list of badges that are stored on the database
	 * @return returnValue, an arrayList containing all the badges found on the database
	 */
	public ArrayList<Badge> getList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Badge> returnValue = new ArrayList<Badge>();
		ArrayList<Personne> listePers = new ArrayList<Personne>();
		int idBadge = 0, idPersonne = 0;

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM Badge ORDER BY idBadge");

			// on execute la requete
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				idBadge = rs.getInt("idBadge");
				idPersonne = rs.getInt("idPersonne");
				PersonDAO con2 = new PersonDAO();
				listePers = con2.getList();
				
				for(int i = 0; i < listePers.size(); i++)
					if(idPersonne == listePers.get(i).getId()) {
						returnValue.add(new Badge(idBadge,listePers.get(i)));
						break;
					}
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
	
	public int delete(int idBadge) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, le ? represente la valeur de l'ID
			// a communiquer dans la suppression.
			// le getter permet de recuperer la valeur de l'ID du fournisseur
			ps = con.prepareStatement("DELETE FROM Badge WHERE idpersonne = ?");
			ps.setInt(1, idBadge);

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fermeture du preparedStatement et de la connexion
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}

	
}

