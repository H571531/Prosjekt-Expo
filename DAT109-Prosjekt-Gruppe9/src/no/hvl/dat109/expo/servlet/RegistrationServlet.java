package no.hvl.dat109.expo.servlet;

import no.hvl.dat109.expo.eao.StandEAO;
import no.hvl.dat109.expo.entities.Stand;
import no.hvl.dat109.expo.utils.RegistrationUtils;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


@WebServlet("/RegistrationServlet")
@MultipartConfig
public class RegistrationServlet extends HttpServlet {

    @EJB
    StandEAO sEAO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part file = request.getPart("file");
        if(file == null)
            return;

        // Servleten forventer en CSV fil med samme kolloner som databasen, men uten header.

        RegistrationUtils.registerFromCSVFile(file.getInputStream(),sEAO);
        response.sendRedirect("StartServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/JSP/Registration.jsp").forward(request, response);
    }
}
