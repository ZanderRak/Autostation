package ua.khpi.shapoval.autostation.command;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.khpi.shapoval.autostation.model.Roles;
import ua.khpi.shapoval.autostation.model.RolesType;
import ua.khpi.shapoval.autostation.model.Users;
import ua.khpi.shapoval.autostation.service.RolesService;
import ua.khpi.shapoval.autostation.service.UsersService;

public class RegistrationCommand extends Command {

	private UsersService usersService;
	private RolesService rolesService;
	private static final String LETTERS = "^[a-zA-Z]*$";
	private static final String LETTERS_AND_NUMBERS = "^[a-zA-Z0-9]*$";
	private static final String LOGIN_PARAM = "login";
	private static final String PASSWORD_PARAM = "password";
	private static final String NAME_PARAM = "name";
	private static final String SURNAME_PARAM = "surname";
	private static final String ROLE_TYPE_PARAM = "role";

	/**
	 * 
	 */
	private static final long serialVersionUID = 4753406755892389071L;

	public RegistrationCommand(UsersService usersService, RolesService rolesService) {
		this.usersService = usersService;
		this.rolesService = rolesService;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String login = request.getParameter(LOGIN_PARAM);
		String password = request.getParameter(PASSWORD_PARAM);
		String name = request.getParameter(NAME_PARAM);
		String surname = request.getParameter(SURNAME_PARAM);
		String role = RolesType.getById(Integer.valueOf(request.getParameter(ROLE_TYPE_PARAM))).toString();

		if (checkLoginAndPassword(login, password) && checkNameAndSurname(name, surname)) {
			Users user = new Users();
			user.setLogin(login);
			user.setPassword(password);
			user.setName(name);
			user.setSurname(surname);
			this.usersService.insert(user);
			int idUser = this.usersService.getUserIdByLogin(login);
			Roles userRole = new Roles();
			userRole.setRoleType(RolesType.valueOf(role));
			userRole.setUserId(idUser);
			this.rolesService.insert(userRole);

		}

		return "/Autostation/register.jsp";
	}

	private String hashPassword(String password) {
		return null;
	}

	private boolean checkLoginAndPassword(String login, String password) {
		if (checkLogin(login) && checkPassword(password)) {
			return true;
		}
		return false;
	}

	private boolean checkNameAndSurname(String name, String surname) {
		if (checkName(name) && checkSurname(surname)) {
			return true;
		}
		return false;
	}

	private boolean checkPassword(String password) {
		if (password != null && !password.isEmpty() && isOnlyLettersAndNumbers(password)) {
			return true;
		}
		return false;
	}

	private boolean checkLogin(String login) {
		if (login != null && !login.isEmpty() && isOnlyLettersAndNumbers(login)) {
			return true;
		}
		return false;
	}

	private boolean checkName(String name) {
		if (name != null && !name.isEmpty() && isOnlyLetters(name)) {
			return true;
		}
		return false;
	}

	private boolean checkSurname(String surname) {
		if (surname != null && !surname.isEmpty() && isOnlyLetters(surname)) {
			return true;
		}
		return false;
	}

	private boolean isOnlyLetters(String input) {
		return Pattern.compile(LETTERS).matcher(input).find();
	}

	private boolean isOnlyLettersAndNumbers(String input) {
		return Pattern.compile(LETTERS_AND_NUMBERS).matcher(input).find();
	}
}
