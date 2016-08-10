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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(int idRole, Roles role) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int idObject) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Roles> select() {
		// TODO Auto-generated method stub
		return null;
	}

}
