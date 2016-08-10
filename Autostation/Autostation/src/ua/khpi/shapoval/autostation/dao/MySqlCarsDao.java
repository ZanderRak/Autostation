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

import ua.khpi.shapoval.autostation.model.Cars;
import ua.khpi.shapoval.autostation.model.CarsServiceability;
import ua.khpi.shapoval.autostation.model.CarsType;
import ua.khpi.shapoval.db.DbConnector;

/**
 * @author serg_shapoval
 *
 */
public class MySqlCarsDao implements CarsDao {

	private static final String INSERT_QUERY = "INSERT INTO cars(model, type, serviceability, idOwner) value(?,?,?,?);";
	private static final String UPDATE_QUERY = "UPDATE cars SET model=?, type=?, serviceability=?, idOwner=? WHERE idCar=?;";
	private static final String DELETE_QUERY = "DELETE FROM cars WHERE idCar=?";
	private static final String SELECT_QUERY = "SELECT*FROM cars";
	private static final String SELECT_CARS_BY_USER_LOGIN = "";
	private static final String UPDATE_SERVICEABILITY_BY_ID_CAR = "UPDAT cars SET serviceability=? WHERE idCar=?;";

	/*
	 * (non-Javadoc)
	 * 
	 * @see ua.khpi.shapoval.autostation.dao.CarsDao#insert(ua.khpi.shapoval.
	 * autostation.model.Cars)
	 */
	@Override
	public Cars insert(Cars object) {
		if (object != null) {
			PreparedStatement stmt = null;
			Connection connection = null;
			try {
				connection = DbConnector.getConnection();
				stmt = connection.prepareStatement(INSERT_QUERY);
				fillCarObject(stmt, object, false);
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
	 * @see ua.khpi.shapoval.autostation.dao.CarsDao#update(int,
	 * ua.khpi.shapoval.autostation.model.Cars)
	 */
	@Override
	public int update(Cars cars) {
		if (cars != null) {
			PreparedStatement stmt = null;
			Connection connection = null;
			try {
				connection = DbConnector.getConnection();
				stmt=connection.prepareStatement(UPDATE_QUERY);
				fillCarObject(stmt, cars, true);
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
	 * @see ua.khpi.shapoval.autostation.dao.CarsDao#delete(int)
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
	 * @see ua.khpi.shapoval.autostation.dao.CarsDao#select()
	 */
	@Override
	public List<Cars> select() {
		Connection connection = null;
		PreparedStatement stmt = null;
		List<Cars> allCars = new ArrayList<>();
		ResultSet rs = null;
		try {
			connection = DbConnector.getConnection();
			stmt = connection.prepareStatement(SELECT_QUERY);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Cars car = new Cars();
				car.setIdCar(rs.getInt(1));
				car.setModel(rs.getString(2));
				car.setType(CarsType.valueOf(rs.getString(3)));
				car.setServiceability(CarsServiceability.valueOf(rs.getString(4)));
				car.setDeleted(rs.getBoolean(5));
				car.setIdOwner(rs.getInt(5));
				allCars.add(car);
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
		return allCars;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ua.khpi.shapoval.autostation.dao.CarsDao#selectCarsForUser(java.lang.
	 * String)
	 */
	@Override
	public List<Cars> selectCarsForUser(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	

	private void fillCarObject(PreparedStatement preparedStatement, Cars car, boolean isUpdate) {

		int index = 1;
		try {

			preparedStatement.setString(index, car.getModel());
			preparedStatement.setString(index++, car.getType().toString().toUpperCase());
			preparedStatement.setString(index++, car.getServiceability().toString().toUpperCase());
			preparedStatement.setInt(index++, car.getIdOwner());
			if (isUpdate) {
				preparedStatement.setInt(index++, car.getIdCar());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
