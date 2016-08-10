package ua.khpi.shapoval.autostation.daoFactory;

import ua.khpi.shapoval.autostation.dao.CarsDao;
import ua.khpi.shapoval.autostation.dao.MySqlCarsDao;
import ua.khpi.shapoval.autostation.dao.MySqlRequestsDao;
import ua.khpi.shapoval.autostation.dao.MySqlRolesDao;
import ua.khpi.shapoval.autostation.dao.MySqlTripsDao;
import ua.khpi.shapoval.autostation.dao.MySqlUsersDao;
import ua.khpi.shapoval.autostation.dao.RequestsDao;
import ua.khpi.shapoval.autostation.dao.RolesDao;
import ua.khpi.shapoval.autostation.dao.TripsDao;
import ua.khpi.shapoval.autostation.dao.UsersDao;

/**
 * 
 * @author serg_shapoval
 *
 */
public class MySqlDaoFactory extends DaoFactory {

	@Override
	public UsersDao getUsersDao() {
		return new MySqlUsersDao();
	}

	@Override
	public RolesDao getRolesDao() {
		return new MySqlRolesDao();
	}

	@Override
	public RequestsDao getRequestsDao() {
		return new MySqlRequestsDao();
	}

	@Override
	public CarsDao getCarsDo() {
		return new MySqlCarsDao();
	}

	@Override
	public TripsDao getTripsDao() {
		return new MySqlTripsDao();
	}

}
