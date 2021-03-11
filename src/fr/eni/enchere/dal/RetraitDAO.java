package fr.eni.enchere.dal;

import java.util.List;

import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.dal.jdbc.DALException;

public interface RetraitDAO {

	void insert(Retrait retrait) throws DALException;

	Retrait selectById(int noArticle) throws DALException;

	List<Retrait> selectAll() throws DALException;

	void update(Retrait retrait) throws DALException;

	void delete(Retrait retrait) throws DALException;

}
