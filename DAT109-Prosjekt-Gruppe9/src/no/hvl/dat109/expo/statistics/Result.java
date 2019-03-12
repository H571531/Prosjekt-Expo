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
    private final Integer MINSTE_ANTALL_STEMMER = 5;
    private List<Vote> votes;
    private List<StandResult> results;
    public List<Vote> getVotes() {
        return votes;
    }

    public Result(List<Vote> votes) {
        // Går igjenom alle stemmene og lager en liste over StandResult
        Map<Stand,List<Vote>> stands = votes.stream().collect(Collectors.groupingBy(Vote::getStand));
        this.results = stands.entrySet().stream()
                .map(x -> new StandResult(x.getKey(),x.getValue()))
                .collect(Collectors.toList());

        this.votes = votes;
    }

    // Baserer seg på gjennomsnitt
    public List<StandResult> getTopStands(Integer limit){


        return results.stream()
                .filter(x -> x.getVotes().size() >= MINSTE_ANTALL_STEMMER)
                .sorted(Comparator.comparing(x -> -x.getWeightedAverage()))
                .limit(limit)
                .collect(Collectors.toList());
    }

}

