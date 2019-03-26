package no.hvl.dat109.expo.utils.test;

import javax.servlet.http.HttpServletRequest;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import no.hvl.dat109.expo.eao.InstituteEAO;
import no.hvl.dat109.expo.eao.StandEAO;
import no.hvl.dat109.expo.eao.StudyEAO;
import no.hvl.dat109.expo.entities.Stand;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import static no.hvl.dat109.expo.utils.AdminTasks.*;

public class AdminTasksTest {

//	@Mock
//	HttpServletRequest requestMock;
//
//	@Rule
//	public MockitoRule mockitoRule = MockitoJUnit.rule();

	
	/**
	 * Tester om riktig melding blir return når requesten sin "edit" parameter blir sjekket.
	 */
	@Test
	public void setupMessageConfirmingStandEditTest1() {

		HttpServletRequest requestMock = mock(HttpServletRequest.class);

		when(requestMock.getParameter("edit")).thenReturn("edited");
		String returnValue = setupMessageConfirmingStandEdit(requestMock);

		assertEquals(returnValue, "Endringene er lagret!");
		assertNotNull(returnValue);
		
		verify(requestMock).getParameter("edit");
	}
	
	/**
	 * Tester om riktig melding blir return når requesten sin "edit" parameter blir sjekket.
	 */
	@Test
	public void setupMessageConfirmingStandEditTest2() {

		HttpServletRequest requestMock = mock(HttpServletRequest.class);

		when(requestMock.getParameter("edit")).thenReturn("Something");
		String returnValue = setupMessageConfirmingStandEdit(requestMock);

		assertEquals(returnValue, "Stand fjernet fra databasen!");
		assertNotNull(returnValue);
		
		verify(requestMock).getParameter("edit");
	}
	
	/**
	 * Tester hva som ser skjer når request sin "edit" er null.
	 */
	@Test
	public void setupMessageConfirmingStandEditTestNull() {

		HttpServletRequest requestMock = mock(HttpServletRequest.class);

		when(requestMock.getParameter("edit")).thenReturn(null);
		String returnValue = setupMessageConfirmingStandEdit(requestMock);

		assertEquals(returnValue, "");
		assertNotNull(returnValue);
		
		verify(requestMock).getParameter("edit");
	}
	
	/**
	 * TODO
	 */
	@Test
	public void makeBrowseSelectionTest() {

		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		StandEAO StandEAOMock = mock(StandEAO.class);
		InstituteEAO InstituteEAOMock = mock(InstituteEAO.class);
		StudyEAO StudyEAOMock = mock(StudyEAO.class);

		when(requestMock.getParameter("selectedInstitute")).thenReturn(null);
		when(requestMock.getParameter("selectedStudy")).thenReturn(null);
		
		
//
//		assertEquals(returnValue, "");
//		assertNotNull(returnValue);
//		
//		verify(mockRequest).getParameter("edit");
	}
	
	@Test
	public void editStandFromDoPostTest() {

		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		StandEAO StandEAOMock = mock(StandEAO.class);
		Stand StandMock = mock(Stand.class);

		when(requestMock.getParameter("standId")).thenReturn("1");
		when(StandEAOMock.findStand("")).thenReturn(StandMock);
		when(requestMock.getParameter("editStand")).thenReturn("edit");
		when(requestMock.getParameter("standName")).thenReturn("Stand1");
		when(requestMock.getParameter("standAuthors")).thenReturn("Name1");
		
//
//		assertEquals(returnValue, "");
//		assertNotNull(returnValue);
//		
//		verify(mockRequest).getParameter("edit");
	}
	
	
}
