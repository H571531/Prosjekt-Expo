package no.hvl.dat109.expo.statistics.test;

import org.junit.After;
import org.junit.Before;

import no.hvl.dat109.expo.entities.Vote;

public class ResultTestSetup {
	
	
	@Before
	public void setUp() {
		Vote vote1 = new Vote();
		Vote vote2 = new Vote();
		Vote vote3 = new Vote();
		Vote vote4 = new Vote();
		Vote vote5 = new Vote();
	}
	
	@After
	public void tearDown() {
		
	}

}
