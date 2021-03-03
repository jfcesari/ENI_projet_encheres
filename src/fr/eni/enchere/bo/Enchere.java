package fr.eni.enchere.bo;

import java.util.Date;

public class Enchere {

	//Attributs
	private Date dateEnchere;
	private float montantEnchere;
	
	//Constructeurs
	public Enchere() {
		//
	}
	
	public Enchere(Date dateEnchere, float montantEnchere) {
		setDateEnchere(dateEnchere);
		setMontantEnchere(montantEnchere);
	}

	//Getter et Setter
	public Date getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public float getMontantEnchere() {
		return montantEnchere;
	}

	public void setMontantEnchere(float montantEnchere) {
		this.montantEnchere = montantEnchere;
	}
	
	@Override
	public String toString() {
		String s = String.format("Date de l'enchère : %s%n Montant de l'enchère : %.2f€%n", getDateEnchere(), getMontantEnchere());
		return s;
	}
}
