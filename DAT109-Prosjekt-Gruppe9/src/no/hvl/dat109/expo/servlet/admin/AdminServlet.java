package no.hvl.dat109.expo.servlet.admin;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.expo.eao.AdminEAO;
import no.hvl.dat109.expo.eao.ExpoEAO;
import no.hvl.dat109.expo.entities.Expo;
import no.hvl.dat109.expo.utils.AdminTasks;
import no.hvl.dat109.expo.utils.LoginUtils;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	AdminEAO adminEAO;
	
	@EJB
	ExpoEAO expoEAO;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(LoginUtils.isLoggedIn(request)) {
			
			String confirmChange = AdminTasks.setupConfirmMessageForBaseAdminPage(request);
			request.setAttribute("confirmChange", confirmChange);
			
			String registrationURL = request.getParameter("registrationURL");
			if(registrationURL != null) {
				response.sendRedirect("AdminRegistrationURLServlet");
			} else {
				request.getRequestDispatcher("WEB-INF/JSP/admin/Admin.jsp").forward(request, response);
			}
			
			
		} else {
			
			response.sendRedirect("StartServlet?loginRequired");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!LoginUtils.isLoggedIn(request)) {
			response.sendRedirect("StartServlet?loginRequired");
		} else {
			
			
			Expo expo = (Expo) getServletContext().getAttribute("expo");
			
			String change = AdminTasks.performBaseAdminTask(request, expo, adminEAO, expoEAO);
			
			
			
			response.sendRedirect("AdminServlet?change=" + change);
		}
	}

}
