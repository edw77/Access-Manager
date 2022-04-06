package model;

import bdd.*;

/**
 * "Personne" Class
 * 
 * @author G4B3
 * @version 1.0
 * */

public class Personne {
	
	/**
	 * id number of the person
	 */
	private int id;
	
	/**
	 * surname of the person
	 */
	private String nom;
	
	/**
	 * first name of the person
	 */
	private String prenom;
	
	/**
	 * birthdate of the person
	 */
	private Date dateNaissance;
	
	/**
	 * profile of the person
	 */
	private Profil profil;
	
	/**
	 * badge of the person
	 */
	private Badge badge;
	
	/**
	 * Constructor n°1
	 * @param id reference of the person
	 * @param nom surname of the person
	 * @param prenom first name of the person
	 * @param dateNaissance birthdate of the person, in a String
	 * @param profil profile of the person
	 */
	public  Personne(int id,String nom,String prenom, String dateNaissance, Profil profil){
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = new Date(dateNaissance);
		this.profil = profil;
		this.badge = null;
	}
	
	/**
	 * Constructor n°2
	 * @param id reference of the person
	 * @param nom surname of the person
	 * @param prenom first name of the person
	 * @param dateNaissance birthdate of the person
	 * @param profil profile of the person
	 * @param badge badge of the person
	 */
	public  Personne(int id,String nom,String prenom, Date dateNaissance, Profil profil,Badge badge){
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.profil = profil;
		this.badge = badge;
		
	}
	
	/**
	 * Constructor n°3
	 * To create a person without a Profile or a Badge
	 * @param id reference of the person
	 * @param nom surname of the person
	 * @param prenom first name of the person
	 * @param dateNaissance birthdate of the person, in a String
	 */
	public  Personne(int id,String nom,String prenom, Date dateNaissance){
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.profil = null;
		this.badge = null;
	}
	
	/**
	 * getter for the current surname of the person
	 * @return nom the surname of the person
	 */
	public String getNom( ){
		return nom;
	}
	
	/**
	 * getter for the current first name of the person
	 * @return prenom the first name of the person
	 */
	public String getPrenom( ){
		return prenom;
	}
	
	/**
	 * setter for the first name of the person
	 * @param prenom the first name of the person
	 */
	public void setPrenom(String prenom ){
		this.prenom = prenom;
	}
	
	/**
	 * setter for the surname of the person
	 * @return prenom the first name of the person
	 */
	public void setNom(String nom ){
		this.nom = nom;
	}
	
	
	/**
	 * getter for the current id of the person
	 * @return id the id of the person
	 */
	public int getId( ){
		return id;
	}
	
	/**
	 * getter for the current profile of the person
	 * @return profile the profile of the person
	 */
	public Profil getProfil( ){
		return profil;
	}
	
	
	/**
	 * setter for the profile, also add it to the database
	 * @param profil the profil you want to associate to a person
	 */
	public void setProfil(Profil profil) {
		this.profil = profil;
		
	}
	
	/**
	 * getter for the birthdate of the person
	 * @return dateNaissance the birthdate of the person
	 */
	public Date getDateNaissance( ){
		return dateNaissance;
	}
	/**
	 * @return
	 */
	public String getDateNaissanceChar() {
		String birthdate = dateNaissance.getJour() + "/" + dateNaissance.getMois() +"/"+ dateNaissance.getAnnee();
		return birthdate;
	}
	
	/**
	 * @param badge
	 */
	public void setBadge(Badge badge) {
		this.badge = badge;
	}
	
	/**
	 * @return
	 */
	public Badge getBadge() {
		return badge;
	}
	
	/**
	 * 
	 */
	public void display( ){
		System.out.printf("\n\n\nNom: "+nom+"\nPrenom: "+prenom);
		System.out.printf("\nProfil:");
		if (profil != null) {
			profil.display();
		}
		else
			System.out.printf("pas de profil");
		System.out.printf("\n\nDate de naissance");
		dateNaissance.display();
	}
}

