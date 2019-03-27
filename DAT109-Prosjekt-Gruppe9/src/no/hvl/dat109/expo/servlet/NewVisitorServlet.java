package no.hvl.dat109.expo.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.expo.eao.ExpoEAO;
import no.hvl.dat109.expo.eao.VisitorEAO;
import no.hvl.dat109.expo.entities.Expo;
import no.hvl.dat109.expo.entities.Visitor;
import no.hvl.dat109.expo.utils.VerificationUtils;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/NewVisitorServlet")
public class NewVisitorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @EJB
    VisitorEAO visitorEAO;
    
    @EJB
    ExpoEAO expoEAO;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String errorCode = request.getParameter("error");
		String errorMessage = "";
		if(errorCode != null) {
			if("loginFailed".equals(errorCode)) {
				errorMessage = "Innlogging mislykkes!";
			} else if("invalidNumber".equals(errorCode)) {
				errorMessage = "Ugyldig telefonnummer!";
			}
		}
		request.setAttribute("errorMessage", errorMessage);
		request.getRequestDispatcher("WEB-INF/JSP/NewVisitor.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("telephone");
		if(id == null || id.equals("")){ //Gitt blankt telefonnummer
			response.sendRedirect("NewVisitorServlet?error=invalidNumber");
			
		} else { //Gitt gyldig telefonnummer
			Expo expo = (Expo) getServletContext().getAttribute("expo");
			
			String verificationURL = "";
			String alreadyRegistered = "";
			
			Visitor visitor = visitorEAO.findVisitor(id);
			if(visitor == null) { //Forsøkt å hente en Visitor, men ikke funnet: Ny Visitor
				
				verificationURL = VerificationUtils.createVisitor(id,visitorEAO,getServletContext().getInitParameter("SMS-API-KEY"), expo, request);
			
			} else { //Visitor er tidligere registrert, men har ikke lenger cookie
				verificationURL = VerificationUtils.getValidationLink(visitor, request);
				alreadyRegistered = "?alreadyRegistered";
			}
			
			if(!expo.isVerificationRequired()) { //Hvis URL skal vises direkte og ikke sendes på SMS
				request.getSession().setAttribute("verificationURL", verificationURL);
			}
			
			
			response.sendRedirect("ConfirmNewVisitorServlet" + alreadyRegistered);
			
		}
	}
}
