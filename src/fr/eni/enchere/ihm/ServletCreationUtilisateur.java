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
@WebServlet("/jsp/ServletCreationUtilisateur")
public class ServletCreationUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/creationCompteUtilisateur.jsp");
        request.setAttribute("page", "createLogin");
        rd.forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        UtilisateurManager um= null;
		try {
			um = new UtilisateurManager();
		} catch (BLLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        List<String> errors = new ArrayList<>();
        // Hash password
        String password = request.getParameter("password");
        String generatedPassword = GestionMotDePasse.hashPassword(password);
        // New user
        Utilisateur utilisateur = new Utilisateur(
                request.getParameter("pseudo"),
                request.getParameter("nom"),
                request.getParameter("prenom"),
                request.getParameter("email"),
                request.getParameter("telephone"),
                request.getParameter("rue"),
                request.getParameter("codePostal"),
                request.getParameter("ville"),
                generatedPassword,
                0,
                false
        );
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/index.jsp");
        try {
            um.insertUtilisateur(utilisateur);
        } catch (BLLException e) {
            GestionErreur.BLLExceptionsCatcher(e, errors, request);
        } catch (DALException e) {
            GestionErreur.DALExceptionsCatcher(e, errors, request);
        }
        if (errors.isEmpty()) {
            try {
                GestionRequete.processHomePageAttributes(request);
            } catch (DALException e) {
                GestionErreur.DALExceptionsCatcher(e, errors, request);
            } catch (BLLException e) {
                GestionErreur.BLLExceptionsCatcher(e, errors, request);
            }
            request.setAttribute("loginCreated", "true");
            request.setAttribute("page", "home");
        } else {
            request.setAttribute("page", "createLogin");
            request.setAttribute("utilisateurError", utilisateur);
        }
        rd.forward(request, response);
    }
}
