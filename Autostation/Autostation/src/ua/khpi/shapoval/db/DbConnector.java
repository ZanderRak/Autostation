/**
 * 
 */
package ua.khpi.shapoval.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;

import com.mysql.jdbc.PreparedStatement;

/**
 * @author serg_shapoval
 *
 */
public class DbConnector {
	private static Logger log = Logger.getLogger(DbConnector.class.getName());
	private static DataSource dataSource;

	public static DataSource init() throws ServletException, SQLException, NamingException, ClassNotFoundException {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env/");
		dataSource = (DataSource) envCtx.lookup("jdbc/autopark");
		return dataSource;
	}

	public static Connection getConnection() throws SQLException {

		return dataSource.getConnection();
	}

	private static void close(java.sql.PreparedStatement preparedStatement) {

		try {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		} catch (SQLException e) {

		}
	}

	private static void close(Connection connection) {

		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	private static void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {

		}
	}

	public static void close(Connection connection, java.sql.PreparedStatement stmt, ResultSet rs) {
		close(connection);
		close(stmt);
		close(rs);
	}

	public static void close(Connection connection, java.sql.PreparedStatement stmt) {
		close(connection);
		close(stmt);

	}

}
