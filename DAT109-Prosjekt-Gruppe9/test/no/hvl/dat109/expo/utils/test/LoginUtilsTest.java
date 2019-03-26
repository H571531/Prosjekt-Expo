package no.hvl.dat109.expo.utils.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.mockito.*;

import no.hvl.dat109.expo.eao.AdminEAO;
import no.hvl.dat109.expo.entities.Admin;
import no.hvl.dat109.expo.utils.PasswordUtil;

import static no.hvl.dat109.expo.utils.LoginUtils.*;

public class LoginUtilsTest {

	@Test
	public void loginHeaderTestWrongPass() {
		HttpServletRequest requestMock = mock(HttpServletRequest.class);

		when(requestMock.getParameter("wrongPassword")).thenReturn("Wrong");

		assertEquals(loginHeader(requestMock), "Feil brukernavn eller passord");
		verify(requestMock).getParameter("wrongPassword");
	}

	@Test
	public void loginHeaderSessionTimeoutTest() {
		HttpServletRequest requestMock = mock(HttpServletRequest.class);

		when(requestMock.getParameter("wrongPassword")).thenReturn(null);
		when(requestMock.getParameter("loginRequired")).thenReturn("Not logged in");

		assertEquals(loginHeader(requestMock), "Du må være logget inn for å se denne siden.");
		verify(requestMock).getParameter("wrongPassword");
		verify(requestMock).getParameter("loginRequired");
	}

	@Test
	public void loginHeaderTestCorrectTest() {
		HttpServletRequest requestMock = mock(HttpServletRequest.class);

		when(requestMock.getParameter("wrongPassword")).thenReturn(null);
		when(requestMock.getParameter("loginRequired")).thenReturn(null);

		assertEquals(loginHeader(requestMock), "");
		verify(requestMock).getParameter("wrongPassword");
		verify(requestMock).getParameter("loginRequired");
	}
	
	/**
	 * request.getParameter("password") == null, -> skal returnere false
	 */
	@Test
	public void loginOkFailureTest() {
		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		Admin admin = new Admin("Username", "");

		when(requestMock.getParameter("password")).thenReturn(null);

		assertFalse(loginOk(requestMock, admin));
		verify(requestMock).getParameter("password");
	}
	
	/**
	 * Admin==null -> skal returnere false
	 */
	@Test
	public void loginOkFailureTest2() {
		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		Admin admin = new Admin();

		when(requestMock.getParameter("password")).thenReturn(null);

		assertFalse(loginOk(requestMock, admin));
		verify(requestMock).getParameter("password");
	}
	
	/**
	 * Hvis password i request.getParameter matcher med passordet til Admin-objekt -> Skal returnere true
	 */
	@Test
	public void loginOkSuccessTest() {
		String password = PasswordUtil.krypterPassord("passwordString");
		Admin admin = new Admin("Username", password);
		HttpServletRequest requestMock = mock(HttpServletRequest.class);

		when(requestMock.getParameter("password")).thenReturn("passwordString");

		assertTrue(loginOk(requestMock, admin));
		verify(requestMock).getParameter("password");
	}
	
	
	 /**
	  * Hvis session==null -> Skal returnere false
	  */
	@Test
	public void isLoggedInTest() {
		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		HttpSession sessionMock = mock(HttpSession.class);

		when(requestMock.getSession(false)).thenReturn(sessionMock);

		assertFalse(isLoggedIn(requestMock));
		verify(requestMock).getSession(false);
	}
	
	/**
	 * Hvis session=/=null men username == null -> Skal bli false
	 */
	@Test
	public void isLoggedInTest2() {
		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		HttpSession sessionMock = mock(HttpSession.class);

		when(requestMock.getSession(false)).thenReturn(sessionMock);
		when(sessionMock.getAttribute("Username")).thenReturn(null);

		assertFalse(isLoggedIn(requestMock));
		verify(requestMock).getSession(false);
	}
	
	/**
	 * Hvis admin==null -> Skal returnerer false
	 */
	@Test
	public void loginFailedTest() {
		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		Admin admin = new Admin();
		AdminEAO adminEAOMock = mock(AdminEAO.class);
		
		when(adminEAOMock.findAdmin("")).thenReturn(admin);

		assertFalse(isLoggedIn(requestMock));
		verify(adminEAOMock).findAdmin("");
	}
	
	/**
	 * Hvis requestet inneholder et "Username" som sammsvarer med en admin i databasen
	 * og passordet i requesten samsvarer med passordet til den adminen
	 * -> Skal lage en session om det ikke eksisterer og returnere true.
	 */
//	TODO fiks denna metoden
	@Test
	public void loginSucessTest() {
		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		AdminEAO adminEAOMock = mock(AdminEAO.class);
		String password = PasswordUtil.krypterPassord("passwordString");
		Admin admin = new Admin("Username", password);
		
		when(requestMock.getParameter("Username")).thenReturn("Username");
		when(adminEAOMock.findAdmin("")).thenReturn(admin);

		assertFalse(isLoggedIn(requestMock));
		verify(adminEAOMock).findAdmin("");
	}
	
	/**
	 * 
	 */
	@Test
	public void sessionStartTest() {
	
	//TODO
	
	}
	
	/** TODO
	 * Logger ut ved å fjerne "Username" i Session og ved session.invalidate().
	 */
//	@Test
//	public void logOutTest() {
//		HttpServletRequest requestMock = mock(HttpServletRequest.class);
//		HttpSession session = new HttpSession();
//		
//		when(requestMock.getSession(false)).thenReturn(sessionMock);
//		
//	}
	
}