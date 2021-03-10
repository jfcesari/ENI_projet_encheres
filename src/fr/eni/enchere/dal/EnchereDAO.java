package fr.eni.enchere.dal;

import java.util.List;

import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.jdbc.DALException;

public interface EnchereDAO {
	
	void insert(Enchere enchere) throws DALException;

	List<Integer> getNoArticlesByUtilisateurAndEtat(Utilisateur utilisateur, String state) throws DALException;

}