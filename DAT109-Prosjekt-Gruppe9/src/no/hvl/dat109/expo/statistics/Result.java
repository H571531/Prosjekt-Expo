package no.hvl.dat109.expo.statistics;


// Jeg er usikker på om jeg vil putte denne klassen i entities pakken.
// Hvis noen vil flytte den står dere fritt til å gjøre det

import no.hvl.dat109.expo.entities.Stand;
import no.hvl.dat109.expo.entities.Vote;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Result {
    // Flytt denne.
    protected static final Integer MINSTE_ANTALL_STEMMER = 5;
    private List<Vote> votes;
    private List<StandResult> standResults;
    private List<StudyResult> studyResults;

    public List<Vote> getVotes() {
        return votes;
    }

    public Result(List<Vote> votes) {
        // Går igjenom alle stemmene og lager en liste over StandResult
        Map<Stand,List<Vote>> stands = votes.stream().collect(Collectors.groupingBy(Vote::getStand));
        this.standResults = stands.entrySet().stream()
                .map(x -> new StandResult(x.getKey(),x.getValue()))
                .collect(Collectors.toList());


        this.studyResults =  standResults.stream()
                .collect(Collectors.groupingBy(StandResult::getIntitute))
                .entrySet()
                .stream()
                .map(x -> new StudyResult(x.getValue(),x.getKey()))
                .collect(Collectors.toList());

        this.votes = votes;
    }

    public List<StandResult> getStandResults() {
        return standResults;
    }

    public List<StudyResult> getStudyResults() {
        return studyResults;
    }

    // Baserer seg på gjennomsnitt
    public List<StandResult> getTopStands(Integer limit){
        return standResults.stream()
                .filter(x -> x.getVotes().size() >= MINSTE_ANTALL_STEMMER)
                .sorted(Comparator.comparing(x -> -x.getWeightedAverage()))
                .limit(limit)
                .collect(Collectors.toList());
    }

}

