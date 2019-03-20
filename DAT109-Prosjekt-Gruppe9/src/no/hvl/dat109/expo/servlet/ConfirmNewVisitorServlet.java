package no.hvl.dat109.expo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.expo.entities.Expo;

/**
 * Servlet implementation class ConfirmNewVisitorServlet
 */
@WebServlet("/ConfirmNewVisitorServlet")
public class ConfirmNewVisitorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Expo expo = (Expo)getServletContext().getAttribute("expo");
		if(!expo.isVerificationRequired()) {
			
			//request.setAttribute("verificationURL", request.getAttribute("verificationURL"));
		}
		
		request.getRequestDispatcher("WEB-INF/JSP/ConfirmNewVisitor.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
