package no.hvl.dat109.expo.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.expo.eao.InstituteEAO;
import no.hvl.dat109.expo.eao.VoteEAO;
import no.hvl.dat109.expo.entities.Expo;
import no.hvl.dat109.expo.entities.Institute;
import no.hvl.dat109.expo.statistics.InstituteResult;
import no.hvl.dat109.expo.statistics.Result;
import no.hvl.dat109.expo.utils.LoginUtils;

/**
 * @author
 *
 */
@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {

    @EJB
    VoteEAO voteEAO;
    
    @EJB
    InstituteEAO instituteEAO;

    Expo expo;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	expo = (Expo) request.getServletContext().getAttribute("expo");
    	
    	
    	if(expo.isStatisticsOpenToPublic() || LoginUtils.isLoggedIn(request)) {
    		 Result result = new Result(voteEAO.findAllVote());
    		 
    		 List<Institute> institutes = instituteEAO.findAllInstitute();

	        request.setAttribute("toplist",result.getTopStandsTotalPoints(5));
	        request.setAttribute("studies",result.getStudyResults());
	        request.setAttribute("institutes",result.getInstituteResults());
	        
	        request.setAttribute("institutesPointTotal", InstituteResult.getTotalInstituteResult(institutes));
	        request.setAttribute("institutesPointWeightedByStands", InstituteResult.getInstitutePointsWeightedByStands(institutes));
	        request.getRequestDispatcher("WEB-INF/JSP/Result.jsp").forward(request, response);
    	} else {
    		request.setAttribute("errorMessage", "Dessverre er ikke vinneren klar enda! Vennligst kom tilbake på et senere tidspunkt!");
    		request.getRequestDispatcher("WEB-INF/JSP/ErrorHandling.jsp").forward(request, response);
    	}
    }
}
