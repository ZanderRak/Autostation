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

	private static final String INSERT_QUERY = "INSERT INTO `users`(login, password, name, surname)"
			+ " values (?,?,?,?,?);";
	private static final String UPDATE_QUERY = "UPDATE `users` SET login = ?, password = ?, name = ?, surname = ? WHERE idUser=?";

	private static final String DELETE_QUERY = "DELETE FROM users WHERE idUser=?";

	private static final String SELECT_QUERY = "SELECT users.idUser, users.login, users.name, users.surname FROM users;";

	private static final String SELECT_USER_ID_BY_LOGIN = "SELECT users.idUser FROM users where users.login = ?";

	private static final String GET_USER_ROLE_BY_LOGIN = "SELECT roles.roleType FROM roles WHERE roles.userId=(SELECT users.idUser FROM users WHERE users.login=?)";

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
			try (Connection connection = DbConnector.getConnection()) {
				stmt = connection.prepareStatement(INSERT_QUERY);
				fillUserObject(stmt, object, false);
				stmt.executeUpdate();
				stmt.close();
				return object;

			} catch (SQLException e) {
				System.err.println(e.getMessage());

				return null;
			} finally {
				try {
					if (stmt != null) {
						stmt.close();
					}
				} catch (SQLException  e1) {
					e1.printStackTrace();
				}
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
				try {
					if (stmt != null) {
						stmt.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
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
				try {
					if (stmt != null) {
						stmt.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
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
				Users user = new Users();
				user.setIdUser(rs.getInt(1));
				user.setLogin(rs.getString(2));
				user.setName(rs.getString(3));
				user.setSurname(rs.getString(4));
				allUsers.add(user);
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

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

			try {
				if (stmt != null) {
					stmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

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

			try {
				if (stmt != null) {
					stmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return "null";

	}

	private void fillUserObject(PreparedStatement preparedStatement, Users user, boolean isUpdate) {
		int index = 1;
		try {

			preparedStatement.setString(index, user.getLogin());
			preparedStatement.setString(index++, user.getPassword());
			preparedStatement.setString(index++, user.getName());
			preparedStatement.setString(index++, user.getSurname());
			if (isUpdate) {
				preparedStatement.setInt(index++, user.getIdUser());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

}
