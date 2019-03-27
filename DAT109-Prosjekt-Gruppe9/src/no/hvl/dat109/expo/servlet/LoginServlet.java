package no.hvl.dat109.expo.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.expo.eao.AdminEAO;
import no.hvl.dat109.expo.utils.LoginUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
		int timeout;
		
		@EJB
		private AdminEAO adminEAO;
		
		@Override
		public void init() throws ServletException {
			timeout = Integer.parseInt(getServletContext().getInitParameter("TIMEOUT"));		
		}
		

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String loginMessage = LoginUtils.loginHeader(request);
			request.setAttribute("loginError", loginMessage);
			
			request.getRequestDispatcher("WEB-INF/JSP/Login.jsp").forward(request, response);
		
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			if(LoginUtils.login(request,timeout, adminEAO)) {
				response.sendRedirect("AdminServlet");
			}else {
				response.sendRedirect("LoginServlet?wrongPassword");
			}
		}


}

