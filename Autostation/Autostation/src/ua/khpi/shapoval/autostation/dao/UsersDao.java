/**
 * 
 */
package ua.khpi.shapoval.autostation.dao;

import java.util.List;

import ua.khpi.shapoval.autostation.model.Users;

/**
 * @author serg_shapoval
 *
 */
public interface UsersDao extends Dao<Users> {
	@Override
	public Users insert(Users object);

	@Override
	public int update(Users user);

	@Override
	public int delete(int idObject);

	@Override
	public List<Users> select();

	/**
	 * Get user's id by login.
	 * 
	 * @param login
	 *            user's login
	 * @return user's id
	 */
	public int getUserIdByLogin(String login);

	/**
	 * Get user role by its id.
	 * 
	 * @param idUser
	 *            user's id
	 * @return user's role
	 */
	public String getUserRole(String login);

}
