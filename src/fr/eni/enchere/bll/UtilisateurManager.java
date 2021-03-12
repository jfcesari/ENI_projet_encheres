package fr.eni.enchere.bll;

import java.sql.SQLException;
import java.util.ArrayList;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.UtilisateurDAO;
import fr.eni.enchere.dal.jdbc.DALException;
import fr.eni.enchere.bll.BLLException;

public class UtilisateurManager {
	
	private static UtilisateurManager instance;
	private static UtilisateurDAO daoUsr;

   public UtilisateurManager() throws BLLException {
        daoUsr = DAOFactory.getUtilisateurDAO();
    }

    //CRUD: selectById
    public Utilisateur getUtilisateurById(int id) throws DALException {
        return daoUsr.selectById(id);
    }
    
    // selectByPseudo
	public Utilisateur getUtilisateurByPseudo(String pseudo_utilisateur) throws DALException {
        return daoUsr.selectByPseudo(pseudo_utilisateur);
	}
    
	public Utilisateur getUtilisateurLogin(String EmailouPseudo, String motDePasse) {
		Utilisateur utilisateur = null;
		try {
		    utilisateur = daoUsr.selectLogin(EmailouPseudo, motDePasse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return utilisateur;	
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

	private boolean verifPseudo(String pseudo2) {
		ArrayList<String> listPseudo = daoUsr.selectAllPseudo();
		for (String pseudo : listPseudo) {
			if(pseudo2.equals(pseudo)) return false;	
		}
		return true;
		
	}
	
	//CRUD: delete
    public void deleteUtilisateur (Utilisateur utilisateur) throws DALException, SQLException {
        try {
			daoUsr.delete(utilisateur);
		} catch (DALException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    private BLLException validateUtilisateur(Utilisateur utilisateur) {
        BLLException bllException = new BLLException();

        if (utilisateur.getPseudo().length()>30) {
            bllException.addError(BLLErrors.length_pseudo);
        }
        if (utilisateur.getNom().length()>30) {
            bllException.addError(BLLErrors.length_nom);
        }
        if (utilisateur.getPrenom().length()>30) {
            bllException.addError(BLLErrors.length_prenom);
        }
        if (utilisateur.getEmail().length()>40) {
            bllException.addError(BLLErrors.length_email);
        }
        if (utilisateur.getTelephone().length()>15) {
            bllException.addError(BLLErrors.length_telephone);
        }
        if (utilisateur.getRue().length()>30) {
            bllException.addError(BLLErrors.length_rue);
        }
        if (utilisateur.getCodePostal().length()>30) {
            bllException.addError(BLLErrors.length_codepostal);
        }
        if (utilisateur.getVille().length()>30) {
            bllException.addError(BLLErrors.length_ville);
        }
        return bllException;
    }

    	public Boolean verifMail (String mail) {
		ArrayList<String> listMail = daoUsr.selectAllEmail();
		for (String email : listMail) {
			if(mail.equals(email)) return false;	
		}
		return true;
	}
}
