package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.DALErrors;
import fr.eni.enchere.dal.EnchereDAO;

public class EnchereDAOJdbcImpl implements EnchereDAO {
	
private static final String SqlAuctInsert = "INSERT INTO encheres (no_utilisateur, no_article, date_enchere, montant_enchere) VALUES (?, ?, ?, ?)";
private static final String SqlSelectByUserAndState = "SELECT E.no_article FROM encheres E INNER JOIN ARTICLES_VENDUS AV on E.no_article = AV.no_article WHERE AV.etat_vente = ? AND E.no_utilisateur = ?";

		@Override
	    public void insert(Enchere enchere) throws DALException {
	        Connection cnx = JdbcTools.connect();
	        try {
	            PreparedStatement stmt = cnx.prepareStatement(SqlAuctInsert);
	            stmt.setInt(1, enchere.getNoUtilisateur());
	            stmt.setInt(2, enchere.getNoArticle());
	            stmt.setObject(3, new Timestamp(enchere.getDateEnchere().getTime()));
	            stmt.setInt(4, enchere.getMontantEnchere());
	            stmt.executeUpdate();
	            cnx.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            DALException dalException = new DALException();
	            dalException.addError(DALErrors.error_insert);
	            throw dalException;
	        }
	    }

		@Override
	    public List<Integer> getNoArticlesByUtilisateurAndEtat(Utilisateur utilisateur, String state) throws DALException {
	        Connection cnx = JdbcTools.connect();
	        List <Integer> noArticlesMatched = new ArrayList<>();
	        try {
	            PreparedStatement stmt = cnx.prepareStatement(SqlSelectByUserAndState);
	            stmt.setString(1, state);
	            stmt.setInt(2, utilisateur.getNoUtilisateur());
	            stmt.execute();
	            ResultSet rs = stmt.getResultSet();
	            while (rs.next()) {
	                noArticlesMatched.add(rs.getInt("no_article"));
	            }
	            cnx.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            DALException dalException = new DALException();
	            dalException.addError(DALErrors.error_select);
	            throw dalException;
	        }

	        return noArticlesMatched;
	    }
}
