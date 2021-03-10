package fr.eni.enchere.dal;

import java.sql.SQLException;

import	fr.eni.enchere.bo.Utilisateur;
//import	fr.eni.enchere.dal.jdbc.UtilisateursDAOJdbcImpl;
import fr.eni.enchere.dal.jdbc.DALException;

//import java.util.List;

public interface UtilisateurDAO {

		//sélectionner Utilisateur par son noUtilisateur
		public Utilisateur selectById(int id) throws DALException;
		
		//Modifier les infos d'un utilisateur connu en BD
		public void update(Utilisateur data) throws DALException;
		
		//Insérer un nouvel Utilisateur
		public void insert(Utilisateur data) throws DALException;
		
		//Supprimer un utilisateur id ou utilisateur?
		public void delete(Utilisateur id) throws DALException, SQLException;
		
		public void delete(int id) throws DALException, SQLException;

		public boolean checkForUniquePseudo(String pseudo) throws DALException;

		public boolean checkForUniqueEmail(String email) throws DALException;

		public Utilisateur selectByPseudo(String pseudo_utilisateur) throws DALException;

}