package no.hvl.dat109.expo.utils.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;

import no.hvl.dat109.expo.eao.VoteEAO;
import no.hvl.dat109.expo.entities.Expo;
import no.hvl.dat109.expo.entities.Stand;
import no.hvl.dat109.expo.entities.Study;
import no.hvl.dat109.expo.entities.Visitor;
import no.hvl.dat109.expo.entities.Vote;
import static no.hvl.dat109.expo.utils.VoteUtils.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class VoteUtilsTest {

	private Study study;
	private Expo expo;
	private Stand stand;
	private VoteEAO voteEAO;
	Optional<Visitor> visitor;
	private Vote realVote;
	private Stand standMock;
	private List<Vote> votedfor;

	@Before
	public void init() {
		visitor = Optional.of(new Visitor("visitorID", "visitorToken"));
		study = new Study();
		expo = new Expo();
		stand = new Stand("standName", "standId", study, expo, "standAuthors", "standToken");
		voteEAO = new VoteEAO();
		realVote = new Vote("1", stand, visitor.get());
		standMock = mock(Stand.class);
		votedfor = new ArrayList<Vote>();
	}
	
	
	@Test
	public void handleVoteTest() {
//		TODO 
//		Inneholer Static
	}

	/**
	 * if visitor vote in database -> return true
	 */
	@Test
	public void visitorHasAlreadyVotedForStandTest() {

		votedfor.add(realVote);
		visitor.get().setVotedfor(votedfor);

		assertTrue(visitorHasAlreadyVotedForStand(visitor, stand, voteEAO));
	}
	
	/**
	 * Hasn't voted for stand -> return false
	 */
	@Test
	public void visitorHasAlreadyVotedForStandFailureTest() {

		Vote anotherStand = new Vote("1", standMock, visitor.get());
		
		votedfor.add(anotherStand);
		visitor.get().setVotedfor(votedfor);

		assertFalse(visitorHasAlreadyVotedForStand(visitor, stand, voteEAO));
	}

}
