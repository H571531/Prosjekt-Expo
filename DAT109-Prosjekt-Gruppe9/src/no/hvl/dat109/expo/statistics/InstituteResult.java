package no.hvl.dat109.expo.statistics;

import no.hvl.dat109.expo.entities.Institute;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class InstituteResult {

    private List<StandResult> standResults;
    private Institute institute;

    protected InstituteResult(List<StandResult> standResults, Institute institute) {
        this.standResults = standResults;
        this.institute = institute;
    }

    public List<StandResult> getTopStands(Integer limit){
        return standResults.stream()
                .filter(x -> x.getVotes().size() >= Result.MINSTE_ANTALL_STEMMER)
                .sorted(Comparator.comparing(x -> -x.getWeightedAverage()))
                .limit(limit)
                .collect(Collectors.toList());
    }

    public Institute getInstitute() {
        return institute;
    }

    public List<StandResult> getStandResults() {
        return standResults;
    }
}
