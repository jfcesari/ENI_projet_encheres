package fr.eni.enchere.ihm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bll.UtilisateurManager;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.jdbc.DALException;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet(urlPatterns = {"/ServletConnexion", "/login_error", "/j_security_check"})
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			
			for(Cookie cookie : cookies) {
				
				if (cookie.getName().equals("EmailouPseudo")) {
                    request.setAttribute("EmailouPseudo", cookie.getValue());
				}
				
				if (cookie.getName().equals("motDePasse")) {
                    request.setAttribute("motDePasse", cookie.getValue());
				}
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp");
		
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
		
		String EmailouPseudo = null;
		String motDePasse = null;
		String save = null;
		Utilisateur utilisateur = null;
		
		EmailouPseudo = request.getParameter("EmailouPseudo");
		motDePasse = request.getParameter("motDePasse");
		save = request.getParameter("save");
		
		if(save != null) {
			
			Cookie cookie = new Cookie("EmailouPseudo", EmailouPseudo);
			cookie.setMaxAge(60 * 60 * 24 * 30);
			response.addCookie(cookie);
			
			Cookie cookie2 = new Cookie("motDePasse", motDePasse);
			cookie2.setMaxAge(60 * 60 * 24 * 30);
			response.addCookie(cookie2);
		}
		
		try {
	           utilisateur = newUser.getUtilisateurLogin(EmailouPseudo, motDePasse);
	           System.out.println(EmailouPseudo);
	           System.out.println(motDePasse);
	           if(utilisateur == null) {
	                String error = "Mot de passe ou Pseudo incorrect";
	                request.setAttribute("message", error);
	                request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request,response);
	                
	            } else {
	                HttpSession session = request.getSession();
	                session.setAttribute("utilisateur", utilisateur);
	                request.getRequestDispatcher("/WEB-INF/jsp/pageAccueil.jsp").forward(request, response);
	                
	                
	                
	            }
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
	}

}