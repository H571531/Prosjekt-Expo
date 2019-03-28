package no.hvl.dat109.expo.utils.test;

import static no.hvl.dat109.expo.utils.VerificationUtils.createStand;
import static no.hvl.dat109.expo.utils.VerificationUtils.editLinkIsValid;
import static no.hvl.dat109.expo.utils.VerificationUtils.generateSafeToken;
import static no.hvl.dat109.expo.utils.VerificationUtils.getValidationLink;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;

import no.hvl.dat109.expo.eao.StandEAO;
import no.hvl.dat109.expo.entities.Expo;
import no.hvl.dat109.expo.entities.Stand;
import no.hvl.dat109.expo.entities.Visitor;

public class VerificationUtilsTest {

	private HttpServletRequest requestMock;
	private Expo expo;
	private StandEAO standEAOMock;
	private Stand stand;

	@Before
	public void init() {
		expo = new Expo();
		standEAOMock = mock(StandEAO.class);
		requestMock = mock(HttpServletRequest.class);
		stand = new Stand("standId", expo, "standToken");
	}

//	TODO
//	Static metode ødelgger for test
	@Test
	public void loginTest() {
//		HttpServletRequest requestMock = mock(HttpServletRequest.class);
//		HttpSession sessionMock = mock(HttpSession.class);
//		Visitor visitor = new Visitor("visitorId", "visitorToken");
//		String token = "visitorToken";
//		
//		when(SessionUtils.getSession(requestMock)).get();
//		Mockito.doNothing().when(sessionMock).setAttribute("visitor", visitor);
//
//		assertTrue(VerificationUtils.login(visitor, token, requestMock));
	}

	@Test
	public void getVisitorTest() {
//		TODO
//		Static metode ødelegger
	}

	@Test
	public void createVisitorTest() {
//		TODO
//		Static metode ødelegger
	}

	/*
	 * Linken er "secure==true" -> skal ha https (med s)
	 */
	@Test
	public void getValidationLinkHttpsTest() {
		Visitor visitor = new Visitor("visitorId", "visitorToken");

		when(requestMock.isSecure()).thenReturn(true);
		when(requestMock.getServerName()).thenReturn("url");
		when(requestMock.getServerPort()).thenReturn(1234);
		when(requestMock.getContextPath()).thenReturn("contextPath");

		String resultLingString = getValidationLink(visitor, requestMock);
		String expectedLinkString = "https://url:1234contextPath/VerificationServlet?id=visitorId&token=visitorToken";

		assertEquals(expectedLinkString, resultLingString);
		verify(requestMock).isSecure();
		verify(requestMock).getServerName();
		verify(requestMock).getServerPort();
	}

	/*
	 * Linken skal ha http (uten s)
	 */
	@Test
	public void getValidationLinkHttpTest() {
		Visitor visitor = new Visitor("visitorId", "visitorToken");

		when(requestMock.isSecure()).thenReturn(false);
		when(requestMock.getServerName()).thenReturn("url");
		when(requestMock.getServerPort()).thenReturn(1234);
		when(requestMock.getContextPath()).thenReturn("contextPath");

		String resultLingString = getValidationLink(visitor, requestMock);
		String expectedLinkString = "http://url:1234contextPath/VerificationServlet?id=visitorId&token=visitorToken";

		assertEquals(expectedLinkString, resultLingString);
		verify(requestMock).isSecure();
		verify(requestMock).getServerName();
		verify(requestMock).getServerPort();
	}

	/**
	 * Sjekker at token blir generert og er av riktig lengde.
	 */
	@Test
	public void generateSafeTokenTest() {
		String generatedToken = generateSafeToken();
		assertNotNull(generatedToken);
		assertEquals(generatedToken.length(), 14);
	}

	/**
	 * Sjekker at metoden returner en Stand
	 */
	@Test
	public void createStandTest() {
		String newStandId = "standId";

		doNothing().when(standEAOMock).addStand(stand);

		Stand returnStand = createStand(requestMock, newStandId, expo, standEAOMock);

		assertNotNull(returnStand);
		assertTrue(returnStand instanceof Stand);
		assertTrue(returnStand.getExpo().equals(expo));
		assertTrue(returnStand.getStandId().equals(newStandId));
	}

	/**
	 * Linken er "secure==true" -> skal ha https (med s)
	 */
	@Test
	public void getValidationLinkForStandSecureTest() {

		when(requestMock.isSecure()).thenReturn(true);
		when(requestMock.getServerName()).thenReturn("url");
		when(requestMock.getServerPort()).thenReturn(1234);
		when(requestMock.getContextPath()).thenReturn("contextPath");

		String resultLingString = getValidationLink(stand, requestMock);
		String expectedLinkString = "https://url:1234contextPath/AdminEditStandServlet?editStandId=standId&editStandToken=standToken";

		assertEquals(expectedLinkString, resultLingString);
		verify(requestMock).isSecure();
		verify(requestMock).getServerName();
		verify(requestMock).getServerPort();
	}

	/**
	 * Linken er "secure==false" -> skal ha http (uten s)
	 */
	@Test
	public void getValidationLinkForStandInsecureTest() {

		when(requestMock.isSecure()).thenReturn(false);
		when(requestMock.getServerName()).thenReturn("url");
		when(requestMock.getServerPort()).thenReturn(1234);
		when(requestMock.getContextPath()).thenReturn("contextPath");

		String resultLingString = getValidationLink(stand, requestMock);
		String expectedLinkString = "http://url:1234contextPath/AdminEditStandServlet?editStandId=standId&editStandToken=standToken";

		assertEquals(expectedLinkString, resultLingString);
		verify(requestMock).isSecure();
		verify(requestMock).getServerName();
		verify(requestMock).getServerPort();
	}

	/**
	 * Standtoken er ikke lik editStandToken -> false
	 */
	@Test
	public void editLinkIsNOTValidTest() {
		String editStandToken = "Intentionally Different";
		String editStandId = "editStandId";

		when(standEAOMock.findStand(editStandId)).thenReturn(stand);

		assertFalse(editLinkIsValid(editStandId, editStandToken, standEAOMock, requestMock));
		verify(standEAOMock).findStand(editStandId);
	}

	/**
	 * Standtoken er lik editStandToken -> true
	 */
	@Test
	public void editLinkIsValidTest() {
		String editStandToken = "standToken";
		String editStandId = "editStandId";

		when(standEAOMock.findStand(editStandId)).thenReturn(stand);
		doNothing().when(requestMock).setAttribute("stand", stand);

		assertTrue(editLinkIsValid(editStandId, editStandToken, standEAOMock, requestMock));
		verify(standEAOMock).findStand(editStandId);
	}

}
