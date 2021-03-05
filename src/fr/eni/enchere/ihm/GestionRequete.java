package fr.eni.enchere.ihm;

import javax.servlet.http.HttpServletRequest;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.dal.jdbc.DALException;

public class GestionRequete {
	public static void processHomePageAttributes(HttpServletRequest request) throws DALException, BLLException {
        request.setAttribute("pseudos", new UtilisateurManager().getUtilisateurByPseudo("pseudo"));
    }
}