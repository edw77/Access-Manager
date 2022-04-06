package bdd;

/**
 * Class that links the database to the application
 * All other DAO classes extends this one
 * 
 * @author Group 4
 * @version 1.0
 * */

public class ConnectionDAO {
	/**
	 * Connexion parameters to the Oracle Database 
	 */
	//final static String URL = "jdbc:oracle:thin:@oracle.esigelec.fr:1521:orcl"; //URL for the database given by ESIGELEC
	final static String URL = "jdbc:oracle:thin:@//srvoracledb.intranet.int:1521/orcl.intranet.int";
	//final static String URL = "jdbc:oracle:thin:@srvoracledb.intranet.int:1521:orcl";
	final static String LOGIN = "C##_G12_G4_APP";   // login for the database given by ESIGELEC
	final static String PASS  = "APP_12_4";   // password
	
	/**
	 * Constructor
	 * 
	 */
	
	
	public ConnectionDAO() {
		// loading of the database pilot
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.err.println("Missing the database pilot(s)");
		}
		// catch(E/S)
	}
}