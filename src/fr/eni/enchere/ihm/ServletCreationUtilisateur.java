package fr.eni.enchere.ihm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.jdbc.DALException;

/**
 * Servlet implementation class ServletCreationUtilisateur
 */
@WebServlet("/ServletCreationUtilisateur")
public class ServletCreationUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/creationCompteUtilisateur.jsp");
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UtilisateurManager newUser = null;
		try {
			newUser = new UtilisateurManager();
		} catch (BLLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String pseudo = null;
		String nom = null;
		String prenom = null;
		String email = null;
		String telephone = null;
		String rue = null;
		String codePostal = null;
		String ville = null;
		String motDePasse = null;
		String confirmationMotDePasse = null;
		
		pseudo = request.getParameter("pseudo").trim();
		nom = request.getParameter("nom").trim();
		prenom = request.getParameter("prenom").trim();
		email = request.getParameter("email").trim();
		telephone = request.getParameter("telephone");
		rue = request.getParameter("rue").trim();
		codePostal = request.getParameter("codePostal");
		ville = request.getParameter("ville").trim();
		motDePasse = request.getParameter("motDePasse").trim();
		confirmationMotDePasse = request.getParameter("confirmationMotDePasse").trim();
		
		Utilisateur user = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, 0, false); 
		
		try {
			
			newUser.insertUser(0, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, confirmationMotDePasse, 0, false);
			
			request.setAttribute("user", user);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageAccueil.jsp");
			rd.forward(request, response);
			
		}catch (Exception e) {
			
			//request.setAttribute("Erreur", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/jsp/creationCompteUtilisateur.jsp");
			
		} 

			
	}

}