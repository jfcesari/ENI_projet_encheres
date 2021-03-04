package fr.eni.enchere.ihm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchere.dal.jdbc.DALException;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/jsp/ServletConnexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConnexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp");
		if (request.isUserInRole("basic_user")) {
            SessionManagement.setSessionConnected(request);
            try {
                // Set the user informations in the session in order to display them everywhere
                SessionManagement.setUtilisateurSessionBean(request, request.getUserPrincipal().getName());
            } catch (DALException e) {
                // This is serious
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
            HttpSession session = request.getSession();
            // If there is this session attribute, we redirect to it
            if (session.getAttribute("uriAndParamsRequested") != null) {
                response.sendRedirect((String) session.getAttribute("uriAndParamsRequested"));
            } else {
                response.sendRedirect(request.getContextPath());
            }

        } else {
            // 1st call to this servlet : GET request without any session bean set
            request.setAttribute("page", "login");
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/index.jsp");
            rd.forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
