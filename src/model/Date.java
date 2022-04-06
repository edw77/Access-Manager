package model;
 

/**
 * "Date" Class
 * 
 * @author G4B3
 * @version 1.0
 * */
public class Date {
	
	/**
	 * the day of the date
	 */
	private int jour;
	
	/**
	 * the month of the date
	 */
	private int mois;
	
	/**
	 * the year of the date
	 */
	private int annee;

	/**
	 * Constructor
	 * @param aJour the day of the date
	 * @param aMois the month of the date
	 * @param aAnnee the year of the date
	 */
	public  Date(int aJour,int aMois,int aAnnee){
		jour = aJour;
		mois = aMois;
		annee = aAnnee;
	}
	
	
	/**
	 * Constructor n°2
	 * @param date a date in format "yyyy-mm-dd" that will be converted 
	 */
	public Date(String date) {
		String[] date2 = date.split(" ")[0].split("-");
		annee = Integer.parseInt(date2[2]);
		mois = Integer.parseInt(date2[1]);
		jour = Integer.parseInt(date2[0]);
	}
	
	
	/**
	 * setter for the attribute jour
	 * @param aJour the day of the date
	 */
	public void setJour(int aJour){
		this.jour = aJour;
	}
	
	
	/**
	 * setter for the attribute mois
	 * @param aMois the month of the date
	 */
	public void setMois(int aMois){
		this.mois = aMois;
	}
	
	
	/**
	 * setter for the attribute year
	 * @param aAnnee the year of the date
	 */
	public void setAnnee(int aAnnee){
		this.annee = aAnnee;
	}
	
	
	/**
	 * getter for the attribute jour
	 * @return jour the current day of the date
	 */
	public int getJour( ){
		return jour;
	}
	
	
	/**
	 * getter for the attribute mois
	 * @return mois the current month of the date
	 */
	public int getMois( ){
		return mois;
	}
	
	
	/**
	 * getter for the attribute annee
	 * @return annee the current year of the date
	 */
	public int getAnnee( ){
		return annee;
	}
	
	/**
	 * display method, show all the attributes of a Date
	 */
	public void display( ){
		System.out.printf("Date : " +jour+"/"+mois+"/"+annee);
	}
}