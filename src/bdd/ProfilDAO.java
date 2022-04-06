package bdd;

import java.sql.*;

import java.util.ArrayList;

import model.*;

	/**
	 * ProfilDAO class
	 * Used to interact with the table "Profil" on the database
	 * 
	 * @author Groupe 4
	 * @version 1.0
	 * */
	public class ProfilDAO extends ConnectionDAO {
		/**
		 * Constructor
		 * 
		 */
		public ProfilDAO() {
			super();
		}
		
		/**
		 * method used to add a Profil to the database
		 * @param profil the profil to be added
		 * @return returnValue whether or not the operation has succeeded
		 */
		public int add(Profil profil) {
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
				ps = con.prepareStatement("INSERT INTO Profil(idprofil,nomprofil) VALUES(profil_seq.nextval,?)");
				ps.setString(1, profil.getNomProfil());

				// Execution de la requete
				returnValue = ps.executeUpdate();

			} catch (Exception e) {
				if (e.getMessage().contains("ORA-00001"))
					System.out.println("Cet identifiant de Profil existe déjà. Ajout impossible !");
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
		
		public ArrayList<Profil> getList() {
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			ArrayList<Profil> returnValue = new ArrayList<Profil>();

			// connexion a la base de donnees
			try {
				con = DriverManager.getConnection(URL, LOGIN, PASS);
				
				//Chargement des profils
				ps = con.prepareStatement("SELECT * FROM Profil ORDER BY idprofil");

				// on execute la requete
				rs = ps.executeQuery();
				// on parcourt les lignes du resultat
				while (rs.next()) {
					returnValue.add(new Profil(rs.getInt("idprofil"),
							                     rs.getString("nomprofil")));
				}
				
				//Chargement des lieux accessibles de chaque profil
				for(int i=0; i < returnValue.size(); i++) {
					ps = con.prepareStatement("SELECT horaireLundi,horaireMardi,horaireMercredi,horaireJeudi,horaireVendredi,horaireSamedi,lieu.idlieu,nom,emplacement,nbacces FROM Acces INNER JOIN Lieu ON Acces.idlieu = Lieu.idlieu WHERE acces.idprof = ? ORDER BY lieu.idlieu");
					ps.setInt(1, returnValue.get(i).getId());
					rs = ps.executeQuery();
					
					while (rs.next()) {
						returnValue.get(i).addLieu(new Lieu(rs.getInt("idlieu"),
								                     rs.getString("nom"),
								                     rs.getString("emplacement"),
								                     rs.getInt("nbacces")));
						
						ArrayList<String> horaires = new ArrayList<String>();
						horaires.add(rs.getString("horaireLundi"));
						horaires.add(rs.getString("horaireMardi"));
						horaires.add(rs.getString("horaireMercredi"));
						horaires.add(rs.getString("horaireJeudi"));
						horaires.add(rs.getString("horaireVendredi"));
						horaires.add(rs.getString("horaireSamedi"));
						returnValue.get(i).addHoraireString(horaires);
						
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
		
		//Give to a profile the access to a new area 
		public int addLieu(Profil profil, Lieu lieu) {
			Connection con = null;
			PreparedStatement ps = null;
			int returnValue = 0;
			ResultSet rs = null;

			// connexion a la base de donnees
			try {
				con = DriverManager.getConnection(URL, LOGIN, PASS);
				
				//Chargement des profils
				ps = con.prepareStatement("INSERT INTO Acces(idProf,idlieu) VALUES (?,?)");
				ps.setInt(1, profil.getId());
				ps.setInt(2, lieu.getId());

				// on execute la requete
				rs = ps.executeQuery();
				
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
		
		
		public int update(Profil profil) {
			Connection con = null;
			PreparedStatement ps = null;
			PreparedStatement ps2 = null;
			int returnValue = 0;

			// connexion a la base de donnees
			try {

				// tentative de connexion
				con = DriverManager.getConnection(URL, LOGIN, PASS);
				// preparation de l'instruction SQL, chaque ? represente une valeur
				// a communiquer dans la modification.
				// les getters permettent de recuperer les valeurs des attributs souhaites
				ps = con.prepareStatement("UPDATE profil set nomprofil = ? WHERE idprofil = ?");
				ps.setString(1, profil.getNomProfil());
				
				ps.setInt(2, profil.getId());

				// Execution de la requete
				returnValue = ps.executeUpdate();
				
				for(int i = 0; i < profil.getListeLieu().size(); i++) {
					ps2 = con.prepareStatement("UPDATE acces set horaireLundi = ?, horaireMardi = ?, horaireMercredi = ?, horaireJeudi = ?, horaireVendredi = ?, horaireSamedi = ? WHERE idprof = ? AND idlieu = ?" );
					ps2.setString(1, profil.getListeHoraire().get(i).getHoraireString(0));
					ps2.setString(2, profil.getListeHoraire().get(i).getHoraireString(1));
					ps2.setString(3, profil.getListeHoraire().get(i).getHoraireString(2));
					ps2.setString(4, profil.getListeHoraire().get(i).getHoraireString(3));
					ps2.setString(5, profil.getListeHoraire().get(i).getHoraireString(4));
					ps2.setString(6, profil.getListeHoraire().get(i).getHoraireString(5));
					ps2.setInt(7, profil.getId());
					ps2.setInt(8, profil.getListeLieu().get(i).getId());
				}
				
				returnValue = ps2.executeUpdate();
				
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
		
		public int associate(Profil profil, Personne personne) {
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
				ps = con.prepareStatement("UPDATE personne set idprofil = ? WHERE idpersonne = ?");
				ps.setInt(1, profil.getId());
				
				ps.setInt(2, personne.getId());

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
		 * method used to delete a Profil to the database
		 * @param profil the profil to be deleted
		 * @return returnValue whether or not the operation has succeeded
		 */
	public int delete(Profil profil) {
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
			ps = con.prepareStatement("DELETE FROM Profil WHERE idprofil = ?");
			ps.setInt(1, profil.getId());

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


	