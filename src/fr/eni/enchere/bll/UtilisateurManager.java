package fr.eni.enchere.bll;

import fr.eni.enchere.bo.Utilisateur;
<<<<<<< Updated upstream
<<<<<<< Updated upstream
import fr.eni.enchere.dal.jdbc.DAOFactory;
import fr.eni.enchere.dal.jdbc.UtilisateurDAO;

public class UtilisateurManager {
	private static UtilisateurDAO daoUsr;

   public UtilisateurManager() throws BLLException {
        daoUsr = DAOFactory.getUtilisateurDAO();
    }

    //CRUD: selectById
    public Utilisateur getUtilisateurById(int id) throws DALException {
        return daoUsr.selectById(id);
    }
    
    //CRUD: update
    public void updateUtilisateur (Utilisateur utilisateur, boolean checkForMail, boolean checkForPseudo) throws BLLException, DALException {
        BLLException bllException = validateUtilisateur(utilisateur);
        if (checkForMail) {
            if (!daoUsr.checkForUniquePseudo(utilisateur.getPseudo())) {
                bllException.addError(BLLErrors.pseudo_taken);
            }
        }
        if (checkForPseudo) {
            if(!daoUsr.checkForUniqueEmail(utilisateur.getEmail())) {
                bllException.addError(BLLErrors.email_taken);
            }
        }

        if (bllException.hasErrors()) {
            throw bllException;
        } else {
            daoUsr.update(utilisateur);
        }
    }

    //CRUD: insert
    public void insertUtilisateur(Utilisateur utilisateur) throws BLLException, DALException {
        BLLException bllException = validateUtilisateur(utilisateur);
        if (!daoUsr.checkForUniquePseudo(utilisateur.getPseudo())) {
            bllException.addError(BLLErrors.pseudo_taken);
        }
        if (!daoUsr.checkForUniqueEmail(utilisateur.getEmail())) {
            bllException.addError(BLLErrors.email_taken);
        }
        if (bllException.hasErrors()) {
            throw bllException;
        } else {
            daoUsr.insert(utilisateur);
        }
    }
    
    private BLLException validateUtilisateur(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return null;
	}

	//CRUD: delete
    public void deleteUtilisateur (Utilisateur utilisateur) throws DALException {
        daoUsr.delete(utilisateur);
    }
=======
=======
>>>>>>> Stashed changes

public class UtilisateurManager {

	private static DAOUtilisateur dao;
	
	static {
		dao=DAOFactory.getDAOUtilisateur();
	}

	public void createUtilisateur (Utilisateur utilisateur) throws BLLException, DALException {
		if (!dao.checkforUniquePseudo(utilisateur.getPseudo())) {
			bllException.addError(BLLErrors.pseudo_taken);
		}
		if (!dao.checkforUniqueEmail(utilisateur.getEmail())) {
			bllException.addError(BLLErrors.email_taken);
		}
		if (bllExcpetion.hasErrors()) {
			throw bllException;
		}
		else {
			dao.insert(utilisateur);
		}
	}
	
	
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
}
