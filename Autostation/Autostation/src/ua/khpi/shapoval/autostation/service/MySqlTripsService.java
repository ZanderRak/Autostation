/**
 * 
 */
package ua.khpi.shapoval.autostation.service;

import java.util.List;

import ua.khpi.shapoval.autostation.dao.TripsDao;
import ua.khpi.shapoval.autostation.model.Trips;
import ua.khpi.shapoval.autostation.model.TripsStatus;
import ua.khpi.shapoval.db.TransactionManager;

/**
 * @author serg_shapoval
 *
 */
public class MySqlTripsService implements TripsService {

	private TripsDao tripsDao;
	private TransactionManager transactionManager;

	public MySqlTripsService(TripsDao tripsDao, TransactionManager transactionManager) {
		this.tripsDao = tripsDao;
		this.transactionManager = transactionManager;
	}

	@Override
	public Trips insert(Trips object) {

		return this.transactionManager.execute(() -> this.tripsDao.insert(object));
	}

	@Override
	public int update(Trips trip) {
		return this.transactionManager.execute(() -> this.tripsDao.update(trip));
	}

	@Override
	public int delete(int idObject) {
		return this.transactionManager.execute(() -> this.tripsDao.delete(idObject));
	}

	@Override
	public List<Trips> select() {
		return this.transactionManager.execute(() -> this.tripsDao.select());
	}

	@Override
	public List<Trips> sortByTripIdDirectOrder() {

		return this.transactionManager.execute(() -> this.tripsDao.sortByTripIdDirectOrder());

	}

	@Override
	public List<Trips> sortByTripIdReverseOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Trips> sortByTripCreationDateDirectOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Trips> sortByTripCreationDateReverseOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Trips> getOpenTrips() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateTripStatus(int idTrip, TripsStatus tripsStatus) {
		// TODO Auto-generated method stub
		return 0;
	}

}
