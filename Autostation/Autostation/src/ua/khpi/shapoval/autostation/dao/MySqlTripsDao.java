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

import ua.khpi.shapoval.autostation.model.Trips;
import ua.khpi.shapoval.autostation.model.TripsStatus;
import ua.khpi.shapoval.db.DbConnector;

/**
 * @author serg_shapoval
 *
 */
public class MySqlTripsDao implements TripsDao {
	private static final String INSERT_QUERY = "INSERT INTO trips(startDate, fromPlace, toPlace, statusTrip, idCreator) VALUE(?,?,?,?,?);";
	private static final String UPDATE_QUERY = "UPDATE trips SET startDate=?, fromPlace=?, toPlace=?, statusTrip=?, idCreator=? WHERE idTrip=?";
	private static final String DELETE_QUERY = "DELETE FROM trips WHERE idTrip = ?;";
	private static final String SELECT_QUERY = "SELECT*FROM trips;";
	private static final String SORT_BY_ID_ASC_ORDER = "SELECT * FROM trips ORDER BY idTrip ASC";
	private static final String SORT_BY_ID_DESC_ORDER = "SELECT * FROM trips ORDER BY idTrip DESC";
	private static final String SORT_BY_DATE_ASC_ORDER = "SELECT * FROM autopark.trips ORDER BY startDate ASC";
	private static final String SORT_BY_DATE_DESC_ORDER = "SELECT * FROM autopark.trips ORDER BY startDate DESC";
	private static final String SELECT_OPEN_TRIPS = "SELECT * FROM autopark.trips WHERE status LIKE 'OPEN'";

	/*
	 * (non-Javadoc)
	 * 
	 * @see ua.khpi.shapoval.autostation.dao.TripsDao#insert(ua.khpi.shapoval.
	 * autostation.model.Trips)
	 */
	@Override
	public Trips insert(Trips object) {
		if (object != null) {
			PreparedStatement stmt = null;
			Connection connection = null;
			try {
				connection = DbConnector.getConnection();
				stmt = connection.prepareStatement(INSERT_QUERY);
				fillTripObject(stmt, object, false);
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
	 * @see ua.khpi.shapoval.autostation.dao.TripsDao#update(int,
	 * ua.khpi.shapoval.autostation.model.Trips)
	 */
	@Override
	public int update(Trips trip) {
		if (trip != null) {
			PreparedStatement stmt = null;
			Connection connection = null;
			try {
				connection = DbConnector.getConnection();
				stmt = connection.prepareStatement(UPDATE_QUERY);
				fillTripObject(stmt, trip, true);
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
	 * @see ua.khpi.shapoval.autostation.dao.TripsDao#delete(int)
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
		}
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ua.khpi.shapoval.autostation.dao.TripsDao#select()
	 */
	@Override
	public List<Trips> select() {
		Connection connection = null;
		PreparedStatement stmt = null;
		List<Trips> allTrips = new ArrayList<>();
		ResultSet rs = null;
		try {
			connection = DbConnector.getConnection();
			stmt = connection.prepareStatement(SELECT_QUERY);
			rs = stmt.executeQuery();
			while (rs.next()) {
				allTrips.add(buildTripObject(rs));
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
		return allTrips;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ua.khpi.shapoval.autostation.dao.TripsDao#sortByTripIdDirectOrder()
	 */
	@Override
	public List<Trips> sortByTripIdDirectOrder() {
		Connection connection = null;
		PreparedStatement stmt = null;
		List<Trips> allTrips = new ArrayList<>();
		ResultSet rs = null;
		try {
			connection = DbConnector.getConnection();
			stmt = connection.prepareStatement(SORT_BY_ID_ASC_ORDER);
			rs = stmt.executeQuery();
			while (rs.next()) {
				allTrips.add(buildTripObject(rs));
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
		return allTrips;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ua.khpi.shapoval.autostation.dao.TripsDao#sortByTripIdReverseOrder()
	 */
	@Override
	public List<Trips> sortByTripIdReverseOrder() {

		Connection connection = null;
		PreparedStatement stmt = null;
		List<Trips> allTrips = new ArrayList<>();
		ResultSet rs = null;
		try {
			connection = DbConnector.getConnection();
			stmt = connection.prepareStatement(SORT_BY_ID_DESC_ORDER);
			rs = stmt.executeQuery();
			while (rs.next()) {
				allTrips.add(buildTripObject(rs));
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
		return allTrips;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ua.khpi.shapoval.autostation.dao.TripsDao#
	 * sortByTripCreationDateDirectOrder()
	 */
	@Override
	public List<Trips> sortByTripCreationDateDirectOrder() {

		Connection connection = null;
		PreparedStatement stmt = null;
		List<Trips> allTrips = new ArrayList<>();
		ResultSet rs = null;
		try {
			connection = DbConnector.getConnection();
			stmt = connection.prepareStatement(SORT_BY_DATE_ASC_ORDER);
			rs = stmt.executeQuery();
			while (rs.next()) {
				allTrips.add(buildTripObject(rs));
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
		return allTrips;

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see ua.khpi.shapoval.autostation.dao.TripsDao#sortByTripCreationDateReverseOrder()
	 */
	@Override
	public List<Trips> sortByTripCreationDateReverseOrder() {

		Connection connection = null;
		PreparedStatement stmt = null;
		List<Trips> allTrips = new ArrayList<>();
		ResultSet rs = null;
		try {
			connection = DbConnector.getConnection();
			stmt = connection.prepareStatement(SORT_BY_DATE_DESC_ORDER);
			rs = stmt.executeQuery();
			while (rs.next()) {
				allTrips.add(buildTripObject(rs));
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
		return allTrips;

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see ua.khpi.shapoval.autostation.dao.TripsDao#getOpenTrips()
	 */
	@Override
	public List<Trips> getOpenTrips() {
		Connection connection = null;
		PreparedStatement stmt = null;
		List<Trips> allOpenTrips = new ArrayList<>();
		ResultSet rs = null;
		try {
			connection = DbConnector.getConnection();
			stmt = connection.prepareStatement(SELECT_OPEN_TRIPS);
			rs = stmt.executeQuery();
			while (rs.next()) {
				allOpenTrips.add(buildTripObject(rs));
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
		return allOpenTrips;

	}

	private void fillTripObject(PreparedStatement preparedStatement, Trips trip, boolean isUpdate) {

		int index = 1;
		try {
			preparedStatement.setDate(1, trip.getStartDate());
			preparedStatement.setString(2, trip.getFromPlace());
			preparedStatement.setString(3, trip.getToPlace());
			preparedStatement.setString(4, trip.getStatusTrip().toString().toUpperCase());
			preparedStatement.setInt(5, trip.getIdCreator());
			if (trip.getIdTrip() != 0) {
				preparedStatement.setInt(6, trip.getIdTrip());

			}

		} catch (SQLException e) {

		}
	}

	private Trips buildTripObject(ResultSet rs) {
		try {
			Trips trip = new Trips();
			trip.setIdTrip(rs.getInt(1));
			trip.setStartDate(rs.getDate(2));
			trip.setFromPlace(rs.getString(3));
			trip.setToPlace(rs.getString(4));
			trip.setStatusTrip(TripsStatus.valueOf(rs.getString(5)));
			trip.setIdCreator(rs.getInt(6));
			return trip;
		} catch (SQLException e) {

		}

		return null;
	}

}
