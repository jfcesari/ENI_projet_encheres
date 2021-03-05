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

public class ArticleVenduDAOJdbcImpl implements DAOArticleVendu {

private static final String SqlSoldArtInsert = "INSERT INTO articles_vendus (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, etat_vente, no_utilisateur, no_categorie) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
private static final String SqlSoldArtSelectById = "SELECT * FROM articles_vendus WHERE no_article = ?";
private static final String SqlSoldArtSelectByCategory = "SELECT * FROM articles_vendus INNER JOIN categories c on articles_vendus.no_categorie = C.no_categorie WHERE C.no_categorie = ?";
	
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
				ps.setString(7, soldArt.getEtatVente());

				ps.executeUpdate();
				keys = ps.getGeneratedKeys();
				if (keys.next()) {
					int id=keys.getInt(1);
					soldArt.setNoArticle(id);
				} else {
					throw new DALException ("Error while retrieving article number.");
				}	
				cnx.close();
			} catch (SQLException e) {
				throw new DALException("Insertion failed", e);
			} finally {
				try {
					keys.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					if(ps != null) {
						ps.close();
					}
				} catch (SQLException e){
					e.printStackTrace();
				}
			}
		}     
	      
		@Override
	    public ArticleVendu selectById(int noArticle) throws DALException {
			throw new DALException("méthode non implementee");
		}

		@Override
	    public List<ArticleVendu> filterByCategory(Categorie categorie) throws DALException {
			throw new DALException("méthode non implementee");
		}
	    	
	    	
	       
	 

	    public List<Integer> filterByEtat(String etat) throws DALException {
			throw new DALException("méthode non implementee");
	    }

		@Override
	    public List<Integer> getArticlesFromASellerAndState(Utilisateur utilisateur, String state) throws DALException {
			throw new DALException("méthode non implementee");
	    }


	    /**
	     *
	     * Get all ArticleVendu instances that the field no_article match a String from the DB
	     * @param filter the filter
	     * @return An ArrayList filled with instances
	     * @throws DALException if the SQL SELECT request is wrong
	     */
		@Override
	    public List<ArticleVendu> filterByString(String filter) throws DALException {
			throw new DALException("méthode non implementee");
	    }
	    /**
	     * Select all the articleVendu from the DB
	     * @return An ArrayList filled with instances of Utilisateur
	     */
		@Override
	    public List<ArticleVendu> selectAll() throws DALException {
			throw new DALException("méthode non implementee");
	    }

		@Override
	    public void update(ArticleVendu articleVendu) throws DALException {
			throw new DALException("méthode non implementee");
	    }

	    /**
	     * Update the current price of an article
	     * @param noArticle int the id of the article to update
	     * @param newPrice int the new price
	     * @throws DALException if there is any issue with the SQL query
	     */
		@Override
	    public void updateCurrentPrice(int noArticle, int newPrice) throws DALException {
			throw new DALException("méthode non implementee");
	    }

		@Override
	    public void delete(ArticleVendu articleVendu) throws DALException {
			throw new DALException("méthode non implementee");
	    }
	    /**
	     * Set a prepared statement used by both INSERT and UPDATE requests
	     * @param articleVendu The instance to insert or update
	     * @param stmt Statement The statement to set
	     * @throws SQLException If parameterIndex does not correspond to a parameter marker in the SQL statement
	     */
	    private void fillPreparedStatement(ArticleVendu articleVendu, PreparedStatement stmt) throws SQLException {
			throw new SQLException("méthode non implementee");
	    }
	    /**
	     * Fill an instance from a ResultSet
	     * @param rs the resultSet
	     * @return articleVendu The instance
	     * @throws SQLException if the ResultSet doesn't match the different fields
	     */
	    private ArticleVendu hydrateArticleVendu(ResultSet rs) throws SQLException {
			throw new SQLException("méthode non implementee");
	    }
}
