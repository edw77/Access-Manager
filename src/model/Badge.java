package model;

/**
 * "Badge" Class
 * 
 * @author G4B3
 * @version 1.0
 * */

public class Badge {
	private int id;
	private Personne personne;

	/**
	 * Constructor
	 * @param personne the person associated with the badge
	 */
	public Badge(int id, Personne personne){
		this.personne = personne;
		this.id = id;
	}
	
	/**
	 * getter for the attribute id
	 * @return the id of the badge
	 */
	public int getId( ){
		return id;
	}
	
	/**
	 * getter for the attribute Personne
	 * @return the person of the badge
	 */
	public Personne getPersonne( ){
		return personne;
	}
	
	/**
	 * display method
	 * show every attribute of the badge
	 */
	public void display( ){
		System.out.printf("\nBadge numero " + id + "\nAssocié à : ");
		if (personne == null)
			System.out.printf(" Aucune personne");
		else
			personne.display();
	}
}