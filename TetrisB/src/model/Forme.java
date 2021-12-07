package model;

public class Forme {

	
	// L, |, 4, O, T
	
	
	Coordonnees[] position = new Coordonnees[4];
	boolean isMoveAllowed = true;
	
	public Forme() {
		
	}

	public char getCharPrint() {
		if(isMoveAllowed) {
			return '@';
		}
		return '#';
	}
	
	public Coordonnees[] getPosition() {
		return position;
	}

	public void setPosition(Coordonnees[] position) {
		this.position = position;
	}

	public boolean isMoveAllowed() {
		return isMoveAllowed;
	}

	public void setMoveAllowed(boolean isMoveAllowed) {
		this.isMoveAllowed = isMoveAllowed;
	}


	
}
