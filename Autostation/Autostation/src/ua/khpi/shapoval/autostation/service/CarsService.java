/**
 * 
 */
package ua.khpi.shapoval.autostation.service;

import java.util.List;

import ua.khpi.shapoval.autostation.model.Cars;

/**
 * @author serg_shapoval
 *
 */
public interface CarsService {

	public Cars addCar(Cars car);
	
	public int updateCar(Cars car);
	
	public int removeCar(int idCar);
	
	public List<Cars> selectCarsForUser(String login);
	
	public int updateCarServiceability(Cars car);
	

}
