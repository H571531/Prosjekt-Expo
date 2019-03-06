package no.hvl.dat109.expo.servlet;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.expo.eao.StandEAO;
import no.hvl.dat109.expo.entities.Expo;

/**
 * Servlet implementation class StartServlet
 */
@WebServlet("/StartServlet")
public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	StandEAO sEAO;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		//For testing: Oppretter expo for 2019
		getServletContext().setAttribute("expo", new Expo(2019));
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//String errorCode = ServletUtils.createErrorMessage(request);
		
		//request.setAttribute("errorCode", errorCode);
		
		request.setAttribute("stands",sEAO.findAllStand());
		request.getRequestDispatcher("WEB-INF/JSP/Start.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
