package model;


/**
 * "Heure" Class
 * 
 * @author G4B3
 * @version 1.0
 * */
public class Heure {
	
	/**
	 * heur , amount of hours of the time
	 */
	private int heur;
	
	/**
	 * minute , amount of minutes of the time
	 */
	private int minute;

	/**
	 * @param aMinute amount of minutes of a time
	 * @param aHeure amount of hours of a time
	 */
	public  Heure(int aMinute,int aHeure){
		minute = aMinute;
		heur = aHeure;
	}
	
	/**
	 * setter for the attribute heur
	 * @param aHeure the hour
	 */
	public void setHeure(int aHeure){
		this.heur = aHeure;
	}
	
	/**
	 * setter for the attribute minute
	 * @param aMinute the minutes of the time
	 */
	public void setMinute(int aMinute){
		this.minute = aMinute;
	}
	
	/**
	 * getter for the attribute heur
	 * @param heur the current hour of the time
	 */
	public int getHeure(){
		return heur;
	}
	
	/**
	 * getter for the attribute year
	 * @param minute the minute of the time
	 */
	public int getMinute(){
		return minute;
	}
	
	
	/**
	 * display method, shows all attributes 
	 */
	public void display( ){
		System.out.printf(heur+"h"+minute);
	}
}