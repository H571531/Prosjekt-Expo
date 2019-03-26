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
import no.hvl.dat109.expo.entities.Stand;
import no.hvl.dat109.expo.entities.Visitor;
import no.hvl.dat109.expo.interfaces.StandInterface;
import no.hvl.dat109.expo.utils.VerificationUtils;
import no.hvl.dat109.expo.utils.VoteUtils;

/**
 * @author
 * Servlet implementation class StandServlet
 */
@WebServlet("/StandServlet")
public class StandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	@EJB
	StandEAO sEAO;
	
	@EJB
	VoteEAO voteEAO;
	
    public StandServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String standId = request.getParameter("standId");
		Optional<Visitor> visitor=VerificationUtils.getVisitor(request);
		
		if(standId != null &&visitor.isPresent()) {
			//Hente Stand fra database, sett request-parameter stand
			
			
			Stand stand = (Stand)sEAO.findStand(standId);
			
			boolean alreadyVoted = VoteUtils.visitorHasAlreadyVotedForStand(visitor, stand, voteEAO);
			
			if(alreadyVoted) {
				request.setAttribute("alreadyVotedMessage", "Du har allerede stemt på standen!");
			}
			
			request.setAttribute("stand", stand);
			
			request.getRequestDispatcher("WEB-INF/JSP/Vote.jsp").forward(request, response);
		}else if(!visitor.isPresent()) {
			
			request.getSession().setAttribute("lastStandVisited", standId);
			response.sendRedirect("NewVisitorServlet");
		}	else {
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
