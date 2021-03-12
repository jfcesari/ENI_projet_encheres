package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.ConnectionProvider;
import fr.eni.enchere.dal.DALErrors;
//import fr.eni.enchere.dal.jdbc.UtilisateurDAO;
import fr.eni.enchere.dal.UtilisateurDAO;

public class UtilisateursDAOJdbcImpl implements UtilisateurDAO {

private static final String sqlUserSelectbyId = "SELECT * FROM utilisateurs WHERE no_utilisateur=?";
private static final String SqlSelectLogin = "SELECT * FROM utilisateurs WHERE (email = ? or pseudo = ?) AND mot_de_passe = ?";
private static final String sqlUserSelectbyPseudo = "SELECT * FROM utilisateurs WHERE pseudo=?";
private static final String sqlUserUpdate = "UPDATE utilisateurs SET pseudo=?, nom=?, prenom=?, email=?, telephone=?, rue=?, code_postal=?, ville=?, mot_de_passe=?, credit=?, administrateur=?";
private static final String sqlUserInsert = "INSERT into utilisateurs (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
private static final String sqlUserDelete = "no_utilisateur=?";
private static final String sqlUniquePseudo = "SELECT * FROM utilisateurs WHERE pseudo LIKE ?";
private static final String sqlUniqueEmail = "SELECT * FROM utilisateurs WHERE email LIKE ?;";
private static final String SqlSelectEmail = "SELECT email FROM utilisateurs";
private static final String SqlSelectPseudo = "SELECT pseudo FROM utilisateurs";
	
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
		cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
            DALException dalException = new DALException();
            dalException.addError(DALErrors.error_insert);
            throw dalException;
			}
		return utilisateur;
	}
	
	@Override
	public Utilisateur selectLogin(String emailouPseudo, String motDePasse) throws DALException {
		Connection cnx=JdbcTools.connect();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Utilisateur utilisateur=null;
		try {
			ps=cnx.prepareStatement(SqlSelectLogin);
			ps.setString(1, emailouPseudo);
			ps.setString(2, emailouPseudo);
			ps.setString(3, motDePasse);
			rs=ps.executeQuery();
			cnx.close();
			
		utilisateur=new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"),  rs.getString("rue"),  rs.getString("code_postal"),  rs.getString("ville"), rs.getString("mot_de_passe"), rs.getInt("credit"), rs.getBoolean("administrateur"));
		cnx.close();
        } catch (SQLException e) {
            e.printStackTrace();
            DALException dalException = new DALException();
            dalException.addError(DALErrors.error_update);
            throw dalException;
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
	cnx.close();
	} catch (SQLException e) {
			e.printStackTrace();
            DALException dalException = new DALException();
            dalException.addError(DALErrors.error_select);
            throw dalException;
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
        } catch (SQLException e) {
            e.printStackTrace();
            DALException dalException = new DALException();
            dalException.addError(DALErrors.error_update);
            throw dalException;
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
				}
			cnx.close();
				}
				catch (SQLException e) {
				e.printStackTrace();
		        DALException dalException = new DALException();
		        dalException.addError(DALErrors.error_insert);
		        throw dalException;
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
            cnx.close();
        } catch (SQLException e) {
            e.printStackTrace();
            DALException dalException = new DALException();
            dalException.addError(DALErrors.error_delete);
            throw dalException;
        }
	}

	@Override
	public void delete(Utilisateur utilisateur) throws DALException {
	    Connection cnx = JdbcTools.connect();
        try {
            PreparedStatement ps = cnx.prepareStatement(sqlUserDelete);
            ps.setInt(1, utilisateur.getNoUtilisateur());
            ps.setString(2,  utilisateur.getPseudo());
            ps.executeUpdate();
            cnx.close();
        } catch (SQLException e) {
            e.printStackTrace();
            DALException dalException = new DALException();
            dalException.addError(DALErrors.error_delete);
            throw dalException;
        }
	}

	@Override
	public boolean checkForUniquePseudo(String pseudo) throws DALException {
		Connection cnx = JdbcTools.connect();
        boolean isUnique = true;
        try {
            PreparedStatement stmt = cnx.prepareStatement(sqlUniquePseudo);
            stmt.setString(1, pseudo);
            stmt.setString(2, pseudo);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
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

	@Override
	public boolean checkForUniqueEmail(String email) throws DALException {
		Connection cnx = JdbcTools.connect();
        boolean isUnique = true;
        try {
            PreparedStatement stmt = cnx.prepareStatement(sqlUniqueEmail);
            stmt.setString(1, email);
            stmt.setString(2, email);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
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

	private Utilisateur utilisateurBuilder(ResultSet rs) {

		Utilisateur utilisateur = new Utilisateur();

		try {

			utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
			utilisateur.setPseudo(rs.getString("pseudo"));
			utilisateur.setNom(rs.getString("nom"));
			utilisateur.setPrenom(rs.getString("prenom"));
			utilisateur.setEmail(rs.getString("email"));
			utilisateur.setTelephone(rs.getString("telephone"));
			utilisateur.setRue(rs.getString("rue"));
			utilisateur.setCodePostal(rs.getString("code_postal"));
			utilisateur.setVille(rs.getString("ville"));
			utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
			utilisateur.setCredit(rs.getInt("credit"));
			utilisateur.setAdministrateur(rs.getBoolean("administrateur"));

		} catch (Exception e) {

			e.printStackTrace();

		}

		return utilisateur;

	}
	
	public ArrayList<String> selectAllEmail() {

		ResultSet rs = null;
		Statement stmt = null;
		Connection cnx = null;

		ArrayList<String> listMail = new ArrayList<String>();

		try {

			cnx = ConnectionProvider.getConnection();
			stmt = cnx.createStatement();

			rs = stmt.executeQuery(SqlSelectEmail);

			while (rs.next()) {

				listMail.add(rs.getString("email"));

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (cnx != null) {
					cnx.close();
				}

			} catch (Exception e2) {

				e2.printStackTrace();

			}

		}

		return listMail;

	}
	public ArrayList<String> selectAllPseudo() {

		ResultSet rs = null;
		Statement stmt = null;
		Connection cnx = null;

		ArrayList<String> listPseudo = new ArrayList<String>();

		try {

			cnx = ConnectionProvider.getConnection();
			stmt = cnx.createStatement();

			rs = stmt.executeQuery(SqlSelectPseudo);

			while (rs.next()) {

				listPseudo.add(rs.getString("pseudo"));

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (cnx != null) {
					cnx.close();
				}

			} catch (Exception e2) {

				e2.printStackTrace();

			}

		}

		return listPseudo;

	}
	
	@Override
	public void insertUser(Utilisateur utilisateurs) {

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection cnx = null;

		try {

			cnx = ConnectionProvider.getConnection();
			pstmt = cnx.prepareStatement(sqlUserInsert, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, utilisateurs.getPseudo());
			pstmt.setString(2, utilisateurs.getNom());
			pstmt.setString(3, utilisateurs.getPrenom());
			pstmt.setString(4, utilisateurs.getEmail());
			pstmt.setString(5, utilisateurs.getTelephone());
			pstmt.setString(6, utilisateurs.getRue());
			pstmt.setString(7, utilisateurs.getCodePostal());
			pstmt.setString(8, utilisateurs.getVille());
			pstmt.setString(9, utilisateurs.getMotDePasse());
			pstmt.setInt(10, 0);
			pstmt.setBoolean(11, false);

			pstmt.executeUpdate();

			rs = pstmt.getGeneratedKeys();

			if (rs.next()) {
				utilisateurs.setNoUtilisateur(rs.getInt(1));
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			try {

				if (rs != null) {
					rs.close();
				}

				if (pstmt != null) {
					pstmt.close();
				}

				if (cnx != null) {
					cnx.close();
				}

			} catch (SQLException e) {

				e.printStackTrace();

			}
		}
	}
}
