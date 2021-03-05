package fr.eni.enchere.bo;

import java.util.Date;

public class ArticleVendu {
	
	//Attributs
	private int noArticle;
	private String nomArticle;
	private Categorie categorieArticle;
	private String description;
	private Date dateDebutEncheres;
	private Date dateFinEncheres;
	private int miseAPrix;
	private int prixVente;
	private String etatVente;
	private Retrait lieuRetrait;
	
	//Constructeurs
	public ArticleVendu() {
		//
	}
	
	//Constructeurs -> Article vendu sans lieu de retrait
	public ArticleVendu(int noArticle, String nomArticle, Categorie categorieArticle, String description, Date dateDebutEncheres, Date dateFinEncheres, int miseAPrix, int prixVente, String etatVente) {
		setNoArticle(noArticle);
		setNomArticle(nomArticle);
		setCategorieArticle(categorieArticle);
		setDescription(description);
		setDateDebutEncheres(dateDebutEncheres);
		setDateFinEncheres(dateFinEncheres);
		setMiseAPrix(miseAPrix);
		setPrixVente(prixVente);
		setEtatVente(etatVente);
	}
	
	//Constructeurs -> Article vendu avec lieu de retrait
	public ArticleVendu(int noArticle, String nomArticle, Categorie categorieArticle, String description, Date dateDebutEncheres, Date dateFinEncheres, int miseAPrix, int prixVente, String etatVente, Retrait lieuRetrait) {
		setNoArticle(noArticle);
		setNomArticle(nomArticle);
		setCategorieArticle(categorieArticle);
		setDescription(description);
		setDateDebutEncheres(dateDebutEncheres);
		setDateFinEncheres(dateFinEncheres);
		setMiseAPrix(miseAPrix);
		setPrixVente(prixVente);
		setEtatVente(etatVente);
		setLieuRetrait(lieuRetrait);
	}
	
	//Getter et Setter
	public int getNoArticle() {
		return noArticle;
	}
	
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}
	
	public String getNomArticle() {
		return nomArticle;
	}
	
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	
	public Categorie getCategorieArticle() {
		return categorieArticle;
	}

	public void setCategorieArticle(Categorie categorieArticle) {
		this.categorieArticle = categorieArticle;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public java.sql.Date getDateDebutEncheres() {
		return (java.sql.Date)dateDebutEncheres;
	}
	
	public void setDateDebutEncheres(Date dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}
	
	public java.sql.Date getDateFinEncheres() {
		return (java.sql.Date)dateFinEncheres;
	}
	
	public void setDateFinEncheres(Date dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}
	
	public int getMiseAPrix() {
		return miseAPrix;
	}
	
	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}
	
	public int getPrixVente() {
		return prixVente;
	}
	
	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}
	
	public String getEtatVente() {
		return etatVente;
	}
	
	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}

	public Retrait getLieuRetrait() {
		return lieuRetrait;
	}

	public void setLieuRetrait(Retrait lieuRetrait) {
		this.lieuRetrait = lieuRetrait;
	}

	@Override
	public String toString() {
		String s = new String();
		if(lieuRetrait.toString().isEmpty()) {
			s = String.format("Numéro de l'article : %d%n Nom de l'article : %s%n Catégorie de l'article : %s%n Description : %s%n Date début de l'enchère : %s%n Date fin de l'enchère : %s%n Mise à prix : %d%n Prix de vente : %d%n État de la vente : %s%n Lieu de retrait : %s%n", 
			getNoArticle(), getNomArticle(), getCategorieArticle(), getDescription(), getDateDebutEncheres(), getDateFinEncheres(), getMiseAPrix(), getPrixVente(), getEtatVente(), getLieuRetrait());
		} else {
			s = String.format("Numéro de l'article : %d%n Nom de l'article : %s%n Catégorie de l'article : %s%n Description : %s%n Date début de l'enchère : %s%n Date fin de l'enchère : %s%n Mise à prix : %d%n Prix de vente : %d%n État de la vente : %s%n", 
			getNoArticle(), getNomArticle(), getCategorieArticle(), getDescription(), getDateDebutEncheres(), getDateFinEncheres(), getMiseAPrix(), getPrixVente(), getEtatVente());	
		} return s;
	}	
}
