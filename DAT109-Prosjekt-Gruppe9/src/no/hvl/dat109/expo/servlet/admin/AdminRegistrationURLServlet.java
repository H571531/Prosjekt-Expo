package no.hvl.dat109.expo.servlet.admin;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.expo.eao.StandEAO;
import no.hvl.dat109.expo.entities.Expo;
import no.hvl.dat109.expo.entities.Stand;
import no.hvl.dat109.expo.utils.LoginUtils;
import no.hvl.dat109.expo.utils.VerificationUtils;

/**
 * Servlet implementation class AdminRegistrationURLServlet
 */
@WebServlet("/AdminRegistrationURLServlet")
public class AdminRegistrationURLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Expo expo;
	
	@EJB
	StandEAO standEAO;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!LoginUtils.isLoggedIn(request)) {
			response.sendRedirect("StartServlet?loginRequired");
		} else {
			String newStandId = request.getParameter("newStandId"); //Opprettet ny stand
			String standId = request.getParameter("standId"); //Hente URL til tidligere opprettet stand
			if(newStandId != null) {
				Stand newStand = standEAO.findStand(newStandId);
				request.setAttribute("newStand",newStand);
				request.setAttribute("newUrl", VerificationUtils.getValidationLink(newStand, request));
			}
			if(standId != null) {
				Stand oldStand = standEAO.findStand(standId);
				request.setAttribute("oldUrl", VerificationUtils.getValidationLink(oldStand, request));
			}
			
			request.getRequestDispatcher("WEB-INF/JSP/admin/RegistrationURLs.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!LoginUtils.isLoggedIn(request)) {
			response.sendRedirect("StartServlet?loginRequired");
		} else {
			String newStandId = request.getParameter("newStandId"); //Id til stand som skal opprettes
			
			if(newStandId != null) {
				expo = (Expo) request.getServletContext().getAttribute("expo");
				VerificationUtils.createStand(request, newStandId, expo, standEAO);
			}
			
		
			
			response.sendRedirect("AdminRegistrationURLServlet?newStandId=" + newStandId);

		}
	}

}
