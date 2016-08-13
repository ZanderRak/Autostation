/**
 * 
 */
package ua.khpi.shapoval.autostation.service;

import java.util.List;

import ua.khpi.shapoval.autostation.model.Roles;

/**
 * @author serg_shapoval
 *
 */
public interface RolesService {
	public Roles insert(Roles object);
	public int update(Roles role);
	public int delete(int idObject);
	public List<Roles> select();
	
}
