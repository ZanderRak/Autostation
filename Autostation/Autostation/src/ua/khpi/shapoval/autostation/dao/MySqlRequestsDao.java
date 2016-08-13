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

import ua.khpi.shapoval.autostation.model.Requests;
import ua.khpi.shapoval.db.DbConnector;

/**
 * @author serg_shapoval
 *
 */
public class MySqlRequestsDao implements RequestsDao {

	private static final String INSERT_QUERY = "INSERT INTO request(idUserReq, idCarReq, idTripReq, idStatusReq) VALUE(?,?,?,?);";
	private static final String UPDATE_QUERY = "UPDATE request SET idUserReq=?, idCarReq=?, idTripReq=?, idStatusReq=? WHERE idRequest=?;";
	private static final String DELETE_QUERY = "DELETE FROM request WHERE idRequest=?";
	private static final String SELECT_QUERY = "SELECT*FROM request;";
	private static final String GET_REQUESTS_BY_TRIP_ID = "SELECT requests.idRequest, requests.idUserReq, requests.idCarReq, requests.idTripReq, requests.idStatusReq FROM requests, trips WHERE idTrip=?;";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ua.khpi.shapoval.autostation.dao.RequestsDao#insert(ua.khpi.shapoval.
	 * autostation.model.Requests)
	 */
	@Override
	public Requests insert(Requests object) {
		if (object != null) {
			PreparedStatement stmt = null;
			Connection connection = null;
			try {
				connection = DbConnector.getConnection();
				stmt = connection.prepareStatement(INSERT_QUERY);
				fillRequestsObject(stmt, object, false);
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
	 * @see ua.khpi.shapoval.autostation.dao.RequestsDao#update(int,
	 * ua.khpi.shapoval.autostation.model.Requests)
	 */
	@Override
	public int update(Requests request) {
		if (request != null) {
			PreparedStatement stmt = null;
			Connection connection = null;
			try {
				connection = DbConnector.getConnection();
				stmt = connection.prepareStatement(UPDATE_QUERY);
				fillRequestsObject(stmt, request, true);
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
	 * @see ua.khpi.shapoval.autostation.dao.RequestsDao#delete(int)
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
	 * @see ua.khpi.shapoval.autostation.dao.RequestsDao#select()
	 */
	@Override
	public List<Requests> select() {
		Connection connection = null;
		PreparedStatement stmt = null;
		List<Requests> allRequests = new ArrayList<>();
		ResultSet rs = null;
		try {
			connection = DbConnector.getConnection();
			stmt = connection.prepareStatement(SELECT_QUERY);
			rs = stmt.executeQuery();
			while (rs.next()) {
				allRequests.add(buildRequest(rs));
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			DbConnector.close(connection, stmt, rs);
		}
		return allRequests;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ua.khpi.shapoval.autostation.dao.RequestsDao#selectRequestsByTripId(int)
	 */
	@Override
	public List<Requests> selectRequestsByTripId(int idTrip) {
		Connection connection = null;
		PreparedStatement stmt = null;
		List<Requests> allRequests = new ArrayList<>();
		ResultSet rs = null;
		try {
			connection = DbConnector.getConnection();
			stmt = connection.prepareStatement(GET_REQUESTS_BY_TRIP_ID);
			stmt.setInt(1, idTrip);
			rs = stmt.executeQuery();
			while (rs.next()) {
				allRequests.add(buildRequest(rs));
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			DbConnector.close(connection, stmt, rs);
		}
		return allRequests;

	}

	private void fillRequestsObject(PreparedStatement preparedStatement, Requests request, boolean isUpdate) {
		int index = 1;
		try {
			preparedStatement.setInt(index, request.getIdUserReq());
			preparedStatement.setInt(index++, request.getIdCarReq());
			preparedStatement.setInt(index++, request.getIdTripReq());
			preparedStatement.setInt(index++, request.getIdStatusReq());
			if (isUpdate) {
				preparedStatement.setInt(index++, request.getIdRequest());
			}
		} catch (SQLException e) {

		}
	}

	private Requests buildRequest(ResultSet rs) {
		try {
			Requests request = new Requests();
			request.setIdRequest(rs.getInt(1));
			request.setIdUserReq(rs.getInt(2));
			request.setIdCarReq(rs.getInt(3));
			request.setIdTripReq(rs.getInt(4));
			request.setIdStatusReq(rs.getInt(5));
			return request;
		} catch (SQLException e) {

		}
		return null;
	}

}
