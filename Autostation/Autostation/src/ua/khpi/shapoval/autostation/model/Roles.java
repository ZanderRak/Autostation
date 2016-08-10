/**
 * 
 */
package ua.khpi.shapoval.autostation.model;

/**
 * @author serg_shapoval
 *
 */
public class Roles {
	/** Role's id. */
	private int idRole;
	/** Role's type. */
	private RolesType roleType;
	/**
	 * Forieng key from Users class - user's id.
	 * 
	 * @see ua.khpi.shapoval.autostation.model.Users.
	 */
	private int userId;

	/**
	 * @return the idRole
	 */
	public int getIdRole() {
		return idRole;
	}

	/**
	 * @param idRole
	 *            the idRole to set
	 */
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	/**
	 * @return the roleType
	 */
	public RolesType getRoleType() {
		return roleType;
	}

	/**
	 * @param roleType
	 *            the roleType to set
	 */
	public void setRoleType(RolesType roleType) {
		this.roleType = roleType;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

}
