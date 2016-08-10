/**
 * 
 */
package ua.khpi.shapoval.autostation.model;

/**
 * @author serg_shapoval
 *
 */
public enum RolesType {

	ADMIN(1), DISPATCHER(2), DRIVER(3);

	/** Role's type id. */
	private int idRoleType;

	RolesType(int idRoleType) {
		this.idRoleType = idRoleType;
	}

	public static RolesType getById(int idRoleType) {
		for (RolesType e : values()) {
			if (e.idRoleType == idRoleType)
				return e;
		}
		throw new IllegalArgumentException();
	}

}
