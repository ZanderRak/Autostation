/**
 * 
 */
package ua.khpi.shapoval.autostation.model;

/**
 * @author serg_shapoval
 *
 */
public enum CarsType {

	MINI(1), CITY(2), VAN(3), CARGO(4);

	private int idCarType;

	CarsType(int idCarType) {
		this.idCarType = idCarType;
	}

	public static CarsType getById(int idCarType) {
		for (CarsType e : values()) {
			if (e.idCarType == idCarType)
				return e;
		}
		throw new IllegalArgumentException();
	}

}
