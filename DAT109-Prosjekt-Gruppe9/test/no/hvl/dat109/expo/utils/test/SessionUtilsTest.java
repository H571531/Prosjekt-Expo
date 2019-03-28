package no.hvl.dat109.expo.utils.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;

import static no.hvl.dat109.expo.utils.SessionUtils.*;

public class SessionUtilsTest {
	
	private HttpServletRequest requestMock;
	private HttpSession sessionMock;
	private String attribute;
	
	@Before
    public void init() {
		requestMock = mock(HttpServletRequest.class);
		sessionMock = mock(HttpSession.class);
		attribute = "attributeString";
    }
	
	
	/**
	 *  session == null -> return Optional.empty()
	 */
	@Test
	public void getSessionNoSessionTest() {
		sessionMock = null;
		
		when(requestMock.getSession(false)).thenReturn(sessionMock);
		
		
		Optional<HttpSession> session = getSession(requestMock);
		assertFalse(session.isPresent());
	}
	
	/**
	 * session != null -> return session
	 */
	@Test
	public void getSessionTest() {
		
		when(requestMock.getSession(false)).thenReturn(sessionMock);
		
		Optional<HttpSession> session = getSession(requestMock);
		assertTrue(session.isPresent());
	}
	
	/**
	 * session == null -> returns Optional.empty();
	 */
	@Test
	public void getSessionParameterNoSessionTest() {
		sessionMock = null;
		
		when(requestMock.getSession(false)).thenReturn(sessionMock);
		
		Optional<HttpSession> session = getSessionParameter(requestMock, attribute);
		assertFalse(session.isPresent());
	}
	
	
	/**
	 * session != null -> returns Object parameter
	 */
	@Test
	public void getSessionParameterTest() {
		
		
		when(requestMock.getSession(false)).thenReturn(sessionMock);
		when(sessionMock.getAttribute(attribute)).thenReturn(attribute);
		
		Object object = getSessionParameter(requestMock, attribute);
		Optional<Object> optAttribute = Optional.of(attribute);
		assertEquals(object, optAttribute);
	}
	
	/**
	 * session == null -> return false
	 */
	@Test
	public void sessionContainsTestAgainstNull() {
		sessionMock = null;
		
		when(requestMock.getSession(false)).thenReturn(sessionMock);
		
		assertFalse(sessionContains(requestMock, attribute));
	}
	
	/**
	 * session == null -> return false
	 */
	@Test
	public void sessionContainsTest() {
		
		when(requestMock.getSession(false)).thenReturn(sessionMock);
		when(sessionMock.getAttribute(attribute)).thenReturn(attribute);
		
		assertTrue(sessionContains(requestMock, attribute));
	}

}
