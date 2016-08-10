/**
 * 
 */
package ua.khpi.shapoval.autostation.dao;

import java.util.List;

import ua.khpi.shapoval.autostation.model.RequestStatus;

/**
 * @author serg_shapoval
 *
 */
public interface RequestStatusDao extends Dao<RequestStatus> {
	@Override
	public RequestStatus insert(RequestStatus object);

	@Override
	public int update(RequestStatus request);

	@Override
	public int delete(int idObject);

	@Override
	public List<RequestStatus> select();
}
