/**
 * 
 */
package ua.khpi.shapoval.autostation.service;

import java.util.List;

import ua.khpi.shapoval.autostation.dao.UsersDao;
import ua.khpi.shapoval.autostation.model.Users;
import ua.khpi.shapoval.db.TransactionManager;

/**
 * @author serg_shapoval
 *
 */
public class MySqlUsersService implements UsersService {

	private UsersDao usersDao;
	private TransactionManager transactionManager;

	public MySqlUsersService(UsersDao usersDao, TransactionManager transactionManager) {
		this.usersDao = usersDao;
		this.transactionManager = transactionManager;
	}

	@Override
	public Users insert(Users object) {
		return this.transactionManager.execute(() -> this.usersDao.insert(object));
	}

	@Override
	public int update(Users user) {
		return this.transactionManager.execute(() -> this.usersDao.update(user));
	}

	@Override
	public int delete(int idObject) {
		return this.transactionManager.execute(() -> this.usersDao.delete(idObject));
	}

	@Override
	public List<Users> select() {
		return this.transactionManager.execute(() -> this.usersDao.select());
	}

	@Override
	public int getUserIdByLogin(String login) {
		return this.transactionManager.execute(()-> this.usersDao.getUserIdByLogin(login));
	}

	@Override
	public String getUserRole(String login) {
		return this.transactionManager.execute(() -> this.usersDao.getUserRole(login));
	}

	@Override
	public Users getUserByLogin(String login) {
		return this.transactionManager.execute(()->this.usersDao.getUserByLogin(login));
	}

}
