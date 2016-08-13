/**
 * 
 */
package ua.khpi.shapoval.autostation.service;

import java.util.List;

import ua.khpi.shapoval.autostation.dao.RolesDao;
import ua.khpi.shapoval.autostation.model.Roles;
import ua.khpi.shapoval.db.TransactionManager;

/**
 * @author serg_shapoval
 *
 */
public class MySqlRolesService implements RolesService {

	private RolesDao rolesDao;
	private TransactionManager transactionManager;

	public MySqlRolesService(RolesDao rolesDao, TransactionManager transactionManager) {
		this.rolesDao = rolesDao;
		this.transactionManager = transactionManager;
	}

	@Override
	public Roles insert(Roles object) {
		return this.transactionManager.execute(() -> this.rolesDao.insert(object));
	}

	@Override
	public int update(Roles role) {
		return this.transactionManager.execute(() -> this.rolesDao.update(role));
	}

	@Override
	public int delete(int idObject) {
		return this.transactionManager.execute(() -> this.rolesDao.delete(idObject));
	}

	@Override
	public List<Roles> select() {
		return this.transactionManager.execute(() -> this.rolesDao.select());
	}

}
