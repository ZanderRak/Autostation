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

import ua.khpi.shapoval.autostation.model.Roles;
import ua.khpi.shapoval.autostation.model.RolesType;
import ua.khpi.shapoval.db.DbConnector;

/**
 * @author serg_shapoval
 *
 */
public class MySqlRolesDao implements RolesDao {

	private static final String INSERT_QUERY = "INSERT INTO `roles`(roleType, userId) VALUE(?,?);";
	private static final String UPDATE_QUERY = "UPDATE roles SET roleType=?, userID=? WHERE idRole=?";
	private static final String SELECT_QUERY = "SELECT*FROM roles;";

	/*
	 * (non-Javadoc)
	 * 
	 * @see ua.khpi.shapoval.autostation.dao.RolesDao#insert(ua.khpi.shapoval.
	 * autostation.model.Roles)
	 */
	@Override
	public Roles insert(Roles object) {
		if (object != null) {
			PreparedStatement stmt = null;
			Connection connection = null;
			try {
				connection = DbConnector.getConnection();
				stmt = connection.prepareStatement(INSERT_QUERY);
				fillRolesObject(stmt, object, false);
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
	 * @see ua.khpi.shapoval.autostation.dao.RolesDao#update(int,
	 * ua.khpi.shapoval.autostation.model.Roles)
	 */
	@Override
	public int update(Roles role) {
		if (role != null) {
			PreparedStatement stmt = null;
			Connection connection = null;
			try {
				connection = DbConnector.getConnection();
				stmt = connection.prepareStatement(UPDATE_QUERY);
				fillRolesObject(stmt, role, true);
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
	 * @see ua.khpi.shapoval.autostation.dao.RolesDao#delete(int)
	 */
	@Override
	public int delete(int idObject) {

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ua.khpi.shapoval.autostation.dao.RolesDao#select()
	 */
	@Override
	public List<Roles> select() {
		Connection connection = null;
		PreparedStatement stmt = null;
		List<Roles> allRoles = new ArrayList<>();
		ResultSet rs = null;
		try {
			connection = DbConnector.getConnection();
			stmt = connection.prepareStatement(SELECT_QUERY);
			rs = stmt.executeQuery();
			while (rs.next()) {
				allRoles.add(buildRole(rs));
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			DbConnector.close(connection, stmt);
		}
		return allRoles;

	}

	private void fillRolesObject(PreparedStatement preparedStatement, Roles role, boolean isUpdate) {

	
		try {
			preparedStatement.setString(1, role.getRoleType().toString().toUpperCase());
			preparedStatement.setInt(2, role.getUserId());
			if (isUpdate) {
				preparedStatement.setInt(3, role.getIdRole());
			}
		} catch (SQLException e) {

		}
	}

	private Roles buildRole(ResultSet rs) {
		try {
			Roles role = new Roles();
			role.setIdRole(rs.getInt(1));
			role.setRoleType(RolesType.valueOf(rs.getString(2)));
			role.setUserId(rs.getInt(3));
			return role;
		} catch (SQLException e) {

		}
		return null;
	}

}
