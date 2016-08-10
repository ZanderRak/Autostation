/**
 * 
 */
package ua.khpi.shapoval.autostation.dao;

import java.util.List;

import ua.khpi.shapoval.autostation.model.Roles;

/**
 * @author serg_shapoval
 *
 */
public interface RolesDao extends Dao<Roles> {
	@Override
	public Roles insert(Roles object);

	@Override
	public int update(Roles role);

	@Override
	public int delete(int idObject);

	@Override
	public List<Roles> select();
	
	
}
