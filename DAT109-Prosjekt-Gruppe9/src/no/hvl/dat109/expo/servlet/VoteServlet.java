package no.hvl.dat109.expo.servlet;

import java.io.IOException;
import java.util.Optional;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.expo.eao.StandEAO;
import no.hvl.dat109.expo.eao.VoteEAO;
import no.hvl.dat109.expo.entities.Expo;
import no.hvl.dat109.expo.entities.Stand;
import no.hvl.dat109.expo.entities.Visitor;
import no.hvl.dat109.expo.entities.Vote;
import no.hvl.dat109.expo.interfaces.StandInterface;
import no.hvl.dat109.expo.utils.VerificationUtils;
import no.hvl.dat109.expo.utils.VoteUtils;

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
	
	Expo expo;

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
		Expo expo = (Expo) request.getServletContext().getAttribute("expo");
		String standId = request.getParameter("standId");
		
		if(standId != null) {
			String redirect = VoteUtils.handleVote(standId, request, sEAO, vEAO, expo);
			response.sendRedirect(redirect);
		} else {
			request.setAttribute("errorMessage", "Ugyldig stand-id!");
			request.getRequestDispatcher("WEB-INF/JSP/ErrorHandling.jsp");
		}
		
		
		
	}
	

}
