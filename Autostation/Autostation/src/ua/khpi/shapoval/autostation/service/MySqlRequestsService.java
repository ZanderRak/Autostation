/**
 * 
 */
package ua.khpi.shapoval.autostation.service;

import java.util.List;

import ua.khpi.shapoval.autostation.dao.RequestsDao;
import ua.khpi.shapoval.autostation.model.Requests;
import ua.khpi.shapoval.db.TransactionManager;

/**
 * @author serg_shapoval
 *
 */
public class MySqlRequestsService implements RequestsService {

	private RequestsDao requestsDao;
	private TransactionManager transactionManager;

	public MySqlRequestsService(RequestsDao requestsDao, TransactionManager transactionManager) {
		this.requestsDao = requestsDao;
		this.transactionManager = transactionManager;
	}

	@Override
	public Requests addRequest(Requests request) {
	
		return this.transactionManager.execute(()->this.requestsDao.insert(request));
	}

	@Override
	public int updateRequestStatus(Requests request) {

		return this.transactionManager.execute(() -> this.requestsDao.update(request));
	}

	@Override
	public int removeReqeust(int idRequest) {

		return this.transactionManager.execute(() -> this.requestsDao.delete(idRequest));
	}

	@Override
	public List<Requests> selectRequestsByTripId(int idTrip) {

		return this.transactionManager.execute(() -> this.requestsDao.selectRequestsByTripId(idTrip));
	}

}
