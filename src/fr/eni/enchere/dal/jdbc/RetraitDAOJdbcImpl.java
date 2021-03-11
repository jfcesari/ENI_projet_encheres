package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.dal.DALErrors;
import fr.eni.enchere.dal.RetraitDAO;

public class RetraitDAOJdbcImpl implements RetraitDAO {

private static final String SqlWdwlInsert = "INSERT INTO retraits (no_article, rue, code_postal, ville) VALUES (?, ?, ?, ?)";
private static final String SqlWdwlSelectById = "SELECT * FROM retraits WHERE no_article = ?";
private static final String SqlWdwlUpdate = "UPDATE retraits SET rue = ?, code_postal = ?, ville = ? WHERE no_article = ?";
private static final String SqlWdwlDelete = "DELETE FROM retraits WHERE no_article = ?";
	
	@Override
    public void insert(Retrait retrait) throws DALException {
        Connection cnx = JdbcTools.connect();
        try {
            PreparedStatement stmt = cnx.prepareStatement(SqlWdwlInsert);
            stmt.setInt(1, retrait.getNoArticle());
            stmt.setString(1, retrait.getRue());
            stmt.setString(2, retrait.getCodePostal());
            stmt.setString(3, retrait.getVille());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            DALException dalException = new DALException();
            dalException.addError(DALErrors.error_insert);
            throw dalException;
        }
    }

	@Override
    public Retrait selectById(int noArticle) throws DALException {
        Connection cnx = JdbcTools.connect();
        Retrait retrait = null;
        try {
            PreparedStatement stmt = cnx.prepareStatement(SqlWdwlSelectById);
            stmt.setInt(1, noArticle);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            if (rs.next()) {
               retrait=new Retrait(rs.getString("rue"), rs.getString("code_postal"), rs.getString("ville"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            DALException dalException = new DALException();
            dalException.addError(DALErrors.error_select);
            throw dalException;
        }
        return retrait;
    }

    @Override
    public List<Retrait> selectAll() throws DALException {
        return null;
    }

    @Override
    public void update(Retrait retrait) throws DALException {
        Connection cnx = JdbcTools.connect();
        try {
            PreparedStatement stmt = cnx.prepareStatement(SqlWdwlUpdate);
            stmt.setString(1, retrait.getRue());
            stmt.setString(2, retrait.getCodePostal());
            stmt.setString(3, retrait.getVille());
            stmt.setInt(4, retrait.getNoArticle());
            stmt.executeUpdate();
            cnx.close();
        } catch (SQLException e) {
            e.printStackTrace();
            DALException dalException = new DALException();
            dalException.addError(DALErrors.error_update);
            throw dalException;
        }
    }

    @Override
    public void delete(Retrait retrait) throws DALException {
        Connection cnx = JdbcTools.connect();
        try {
            PreparedStatement stmt = cnx.prepareStatement(SqlWdwlDelete);
            stmt.setInt(1, retrait.getNoArticle());
            stmt.executeUpdate();
            cnx.close();
        } catch (SQLException e) {
            e.printStackTrace();
            DALException dalException = new DALException();
            dalException.addError(DALErrors.error_delete);
            throw dalException;
        }
    }
}
