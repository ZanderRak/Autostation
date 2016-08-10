/**
 * 
 */
package ua.khpi.shapoval.autostation.dao;

import java.util.List;

import ua.khpi.shapoval.autostation.model.Cars;

/**
 * @author serg_shapoval
 *
 */
public interface CarsDao extends Dao<Cars> {

	@Override
	public Cars insert(Cars object);

	@Override
	public int update(Cars cars);

	@Override
	public int delete(int idObject);

	@Override
	public List<Cars> select();

	/**
	 * Select all cars for specified user.
	 * 
	 * @param login
	 *            user's login
	 * @return list of cars
	 */
	public List<Cars> selectCarsForUser(String login);


}
