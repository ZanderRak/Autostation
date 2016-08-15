package ua.khpi.shapoval.autostation.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutCommand extends Command {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6239265835456348160L;
	private static final String LOGIN_PAGE = "/Autostation/";

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return LOGIN_PAGE;
	}

}
