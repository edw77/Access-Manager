package model;
import java.util.ArrayList;

/**
 * "Lieu" Class
 * 
 * @author G4B3
 * @version 1.0
 * */

public class Lieu {
	
	/**
	 * id number for the concerned area
	 */
	private int id;
	
	/**
	 * name of the area
	 */
	private String nomLieu;
	
	/**
	 * name of the location of the area
	 */
	private String emplacement;
	
	/**
	 * number of accesses this area has
	 */
	private int nbAcces;

	/**
	 * Constructor
	 * @param id
	 * @param nomLieu
	 * @param emplacement
	 * @param nbAcces
	 */
	public  Lieu(int id,String nomLieu, String emplacement, int nbAcces){
		this.nomLieu = nomLieu;
		this.id = id;
		this.emplacement = emplacement;
		this.nbAcces = nbAcces;
	}
	/**
	 * getter for the attribute nomLieu
	 * @return nomLieu, current name of the area
	 */
	public String getNomLieu( ){
		return nomLieu;
	}
	
	/**
	 * getter for the attribute id
	 * @return nomLieu, current id of the area
	 */
	public int getId( ){
		return id;
	}
	
	/**
	 * getter for the attribute emplacement
	 * @return emplacement, current name of the location of the area
	 */
	public String getEmplacement( ){
		return emplacement;
	}
	
	/**
	 * setter for the attribute nbAcces
	 * @param n the number of access(es) this area should have
	 */
	public void setNbAcces(int n ){
		nbAcces = n;
	}
	
	/**
	 * getter for the attribute nbAcces
	 * @return nbAcces, the number of access(es) this area currently has
	 */
	public int getNbAcces( ){
		return nbAcces;
	}
	
	/**
	 * setter
	 * @param nom, the name you want to set on this area
	 */
	public void setNomLieu(String nom ){
		this.nomLieu = nom;
	}
	
	/**
	 * setter for the attribute emplacement
	 * @param emplacement, the name of the location you want to associate with that area
	 */
	public void setEmplacement(String emplacement ){
		this.emplacement = emplacement;
	}

	/**
	 * display method
	 * show in the console all the attributes of an object of this class
	 */
	public void display( ){
		System.out.printf("\nId du lieu :" + id + "\nNom du lieu : " + nomLieu + "\nEmplacement : " + emplacement + "\nNombre d'accès : " + nbAcces);
	}

}
