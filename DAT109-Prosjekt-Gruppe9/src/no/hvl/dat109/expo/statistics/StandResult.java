package no.hvl.dat109.expo.statistics;

import no.hvl.dat109.expo.entities.Institute;
import no.hvl.dat109.expo.entities.Stand;
import no.hvl.dat109.expo.entities.Vote;

import java.util.List;

public class StandResult {

    // Liste over all stemmene standen har fått
    private List<Vote> votes;
    private Stand stand;
    /*
        Teller opp hvor mange av hver poengvekt som standen har fått
    private List<Integer> voteCounts;
    */

    protected StandResult(Stand stand, List<Vote> votes) {
        this.votes = votes;
        this.stand = stand;
    }

    public Integer getTotalPoints(){
        Integer acc = 0;
        for(Vote vote : votes){
            acc += vote.getVoteValue();
        }
        return acc;
    }

    public Double getWeightedAverage(){
        return getTotalPoints().doubleValue() / votes.size();
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public Stand getStand() {
        return stand;
    }

    public Institute getIntitute(){
        return stand.getInstitute();
    }
}
