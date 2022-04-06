package bdd;
import java.sql.*;

import java.util.ArrayList;

import model.*;

/**
 * Class that links the database to the application
 * Used to interact with the "Personne" table
 * 
 * @author Group 4
 * @version 1.0
 * */

public class PersonDAO extends ConnectionDAO {
	/**
	 * Constructor
	 * 
	 */
	public PersonDAO() {
		super();
	}
	
	
	/**
	 * method used to add a new Person to the database
	 * @param personne the personne to be added
	 * @return returnValue whether or not the person has been added
	 */
	public int add(Personne personne) {
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
			ps = con.prepareStatement("INSERT INTO Personne(idPersonne,nom,prenom,dateNaissance,idProfil,idBadge) VALUES (personne_seq.nextval,?,?,?,null,null)");
			ps.setString(1, personne.getNom());
			ps.setString(2, personne.getPrenom());
			ps.setString(3, personne.getDateNaissanceChar());

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
	 * method used to modify an existing Person on the database
	 * @param personne the personne to be modified
	 * @return returnValue whether or not the person has been modified
	 */
	public int update(Personne personne) {
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
			ps = con.prepareStatement("UPDATE personne set nom = ?, prenom = ?, dateNaissance = ?, idProfil = ?, idBadge = ? WHERE idpersonne = ?");
			ps.setString(1, personne.getNom());
			ps.setString(2, personne.getPrenom());
			ps.setString(3, personne.getDateNaissanceChar());
			
			if (personne.getProfil() != null)
				ps.setInt(4, personne.getProfil().getId());
			else
				ps.setNull(4, Types.NULL);
			
			if(personne.getBadge() != null)
				ps.setInt(5, personne.getBadge().getId());
			else
				ps.setNull(5, Types.NULL);
			
			ps.setInt(6, personne.getId());

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
	
	public ArrayList<Personne> getListNoProfil() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Personne> returnValue = new ArrayList<Personne>();
		ProfilDAO conProfil = new ProfilDAO();

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM personne ORDER BY idpersonne");

			// on execute la requete
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
 			while (rs.next()) {
 				
				returnValue.add(new Personne(rs.getInt("idPersonne"),
		                     rs.getString("nom"),
		                     rs.getString("prenom"),
		                     rs.getString("dateNaissance"),
		                    null));
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
	
	/**
	 * method used to get a list of the persons that are currently on the database
	 * @return returnValue an ArrayList with all the persons currently on the database
	 */
	public ArrayList<Personne> getList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Personne> returnValue = new ArrayList<Personne>();
		ProfilDAO conProfil = new ProfilDAO();
		ArrayList<Profil> profils = conProfil.getList();
		int idprofil = -1, index_num = -1;

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM personne ORDER BY idpersonne");

			// on execute la requete
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
 			while (rs.next()) {
 				idprofil = rs.getInt("idProfil");
				if ( idprofil >= 0) {
					for(int i = 0; i < profils.size(); i++)
						if(idprofil == profils.get(i).getId())
							index_num = i;
					
					returnValue.add(new Personne(rs.getInt("idPersonne"),
		                     rs.getString("nom"),
		                     rs.getString("prenom"),
		                     rs.getString("dateNaissance"),
		                    profils.get(index_num)));
					
				}
				else {
					returnValue.add(new Personne(rs.getInt("idPersonne"),
		                     rs.getString("nom"),
		                     rs.getString("prenom"),
		                     rs.getString("dateNaissance"),
		                    null));
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
	
	
	/**
	 * method used to get a list of the persons that are currently on the database
	 * @return returnValue an ArrayList with all the persons currently on the database
	 */
	public ArrayList<Personne> getListWithNoBadge() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Personne> returnValue = new ArrayList<Personne>();
		ProfilDAO conProfil = new ProfilDAO();
		ArrayList<Profil> profils = conProfil.getList();
		int idprofil = -1, index_num = -1;

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT badge.idbadge,nom,prenom,Personne.idPersonne,dateNaissance FROM Personne LEFT JOIN Badge ON badge.idpersonne = personne.idpersonne WHERE badge.idBadge IS NULL");

			// on execute la requete
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
 			while (rs.next()) {
				returnValue.add(new Personne(rs.getInt("idPersonne"),
		                     rs.getString("nom"),
		                     rs.getString("prenom"),
		                     rs.getString("dateNaissance"),
		                   null));
					
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
	
	/**
	 * method used to delete an existing Person on the database
	 * @param personne the personne to be deleted
	 * @return returnValue whether or not the person has been deleted
	 */
	public int delete(Personne personne) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("DELETE FROM personne WHERE id = ?");
			ps.setInt(1, personne.getId());

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

