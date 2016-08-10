/**
 * 
 */
package ua.khpi.shapoval.autostation.model;

/**
 * @author serg_shapoval
 *
 */
public enum TripsStatus {

	OPEN(1), PERFOMING(2), CLOSED(3), CANCELED(4);

	private int idStatusTrip;

	TripsStatus(int idStatusTrip) {
		this.idStatusTrip = idStatusTrip;
	}

	public static TripsStatus getById(int idStatusTrip) {
		for (TripsStatus e : values()) {
			if (e.idStatusTrip == idStatusTrip)
				return e;
		}
		throw new IllegalArgumentException();
	}

}
