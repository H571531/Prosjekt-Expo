package no.hvl.dat109.expo.servlet;

import no.hvl.dat109.expo.eao.StandEAO;
import no.hvl.dat109.expo.eao.VoteEAO;
import no.hvl.dat109.expo.entities.Stand;
import no.hvl.dat109.expo.entities.Vote;
import no.hvl.dat109.expo.interfaces.StandInterface;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author
 * Servlet implementation class StemmeServlet
 */
@WebServlet("/VoteServlet")
public class VoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	VoteEAO vEAO;
	@EJB
	StandEAO sEAO;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String standId = request.getParameter("voteCastedFor");
		if(standId != null) {
			StandInterface stand = sEAO.findStand(standId);
			//StandInterface stand = ConstructionUtils.setupStand(Integer.parseInt(standId));
			
			request.setAttribute("stand", stand);
			request.getRequestDispatcher("WEB-INF/JSP/VoteCasted.jsp").forward(request, response);
		} else {
			response.sendRedirect("StartServlet?InvalidRequest");
		}
		
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String standId = request.getParameter("standId");
		String voteValue = request.getParameter("voteValue");
		List<Cookie> cookies =Arrays.asList(request.getCookies());
		
		
		if(standId != null && voteValue != null&& !cookies.isEmpty()) {
			//Foreløpig ingen form for registrering av bruker
			Stand stand = sEAO.findStand(standId);
			
			
			Vote vote = new Vote(voteValue,stand);
			
			
			vEAO.voteForStand(vote);
			
			//TODO: Behandle gitt stemme
			
			response.sendRedirect("VoteServlet?voteCastedFor=" + standId);
		} else if(cookies.isEmpty()){
			response.sendRedirect("NewVisitorServlet");
		}else {
			response.sendRedirect("StartServlet?InvalidVote");
		}
	}

}
