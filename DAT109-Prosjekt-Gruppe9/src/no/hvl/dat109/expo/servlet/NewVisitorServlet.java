package no.hvl.dat109.expo.servlet;

import java.io.IOException;
import java.util.Optional;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.expo.eao.ExpoEAO;
import no.hvl.dat109.expo.eao.VisitorEAO;
import no.hvl.dat109.expo.entities.Expo;
import no.hvl.dat109.expo.utils.SessionUtils;
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
		if(id == null){
			return;
		}

		Expo expo = (Expo) getServletContext().getAttribute("expo");
		
		String verificationURL = VerificationUtils.createVisitor(id,visitorEAO,getServletContext().getInitParameter("SMS-API-KEY"), expo, request);
		
		
		if(!expo.isVerificationRequired()) {
			request.getSession().setAttribute("verificationURL", verificationURL);
		}
		response.sendRedirect("ConfirmNewVisitorServlet");
		
//		if(expo.isVerificationRequired()) {
//			
//		} else {
//			
//		}
//		
//		
//		Optional<String> lastStand = SessionUtils.getSessionParameter(request,"from");
//		if(lastStand.isPresent()){
//		    response.sendRedirect("/StandServlet?standid=" + lastStand.get());
//        }else{
//		    response.sendRedirect("/StartServlet");
//        }


	}//

}
