package no.hvl.dat109.expo.servlet;

import no.hvl.dat109.expo.eao.StandEAO;
import no.hvl.dat109.expo.entities.Stand;
import no.hvl.dat109.expo.utils.RegistrationUtils;
import org.apache.commons.io.FileUtils;

import javax.ejb.EJB;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.charset.StandardCharsets;


@WebServlet("/RegistrationServlet")
@MultipartConfig
public class RegistrationServlet extends HttpServlet {

    @EJB
    StandEAO sEAO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part part = request.getPart("image");
        String id = request.getParameter("standid");
        String name = request.getParameter("name");

        if(part == null || id == null || name == null)
            return;

        registerStand(part, id, name);
        response.sendRedirect("StartServlet");
    }

    // Denne er avhengig av både Servlet og EAO, gir det menig å flytte den til en util?
    private void registerStand(Part part, String id, String name) throws IOException {
        sEAO.addStand(new Stand(name,Integer.parseInt(id)));

        // TODO: Send feilmelding ved feil input og sørg for at alle filformat fungerer.
        String path = getServletContext().getRealPath("img/standPosters/poster_2019_" + id + ".png");
        File file = new File(path);
        FileUtils.copyInputStreamToFile(part.getInputStream(),file);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/JSP/Registration.jsp").forward(request, response);
    }
}
