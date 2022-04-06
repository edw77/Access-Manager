

import bdd.*;
import model.*;
import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		
		ProfilDAO con = new ProfilDAO();
		
		ArrayList<Profil> liste = con.getList();
		
		System.out.print(liste.get(0).getListeHoraire().get(1).getHoraireString(2));		
	}
}

