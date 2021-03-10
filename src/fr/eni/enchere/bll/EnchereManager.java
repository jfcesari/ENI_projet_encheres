package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.EnchereDAO;
import fr.eni.enchere.dal.jdbc.DALException;

public class EnchereManager {
	 public static EnchereDAO daoAuc;

	    static {
	        daoAuc = DAOFactory.getDAOEnchere();
	    }

	    public void createEnchere(Enchere enchere) throws DALException {
	        daoAuc.insert(enchere);
	    }

	    public List<Integer> selectIdArticlesFromUserAndState(Utilisateur utilisateur, String state) throws DALException {
	        return daoAuc.getNoArticlesByUtilisateurAndEtat(utilisateur, state);
	    }
	}