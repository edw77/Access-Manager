package model;


/**
 * "Horaire" Class
 * 
 * @author G4B3
 * @version 1.0
 * */
public class Horaire {
	/**
	 * ouvertures : Opening hours 
	 */
	private Heure[] ouvertures;
	
	/**
	 * fermetures : Closing hours
	 */
	private Heure[] fermetures;

	
	/**
	 * Constructor
	 * @param ouvertures opening hours 
	 * @param fermetures closing hours
	 */
	public  Horaire(Heure[] ouvertures, Heure[] fermetures){
		this.ouvertures = ouvertures;
		this.fermetures = fermetures;
	}
	
	/**
	 * Constructor n°2
	 * Creates an "Horaire" with empty hours
	 */
	public  Horaire( ){
		ouvertures = new Heure[6];
		fermetures = new Heure[6];
	}
	
	/**
	 * Constructor n°3
	 * Creates an "Horaire" based on a String in the format "hh:mm"
	 * @param horaire
	 */
	public Horaire(String horaire) {
		
	}
	
	/**
	 * getter for a certain hour
	 * @param number the number corresponding to the day of the hour you want (0~5)
	 * @return returnValue the closing and opening hours of the specified day
	 */
	public Heure[] getHoraire(int number){
		Heure[] returnValue = new Heure[2];
		returnValue[0] = ouvertures[number];
		returnValue[1] = fermetures[number];
		return returnValue;
	}
	
	/**
	 * getter for a certain hour in string format
	 * @param number the number corresponding to the day of the hour you want (0~5)
	 * @return returnValue the closing and opening hours of the specified day
	 */
	public String getHoraireString(int number){
		String returnValue = Integer.toString(ouvertures[number].getHeure()) + "h" + Integer.toString(ouvertures[number].getMinute());
		returnValue = returnValue + "-" + Integer.toString(fermetures[number].getHeure()) + "h" + Integer.toString(fermetures[number].getMinute());
		return returnValue;
	}
	
	/**
	 * setter for a certain hour
	 * @param horaire the closing and opening hours you want to set
	 * @param number the number corresponding to the day of the hour you want to set
	 */
	public void setHoraire(Heure[] horaire,int number){
		ouvertures[number] = horaire[0];
		fermetures[number] = horaire[1];
	}
	
	/**
	 * display method to show all the attributes of the class
	 */
	public void display( ){
		for(int i=0;i < 5;i++) {
			System.out.printf("Day #" + i+1 + "\n");
			ouvertures[i].display();
			System.out.println(" to ");
			fermetures[i].display();
		}
	}
}