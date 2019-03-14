package no.hvl.dat109.expo.servlet;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.expo.eao.InstituteEAO;
import no.hvl.dat109.expo.eao.StandEAO;
import no.hvl.dat109.expo.eao.StudyEAO;
import no.hvl.dat109.expo.entities.Institute;
import no.hvl.dat109.expo.entities.Stand;
import no.hvl.dat109.expo.entities.Study;

/**
 * @author
 * Servlet implementation class BrowseServlet
 */
@WebServlet("/BrowseServlet")
public class BrowseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	InstituteEAO instituteEAO;
	
	@EJB
	StudyEAO studyEAO;
	
	@EJB
	StandEAO standEAO;
	
	@Override
	public void init() throws ServletException {
		super.init();
		getServletContext().setAttribute("studies",studyEAO.findAllStudy());
		getServletContext().setAttribute("institutes", instituteEAO.findAllInstitute());
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String selectedInstitute = request.getParameter("selectedInstitute");
		String selectedStudy = request.getParameter("selectedStudy");
		
		List<Stand> currentStands = standEAO.findAllStand();

		
		if(selectedInstitute != null && !selectedInstitute.equals("all")) {
			Institute selectedInst = instituteEAO.findInstitute(selectedInstitute);
			
			request.setAttribute("selectedInst", selectedInst);
			
			currentStands = selectedInst.getStudies().stream().
							flatMap(s -> s.getStands().stream()).collect(Collectors.toList());
			
		}
		if(selectedStudy != null && !selectedStudy.equals("all")) {
			Study selectedStud = studyEAO.findStudy(selectedStudy);
			request.setAttribute("selectedStud", selectedStud);
			
			currentStands = selectedStud.getStands();
		}
		
		request.setAttribute("currentStands", currentStands);
		
		request.getRequestDispatcher("WEB-INF/JSP/Browse.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
