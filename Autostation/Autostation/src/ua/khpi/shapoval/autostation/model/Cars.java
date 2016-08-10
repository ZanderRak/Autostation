/**
 * 
 */
package ua.khpi.shapoval.autostation.model;

/**
 * @author serg_shapoval
 *
 */
public class Cars {
	/** Car's id. */
	private int idCar;
	/** Car's model. */
	private String model;
	/** Car's type. */
	private CarsType type;
	/** Car's serviceability. */
	private CarsServiceability serviceability;
	/** Car's flag for checking deleted cars. */
	private boolean isDeleted;
	/**
	 * Car's owner id.
	 * 
	 * @see ua.khpi.shapoval.autostation.model.Users.
	 */
	private int idOwner;

	/**
	 * @return the idCar
	 */
	public int getIdCar() {
		return idCar;
	}

	/**
	 * @param idCar
	 *            the idCar to set
	 */
	public void setIdCar(int idCar) {
		this.idCar = idCar;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model
	 *            the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the type
	 */
	public CarsType getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(CarsType type) {
		this.type = type;
	}

	/**
	 * @return the serviceability
	 */
	public CarsServiceability getServiceability() {
		return serviceability;
	}

	/**
	 * @param serviceability
	 *            the serviceability to set
	 */
	public void setServiceability(CarsServiceability serviceability) {
		this.serviceability = serviceability;
	}

	/**
	 * @return the isDeleted
	 */
	public boolean isDeleted() {
		return isDeleted;
	}

	/**
	 * @param isDeleted
	 *            the isDeleted to set
	 */
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * @return the idOwner
	 */
	public int getIdOwner() {
		return idOwner;
	}

	/**
	 * @param idOwner
	 *            the idOwner to set
	 */
	public void setIdOwner(int idOwner) {
		this.idOwner = idOwner;
	}

}
