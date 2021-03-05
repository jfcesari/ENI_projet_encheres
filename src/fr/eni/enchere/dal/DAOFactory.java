package fr.eni.enchere.dal;

import fr.eni.enchere.dal.jdbc.UtilisateursDAOJdbcImpl;

public class DAOFactory {
    public static UtilisateurDAO getUtilisateurDAO() {
        return new UtilisateursDAOJdbcImpl();
    }
    
    public static ArticleVenduDAO getArticleVenduDAO() {
        return new ArticleVenduDAOJdbcImpl();
    }
    
    public static CategorieDAO getCategorieDAO() {
        return new CategorieDAOJdbcImpl();
    }
    
    public static DAOEnchere getEnchereDAO() {
        return new EnchereDAOJdbcImpl();
    }
}