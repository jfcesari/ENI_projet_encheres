package fr.eni.enchere.bll;

import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.RetraitDAO;
import fr.eni.enchere.dal.jdbc.DALException;

public class RetraitManager {
	 private static RetraitDAO daoWdwl;

	    static {
	        daoWdwl = DAOFactory.getRetraitDAO();
	    }

	    public void createRetrait(Retrait retrait) throws DALException, BLLException {
	        BLLException bllException = validateRetrait(retrait);
	        if (bllException.hasErrors()) {
	            throw bllException;
	        } else {
	        	daoWdwl.insert(retrait);
	        }
	    }

	    public Retrait getRetraitByNoArticle(int noArticle) throws DALException {
	        return daoWdwl.selectById(noArticle);
	    }

	    public void updateRetrait(Retrait retrait) throws DALException, BLLException {
	        BLLException bllException = validateRetrait(retrait);
	        if (bllException.hasErrors()) {
	            throw bllException;
	        } else {
	        	daoWdwl.update(retrait);
	        }
	    }

	    public void deleteRetrait(Retrait retrait) throws DALException {
	    	daoWdwl.delete(retrait);
	    }

	    private BLLException validateRetrait(Retrait retraitToValidate) {
	        BLLException bllException = new BLLException();
	        if (retraitToValidate.getRue().length() > 30) {
	            bllException.addError(BLLErrors.length_rue);
	        }
	        if (retraitToValidate.getCodePostal().length() > 15) {
	            bllException.addError(BLLErrors.length_codepostal);
	        }
	        if (retraitToValidate.getVille().length() > 30) {
	            bllException.addError(BLLErrors.length_ville);
	        }
	        return bllException;
	    }
}
