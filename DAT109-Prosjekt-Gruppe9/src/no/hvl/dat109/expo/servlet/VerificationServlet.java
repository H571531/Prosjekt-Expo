package no.hvl.dat109.expo.servlet;

import no.hvl.dat109.expo.eao.VisitorEAO;
import no.hvl.dat109.expo.entities.Visitor;
import no.hvl.dat109.expo.utils.SessionUtils;
import no.hvl.dat109.expo.utils.VerificationUtils;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/VerificationServlet")
public class VerificationServlet extends HttpServlet {

    @EJB
    VisitorEAO visitorEAO;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String token = request.getParameter("token");

        if(id == null || token == null){
            // TODO: Fiks feilhåndtering
            response.sendRedirect("NewVisitorServlet");
        }
       
        Visitor visitor = visitorEAO.findVisitor(id);
        Boolean successfulLogin = VerificationUtils.login(visitor,token,request);
        if(successfulLogin){
        	Optional<String> lastStand = SessionUtils.getSessionParameter(request,"lastStandVisited");
    		if(lastStand.isPresent()){
    		    response.sendRedirect("StandServlet?standId=" + lastStand.get());
            } else {
            	response.sendRedirect("StartServlet");
            }
            // TODO: Diriger til stand
        }else{
        	response.sendRedirect("NewVisitorServlet?error=loginFailed");
            // TODO: Send feilmelding
        }

    }
}
