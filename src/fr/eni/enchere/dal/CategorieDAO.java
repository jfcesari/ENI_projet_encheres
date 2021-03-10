package fr.eni.enchere.dal;

import java.util.List;

import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.dal.jdbc.DALException;

public interface CategorieDAO {

	void insert(Categorie categorie) throws DALException;

	Categorie selectById(int id) throws DALException;

	List<Categorie> selectAll() throws DALException;

	boolean checkForUniqueCategorieLibelle(String libelle);

}