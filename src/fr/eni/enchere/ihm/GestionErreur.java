package fr.eni.enchere.ihm;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.dal.jdbc.DALException;
import fr.eni.enchere.messages.LecteurMessage;

public class GestionErreur {
	/**
     * Treat a BLLException errors message and them to an ArrayList
     * @param e The BLLException
     * @param errors The ArrayList
     * @param request The instance of the HTTP request
     */
    public static void BLLExceptionsCatcher(BLLException e, List<String> errors, HttpServletRequest request) {
        for (Integer code_error : e.getListErrorCodes()) {
            errors.add(LecteurMessage.getMessageErreur(code_error));
        }
        request.setAttribute("errors", errors);
    }
    /**
     * Treat a BLLException errors message and them to an ArrayList
     * Send also a custom attribute to the jsp
     * @param e The BLLException
     * @param errors The ArrayList
     * @param request The instance of the HTTP request
     */
    public static void DALExceptionsCatcher(DALException e, List<String> errors, HttpServletRequest request) {
        request.setAttribute("error_name", "Erreur avec la base de données : ");
        for (Integer code_error : e.getListErrorCodes()) {
            errors.add(LecteurMessage.getMessageErreur(code_error));
        }
        request.setAttribute("errors", errors);
    }
}