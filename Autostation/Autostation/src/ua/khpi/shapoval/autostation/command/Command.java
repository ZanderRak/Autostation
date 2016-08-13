/**
 * 
 */
package ua.khpi.shapoval.autostation.command;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author serg_shapoval
 *
 */
public abstract class Command implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 43912075607167886L;

	public abstract String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException;

	@Override
	public final String toString() {
		return getClass().getSimpleName();
	}

}
