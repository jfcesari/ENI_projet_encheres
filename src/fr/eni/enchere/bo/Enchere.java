package fr.eni.enchere.bo;

import java.util.Date;

public class Enchere {

	//Attributs
	private int noUtilisateur;
	private int noArticle;
	private Date dateEnchere;
	private int montantEnchere;
	
	//Constructeurs
	public Enchere() {
		//
	}
	
	public Enchere(Date dateEnchere, int montantEnchere) {
		setDateEnchere(dateEnchere);
		setMontantEnchere(montantEnchere);
	}

	//Getter et Setter
	public Date getDateEnchere() {
		return dateEnchere;
	}

	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public int getMontantEnchere() {
		return montantEnchere;
	}

	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}
	
	@Override
	public String toString() {
		String s = String.format("Date de l'enchère : %s%n Montant de l'enchère : %d%n", getDateEnchere(), getMontantEnchere());
		return s;
	}

}
