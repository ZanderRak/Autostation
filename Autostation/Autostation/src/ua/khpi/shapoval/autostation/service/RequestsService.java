/**
 * 
 */
package ua.khpi.shapoval.autostation.service;

import java.util.List;

import ua.khpi.shapoval.autostation.model.Requests;

/**
 * @author serg_shapoval
 *
 */
public interface RequestsService {

	public Requests addRequest(Requests request);
	
	public int removeReqeust(int idRequest);
	
	public int updateRequestStatus(Requests request);
	
	public List<Requests> selectRequestsByTripId(int idTrip);

}
