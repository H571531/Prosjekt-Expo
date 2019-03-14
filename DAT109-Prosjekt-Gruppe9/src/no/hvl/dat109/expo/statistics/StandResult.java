package no.hvl.dat109.expo.statistics;

import no.hvl.dat109.expo.entities.Institute;
import no.hvl.dat109.expo.entities.Study;
import no.hvl.dat109.expo.entities.Stand;
import no.hvl.dat109.expo.entities.Vote;

import java.util.List;

/**
 * @author
 *
 */
public class StandResult {

    // Liste over all stemmene standen har fått
    private List<Vote> votes;
    private Stand stand;
    /*
        Teller opp hvor mange av hver poengvekt som standen har fått
    private List<Integer> voteCounts;
    */

    /**
     * Lager et nytt resultat for en stand
     * @param Stand stand som skal lages et resultat for
     * @param List<Vote> votes liste over stemmer for standen
     */
    protected StandResult(Stand stand, List<Vote> votes) {
        this.votes = votes;
        this.stand = stand;
    }

    /**
     * Teller stemmer for standen og gir en poengsum
     * @return Integer acc poengsum for standen
     */
    public Integer getTotalPoints(){
        Integer acc = 0;
        for(Vote vote : votes){
            acc += vote.getVoteValue();
        }
        return acc;
    }

    /**
     * Henter gjennomsnittet av vekt paa stemmer for standen
     * @return Double average gjennomsnittet av poeng for standen
     */
    public Double getWeightedAverage(){
        return getTotalPoints().doubleValue() / votes.size();
    }

    /**
     * Henter alle stemmene for standen og returnerer en liste over disse
     * @return List<Vote> liste over stemmer for en stand
     */
    public List<Vote> getVotes() {
        return votes;
    }

    /**
     * Henter standen for et resultat
     * @return Stand stand som har resultatet
     */
    public Stand getStand() {
        return stand;
    }

    /**
     * Henter studiet som standen er fra for resultatet
     * @return Study study studiet som standen er fra
     */
    public Study getStudy(){
        return stand.getStudy();
    }

    /**
     * Henter instituttet som standen er fra for resultatet
     * @return
     */
    public Institute getInstitute(){
        return stand.getStudy().getInstitute();
    }


}
