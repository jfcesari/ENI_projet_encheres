package fr.eni.enchere.ihm;

import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.jdbc.DALException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GestionSession {
    /**
     * Get the session and record a session attribute for 5 minutes
     * @param request The request instance
     */
    public static void setSessionConnected (HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(300);
        session.setAttribute("isConnected", "true");
    }

    /**
     * Destroy the session, bye bye user !
     * @param request The request instance
     */
    public static void destroySession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
    }

    /**
     *Set a session JavaBean from the pseudo the connected user
     * @param request The request instance
     * @param pseudo_utilisateur String
     * @throws DALException If there were any SQL issue into the DAL
     */
    public static void setUtilisateurSessionBean(HttpServletRequest request, String pseudo_utilisateur) throws DALException {
        UtilisateurManager um = new UtilisateurManager();
        HttpSession session = request.getSession();
        Utilisateur utilisateurToBean = um.getUtilisateurByPseudo(pseudo_utilisateur);
        session.setAttribute("utilisateurSession", utilisateurToBean);
    }
}