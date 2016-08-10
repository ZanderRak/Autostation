/**
 * 
 */
package ua.khpi.shapoval.autostation.model;

/**
 * @author serg_shapoval
 *
 */
public class RequestStatus {
	/** Id of status. */
	private int idStatus;
	/** Message of status. */
	private String message;

	/**
	 * @return the idStatus
	 */
	public int getIdStatus() {
		return idStatus;
	}

	/**
	 * @param idStatus
	 *            the idStatus to set
	 */
	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
