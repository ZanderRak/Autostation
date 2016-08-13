/**
 * 
 */
package ua.khpi.shapoval.listner;

import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;

import ua.khpi.shapoval.autostation.command.CommandContainer;
import ua.khpi.shapoval.autostation.dao.CarsDao;
import ua.khpi.shapoval.autostation.dao.MySqlCarsDao;
import ua.khpi.shapoval.autostation.dao.MySqlRequestStatusDao;
import ua.khpi.shapoval.autostation.dao.MySqlRequestsDao;
import ua.khpi.shapoval.autostation.dao.MySqlRolesDao;
import ua.khpi.shapoval.autostation.dao.MySqlTripsDao;
import ua.khpi.shapoval.autostation.dao.MySqlUsersDao;
import ua.khpi.shapoval.autostation.dao.RequestStatusDao;
import ua.khpi.shapoval.autostation.dao.RequestsDao;
import ua.khpi.shapoval.autostation.dao.RolesDao;
import ua.khpi.shapoval.autostation.dao.TripsDao;
import ua.khpi.shapoval.autostation.dao.UsersDao;
import ua.khpi.shapoval.autostation.service.CarsService;
import ua.khpi.shapoval.autostation.service.MySqlCarsService;
import ua.khpi.shapoval.autostation.service.MySqlRequestStatusService;
import ua.khpi.shapoval.autostation.service.MySqlRequestsService;
import ua.khpi.shapoval.autostation.service.MySqlRolesService;
import ua.khpi.shapoval.autostation.service.MySqlTripsService;
import ua.khpi.shapoval.autostation.service.MySqlUsersService;
import ua.khpi.shapoval.autostation.service.RequestStatusService;
import ua.khpi.shapoval.autostation.service.RequestsService;
import ua.khpi.shapoval.autostation.service.RolesService;
import ua.khpi.shapoval.autostation.service.TripsService;
import ua.khpi.shapoval.autostation.service.UsersService;
import ua.khpi.shapoval.db.DbConnector;
import ua.khpi.shapoval.db.TransactionManager;

/**
 * @author serg_shapoval
 *
 */
public class ContextListner implements ServletContextListener {

	private static final String USER_DAO_ATTR = "usersDao";
	private static final String USER_SERVICE_ATTR = "usersService";
	private static final String CARS_DAO_ATTR = "carsDao";
	private static final String CARS_SERVICE_ATTR = "carsService";
	private static final String ROLES_DAO_ATTR = "rolesDao";
	private static final String ROLES_SERVICE_ATTR = "rolesService";
	private static final String TRIPS_DAO_ATTR = "tripsDao";
	private static final String TRIPS_SERVICE_ATTR = "tripsService";
	private static final String REQUEST_STATUS_DAO_ATTR = "requestStatusDao";
	private static final String REQUEST_STATUS_SERVICE_ATTR = "requestStatusService";
	private static final String REQUESTS_DAO_ATTR = "requestsDao";
	private static final String REQUESTS_SERVICE_ATTR = "requestsService";

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.
	 * ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.ServletContextListener#contextInitialized(javax.servlet.
	 * ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext context = servletContextEvent.getServletContext();
		UsersDao usersDao = new MySqlUsersDao();
		TransactionManager transactionManager = null;
		try {
			/*
			 * Context initCtx = new InitialContext(); Context envCtx =
			 * (Context) initCtx.lookup("java:comp/env/"); DataSource ds =
			 * (DataSource) envCtx.lookup("jdbc/autopark"); transactionManager =
			 * new TransactionManager(ds);
			 */
			transactionManager = new TransactionManager(DbConnector.init());
		} catch (NamingException | ClassNotFoundException | ServletException | SQLException e) {
			e.printStackTrace();
		}

		context.setAttribute(USER_DAO_ATTR, usersDao);
		UsersService usersService = new MySqlUsersService(usersDao, transactionManager);
		context.setAttribute(USER_SERVICE_ATTR, usersService);
		CarsDao carsDao = new MySqlCarsDao();
		context.setAttribute(CARS_DAO_ATTR, carsDao);
		CarsService carsService = new MySqlCarsService(carsDao, transactionManager);
		context.setAttribute(CARS_SERVICE_ATTR, carsService);
		RolesDao rolesDao = new MySqlRolesDao();
		context.setAttribute(ROLES_DAO_ATTR, rolesDao);
		RolesService rolesService = new MySqlRolesService(rolesDao, transactionManager);
		context.setAttribute(ROLES_SERVICE_ATTR, rolesService);
		TripsDao tripsDao = new MySqlTripsDao();
		context.setAttribute(TRIPS_DAO_ATTR, tripsDao);
		TripsService tripsService = new MySqlTripsService(tripsDao, transactionManager);
		context.setAttribute(TRIPS_SERVICE_ATTR, tripsService);
		RequestStatusDao requestStatusDao = new MySqlRequestStatusDao();
		context.setAttribute(REQUEST_STATUS_DAO_ATTR, requestStatusDao);
		RequestStatusService requestStatusService = new MySqlRequestStatusService(requestStatusDao, transactionManager);
		context.setAttribute(REQUEST_STATUS_SERVICE_ATTR, requestStatusService);
		RequestsDao requestsDao = new MySqlRequestsDao();
		context.setAttribute(REQUESTS_DAO_ATTR, requestsDao);
		RequestsService requestsService = new MySqlRequestsService(requestsDao, transactionManager);
		context.setAttribute(REQUESTS_SERVICE_ATTR, requestsService);
		//CommandContainer commandContainer = new CommandContainer(commands);
		
		
		
		
	}
	
	
	

}
