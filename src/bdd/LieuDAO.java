package bdd;

import java.sql.*;

import java.util.ArrayList;

import model.*;

/**
 * LieuDAO class
 * Used to interact with the "Lieu" table on the database
 * @author Group 4
 * @version 1.0
 * */

public class LieuDAO extends ConnectionDAO {

	/**
	 * Constructor
	 * 
	 */
	public LieuDAO() {
		super();
	}
	
	
	public int setAcces(Profil profil, Lieu lieu) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, chaque ? represente une valeur
			// a communiquer dans la modification.
			// les getters permettent de recuperer les valeurs des attributs souhaites
			ps = con.prepareStatement("INSERT INTO Acces(idProf,idlieu,horaireLundi,horaireMardi,horaireMercredi,horaireJeudi,horaireVendredi,horaireSamedi)"
					+ " VALUES (?,?,'8h30-18h30','8h30-18h30','8h30-18h30','8h30-18h30','8h30-18h30','8h30-18h30')");
			ps.setInt(1, profil.getId());
			
			ps.setInt(2, lieu.getId());

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
	
	
	/**
	 * Method to get a list of areas that are stored on the database
	 * @return returnValue, an arrayList containing all the areas found on the database
	 */
	public ArrayList<Lieu> getList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Lieu> returnValue = new ArrayList<Lieu>();

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM lieu ORDER BY idlieu");

			// on execute la requete
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				returnValue.add(new Lieu(rs.getInt("idlieu"),
						                     rs.getString("nom"),
						                     rs.getString("emplacement"),
						                     rs.getInt("nbacces")));
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
