package no.hvl.dat109.expo.statistics;

import no.hvl.dat109.expo.entities.Faculty;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FacultyResult {

    private List<StandResult> standResults;
    private Faculty faculty;

    protected FacultyResult(List<StandResult> standResults, Faculty faculty) {
        this.standResults = standResults;
        this.faculty = faculty;
    }

    public List<StandResult> getTopStands(Integer limit){
        return standResults.stream()
                .filter(x -> x.getVotes().size() >= Result.MINSTE_ANTALL_STEMMER)
                .sorted(Comparator.comparing(x -> -x.getWeightedAverage()))
                .limit(limit)
                .collect(Collectors.toList());
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public List<StandResult> getStandResults() {
        return standResults;
    }
}
