package fr.eni.enchere.dal;

import java.util.List;

import fr.eni.enchere.bo.Utilisateur;

public class EnchereDAO {
	List<String>getArticlesByUtilisateur(Utilisateur utilisateur, String articles);
}