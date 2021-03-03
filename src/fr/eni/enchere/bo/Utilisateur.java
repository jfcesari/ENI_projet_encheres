package fr.eni.enchere.bo;

import java.util.List;
import java.util.ArrayList;

public class Utilisateur {
	
	//Attributs
	private List<ArticleVendu> vente = new ArrayList<ArticleVendu>();
	private int noUtilisateur;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private int telephone;
	private String rue;
	private int codePostal;
	private String ville;
	private String motDePasse;
	private int credit;
	private boolean administrateur;

	//Constucteurs
	public Utilisateur() {
		//
	}
	
	public Utilisateur(int noUtilisateur, String pseudo, String nom, String prenom,	String email, int telephone, String rue, int codePostal, String ville, String motDePasse, int credit, boolean administrateur) {
		setNoUtilisateur(noUtilisateur);
		setPseudo(pseudo);
		setNom(nom);
		setPrenom(prenom);
		setEmail(email);
		setTelephone(telephone);
		setRue(rue);
		setCodePostal(codePostal);
		setVille(ville);
		setMotDePasse(motDePasse);
		setCredit(credit);
		setAdministrateur(administrateur);
	}
	
	
	//Getter et Setter
	public List<ArticleVendu> getVente() {
		return vente;
	}

	public void setVente(List<ArticleVendu> vente) {
		this.vente = vente;
	}
	
	public int getNoUtilisateur() {
		return noUtilisateur;
	}
	
	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}
	
	public String getPseudo() {
		return pseudo;
	}
	
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getTelephone() {
		return telephone;
	}
	
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	
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
	
	public String getMotDePasse() {
		return motDePasse;
	}
	
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	public int getCredit() {
		return credit;
	}
	
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	public boolean getAdministrateur() {
		return administrateur;
	}
	
	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}

	@Override
	public String toString() {
		String s = String.format("Numéro d'utilisateur : %s%n Pseudo : %s%n Nom : %s%n Prénom : %s%n Email : %s%n Téléphone : %d%n Adresse postale : %s%n%d %s%n Mot de passe : %s%n Crédits : %d%n Administrateur : %s", 
		getNoUtilisateur(), getPseudo(), getNom(), getPrenom(), getEmail(), getTelephone(), getRue(), getCodePostal(), getVille(), getMotDePasse(), getCredit(), getAdministrateur());
		return s;
	}
	
	// /!\ La liste vente doit être ajoutée dans la méthode toString 
}
