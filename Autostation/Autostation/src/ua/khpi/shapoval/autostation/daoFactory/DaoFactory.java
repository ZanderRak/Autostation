/**
 * 
 */
package ua.khpi.shapoval.autostation.daoFactory;

import ua.khpi.shapoval.autostation.dao.CarsDao;
import ua.khpi.shapoval.autostation.dao.RequestsDao;
import ua.khpi.shapoval.autostation.dao.RolesDao;
import ua.khpi.shapoval.autostation.dao.TripsDao;
import ua.khpi.shapoval.autostation.dao.UsersDao;

/**
 * @author serg_shapoval
 *
 */
public abstract class DaoFactory {

	public static final int MYSQL = 1;

	public abstract UsersDao getUsersDao();

	public abstract RolesDao getRolesDao();

	public abstract RequestsDao getRequestsDao();

	public abstract CarsDao getCarsDo();

	public abstract TripsDao getTripsDao();

	public static DaoFactory getDAOFactory(int factoryCode) {
		switch (factoryCode) {
		case MYSQL:
			return new MySqlDaoFactory();
		default:
			return null;
		}
	}

}
