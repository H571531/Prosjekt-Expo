package no.hvl.dat109.Expo.Servlet;

import no.hvl.dat109.Expo.Utils.QRUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/QRCodeServlet")
public class QRCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hosturl = request.getServerName() + ":" + request.getServerPort();
        String stand = request.getParameter("stand");
        if(stand == null){
            // Rediriger til feilmelding
        }else{
            Optional<BufferedImage> image = QRUtils.generateQR(hosturl + "/StandServlet?standId=" + stand,300,300);
            // Legg til kode som sjekker om bildet finnes
            response.setContentType("image/png");
            new File("/cache").mkdir();
            ImageIO.setCacheDirectory(new File("/cache"));
            ImageIO.write(image.get(),"png",response.getOutputStream());
        }

    }
}
