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
		
		if(expo.isVoteRegistrationOpen()) {
			String standId = request.getParameter("standId");
			// Midlertidig løsning
			String voteValue = "1";
			Optional <Visitor> visitor=VerificationUtils.getVisitor(request);
			
			
			if(standId != null && voteValue != null && visitor.isPresent()) {
				Stand stand = sEAO.findStand(standId);
				Vote vote = new Vote(voteValue,stand,visitor.get());
				
				
				vEAO.voteForStand(vote);
				
				
				response.sendRedirect("VoteServlet?voteCastedFor=" + standId);
			} else if(!visitor.isPresent()){
				response.sendRedirect("NewVisitorServlet");
			}else {
				response.sendRedirect("StartServlet?InvalidVote");
			}
		} else {
			response.sendRedirect("RegistrationClosedServlet?registration=vote");
		}
		
	}

}
