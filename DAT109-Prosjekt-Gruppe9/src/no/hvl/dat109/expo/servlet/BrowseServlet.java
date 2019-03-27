package no.hvl.dat109.expo.servlet;

import no.hvl.dat109.expo.eao.InstituteEAO;
import no.hvl.dat109.expo.eao.StandEAO;
import no.hvl.dat109.expo.eao.StudyEAO;
import no.hvl.dat109.expo.entities.Institute;
import no.hvl.dat109.expo.entities.Stand;
import no.hvl.dat109.expo.entities.Study;
import no.hvl.dat109.expo.utils.AdminTasks;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Gruppe 9
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
		
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminTasks.makeBrowseSelection(request, standEAO, instituteEAO, studyEAO);
		request.getRequestDispatcher("WEB-INF/JSP/Browse.jsp").forward(request, response);
		
	}


}
