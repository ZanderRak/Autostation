/**
 * 
 */
package ua.khpi.shapoval.autostation.service;

import ua.khpi.shapoval.autostation.dao.RequestStatusDao;
import ua.khpi.shapoval.db.TransactionManager;

/**
 * @author serg_shapoval
 *
 */
public class MySqlRequestStatusService implements RequestStatusService {

	private RequestStatusDao requestStatusDao;
	private TransactionManager transactionManager;

public MySqlRequestStatusService(RequestStatusDao requestStatusDao, TransactionManager transactionManager) {
	this.requestStatusDao=requestStatusDao;
	this.transactionManager=transactionManager;

}

}
