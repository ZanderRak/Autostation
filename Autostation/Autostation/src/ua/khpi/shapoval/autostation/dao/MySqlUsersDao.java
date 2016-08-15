/**
 * 
 */
package ua.khpi.shapoval.autostation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.khpi.shapoval.autostation.model.Users;
import ua.khpi.shapoval.db.DbConnector;

/**
 * @author serg_shapoval
 *
 */
public class MySqlUsersDao implements UsersDao {

	private static final String INSERT_QUERY = "INSERT INTO `users`(login, password, passwordSalt, name, surname)"
			+ " value (?,?,?,?,?);";
	private static final String UPDATE_QUERY = "UPDATE `users` SET login = ?, password = ?, name = ?, surname = ? WHERE idUser=?";

	private static final String DELETE_QUERY = "DELETE FROM users WHERE idUser=?";

	private static final String SELECT_QUERY = "SELECT*FROM users;";

	private static final String SELECT_USER_ID_BY_LOGIN = "SELECT users.idUser FROM users where users.login = ?";

	private static final String GET_USER_ROLE_BY_LOGIN = "SELECT roles.roleType FROM roles WHERE roles.userId=(SELECT users.idUser FROM users WHERE users.login=?)";

	private static final String SELECT_USER_BY_LOGIN = "SELECT*FROM users WHERE users.login=?";

	/*
	 * (non-Javadoc)
	 * 
	 * @see ua.khpi.shapoval.autostation.dao.UsersDao#insert(ua.khpi.shapoval.
	 * autostation.model.Users)
	 */
	@Override
	public Users insert(Users object) {
		if (object != null) {
			PreparedStatement stmt = null;
			Connection connection = null;
			try {
				connection = DbConnector.getConnection();
				stmt = connection.prepareStatement(INSERT_QUERY);
				fillUserObject(stmt, object, false);
				stmt.executeUpdate();

				return object;

			} catch (SQLException e) {
				System.err.println(e.getMessage());

				return null;
			} finally {
				DbConnector.close(connection, stmt);
			}
		} else {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ua.khpi.shapoval.autostation.dao.UsersDao#update(int)
	 */
	@Override
	public int update(Users user) {
		if (user != null) {
			PreparedStatement stmt = null;
			Connection connection = null;
			try {
				connection = DbConnector.getConnection();
				stmt = connection.prepareStatement(UPDATE_QUERY);
				fillUserObject(stmt, user, true);
				return stmt.executeUpdate();

			} catch (SQLException e) {
				System.err.println(e.getMessage());
				return 0;
			} finally {
				DbConnector.close(connection, stmt);
			}
		} else {
			return 0;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ua.khpi.shapoval.autostation.dao.UsersDao#delete(int)
	 */
	@Override
	public int delete(int idObject) {
		if (idObject != 0) {
			PreparedStatement stmt = null;
			Connection connection = null;
			try {
				connection = DbConnector.getConnection();
				stmt = connection.prepareStatement(DELETE_QUERY);
				stmt.setInt(1, idObject);
				return stmt.executeUpdate();
			} catch (SQLException e) {
				System.err.println(e.getMessage());
				return 0;
			} finally {
				DbConnector.close(connection, stmt);
			}
		} else {
			return 0;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ua.khpi.shapoval.autostation.dao.UsersDao#select()
	 */
	@Override
	public List<Users> select() {
		Connection connection = null;
		PreparedStatement stmt = null;
		List<Users> allUsers = new ArrayList<>();
		ResultSet rs = null;
		try {
			connection = DbConnector.getConnection();
			stmt = connection.prepareStatement(SELECT_QUERY);
			rs = stmt.executeQuery();
			while (rs.next()) {
				allUsers.add(buildUserObject(rs));
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			DbConnector.close(connection, stmt);
		}
		return allUsers;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ua.khpi.shapoval.autostation.dao.UsersDao#getUserIdByLogin(java.lang.
	 * String)
	 */
	@Override
	public int getUserIdByLogin(String login) {
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			connection = DbConnector.getConnection();
			stmt = connection.prepareStatement(SELECT_USER_ID_BY_LOGIN);
			stmt.setString(1, login);
			rs = stmt.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return 0;
		} finally {
			DbConnector.close(connection, stmt, rs);
		}
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ua.khpi.shapoval.autostation.dao.UsersDao#getUserRole(int)
	 */
	@Override
	public String getUserRole(String login) {
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			connection = DbConnector.getConnection();
			stmt = connection.prepareStatement(GET_USER_ROLE_BY_LOGIN);
			stmt.setString(1, login);
			rs = stmt.executeQuery();
			while (rs.next()) {
				return rs.getString(1);
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return "null";
		} finally {
			DbConnector.close(connection, stmt, rs);
		}
		return "null";

	}

	@Override
	public Users getUserByLogin(String login) {
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			connection = DbConnector.getConnection();
			stmt = connection.prepareStatement(SELECT_USER_BY_LOGIN);
			stmt.setString(1, login);
			rs = stmt.executeQuery();
			while (rs.next()) {
				return buildUserObject(rs);
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			DbConnector.close(connection, stmt);
		}
		return null;
	}

	private void fillUserObject(PreparedStatement preparedStatement, Users user, boolean isUpdate) {

		try {
			preparedStatement.setString(1, user.getLogin());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, "salt");
			preparedStatement.setString(4, user.getName());
			preparedStatement.setString(5, user.getSurname());
			if (isUpdate) {
				preparedStatement.setInt(6, user.getIdUser());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private Users buildUserObject(ResultSet rs) {
		Users user = new Users();
		try {
			System.out.println("build object");
			
			user.setIdUser(rs.getInt(1));
			user.setLogin(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setPasswordSalt(rs.getString(4));
			user.setName(rs.getString(5));
			user.setSurname(rs.getString(6));
			System.out.println("object built");
			return user;
		} catch (SQLException e) {
			return null;
		}

	}

}
