package no.hvl.dat109.expo.servlet;

import no.hvl.dat109.expo.eao.VoteEAO;
import no.hvl.dat109.expo.statistics.Result;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author
 *
 */
@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {

    @EJB
    VoteEAO voteEAO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Result result = new Result(voteEAO.findAllVote());

        request.setAttribute("toplist",result.getTopStandsTotal(5));
        request.setAttribute("studies",result.getStudyResults());
        request.setAttribute("institutes",result.getInstituteResults());
        request.getRequestDispatcher("WEB-INF/JSP/Result.jsp").forward(request, response);
    }
}
