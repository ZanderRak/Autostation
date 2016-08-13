/**
 * 
 */
package ua.khpi.shapoval.autostation.service;

import java.util.List;

import ua.khpi.shapoval.autostation.dao.RequestStatusDao;
import ua.khpi.shapoval.autostation.model.RequestStatus;
import ua.khpi.shapoval.db.TransactionManager;

/**
 * @author serg_shapoval
 *
 */
public class MySqlRequestStatusService implements RequestStatusService {

	private RequestStatusDao requestStatusDao;
	private TransactionManager transactionManager;

	public MySqlRequestStatusService(RequestStatusDao requestStatusDao, TransactionManager transactionManager) {
		this.requestStatusDao = requestStatusDao;
		this.transactionManager = transactionManager;

	}

	@Override
	public RequestStatus addRequestStatus(RequestStatus requestStatus) {
		return this.transactionManager.execute(() -> this.requestStatusDao.insert(requestStatus));
	}

	@Override
	public int updateRequestStatus(RequestStatus requestStatus) {
		return this.transactionManager.execute(() -> this.requestStatusDao.update(requestStatus));
	}

	@Override
	public int deleteReqeuestStatus(int idRequestStatus) {
		return this.transactionManager.execute(() -> this.requestStatusDao.delete(idRequestStatus));
	}

	@Override
	public List<RequestStatus> selectAllRequestStatus() {
		return this.transactionManager.execute(() -> this.requestStatusDao.select());
	}

}
