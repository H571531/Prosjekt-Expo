package no.hvl.dat109.expo.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.expo.eao.StandEAO;
import no.hvl.dat109.expo.entities.Stand;

/**
 * Servlet implementation class ConfirmNewStandServlet
 */
@WebServlet("/ConfirmNewStandServlet")
public class ConfirmNewStandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	StandEAO standEAO;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String standid = request.getParameter("stand");
		
		if(standid != null) {
			Stand stand = standEAO.findStand(standid);
			request.setAttribute("stand", stand);
			request.getRequestDispatcher("WEB-INF/JSP/ConfirmNewStand.jsp").forward(request, response);
		} else {
			response.sendRedirect("RegistrationServlet?invalidStandId");
		}
	}
	

}
