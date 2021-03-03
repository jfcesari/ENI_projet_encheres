package fr.eni.enchere.dal.jdbc;

public class DAOFactory {
    public static UtilisateurDAO getDAOUtilisateur() {
        return new UtilisateursDAOJdbcImpl();
    }
}