package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.dal.CategorieDAO;
import fr.eni.enchere.dal.DALErrors;

public class CategorieDAOJdbcImpl implements CategorieDAO {

private static final String SqlCatInsert = "INSERT INTO categories VALUES (?)";
private static final String SqlCatSelectById = "SELECT * FROM categories WHERE no_categorie = ?";
private static final String SqlCatSelectAll = "SELECT * FROM categories";
private static final String SqlCatCheckIfUnique = "SELECT * FROM categories WHERE libelle LIKE ?";

	@Override
    public void insert(Categorie categorie) throws DALException {
        Connection cnx = JdbcTools.connect();
        try {
            PreparedStatement ps = cnx.prepareStatement(SqlCatInsert, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, categorie.getLibelle());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                categorie.setNoCategorie(rs.getInt(1));
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
    public Categorie selectById(int id) throws DALException {
        Connection cnx = JdbcTools.connect();
        Categorie categorie = null;
        try {
            PreparedStatement ps = cnx.prepareStatement(SqlCatSelectById);
            ps.setInt(1, id);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            if (rs.next()) {
                categorie = new Categorie(
                        rs.getInt("no_categorie"),
                        rs.getString("libelle")
                );
            }
            cnx.close();
        } catch (SQLException e) {
            e.printStackTrace();
            DALException dalException = new DALException();
            dalException.addError(DALErrors.error_select);
            throw dalException;
        }
        return categorie;
    }

    @Override
    public List<Categorie> selectAll() throws DALException {
        Connection cnx = JdbcTools.connect();
        List<Categorie> categories = new ArrayList<>();
        try{
            Statement ps = cnx.createStatement();
            ps.execute(SqlCatSelectAll);
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                categories.add(new Categorie(
                        rs.getInt("no_categorie"),
                        rs.getString("libelle")
                ));
            }
            cnx.close();
        } catch (SQLException e) {
            e.printStackTrace();
            DALException dalException = new DALException();
            dalException.addError(DALErrors.error_select);
            throw dalException;
        }
        return categories;
    }

    public boolean checkForUniqueCategorieLibelle(String libelle) throws DALException {
        Connection cnx = JdbcTools.connect();
        boolean isUnique = true;
        try {
            PreparedStatement ps = cnx.prepareStatement(SqlCatCheckIfUnique);
            ps.setString(1, libelle);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            if (rs.next()) {
                isUnique = false;
            }
            cnx.close();
        } catch (SQLException e) {
            e.printStackTrace();
            DALException dalException = new DALException();
            dalException.addError(DALErrors.error_select);
            throw dalException;
        }
        return isUnique;
    }
}
