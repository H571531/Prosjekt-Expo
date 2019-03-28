package no.hvl.dat109.expo.utils.test;

import static no.hvl.dat109.expo.utils.LoginUtils.isLoggedIn;
import static no.hvl.dat109.expo.utils.LoginUtils.logOut;
import static no.hvl.dat109.expo.utils.LoginUtils.login;
import static no.hvl.dat109.expo.utils.LoginUtils.loginHeader;
import static no.hvl.dat109.expo.utils.LoginUtils.loginOk;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;

import no.hvl.dat109.expo.eao.AdminEAO;
import no.hvl.dat109.expo.entities.Admin;
import no.hvl.dat109.expo.utils.PasswordUtil;

public class LoginUtilsTest {

	private HttpServletRequest requestMock;
	private HttpSession sessionMock;

	@Before
	public void init() {
		requestMock = mock(HttpServletRequest.class);
		sessionMock = mock(HttpSession.class);
	}

	/**
	 * Request parameter "wrongPassword" -> Return string for feil passord
	 */
	@Test
	public void loginHeaderTestWrongPass() {

		when(requestMock.getParameter("wrongPassword")).thenReturn("Wrong");

		assertEquals(loginHeader(requestMock), "Feil brukernavn eller passord");
		verify(requestMock).getParameter("wrongPassword");
	}

	/**
	 * Request parameter "loginRequired" -> return string om at bruker må være
	 * innlogget
	 */
	@Test
	public void loginHeaderSessionTimeoutTest() {

		when(requestMock.getParameter("wrongPassword")).thenReturn(null);
		when(requestMock.getParameter("loginRequired")).thenReturn("Not logged in");

		assertEquals(loginHeader(requestMock), "Du må være logget inn for å se denne siden.");
		verify(requestMock).getParameter("wrongPassword");
		verify(requestMock).getParameter("loginRequired");
	}

	/**
	 * Request parametre "wrongPassword" og "loginRequied" begge lik null -> return
	 * ""
	 */
	@Test
	public void loginHeaderTestCorrectTest() {

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
		Admin admin = new Admin();
		admin = null;

		assertFalse(loginOk(requestMock, admin));
	}

	/**
	 * Hvis password i request.getParameter matcher med passordet til Admin-objekt
	 * -> Skal returnere true
	 */
	@Test
	public void loginOkSuccessTest() {
		String password = PasswordUtil.krypterPassord("passwordString");
		Admin admin = new Admin("Username", password);

		when(requestMock.getParameter("password")).thenReturn("passwordString");

		assertTrue(loginOk(requestMock, admin));
		verify(requestMock).getParameter("password");
	}

	/**
	 * Hvis session==null -> Skal returnere false
	 */
	@Test
	public void isLoggedInTest() {

		when(requestMock.getSession(false)).thenReturn(sessionMock);

		assertFalse(isLoggedIn(requestMock));
		verify(requestMock).getSession(false);
	}

	/**
	 * Hvis session != null men username == null -> Skal bli false
	 */
	@Test
	public void isLoggedInTest2() {

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
		AdminEAO adminEAOMock = mock(AdminEAO.class);
		String password = PasswordUtil.krypterPassord("passwordString");
		Admin admin = new Admin("Username", password);

		when(requestMock.getParameter("Username")).thenReturn("Username");
		when(adminEAOMock.findAdmin("Username")).thenReturn(admin);

		assertFalse(login(requestMock, 10, adminEAOMock));
		verify(adminEAOMock).findAdmin("Username");
	}

	/**
	 * Hvis requestet inneholder et "Username" som sammsvarer med en admin i
	 * databasen og passordet i requesten samsvarer med passordet til den adminen ->
	 * Skal lage en session om det ikke eksisterer og returnere true.
	 */
	@Test
	public void loginSucessTest() {
//		TODO
//		Inneholder static
	}

	/**
	 * Session != Null -> session.invalidate()
	 */
	@Test
	public void sessionStartInvalidateTest() {
//		TODO
//		Inneholder static
	}

	/**
	 * TODO Logger ut ved å fjerne "Username" i Session og ved session.invalidate().
	 */
	@Test
	public void logOutTest() {
		when(requestMock.getSession(false)).thenReturn(sessionMock);
		doNothing().when(sessionMock).removeAttribute("Username");
		doNothing().when(sessionMock).invalidate();

		logOut(requestMock);

		verify(sessionMock).removeAttribute("Username");
		verify(sessionMock).invalidate();

	}

	/**
	 * 
	 */
	@Test
	public void logOutNullTest() {
		sessionMock = null;

		when(requestMock.getSession(false)).thenReturn(sessionMock);

		logOut(requestMock);
	}

}