package no.hvl.dat109.expo.servlet;

import no.hvl.dat109.expo.eao.VisitorEAO;
import no.hvl.dat109.expo.utils.SessionUtils;
import no.hvl.dat109.expo.utils.VerificationUtils;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/NewVisitorServlet")
public class NewVisitorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @EJB
    VisitorEAO visitorEAO;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

		VerificationUtils.createVisitor(id,visitorEAO,getServletContext().getInitParameter("SMS-API-KEY"));

		Optional<String> lastStand = SessionUtils.getSessionParameter(request,"from");
		if(lastStand.isPresent()){
		    response.sendRedirect("/StandServlet?standid=" + lastStand.get());
        }else{
		    response.sendRedirect("/StartServlet");
        }


	}//

}
