package no.hvl.dat109.expo.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.expo.eao.AdminEAO;
import no.hvl.dat109.expo.eao.ExpoEAO;
import no.hvl.dat109.expo.eao.StandEAO;
import no.hvl.dat109.expo.entities.Expo;
import no.hvl.dat109.expo.utils.LoginUtils;

/**
 * @author Servlet implementation class StartServlet
 */
@WebServlet("/StartServlet")
public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int timeout;
	private String activeExpoYear;
	
	@EJB
	private AdminEAO adminEAO;

	@EJB
	StandEAO sEAO;

	
	@EJB
	ExpoEAO expoEAO;

	@Override
	public void init() throws ServletException {
		super.init();
		timeout = Integer.parseInt(getServletContext().getInitParameter("TIMEOUT"));
		activeExpoYear = getServletContext().getInitParameter("ACTIVEEXPO");
		Expo expo = expoEAO.findExpo(activeExpoYear);

		if(expo == null) {
			expo = new Expo(activeExpoYear, false, false);
			expoEAO.createExpo(expo);
		}
		
		getServletContext().setAttribute("expo", expoEAO.findExpo(activeExpoYear));
	}

	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String loginMessage = LoginUtils.loginHeader(request);
		String standError="";
		request.setAttribute("loginError", loginMessage);
		String standid = request.getParameter("standid");
		
		if((null != standid)) {
			if(sEAO.standExists(standid)) {
				response.sendRedirect("QRCodeServlet?stand=" + standid);
			}else {
				standError="Finner ikke stand med id:"+standid;
				request.setAttribute("standError", standError);
				request.getRequestDispatcher("WEB-INF/JSP/Frontpage.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("standError", standError);
			request.getRequestDispatcher("WEB-INF/JSP/Frontpage.jsp").forward(request, response);
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (LoginUtils.login(request, timeout, adminEAO)) {
			response.sendRedirect("AdminServlet");
		} else {
			response.sendRedirect("StartServlet?wrongPassword");
		}
	}

}
