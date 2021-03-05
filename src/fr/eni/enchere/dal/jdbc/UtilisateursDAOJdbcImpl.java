package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.enchere.bo.Utilisateur;
//import fr.eni.enchere.dal.jdbc.UtilisateurDAO;
import fr.eni.enchere.dal.UtilisateurDAO;

public class UtilisateursDAOJdbcImpl implements UtilisateurDAO {

private static final String sqlUserSelectbyId = "SELECT * FROM utilisateurs WHERE no_utilisateur=?";
private static final String sqlUserUpdate = "UPDATE utilisateurs SET pseudo=?, nom=?, prenom=?, email=?, telephone=?, rue=?, code_postal=?, ville=?, mot_de_passe=?, credit=?, administrateur=?";
private static final String sqlUserInsert = "INSERT into utilisateurs (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
private static final String sqlUserDelete = "no_utilisateur=?";
private static final String sqlUserSelectbyPseudo = "SELECT * FROM utilisateurs WHERE pseudo=?";
	
	@Override
	public Utilisateur selectById(int id) throws DALException {
		Connection cnx=JdbcTools.connect();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Utilisateur utilisateur=null;
		try {
			ps=cnx.prepareStatement(sqlUserSelectbyId);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			cnx.close();
			
		utilisateur=new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"),  rs.getString("rue"),  rs.getString("code_postal"),  rs.getString("ville"), rs.getString("mot_de_passe"), rs.getInt("credit"), rs.getBoolean("administrateur"));
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
		}
		return utilisateur;
	}
	
	@Override
	public Utilisateur selectByPseudo(String pseudo_utilisateur) throws DALException {
	Connection cnx=JdbcTools.connect();
	PreparedStatement ps=null;
	ResultSet rs=null;
	Utilisateur utilisateur=null;
	try {
		ps=cnx.prepareStatement(sqlUserSelectbyPseudo);
		ps.setString(1, pseudo_utilisateur);
		rs=ps.executeQuery();
		cnx.close();
		
	utilisateur=new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"),  rs.getString("rue"),  rs.getString("code_postal"),  rs.getString("ville"), rs.getString("mot_de_passe"), rs.getInt("credit"), rs.getBoolean("administrateur"));
	} catch (SQLException e) {
		throw new DALException("Request failed for user "+pseudo_utilisateur, e);
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
	}
	return utilisateur;
}
	
	@Override
	public void update(Utilisateur usr) throws DALException {
		Connection cnx=JdbcTools.connect();
		PreparedStatement ps=null;
		try {
			ps=cnx.prepareStatement(sqlUserUpdate);
		
			ps.setString(1, usr.getPseudo());
			ps.setString(2, usr.getNom());
			ps.setString(3, usr.getPrenom());
			ps.setString(4, usr.getEmail());
			ps.setString(5, usr.getTelephone());
			ps.setString(6, usr.getRue());
			ps.setString(7, usr.getCodePostal());
			ps.setString(8, usr.getVille());
			ps.setString(9, usr.getMotDePasse());
			ps.setInt(10, usr.getCredit());
			ps.setBoolean(11, usr.getAdministrateur());

			ps.executeUpdate();
			cnx.close();
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
		}
	}

	@Override
	public void insert(Utilisateur usr) throws DALException {
		Connection cnx=JdbcTools.connect();
		PreparedStatement ps=null;
		ResultSet keys=null;
		try {
			ps=cnx.prepareStatement(sqlUserInsert, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, usr.getPseudo());
			ps.setString(2, usr.getNom());
			ps.setString(3, usr.getPrenom());
			ps.setString(4, usr.getEmail());
			ps.setString(5, usr.getTelephone());
			ps.setString(6, usr.getRue());
			ps.setString(7, usr.getCodePostal());
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
	public void delete(int id) throws DALException, SQLException {
		Connection cnx=JdbcTools.connect();
		PreparedStatement ps = null;
		try {
			ps=cnx.prepareStatement(sqlUserDelete);
			ps.setString(1,"no_utilisateur");
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
			cnx.close();
		}
	}

	@Override
	public void delete(Utilisateur id) throws DALException {
	// TODO Auto-generated method stub
	
	}

	@Override
	public boolean checkForUniquePseudo(String pseudo) {
	// TODO Auto-generated method stub
	return false;
	}

	@Override
	public boolean checkForUniqueEmail(String email) {
	// TODO Auto-generated method stub
	return false;
	}
}
