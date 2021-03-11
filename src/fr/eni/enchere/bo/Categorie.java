package fr.eni.enchere.bo;

public class Categorie {
	
	//Attributs
	private static int noCategorie;
	private String libelle;
	
	//Constructeurs
	public Categorie() {
		//
	}

	public Categorie(int noCategorie, String libelle) {
		setNoCategorie(noCategorie);
		setLibelle(libelle);
	}

	//Getter et Setter
	public static int getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	@Override
	public String toString() {
		String s = String.format("Numéro catégorie : %d%n Libellé : %s%n", getNoCategorie(), getLibelle());
		return s;
	}
	
}
