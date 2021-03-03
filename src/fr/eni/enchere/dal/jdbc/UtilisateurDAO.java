package fr.eni.enchere.dal.jdbc;

import	fr.eni.enchere.bo.Utilisateur;
import	fr.eni.enchere.dal.jdbc.UtilisateursDAOJdbcImpl;

import java.util.List;

public interface UtilisateurDAO {

		//sélectionner Utilisateur par son noUtilisateur
		public Utilisateur selectById(int id) throws DALException;
		//Modifier les infos d'un utilisateur connu en BD
		public void update(Utilisateur data) throws DALException;
		
		//Insérer un nouvel Utilisateur
		public void insert(Utilisateur data) throws DALException;
		
		//Supprimer un utilisateur
		public void delete(int id) throws DALException;

}