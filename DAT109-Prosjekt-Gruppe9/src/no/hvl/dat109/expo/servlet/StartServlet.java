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
 * @author
 * Servlet implementation class StartServlet
 */
@WebServlet("/StartServlet")
public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	int timeout;
	
	@EJB
	private AdminEAO adminEAO;
	
	@Override
	public void init() throws ServletException {
		super.init();
		timeout = Integer.parseInt(getServletContext().getInitParameter("TIMEOUT"));
		//TODO: Fjerne før avslutning
		getServletContext().setAttribute("expo", expoEAO.findExpo("2019"));
	}

	@EJB
	StandEAO sEAO;
	
	@EJB
	ExpoEAO expoEAO;
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginMessage = LoginUtils.loginHeader(request);
		request.setAttribute("loginError", loginMessage);
		
		
		
		//request.setAttribute("stands",sEAO.findAllStand());
		
		String standid=request.getParameter("standid");
			System.out.println(standid);
			if(standid==null) {
				request.getRequestDispatcher("WEB-INF/JSP/Frontpage.jsp").forward(request, response);
		}else if(!(standid==null) && sEAO.standExists(standid)) {
			response.sendRedirect("QRCodeServlet?stand="+standid);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(LoginUtils.login(request,timeout, adminEAO)) {
			response.sendRedirect("AdminServlet");
		}else {
			response.sendRedirect("StartServlet?wrongPassword");
		}
	}

}
