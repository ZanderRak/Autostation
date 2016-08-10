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

import ua.khpi.shapoval.autostation.model.RequestStatus;
import ua.khpi.shapoval.db.DbConnector;

/**
 * @author serg_shapoval
 *
 */
public class MySqlRequestStatusDao implements RequestStatusDao {

	private static final String INSERT_QUERY = "INSERT INTO requestStatus(message) VALUE(?);";
	private static final String UPDATE_QUERY = "UPDATE requestStatus SET message=? WHERE idStatus=?;";
	private static final String DELETE_QUERY = "DELETE FROM requestStatus WHERE idStatus=?;";
	private static final String SELECT_QUERY = "SELECT*FROM requestStatus;";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ua.khpi.shapoval.autostation.dao.RequestStatusDao#insert(ua.khpi.shapoval
	 * .autostation.model.RequestStatus)
	 */
	@Override
	public RequestStatus insert(RequestStatus object) {

		if (object != null) {
			PreparedStatement stmt = null;
			Connection connection = null;
			try {
				connection = DbConnector.getConnection();
				stmt = connection.prepareStatement(INSERT_QUERY);

				fillRequestStatusObject(stmt, object, false);
				stmt.executeUpdate();

				return object;

			} catch (SQLException e) {
				System.err.println(e.getMessage());

				return null;
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
			return null;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ua.khpi.shapoval.autostation.dao.RequestStatusDao#update(int,
	 * ua.khpi.shapoval.autostation.model.RequestStatus)
	 */
	@Override
	public int update(RequestStatus request) {
		if (request != null) {
			PreparedStatement stmt = null;
			Connection connection = null;
			try {
				connection = DbConnector.getConnection();
				stmt = connection.prepareStatement(UPDATE_QUERY);
				fillRequestStatusObject(stmt, request, true);
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
	 * @see ua.khpi.shapoval.autostation.dao.RequestStatusDao#delete(int)
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
	 * @see ua.khpi.shapoval.autostation.dao.RequestStatusDao#select()
	 */
	@Override
	public List<RequestStatus> select() {
		Connection connection = null;
		PreparedStatement stmt = null;
		List<RequestStatus> allRequestStatus = new ArrayList<>();
		ResultSet rs = null;
		try {
			connection = DbConnector.getConnection();
			stmt = connection.prepareStatement(SELECT_QUERY);
			rs = stmt.executeQuery();
			while (rs.next()) {
				RequestStatus requestStatus = new RequestStatus();
				requestStatus.setIdStatus(rs.getInt(1));
				requestStatus.setMessage(rs.getString(2));
				allRequestStatus.add(requestStatus);
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
		return allRequestStatus;

	}

	private void fillRequestStatusObject(PreparedStatement preparedStatement, RequestStatus requestStatus,
			boolean isUpdate) {
		try {
			int index = 1;
			preparedStatement.setString(index, requestStatus.getMessage());
			if (isUpdate) {
				preparedStatement.setInt(index++, requestStatus.getIdStatus());
			}
		} catch (SQLException e) {

		}

	}

}
