/**
 * 
 */
package ua.khpi.shapoval.autostation.service;

import java.util.List;

import ua.khpi.shapoval.autostation.model.RequestStatus;

/**
 * @author serg_shapoval
 *
 */
public interface RequestStatusService {

	public RequestStatus addRequestStatus(RequestStatus requestStatus);
	
	public int updateRequestStatus(RequestStatus requestStatus);
	
	public int deleteReqeuestStatus(int idRequestStatus);
	
	public List<RequestStatus> selectAllRequestStatus();
	
}
