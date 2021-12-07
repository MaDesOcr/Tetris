package main;

import java.util.ArrayList;
import java.util.Timer;

import model.Carre;
import model.Coordonnees;
import model.Forme;
import model.L;
import model.Quatre;
import model.T;
import model.Trait;
import utilitaires.Utilitaires;

public class Game {

	char[][] ecran = new char[20][20];
	ArrayList<Forme> alForme= new ArrayList<Forme>();
	
	public void launch() {
		
		Utilitaires.fillEcran(ecran);
		
		
			Timer timer;
		    timer = new Timer();
		    timer.schedule(new HandleForme(alForme, ecran), 1000, 200);
		    //System.out.println(Utilitaires.saisieString());
		
	} 	

	

}
