/**
 * 
 */
package ua.khpi.shapoval.autostation.dao;

import java.util.List;

import ua.khpi.shapoval.autostation.model.Requests;

/**
 * @author serg_shapoval
 *
 */
public interface RequestsDao extends Dao<Requests> {

	@Override
	public Requests insert(Requests object);

	@Override
	public int update(Requests request);

	@Override
	public int delete(int idObject);

	@Override
	public List<Requests> select();

	/**
	 * Select all trip's requests.
	 * 
	 * @param idTrip
	 *            id of trip
	 * @return list of request
	 */
	public List<Requests> selectRequestsByTripId(int idTrip);

}
