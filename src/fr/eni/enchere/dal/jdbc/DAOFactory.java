package fr.eni.enchere.dal.jdbc;

public abstract class DAOFactory {

	public static UtilisateursDAOJdbcImpl getUtilisateurDAO()
	{
		return new UtilisateursDAOJdbcImpl();
	}
	
}
