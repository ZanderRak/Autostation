/**
 * 
 */
package ua.khpi.shapoval.autostation.service;

import java.util.List;

import ua.khpi.shapoval.autostation.dao.CarsDao;
import ua.khpi.shapoval.autostation.model.Cars;
import ua.khpi.shapoval.db.TransactionManager;

/**
 * @author serg_shapoval
 *
 */
public class MySqlCarsService implements CarsService {

	private CarsDao carsDao;
	private TransactionManager transactionManager;

	public MySqlCarsService(CarsDao carsDao, TransactionManager transactionManager) {
		this.carsDao = carsDao;
		this.transactionManager = transactionManager;
	}

	@Override
	public Cars addCar(Cars car) {

		return this.transactionManager.execute(() -> carsDao.insert(car));

	}

	@Override
	public int updateCar(Cars car) {
		return this.transactionManager.execute(() -> carsDao.update(car));
	}

	@Override
	public int removeCar(int idCar) {
		return this.transactionManager.execute(() -> carsDao.delete(idCar));
	}

	@Override
	public List<Cars> selectCarsForUser(String login) {

		return this.transactionManager.execute(() -> carsDao.selectCarsForUser(login));
	}

	@Override
	public int updateCarServiceability(Cars car) {
		return this.transactionManager.execute(() -> carsDao.update(car));
	}

}
