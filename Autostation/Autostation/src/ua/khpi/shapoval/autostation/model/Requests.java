/**
 * 
 */
package ua.khpi.shapoval.autostation.model;

/**
 * @author serg_shapoval
 *
 */
public class Requests {
	/** Request's id. */
	private int idRequest;
	/**
	 * Forieng key from Users class - user's id.
	 * 
	 * @see ua.khpi.shapoval.autostation.model.Users.
	 */
	private int idUserReq;
	/**
	 * Forieng key from Cars class - car's id.
	 * 
	 * @see ua.khpi.shapoval.autostation.model.Cars.
	 */
	private int idCarReq;
	/**
	 * Forieng key from Trips class - car's id.
	 * 
	 * @see ua.khpi.shapoval.autostation.model.Trips.
	 */
	private int idTripReq;
	/**
	 * Forieng key from Trips class - trip's id.
	 * 
	 * @see ua.khpi.shapoval.autostation.model.Trips.
	 */
	private int idStatusReq;

	/**
	 * @return the idRequest
	 */
	public int getIdRequest() {
		return idRequest;
	}

	/**
	 * @param idRequest
	 *            the idRequest to set
	 */
	public void setIdRequest(int idRequest) {
		this.idRequest = idRequest;
	}

	/**
	 * @return the idUserReq
	 */
	public int getIdUserReq() {
		return idUserReq;
	}

	/**
	 * @param idUserReq
	 *            the idUserReq to set
	 */
	public void setIdUserReq(int idUserReq) {
		this.idUserReq = idUserReq;
	}

	/**
	 * @return the idCarReq
	 */
	public int getIdCarReq() {
		return idCarReq;
	}

	/**
	 * @param idCarReq
	 *            the idCarReq to set
	 */
	public void setIdCarReq(int idCarReq) {
		this.idCarReq = idCarReq;
	}

	/**
	 * @return the idTripReq
	 */
	public int getIdTripReq() {
		return idTripReq;
	}

	/**
	 * @param idTripReq
	 *            the idTripReq to set
	 */
	public void setIdTripReq(int idTripReq) {
		this.idTripReq = idTripReq;
	}

	/**
	 * @return the idStatusReq
	 */
	public int getIdStatusReq() {
		return idStatusReq;
	}

	/**
	 * @param idStatusReq
	 *            the idStatusReq to set
	 */
	public void setIdStatusReq(int idStatusReq) {
		this.idStatusReq = idStatusReq;
	}

}
