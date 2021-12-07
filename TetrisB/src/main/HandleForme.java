package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;

import model.Carre;
import model.Coordonnees;
import model.Forme;
import model.L;
import model.Quatre;
import model.T;
import model.Trait;
import utilitaires.Utilitaires;

public class HandleForme extends TimerTask{
	
	char[][] ecran = new char[20][20];
	ArrayList<Forme> alForme= new ArrayList<Forme>();
	boolean mustCreateNewForme = true;
	boolean gameOn = true;
	
    public HandleForme(ArrayList<Forme> alForme, char[][] ecran) {
    	this.ecran = ecran;
    	this.alForme = alForme;
    	
    }

	@Override
	public void run() {
		if(gameOn) {
			for (Forme forme : alForme) {
				if(forme.isMoveAllowed()) {
					mustCreateNewForme = false;
				}
				else {
					mustCreateNewForme = true;
				}
			}
			
			if(mustCreateNewForme) {
				createforme();
			}
			
			for (Forme f : alForme) {
				if(f.isMoveAllowed()) {
					checkMove(f, ecran);
					if(f.isMoveAllowed()) {
						moveAuto(f, ecran);	
					}
					else {
						freezeForme(f,ecran);
						
					}
				}
			}
			
			Utilitaires.printEcran(ecran);
		}
		else {
			System.out.println("Au revoir");
			System.exit(0);
		}
	}
	
	public void createforme() {
		Forme t = createRandomForme();
		alForme.add(t);
		mustCreateNewForme = false;
		addFormeToEcran(t);
	}
	
	private Forme createRandomForme() {
		Random rand = new Random();
		switch(rand.nextInt(4)) {
			case 0 : return new T();
			case 1 : return new L();
			case 2 : return new Carre();
			case 3 : return new Trait();
			default : return new Quatre();
		}
	}

	private void freezeForme(Forme f, char[][] ecran2) {
		for (Coordonnees c : f.getPosition()) {
			ecran[c.getX()][c.getY()]=' ';
			ecran[c.getX()][c.getY()]=f.getCharPrint();
		}		
	}

	private void moveAuto(Forme f, char[][] ecran) {
			
			for (Coordonnees c : f.getPosition()) {
				ecran[c.getX()][c.getY()]=' ';
			}
			for (Coordonnees c : f.getPosition()) {
				c.setY(c.getY()+1);
				ecran[c.getX()][c.getY()]=f.getCharPrint();
			}
		
	}

	
	private void checkMove(Forme f, char[][] ecran2) {
		for (Coordonnees c : f.getPosition()) {
			if(ecran[c.getX()][c.getY()+1] != '@'
					&& ecran[c.getX()][c.getY()+1] != '\u0000'
					&& ecran[c.getX()][c.getY()+1] != ' ') {
				f.setMoveAllowed(false);
			}
		}
	}
	private void addFormeToEcran(Forme f) {
		for (Coordonnees c : f.getPosition()) {
			if(ecran[c.getX()][c.getY()+1] != ' ') {
				gameOn = false;
			}
			else {
				ecran[c.getX()][c.getY()]=f.getCharPrint();
			}
		}
	}
}
