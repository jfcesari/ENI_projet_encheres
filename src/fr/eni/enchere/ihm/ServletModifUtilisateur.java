package fr.eni.enchere.ihm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bo.Utilisateur;

/**
 * Servlet implementation class ServletModifUtilisateur
 */
@WebServlet("/ServletModifUtilisateur")
public class ServletModifUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/modifUtilisateur.jsp");
		
		String newPseudo = request.getParameter("newPseudo");
		String newNom = request.getParameter("newNom");
		String newPrenom = request.getParameter("newPrenom");
		String newEmail = request.getParameter("newEmail");
		String newTelephone = request.getParameter("newTelephone");
		String newRue = request.getParameter("newRue");
		String newCodePostal = request.getParameter("newCodePostal");
		String newVille = request.getParameter("newVille");
		String motDePasseActuel = request.getParameter("motDePasseActuel");
		String newMotDePasse = request.getParameter("newMotDePasse");
		String newConfirmationMotDePasse = request.getParameter("newConfirmationMotDePasse");
				
		String motDePasse = ((Utilisateur) request).getMotDePasse();
		
		if(motDePasseActuel.equals(motDePasse) && newMotDePasse.equals(newConfirmationMotDePasse)) {
			Utilisateur modifUtilisateur = new Utilisateur(newPseudo, newNom, newPrenom, newEmail, newTelephone, newRue, newCodePostal, newVille, newMotDePasse, 0, false);
			UtilisateurManager.updateUtilisateur(modifUtilisateur, checkForMail, checkForPseudo);	
			request.getRequestDispatcher("WEB-IF/jsp/affichageUtilisateur.jsp").forward(request, response);
		} else {
			
			request.getRequestDispatcher("WEB-IF/jsp/modifUtilisateur.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}