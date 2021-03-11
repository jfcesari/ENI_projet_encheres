package fr.eni.enchere.dal;

import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.jdbc.DALException;

public interface DAOArticleVendu {

	void insert(ArticleVendu soldArt) throws DALException;

	ArticleVendu selectById(int noArticle) throws DALException;

	List<ArticleVendu> filterByCategory(Categorie categorie) throws DALException;

	List<Integer> getArticlesFromASellerAndState(Utilisateur utilisateur, String state) throws DALException;

	/**
	 *
	 * Get all ArticleVendu instances that the field no_article match a String from the DB
	 * @param filter the filter
	 * @return An ArrayList filled with instances
	 * @throws DALException if the SQL SELECT request is wrong
	 */
	List<ArticleVendu> filterByString(String filter) throws DALException;

	/**
	 * Select all the articleVendu from the DB
	 * @return An ArrayList filled with instances of Utilisateur
	 */
	List<ArticleVendu> selectAll() throws DALException;

	void update(ArticleVendu articleVendu) throws DALException;

	/**
	 * Update the current price of an article
	 * @param noArticle int the id of the article to update
	 * @param newPrice int the new price
	 * @throws DALException if there is any issue with the SQL query
	 */
	void updateCurrentPrice(int noArticle, int newPrice) throws DALException;

	void delete(ArticleVendu articleVendu) throws DALException;

}
