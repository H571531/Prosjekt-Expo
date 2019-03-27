package no.hvl.dat109.expo.servlet.admin;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.expo.eao.InstituteEAO;
import no.hvl.dat109.expo.eao.StandEAO;
import no.hvl.dat109.expo.eao.StudyEAO;
import no.hvl.dat109.expo.entities.Stand;
import no.hvl.dat109.expo.utils.AdminTasks;
import no.hvl.dat109.expo.utils.LoginUtils;
import no.hvl.dat109.expo.utils.VerificationUtils;

/**
 * Servlet implementation class AdminEditStandServlet
 */
@WebServlet("/AdminEditStandServlet")
@MultipartConfig
public class AdminEditStandServlet extends HttpServlet {
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
		String editStandId = request.getParameter("editStandId");
		String editStandToken = request.getParameter("editStandToken");
		
		String path = "";
		
		if(LoginUtils.isLoggedIn(request)) { //Admin skal redigere stand, og er logget inn
			
			request.setAttribute("adminLoggedIn", true);
			
			
			String standId = request.getParameter("standId");
			if(standId != null) {
				
				Stand stand = standEAO.findStand(standId);
				AdminTasks.setupStandEdit(request, stand, studyEAO, instituteEAO);
				
				path = "WEB-INF/JSP/admin/AdminEditStand.jsp";
			} else {
				path = "WEB-INF/JSP/admin/AdminBrowse.jsp";
			}
			
			
		} else if(editStandId != null && editStandToken != null) { //Stand-medlem har fått edit-URL av admin
			boolean tokenOk = VerificationUtils.editLinkIsValid(editStandId, editStandToken, standEAO, request);
			if(tokenOk) {
				
				AdminTasks.setupStandEdit(request, standEAO.findStand(editStandId), studyEAO, instituteEAO);
				path = "WEB-INF/JSP/admin/AdminEditStand.jsp";
				
			} else {
				
				request.setAttribute("errorMessage", "Ugyldig lenke! Vennligst be en administrator om en ny!");
				path = "WEB-INF/JSP/ErrorHandling.jsp";
				
			}
			
		}
		
		
		else {
			path = "WEB-INF/JSP/Frontpage.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String editStandId = request.getParameter("standId");
		String editStandToken = request.getParameter("standToken");
		
		String redirect = "";
		
		if(LoginUtils.isLoggedIn(request)) {
			request.setCharacterEncoding("UTF-8");

			String editString = AdminTasks.editStandFromDoPost(request, standEAO, studyEAO);
			redirect = "AdminBrowseServlet?edit=" + editString;
			
		} else if(editStandId != null && editStandToken != null) {
			
			boolean tokenOk = VerificationUtils.editLinkIsValid(editStandId, editStandToken, standEAO, request);
			if(tokenOk) {
				AdminTasks.editStandFromDoPost(request, standEAO, studyEAO);
				redirect = "AdminEditStandServlet?editStandId=" + editStandId + "&editStandToken=" + editStandToken;
			}
			
		} else {

			
			redirect = "LoginServlet?loginRequired";
		}
		
		response.sendRedirect(redirect);
		
		
		
		
	}

}
