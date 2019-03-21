package no.hvl.dat109.expo.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;

import no.hvl.dat109.expo.eao.StandEAO;
import no.hvl.dat109.expo.eao.StudyEAO;
import no.hvl.dat109.expo.entities.Expo;
import no.hvl.dat109.expo.entities.Institute;
import no.hvl.dat109.expo.entities.Stand;
import no.hvl.dat109.expo.entities.Study;

/**
 * @author
 *
 */
@WebServlet("/RegistrationServlet")
@MultipartConfig
public class RegistrationServlet extends HttpServlet {

    @EJB
    StandEAO sEAO;
    @EJB
    StudyEAO studyEAO;
    
    Expo expo;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	if(expo.isStandRegistrationOpen()) {

        request.setCharacterEncoding("UTF-8");
	        Part part = request.getPart("image");
	        String id = request.getParameter("standid");
	        String name = request.getParameter("name");
	        String study = request.getParameter("study");
	        String authors = request.getParameter("authors");
	
	        if(part == null || id == null || name == null || study == null || authors == null)
	            return;
	
	        registerStand(part, id, name,study, authors);

	        response.sendRedirect("ConfirmNewStandServlet?stand=" + id);
    	} else {
    		response.sendRedirect("RegistrationClosedServlet?registration=stand");
    	}
    }

    // Denne er avhengig av både Servlet og EAO, gir det menig å flytte den til en util?
    private void registerStand(Part part, String id, String name,String study, String authors) throws IOException {
        expo = (Expo) getServletContext().getAttribute("expo");
    	sEAO.addStand(new Stand(name,id,studyEAO.findStudy(study), expo, authors));

        // TODO: Send feilmelding ved feil input og sørg for at alle filformat fungerer.
        String path = getServletContext().getRealPath("img/standPosters/poster_2019_" + id + ".png");
        File file = new File(path);
        FileUtils.copyInputStreamToFile(part.getInputStream(),file);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	expo = (Expo) request.getServletContext().getAttribute("expo");
    	
		Map<Institute, List<Study>> institutes = studyEAO.findAllStudy()
                .stream()
                .collect(Collectors.groupingBy(Study::getInstitute));

        List<Map.Entry<String,List<Study>>> list = new ArrayList(institutes.entrySet());
        request.setAttribute("institutes", list);
        request.getRequestDispatcher("WEB-INF/JSP/Registration.jsp").forward(request, response);
    	
    	
        
    }
}
