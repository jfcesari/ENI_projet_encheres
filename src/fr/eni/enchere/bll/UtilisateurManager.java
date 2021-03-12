package fr.eni.enchere.bll;

import java.sql.SQLException;
import java.util.ArrayList;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.UtilisateurDAO;
import fr.eni.enchere.dal.jdbc.DALException;
import fr.eni.enchere.bll.BLLException;

public class UtilisateurManager {
	
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
    public Utilisateur insertUtilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone, String rue, String codePostal, String ville, String motDePasse, int credit, boolean administrateur) {
		
		Utilisateur utilisateur = new Utilisateur();
	
		utilisateur.setPseudo(pseudo);
		utilisateur.setNom(nom);
		utilisateur.setPrenom(prenom);
		utilisateur.setEmail(email);
		utilisateur.setTelephone(telephone);
		utilisateur.setRue(rue);
		utilisateur.setCodePostal(codePostal);
		utilisateur.setVille(ville);
		utilisateur.setMotDePasse(motDePasse);
		utilisateur.setCredit(0);
		utilisateur.setAdministrateur(false);
		if(verifMail(email) == true && verifPseudo(pseudo) == true) {
			try {
				this.daoUsr.insert(utilisateur);
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			System.out.println("CPALAMERDE");
			
		}else {
			//throw new BusinessException("L'email est déjà utilisé, veuillez en utiliser un autre.");
			System.out.println("CLAMERDE");
		}
		return utilisateur;
		
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
