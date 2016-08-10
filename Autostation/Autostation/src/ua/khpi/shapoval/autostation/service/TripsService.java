/**
 * 
 */
package ua.khpi.shapoval.autostation.service;

import java.util.List;

import ua.khpi.shapoval.autostation.model.Trips;
import ua.khpi.shapoval.autostation.model.TripsStatus;

/**
 * @author serg_shapoval
 *
 */
public interface TripsService {
	public Trips insert(Trips object);

	public int update(Trips trip);

	public int delete(int idObject);

	public List<Trips> select();

	public List<Trips> sortByTripIdDirectOrder();

	public List<Trips> sortByTripIdReverseOrder();

	public List<Trips> sortByTripCreationDateDirectOrder();

	public List<Trips> sortByTripCreationDateReverseOrder();

	public List<Trips> getOpenTrips();

	public int updateTripStatus(int idTrip, TripsStatus tripsStatus);

}
