/**
 * 
 */
package ua.khpi.shapoval.autostation.dao;

import java.util.List;

import ua.khpi.shapoval.autostation.model.Trips;
import ua.khpi.shapoval.autostation.model.TripsStatus;

/**
 * @author serg_shapoval
 *
 */
public interface TripsDao extends Dao<Trips> {
	@Override
	public Trips insert(Trips object);

	@Override
	public int update(Trips trip);

	@Override
	public int delete(int idObject);

	@Override
	public List<Trips> select();

	/**
	 * Sort by trip id in direct order.
	 * 
	 * @return sorted list
	 */
	public List<Trips> sortByTripIdDirectOrder();

	/**
	 * Sort by trip id in reverse order.
	 * 
	 * @return sorted list
	 */
	public List<Trips> sortByTripIdReverseOrder();

	/**
	 * Sort by date of trip creation in direct order.
	 * 
	 * @return sorted list
	 */
	public List<Trips> sortByTripCreationDateDirectOrder();

	/**
	 * Sort by date of trip creation in reverse order.
	 * 
	 * @return sorted list
	 */
	public List<Trips> sortByTripCreationDateReverseOrder();

	/**
	 * Get all open trips.
	 * 
	 * @return list with open trips
	 */
	public List<Trips> getOpenTrips();

}
