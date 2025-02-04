package fr.eni.enchere.bo;

public class Retrait {

	//Attributs
	private int noArticle;
	private String rue;
	private String codePostal;
	private String ville;
	
	//Constructeurs
	public Retrait() {
		//
	}
	
	public Retrait(String rue, String codePostal, String ville) {
		setRue(rue);
		setCodePostal(codePostal);
		setVille(ville);
	}
	
	//Getter et Setter
	public int getNoArticle() {
		return noArticle;
	}
	
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
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
		String s = String.format("Lieu de retrait : %s, %s %s%n", getRue(), getCodePostal(), getVille());
		return s;
	}
}
