/**
 * 
 */
package ua.khpi.shapoval.autostation.model;

/**
 * @author serg_shapoval
 *
 */
public enum CarsServiceability {

	GOOD(1), REPAIR_NEEDED(2), IS_FAULTY(3);

	private int idCarServiceability;

	CarsServiceability(int idCarServiceability) {
		this.idCarServiceability = idCarServiceability;
	}

	public static CarsServiceability getById(int idCarServiceability) {
		for (CarsServiceability e : values()) {
			if (e.idCarServiceability == idCarServiceability)
				return e;
		}
		throw new IllegalArgumentException();
	}

}
