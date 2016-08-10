/**
 * 
 */
package ua.khpi.shapoval.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.sql.DataSource;

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

}
