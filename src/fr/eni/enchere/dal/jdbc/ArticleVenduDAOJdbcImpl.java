package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.ArticleVenduDAO;
import fr.eni.enchere.dal.DALErrors;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {

private static final String SqlSoldArtInsert = "INSERT INTO articles_vendus (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente) VALUES (?, ?, ?, ?, ?, ?)";
private static final String SqlSoldArtSelectById = "SELECT * FROM articles_vendus WHERE no_article = ?";
private static final String SqlSelectAll = "SELECT * FROM articles_vendus";
private static final String SqlSoldArtSelectByCategory = "SELECT * FROM articles_vendus INNER JOIN categories c on articles_vendus.no_categorie = C.no_categorie WHERE C.no_categorie = ?";
private static final String SqlSelectByEtat = "SELECT no_article FROM articles_vendus WHERE etat_vente = ?";
private static final String SqlSelectBySellerAndState = "SELECT AV.no_article FROM utilisateurs U INNER JOIN articles_vendus AV on U.no_utilisateur = AV.no_utilisateur WHERE U.no_utilisateur = ? AND AV.etat_vente = ?";
private static final String SqlSelectByName = "SELECT * FROM articles_vendus WHERE nom_article LIKE ?";
private static final String SqlUpdateById = "UPDATE articles_vendus SET nom_article = ?, description = ?, date_debut_encheres = ?, date_fin_encheres = ?, prix_initial = ?, prix_vente = ?, etat_vente = ?, no_utilisateur = ?, no_categorie = ? WHERE no_article= ?;";
private static final String SqlUpdateCurrentPrice = "UPDATE artiles_vendus SET prix_vente = ? WHERE no_article = ?";
private static final String SqlDelete = "DELETE FROM articles_vendus WHERE no_article = ?";

		@Override
		public void insert(ArticleVendu soldArt) throws DALException {
			Connection cnx = JdbcTools.connect();
			PreparedStatement ps=null;
			ResultSet keys=null;
			try {
				ps=cnx.prepareStatement(SqlSoldArtInsert, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, soldArt.getNomArticle());
				ps.setString(2, soldArt.getDescription());
				ps.setDate(3, soldArt.getDateDebutEncheres());
				ps.setDate(4, soldArt.getDateFinEncheres());
				ps.setInt(5, soldArt.getMiseAPrix());
				ps.setInt(6, soldArt.getPrixVente());
				ps.executeUpdate();
				keys = ps.getGeneratedKeys();
				if (keys.next()) {
					int id=keys.getInt(1);
					soldArt.setNoArticle(id);
				}
				cnx.close();
				} catch (SQLException e) {
					e.printStackTrace();
		            DALException dalException = new DALException();
		            dalException.addError(DALErrors.error_insert);
		            throw dalException;
					}        
		}
	      
		@Override
	    public ArticleVendu selectById(int noArticle) throws DALException {
			Connection cnx=JdbcTools.connect();
			PreparedStatement ps=null;
			ResultSet rs=null;
			ArticleVendu articleVendu=null;
			try {
				ps=cnx.prepareStatement(SqlSoldArtSelectById);
				ps.setInt(1, noArticle);
				rs=ps.executeQuery();
				articleVendu=new ArticleVendu(rs.getInt("noArticle"), rs.getString("nomArticle"), rs.getInt("nocategorie"), rs.getString("description"), rs.getDate("dateDebutEncheres"), rs.getDate("dateFinEncheres"),  rs.getInt("miseAPrix"),  rs.getInt("PrixVente"),  rs.getString("etatVente"));				
			cnx.close();
			} catch (SQLException e) {
					e.printStackTrace();
		            DALException dalException = new DALException();
		            dalException.addError(DALErrors.error_select);
		            throw dalException;
		            }
			return articleVendu;
		}

		@Override
	    public List<ArticleVendu> selectAll() throws DALException {
	        Connection cnx = JdbcTools.connect();
	        List<ArticleVendu> articlesVendus = new ArrayList<>();
	        try {
	            PreparedStatement ps = cnx.prepareStatement(SqlSelectAll);
	            ps.execute();
	            ResultSet rs = ps.getResultSet();
	            while (rs.next()) {
	                articlesVendus.add(new ArticleVendu(rs.getInt("noArticle"), rs.getString("nomArticle"), rs.getInt("noCategorie"), rs.getString("description"), rs.getDate("dateDebutEncheres"), rs.getDate("dateFinEncheres"), rs.getInt("miseAPrix"), rs.getInt("PrixVente"), rs.getString("etatVente")));				
				}
	            cnx.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            DALException dalException = new DALException();
	            dalException.addError(DALErrors.error_select);
	            throw dalException;
	            }
	        return articlesVendus;
	    }
		
		@Override
	    public List<ArticleVendu> selectByCategory(Categorie categorie) throws DALException {
			Connection cnx=JdbcTools.connect();
			PreparedStatement ps=null;
			ResultSet rs=null;
			List<ArticleVendu> articlesVendus = new ArrayList<>();
			try {
				ps=cnx.prepareStatement(SqlSoldArtSelectById);
				ps.setInt(1, Categorie.getNoCategorie());
				rs=ps.executeQuery();
				cnx.close();
				while (rs.next()) {
	                articlesVendus.add(new ArticleVendu(rs.getInt("noArticle"), rs.getString("nomArticle"), rs.getInt("noCategorie"), rs.getString("description"), rs.getDate("dateDebutEncheres"), rs.getDate("dateFinEncheres"), rs.getInt("miseAPrix"), rs.getInt("PrixVente"), rs.getString("etatVente")));				
				}
	            cnx.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            DALException dalException = new DALException();
	            dalException.addError(DALErrors.error_select);
	            throw dalException;
	        }
			return articlesVendus;
		}
	    	
	    public List<Integer> selectByEtat(String etatVente) throws DALException {
	        Connection cnx = JdbcTools.connect();
	        List<Integer> articlesVendus = new ArrayList<>();
	        try {
	            PreparedStatement ps = cnx.prepareStatement(SqlSelectByEtat);
	            ps.setString(1, etatVente);
	            ps.execute();
	            ResultSet rs = ps.getResultSet();
	            while (rs.next()) {
	                articlesVendus.add(rs.getInt("no_article"));
	            }
	            cnx.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            DALException dalException = new DALException();
	            dalException.addError(DALErrors.error_select);
	            throw dalException;
	        }
	        return articlesVendus;
	    }

		@Override
	    public List<Integer> getArticlesFromASellerAndState(Utilisateur utilisateur, String etatVente) throws DALException {
			 Connection cnx = JdbcTools.connect();
		     List <Integer> articleVendus = new ArrayList<>();
		     try {
		            PreparedStatement ps = cnx.prepareStatement(SqlSelectBySellerAndState);
		            ps.setInt(1, utilisateur.getNoUtilisateur());
		            ps.setString(2, etatVente);
		            ps.execute();
		            ResultSet rs = ps.getResultSet();
		            while (rs.next()) {
		                articleVendus.add(rs.getInt("no_article"));
		            }
		            cnx.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		            DALException dalException = new DALException();
		            dalException.addError(DALErrors.error_select);
		            throw dalException;
		        }
		        return articleVendus;
	    }

		@Override
	    public List<ArticleVendu> selectByString(String search) throws DALException {
	        Connection cnx = JdbcTools.connect();
	        List<ArticleVendu> articlesVendus = new ArrayList<>();
	        try {
	            PreparedStatement ps = cnx.prepareStatement(SqlSelectByName);
	            ps.setString(1, "%" + search + "%");
	            ps.execute();
	            ResultSet rs = ps.getResultSet();
	            while(rs.next()) {
	            	 articlesVendus.add(new ArticleVendu(rs.getInt("noArticle"), rs.getString("nomArticle"), rs.getInt("noCategorie"), rs.getString("description"), rs.getDate("dateDebutEncheres"), rs.getDate("dateFinEncheres"), rs.getInt("miseAPrix"), rs.getInt("PrixVente"), rs.getString("etatVente")));				
				}
	            cnx.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            DALException dalException = new DALException();
	            dalException.addError(DALErrors.error_select);
	            throw dalException;
	        }
	        return articlesVendus;
	    }

		@Override
	    public void update(ArticleVendu soldArt) throws DALException {
			 Connection cnx = JdbcTools.connect();
		        try {
		            PreparedStatement ps = cnx.prepareStatement(SqlUpdateById);
		            ps.setString(1, soldArt.getNomArticle());
					ps.setInt(8, soldArt.getNoCategorie());
					ps.setString(2, soldArt.getDescription());
					ps.setDate(3, soldArt.getDateDebutEncheres());
					ps.setDate(4, soldArt.getDateFinEncheres());
					ps.setInt(5, soldArt.getMiseAPrix());
					ps.setInt(6, soldArt.getPrixVente());
					ps.setString(7, soldArt.getEtatVente());
		            ps.setInt(10, soldArt.getNoArticle());
		            ps.execute();
		            cnx.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		            DALException dalException = new DALException();
		            dalException.addError(DALErrors.error_update);
		            throw dalException;
		        }
	    }

		@Override
	    public void updateCurrentPrice(int noArticle, int newPrice) throws DALException {
		     Connection cnx = JdbcTools.connect();
		        try {
		            PreparedStatement ps = cnx.prepareStatement(SqlUpdateCurrentPrice);
		            ps.setInt(1, newPrice);
		            ps.setInt(2, noArticle);
		            ps.executeUpdate();
		            cnx.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		            DALException dalException = new DALException();
		            dalException.addError(DALErrors.error_update);
		            throw dalException;
		        }
	    }

		@Override
	    public void delete(ArticleVendu articleVendu) throws DALException {
		    Connection cnx = JdbcTools.connect();
	        try {
	            PreparedStatement ps = cnx.prepareStatement(SqlDelete);
	            ps.setInt(1, articleVendu.getNoArticle());
	            ps.executeUpdate();
	            cnx.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            DALException dalException = new DALException();
	            dalException.addError(DALErrors.error_delete);
	            throw dalException;
	        }
	    }
}
