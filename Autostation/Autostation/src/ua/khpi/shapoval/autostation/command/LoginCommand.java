/**
 * 
 */
package ua.khpi.shapoval.autostation.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.khpi.shapoval.autostation.model.Roles;
import ua.khpi.shapoval.autostation.model.RolesType;
import ua.khpi.shapoval.autostation.model.Users;
import ua.khpi.shapoval.autostation.service.UsersService;

/**
 * @author serg_shapoval
 *
 */
public class LoginCommand extends Command {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5337459310900087298L;
	private static final String SESSION_ATTR_LOGIN = "login";
	private static final String SESSION_ATTR_ID = "userId";
	private static final String SESSION_ATTR_ROLE = "userRole";
	private static final Logger LOG = Logger.getLogger(LoginCommand.class);
	private static final String PROFILE_JSP = "profile.jsp";
	private static final String USER_INFO_OBJECT="userInfo";
	private UsersService usersService;

	public LoginCommand(UsersService usersService) {
		this.usersService = usersService;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		if (login == null || password == null || login.isEmpty() || password.isEmpty()) {
			return null;
		}
		
		Users user = usersService.getUserByLogin(login);
		if (user == null || !password.equals(user.getPassword())) {
			return null;
		}

		Roles role = new Roles();
		role.setRoleType(RolesType.valueOf(this.usersService.getUserRole(login)));
		String forward = PROFILE_JSP;
	
		session.setAttribute(USER_INFO_OBJECT, user);
		session.setAttribute(SESSION_ATTR_LOGIN, login);
		session.setAttribute(SESSION_ATTR_ID, user.getIdUser());
		session.setAttribute(SESSION_ATTR_ROLE, role.getRoleType().toString());
		
		return forward;
	}

}
