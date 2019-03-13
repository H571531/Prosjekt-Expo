package no.hvl.dat109.expo.statistics;

import no.hvl.dat109.expo.entities.Study;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudyResult {

    private List<StandResult> standResults;
    private Study study;

    protected StudyResult(List<StandResult> standResults, Study study) {
        this.standResults = standResults;
        this.study = study;
    }

    public List<StandResult> getTopStands(Integer limit){
        return standResults.stream()
                .filter(x -> x.getVotes().size() >= Result.MINSTE_ANTALL_STEMMER)
                .sorted(Comparator.comparing(x -> -x.getWeightedAverage()))
                .limit(limit)
                .collect(Collectors.toList());
    }

    public Study getStudy() {
        return study;
    }

    public List<StandResult> getStandResults() {
        return standResults;
    }
}
