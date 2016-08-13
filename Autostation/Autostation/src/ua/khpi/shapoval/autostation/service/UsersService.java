/**
 * 
 */
package ua.khpi.shapoval.autostation.service;

import java.util.List;

import ua.khpi.shapoval.autostation.model.Users;

/**
 * @author serg_shapoval
 *
 */
public interface UsersService {

	public Users insert(Users object);

	public int update(Users user);

	public int delete(int idObject);

	public List<Users> select();

	public int getUserIdByLogin(String login);

	public String getUserRole(String login);

}
