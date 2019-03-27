package no.hvl.dat109.expo.servlet;

import no.hvl.dat109.expo.eao.StandEAO;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GetQRCodeServlet")
public class GetQRCodeServlet extends HttpServlet {

    @EJB
    StandEAO standEAO;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String standId = request.getParameter("standId");
        String redirect = "";
        
        if(standId != null && standEAO.standExists(standId)){
        	redirect = "QRCodeServlet?stand=" + standId;
        } else {
        	redirect = "StartServlet?error=ugyldigstand";
        }

       response.sendRedirect(redirect);

    }
}
