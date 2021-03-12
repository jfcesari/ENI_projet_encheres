package fr.eni.enchere.bll;

import java.util.Date;
import java.util.Arrays;
import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.ArticleVenduDAO;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.jdbc.DALException;

public class ArticleVenduManager {
    private static ArticleVenduDAO daoAV;

    static {
        daoAV = DAOFactory.getDAOArticleVendu();
    }

    public void createArticleVendu(ArticleVendu articleVendu) throws BLLException, DALException {
        BLLException bllException = validateArticleVendu(articleVendu);
        if (bllException.hasErrors()) {
            throw bllException;
        } else {
            daoAV.insert(articleVendu);
        }
    }

    public ArticleVendu getArticleById(int id) throws DALException, BLLException {
        ArticleVendu articleVendu = daoAV.selectById(id);
        if (articleVendu == null) {
            BLLException bllException = new BLLException();
            bllException.addError(BLLErrors.no_result);
            throw bllException;
        }
        return articleVendu;
    }

    public void updateArticle(ArticleVendu article) throws BLLException, DALException {
        BLLException bllException = validateArticleVendu(article);
        if (bllException.hasErrors()) {
            throw bllException;
        } else {
            daoAV.update(article);
        }
    }

    public void updateCurrentPrice(int noArticle, int newPrix) throws DALException {
        daoAV.updateCurrentPrice(noArticle, newPrix);
    }

    public void deleteArticle(ArticleVendu articleVendu) throws DALException {
        daoAV.delete(articleVendu);
    }

    public List<ArticleVendu> getAllArticlesVendus() throws DALException, BLLException {
        List<ArticleVendu> articlesVendus = daoAV.selectAll();
        if (articlesVendus.isEmpty()) {
            BLLException bllException = new BLLException();
            bllException.addError(BLLErrors.no_result);
            throw bllException;
        } else {
            return articlesVendus;
        }
    }

    public List<Integer> getArticlesByEtat(String etat) throws DALException, BLLException {
        List<Integer> articlesVendus = daoAV.selectByEtat(etat);
        if (articlesVendus.isEmpty()) {
            BLLException bllException = new BLLException();
            bllException.addError(BLLErrors.no_result);
            throw bllException;
        } else {
            return articlesVendus;
        }
    }

    public List<ArticleVendu> getArticlesFromCategory(Categorie categorie) throws DALException, BLLException {
        List<ArticleVendu> articlesVendus = daoAV.selectByCategory(categorie);
        if (articlesVendus.isEmpty()) {
            BLLException bllException = new BLLException();
            bllException.addError(BLLErrors.no_result);
            throw bllException;
        } else {
            return articlesVendus;
        }
    }

    public List<ArticleVendu> getArticlesFilterByNomArticle(String filter) throws DALException, BLLException {
        List<ArticleVendu> articlesVendus = daoAV.selectByString(filter);
        if (articlesVendus.isEmpty()) {
            BLLException bllException = new BLLException();
            bllException.addError(BLLErrors.no_result);
            throw bllException;
        } else {
            return articlesVendus;
        }
    }

    private BLLException validateArticleVendu(ArticleVendu articleVendu) {
        BLLException bllException = new BLLException();
        if (articleVendu.getNomArticle().length() > 30) {
            bllException.addError(BLLErrors.length_art_name);
        }
        if (articleVendu.getDescription().length() > 300) {
            bllException.addError(BLLErrors.length_art_description);
        }
        String[] acceptedValuesEtatVente = {"enchères en cours", "enchères en cours", "enchères remportées", "ventes en cours", "ventes non débutées", "ventes terminées"};
        if (!Arrays.asList(acceptedValuesEtatVente).contains(articleVendu.getEtatVente())) {
            bllException.addError(BLLErrors.error_status);
        }
        if (articleVendu.getDateDebutEncheres().after(articleVendu.getDateFinEncheres())) {
            bllException.addError(BLLErrors.error_end_date);
        }
        if (articleVendu.getDateDebutEncheres().before(new Date()) || articleVendu.getDateFinEncheres().before(new Date())) {
            bllException.addError(BLLErrors.error_beginning_date);
        }
        return bllException;
    }
}