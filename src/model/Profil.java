package model;
import bdd.*;
import java.util.ArrayList;


/**
 * "Profile" Class
 * 
 * @author G4B3
 * @version 1.0
 * */
public class Profil {
	
	private int id;
	private String nomProfil;
	private ArrayList<Lieu> listeLieu;
	private ArrayList<Horaire> listeHoraire;
	
	/**
	 * Constructor
	 * @param id the id of the profile
	 * @param nomProfil the name of the profile
	 */
	public Profil(int id,String nomProfil) {
		this.nomProfil = nomProfil;
		this.id = id;
		listeLieu = new ArrayList<Lieu>();
		listeHoraire = new ArrayList<Horaire>();
	}
	
	/**
	 * Constructor n°2
	 * @param id the id of the profile
	 * @param nomProfil the name of the profile
	 * @param listeLieu the list of areas accessible to that profile
	 * @param listeHoraire the corresponding hours of access to areas accessible to that profile
	 */
	public Profil(int id,String nomProfil, ArrayList<Lieu> listeLieu, ArrayList<Horaire> listeHoraire) {
		this.nomProfil = nomProfil;
		this.id = id;
		this.listeLieu = listeLieu;
		this.listeHoraire = listeHoraire;
	}
	
	/**
	 * Constructor n°3
	 * @param nomProfil the name of the profile
	 */
	public Profil(String nomProfil) {
		this.nomProfil = nomProfil;
		this.id = 0;
		listeLieu = new ArrayList<Lieu>();
		listeHoraire = new ArrayList<Horaire>();
	}
	
	/**
	 * getter for the attribute id
	 * @return id the id of the profile
	 */
	public int getId( ){
		return id;
	}
	
	/**
	 * add an area to the list of areas accessible to that profile
	 * @param lieu an area you wish to add
	 */
	public void addLieu(Lieu lieu) {
		listeLieu.add(lieu);
	}
	
	/**
	 * add a timestamp corresponding to an area the profil has access to
	 * @param horaire
	 */
	public void addHoraire(Horaire horaire) {
		listeHoraire.add(horaire);
	}
	
	/**
	 * add a timestamp (in String format) corresponding to an area the profil has access to
	 * @param horaire
	 */
	public void addHoraireString(ArrayList<String> horaire) {
		Horaire horaireComplet = new Horaire();
		Heure[] ouvFerm = new Heure[2]; 
		
		for(int i = 0; i < horaire.size(); i++) {
			String hfermeture = horaire.get(i).split("-")[1];
			String houverture = horaire.get(i).split("-")[0];
			
			ouvFerm[0] = new Heure(Integer.parseInt(houverture.split("h")[1]),Integer.parseInt(houverture.split("h")[0]));
			ouvFerm[1] = new Heure(Integer.parseInt(hfermeture.split("h")[1]),Integer.parseInt(hfermeture.split("h")[0]));
			
			
			horaireComplet.setHoraire(ouvFerm, i);
			
		}
		listeHoraire.add(horaireComplet);
		
		//listeHoraire.add(horaire);
	}
	
	/**
	 * getter for the name of the profile
	 * @return nomProfil the name of the profile
	 */
	public String getNomProfil() {
		return nomProfil;
	}
	
	
	/**
	 * getter for the list of accessible areas
	 * @return listeLieu the list of areas accessible to that profile
	 */
	public ArrayList<Lieu> getListeLieu(){
		return listeLieu;
	}
	
	/**
	 * getter for the list of accessible hours to the areas
	 * @return listeHoraire 
	 */
	public ArrayList<Horaire> getListeHoraire(){
		return listeHoraire;
	}


	/**
	 * setter for the name of the profile
	 * @param nomProfil the name you want to associate with the profile
	 */
	public void setNomProfil(String nomProfil) {
		this.nomProfil = nomProfil;
	}
	
	/**
	 * display method, shows all the attributes of the class
	 */
	public void display() {
		System.out.printf("\n\nNom du profil :" + nomProfil + "\n");
		
		if(listeLieu.isEmpty()) {
			System.out.printf("\nAucun lieu");
		}
		else {
			for(int i = 0; i < listeLieu.size(); i++) {
				System.out.printf("\nLieu #" + i + "\n");
				listeLieu.get(i).display();
				listeHoraire.get(i).display();
			}
		}
		
	}

}
