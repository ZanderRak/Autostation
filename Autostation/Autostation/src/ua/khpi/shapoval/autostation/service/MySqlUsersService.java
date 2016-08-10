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

	private UsersDao usersDAO;
	private TransactionManager transactionManager;

	public MySqlUsersService(UsersDao usersDao, TransactionManager transactionManager) {
		this.usersDAO = usersDao;
		this.transactionManager = transactionManager;
	}

	@Override
	public Users insert(Users object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(int idObject, Users user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int idObject) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Users> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getUserIdByLogin(String login) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getUserRole(String login) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
