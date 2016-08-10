/**
 * 
 */
package ua.khpi.shapoval.db;

/**
 * @author serg_shapoval
 *
 */
public interface Transaction<T> {
	public T execute();
}
