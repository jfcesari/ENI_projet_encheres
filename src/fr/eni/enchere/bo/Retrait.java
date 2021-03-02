package fr.eni.enchere.bo;

public class Retrait {

	//Attributs
	private String rue;
	private int codePostal;
	private String ville;
	
	//Constructeurs
	public Retrait() {
		//
	}
	
	public Retrait(String rue, int codePostal, String ville) {
		setRue(rue);
		setCodePostal(codePostal);
		setVille(ville);
	}

	
	//Getter et Setter
	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
	@Override
	public String toString() {
		String s = String.format("Lieu de retrait : %s, %d %s%n", getRue(), getCodePostal(), getVille());
		return s;
	}
}
