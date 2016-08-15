package ua.khpi.shapoval.autostation.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.khpi.shapoval.autostation.command.Command;
import ua.khpi.shapoval.autostation.command.CommandContainer;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/controller")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ERROR_PAGE = "error.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		process(request, response);
	}

	/**
	 * Main method of this controller.
	 */
	private void process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String commandName = request.getParameter("command");
		System.out.println("command: "+commandName);

		Command command = CommandContainer.get(commandName);

		// execute command and get forward address
		String forward = ERROR_PAGE;
		try {
			forward = command.execute(request, response);
		} catch (Exception ex) {
			request.setAttribute("errorMessage", ex.getMessage());
		
		}
	response.sendRedirect(forward);
		//request.getRequestDispatcher(forward).forward(request, response);
	}

}
