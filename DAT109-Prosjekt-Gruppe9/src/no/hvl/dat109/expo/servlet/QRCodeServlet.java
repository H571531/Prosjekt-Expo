package no.hvl.dat109.expo.servlet;

import no.hvl.dat109.expo.utils.QRUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

/**
 * @author
 *
 */
@WebServlet("/QRCodeServlet")
public class QRCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void init() throws ServletException {
        new File("/cache").mkdir();
        ImageIO.setCacheDirectory(new File("/cache"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hosturl = request.getServerName() + ":" + request.getServerPort();
        String stand = request.getParameter("stand");
        if(stand == null){
            // Rediriger til feilmelding
        }else{
            String protocol = (request.isSecure()) ? "https" : "http";
            Optional<BufferedImage> image = QRUtils.generateQR(protocol + "://" + hosturl + request.getContextPath() + "/StandServlet?standId=" + stand,300,300);
            // Legg til kode som sjekker om bildet finnes
            response.setContentType("image/png");
            ImageIO.write(image.get(),"png",response.getOutputStream());
        }

    }
}
