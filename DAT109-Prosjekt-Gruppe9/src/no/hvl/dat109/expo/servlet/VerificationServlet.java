package no.hvl.dat109.expo.servlet;

import no.hvl.dat109.expo.eao.VisitorEAO;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/VerificationServlet")
public class VerificationServlet extends HttpServlet {

    @EJB
    VisitorEAO visitorEAO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String token = request.getParameter("token");

        if(id == null || token == null){
            // Feil håndtering
        }

        visitorEAO.findVisitor(id).getVisitorToken().equals(token);



    }
}
