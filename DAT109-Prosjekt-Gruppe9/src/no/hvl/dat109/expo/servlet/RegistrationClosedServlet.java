package no.hvl.dat109.expo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationClosedServlet
 */
@WebServlet("/RegistrationClosedServlet")
public class RegistrationClosedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String attemptedRegistration = request.getParameter("registration");
		if(attemptedRegistration != null) {
			request.setAttribute("attemptedRegistration", attemptedRegistration);
			request.getRequestDispatcher("WEB-INF/JSP/RegistrationClosed.jsp").forward(request, response);
		} else {
			response.sendRedirect("StartServlet");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
