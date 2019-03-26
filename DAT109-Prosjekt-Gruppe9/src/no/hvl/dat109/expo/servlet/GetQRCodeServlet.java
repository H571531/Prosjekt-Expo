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
        if(standId == null){
            return;
        }

        if(standEAO.standExists(standId)){
            response.sendRedirect("QRCodeServlet?stand=" + standId);
        }else{
            response.sendRedirect("StartServlet?error=ugyldigstand");
        }

    }
}
