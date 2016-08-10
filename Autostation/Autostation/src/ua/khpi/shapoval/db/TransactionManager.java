/**
 * 
 */
package ua.khpi.shapoval.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * @author serg_shapoval
 *
 */
public class TransactionManager {
	private DataSource dataSource;

	public TransactionManager(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public <T> T execute(Transaction<T> transaction) {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			T value = transaction.execute();
			connection.commit();
			return value;
		} catch (SQLException exception) {
			rollBack(connection);
		} finally {
			close(connection);
		}
		return null;
	}

	private void rollBack(Connection connection) {
		if (connection != null) {
			try {
				connection.rollback();
			} catch (SQLException ex) {

			}
		}
	}

	private void close(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException ex) {

			}
		}
	}

}
