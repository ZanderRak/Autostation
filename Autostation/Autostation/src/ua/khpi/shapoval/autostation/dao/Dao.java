/**
 * 
 */
package ua.khpi.shapoval.autostation.dao;

import java.util.List;

/**
 * Generic interface for CRUD operations.
 * 
 * @author serg_shapoval
 *
 */
public interface Dao<T> {
	/**
	 * Insert operation.
	 * 
	 * @param object
	 *            object needed to add
	 * @return object that added
	 */
	public T insert(T object);

	/**
	 * Update operation.
	 * 
	 * @param idObject
	 *            id of object needed to update
	 * @return count of raws that was updated
	 */
	public int update(T object);

	/**
	 * Delete operation.
	 * 
	 * @param idObject
	 *            id of object needed to delete
	 * @return count of raws that was deleted
	 */
	public int delete(int idObject);

	/**
	 * Select operation.
	 * 
	 * @return a list of selected objects
	 */
	public List<T> select();

	
	
}
