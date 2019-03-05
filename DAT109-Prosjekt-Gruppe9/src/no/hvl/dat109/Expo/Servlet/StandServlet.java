package no.hvl.dat109.Expo.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.Expo.Interface.StandInterface;
import no.hvl.dat109.Expo.entities.Stand;
import no.hvl.dat109.expo.EAO.StandEAO;

/**
 * Servlet implementation class StandServlet
 */
@WebServlet("/StandServlet")
public class StandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	StandEAO sEAO=new StandEAO();
    public StandServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String standId = request.getParameter("standId");
		
		if(standId != null) {
			//Hente Stand fra database, sett request-parameter stand
			
			StandInterface stand = (Stand)sEAO.findStand(Integer.parseInt(standId));
					//kon.setupStand(Integer.parseInt(standId));
			
			
			request.setAttribute("stand", stand);
			
			request.getRequestDispatcher("WEB-INF/JSP/Vote.jsp").forward(request, response);
		} else {
			response.sendRedirect("StartServlet?invalidStandId");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
