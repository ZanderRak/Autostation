/**
 * 
 */
package ua.khpi.shapoval.autostation.model;

import java.sql.Date;

/**
 * @author serg_shapoval
 *
 */
public class Trips {
	/** Trip's id. */
	private int idTrip;
	/** Trip's date in specified format <b>YYYY-MM-DD</b>. */
	private Date startDate;
	/** Trip's start place. */
	private String fromPlace;
	/** Trip's finish place. */
	private String toPlace;
	/** Trip's status. */
	private TripsStatus statusTrip;
	/**
	 * Foreing key from Users class - user's id.
	 * 
	 * @see ua.khpi.shapoval.autostation.model.Users.
	 */
	private int idCreator;

	/**
	 * @return the idTrip
	 */
	public int getIdTrip() {
		return idTrip;
	}

	/**
	 * @param idTrip
	 *            the idTrip to set
	 */
	public void setIdTrip(int idTrip) {
		this.idTrip = idTrip;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the fromPlace
	 */
	public String getFromPlace() {
		return fromPlace;
	}

	/**
	 * @param fromPlace
	 *            the fromPlace to set
	 */
	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}

	/**
	 * @return the toPlace
	 */
	public String getToPlace() {
		return toPlace;
	}

	/**
	 * @param toPlace
	 *            the toPlace to set
	 */
	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}

	/**
	 * @return the statusTrip
	 */
	public TripsStatus getStatusTrip() {
		return statusTrip;
	}

	/**
	 * @param statusTrip
	 *            the statusTrip to set
	 */
	public void setStatusTrip(TripsStatus statusTrip) {
		this.statusTrip = statusTrip;
	}

	/**
	 * @return the idCreator
	 */
	public int getIdCreator() {
		return idCreator;
	}

	/**
	 * @param idCreator
	 *            the idCreator to set
	 */
	public void setIdCreator(int idCreator) {
		this.idCreator = idCreator;
	}

}
