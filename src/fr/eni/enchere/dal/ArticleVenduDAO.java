package fr.eni.enchere.dal;

import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.jdbc.DALException;

public interface ArticleVenduDAO {

	void insert(ArticleVendu soldArt) throws DALException;

	ArticleVendu selectById(int noArticle) throws DALException;

	List<ArticleVendu> selectAll() throws DALException;

	List<ArticleVendu> selectByCategory(Categorie categorie) throws DALException;
	
	List<Integer> selectByEtat(String etatVente) throws DALException;

	List<Integer> getArticlesFromASellerAndState(Utilisateur utilisateur, String etat) throws DALException;

	List<ArticleVendu> selectByString(String search) throws DALException;

	void update(ArticleVendu soldArt) throws DALException;

	void updateCurrentPrice(int noArticle, int newPrice) throws DALException;

	void delete(ArticleVendu articleVendu) throws DALException;

}
