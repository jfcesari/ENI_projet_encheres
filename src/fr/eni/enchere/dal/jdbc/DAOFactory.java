package fr.eni.enchere.dal.jdbc;

public class DAOFactory {
    public static UtilisateurDAO getUtilisateurDAO() {
        return new UtilisateursDAOJdbcImpl();
    }
}