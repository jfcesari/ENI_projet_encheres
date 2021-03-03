package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.enchere.bo.Utilisateur;

public class UtilisateursDAOJdbcImpl implements UtilisateurDAO {

private static final String sqlUserSelectbyId = "SELECT * FROM utilisateurs WHERE no_utilisateur=?";
private static final String sqlUserUpdate = "UPDATE utilisateurs SET pseudo=?, nom=?, prenom=?, email=?, telephone=?, rue=?, code_postal=?, ville=?, mot_de_passe=?, credit=?, administrateur=?";
private static final String sqlUserInsert = "INSERT into utilisateurs (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
private static final String sqlUserDelete = "no_utilisateur=?";

	
	public Utilisateur selectById(int id) throws DALException {
		Connection connection=JdbcTools.connect();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Utilisateur utilisateur=null;
		try {
			connection=getConnection();
			ps=connection.prepareStatement(sqlUserSelectbyId);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			
		utilisateur=new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getInt("telephone"),  rs.getString("rue"),  rs.getInt("code_postal"),  rs.getString("ville"), rs.getString("mot_de_passe"), rs.getInt("credit"), rs.getBoolean("administrateur"));
		} catch (SQLException e) {
			throw new DALException("Request failed for id "+id, e);
		} finally {
			try {
				rs.close();
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
			closeConnection();
		}
		return utilisateur;
	}

public void update(Utilisateur usr) throws DALException {
	Connection connection=JdbcTools.connect();
	PreparedStatement ps=null;
	try {
		connection=getConnection();
		ps=connection.prepareStatement(sqlUserUpdate);
		
		ps.setString(1, usr.getPseudo());
		ps.setString(2, usr.getNom());
		ps.setString(3, usr.getPrenom());
		ps.setString(4, usr.getEmail());
		ps.setInt(5, usr.getTelephone());
		ps.setString(6, usr.getRue());
		ps.setInt(7, usr.getCodePostal());
		ps.setString(8, usr.getVille());
		ps.setString(9, usr.getMotDePasse());
		ps.setInt(10, usr.getCredit());
		ps.setBoolean(11, usr.getAdministrateur());

		ps.executeUpdate();

	} catch (SQLException e){
		throw new DALException("Update failed ", e);
	} finally {
		try {
			if (ps!=null) {
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
	}
}

public void insert(Utilisateur usr) throws DALException {
	Connection connection=JdbcTools.connect();
	PreparedStatement ps=null;
	ResultSet keys=null;
	try {
		connection = getConnection();
		ps=connection.prepareStatement(sqlUserInsert, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, usr.getPseudo());
		ps.setString(2, usr.getNom());
		ps.setString(3, usr.getPrenom());
		ps.setString(4, usr.getEmail());
		ps.setInt(5, usr.getTelephone());
		ps.setString(6, usr.getRue());
		ps.setInt(7, usr.getCodePostal());
		ps.setString(8, usr.getVille());
		ps.setString(9, usr.getMotDePasse());
		ps.setInt(10, usr.getCredit());
		ps.setBoolean(11, usr.getAdministrateur());

		ps.executeUpdate();
		keys = ps.getGeneratedKeys();
		if (keys.next()) {
			int id=keys.getInt(1);
			usr.setNoUtilisateur(id);
		} else {
			throw new DALException ("Error while retrieving id.");
		}	
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
		closeConnection();
	}
}

public void delete(int id) throws DALException {
	Connection connection=JdbcTools.connect();
	PreparedStatement ps = null;
	try {
		connection = getConnection();
		ps = connection.prepareStatement(sqlUserDelete);
		ps.setString(1,);
		ps.executeUpdate();
	} catch (SQLException e) {
		throw new DALException("Deletion failed for id=" + id, e);
	} finally {
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();

	}
}
}
