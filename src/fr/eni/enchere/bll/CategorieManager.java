package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.dal.CategorieDAO;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.jdbc.DALException;

public class CategorieManager {
	 private static CategorieDAO daoCat;

	    static {
	        daoCat = DAOFactory.getDAOCategorie();
	    }

	    public void createCategorie(Categorie categorie) throws DALException, BLLException {
	        BLLException bllException = new BLLException();
	        if (categorie.getLibelle().length() > 30) {
	            bllException.addError(BLLErrors.length_libelle);
	        }
	        if (!daoCat.checkForUniqueCategorieLibelle(categorie.getLibelle())) {
	            bllException.addError(BLLErrors.libelle_taken);
	        }
	        if (bllException.hasErrors()) {
	            throw bllException;
	        } else {
	            daoCat.insert(categorie);
	        }
	    }

	    public Categorie getCategorieById(int id) throws DALException {
	        return daoCat.selectById(id);
	    }

	    public List<Categorie> getAllCategories() throws DALException {
	        return daoCat.selectAll();
	    }
	}