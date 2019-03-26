package no.hvl.dat109.expo.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.expo.eao.InstituteEAO;
import no.hvl.dat109.expo.eao.VoteEAO;
import no.hvl.dat109.expo.statistics.InstituteResult;
import no.hvl.dat109.expo.statistics.Result;

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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Result result = new Result(voteEAO.findAllVote());
        //Gson gson = new Gson();
        
       // request.setAttribute("gsonToplist", gson.toJson(result.getTopStandsTotalPoints(5)));
        //request.setAttribute("gToplist", result.getTopStandsTotalPoints(5));

        request.setAttribute("toplist",result.getTopStandsTotalPoints(5));
        request.setAttribute("studies",result.getStudyResults());
        request.setAttribute("institutes",result.getInstituteResults());
        
        request.setAttribute("institutesPointTotal", InstituteResult.getTotalInstituteResult(instituteEAO.findAllInstitute()));
        request.getRequestDispatcher("WEB-INF/JSP/Result.jsp").forward(request, response);
    }
}
