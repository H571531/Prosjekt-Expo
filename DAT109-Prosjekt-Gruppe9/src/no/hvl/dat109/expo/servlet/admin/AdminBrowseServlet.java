package no.hvl.dat109.expo.servlet.admin;

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
import no.hvl.dat109.expo.utils.AdminTasks;
import no.hvl.dat109.expo.utils.LoginUtils;

/**
 * Servlet implementation class AdminBrowseServlet
 */
@WebServlet("/AdminBrowseServlet")
public class AdminBrowseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	InstituteEAO instituteEAO;
	
	@EJB
	StudyEAO studyEAO;
	
	@EJB
	StandEAO standEAO;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(LoginUtils.isLoggedIn(request)) {
			
			
			String confirmEdit = AdminTasks.setupMessageConfirmingStandEdit(request);
			
			request.setAttribute("confirmEdit", confirmEdit);
			
			AdminTasks.makeBrowseSelection(request, standEAO, instituteEAO, studyEAO);
			
			request.getRequestDispatcher("WEB-INF/JSP/admin/AdminBrowse.jsp").forward(request, response);
			
		} else {
			
			request.getRequestDispatcher("WEB-INF/JSP/Login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
