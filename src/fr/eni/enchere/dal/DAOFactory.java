package fr.eni.enchere.dal;

import fr.eni.enchere.dal.jdbc.ArticleVenduDAOJdbcImpl;
import fr.eni.enchere.dal.jdbc.CategorieDAOJdbcImpl;
import fr.eni.enchere.dal.jdbc.EnchereDAOJdbcImpl;
import fr.eni.enchere.dal.jdbc.UtilisateursDAOJdbcImpl;

public class DAOFactory {
    public static UtilisateurDAO getUtilisateurDAO() {
        return new UtilisateursDAOJdbcImpl();
    }

	public static ArticleVenduDAO getDAOArticleVendu() {
		return new ArticleVenduDAOJdbcImpl();
	}

	public static CategorieDAO getDAOCategorie() {
		return new CategorieDAOJdbcImpl();
	}
  
    public static EnchereDAO getDAOEnchere() {
    	return new EnchereDAOJdbcImpl();
	}
}