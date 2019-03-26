package no.hvl.dat109.expo.statistics;


// Jeg er usikker på om jeg vil putte denne klassen i entities pakken.
// Hvis noen vil flytte den står dere fritt til å gjøre det

import no.hvl.dat109.expo.entities.Stand;
import no.hvl.dat109.expo.entities.Vote;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author
 *
 */
public class Result {
    // Flytt denne.
    protected static final Integer MINSTE_ANTALL_STEMMER = 1;
    private List<Vote> votes;
    private List<StandResult> standResults;
    private List<StudyResult> studyResults;
    private List<InstituteResult> instituteResults;

    /**
     * Henter alle stemmer og returnerer en liste over disse
     * @return List<Vote> liste over alle stemmer
     */
    public List<Vote> getVotes() {
        return votes;
    }

    /**
     * Lager et nytt resultat for en expo
     * @param List<Vote> votes alle stemmene for ett expo
     */
    public Result(List<Vote> votes) {
        // Går igjenom alle stemmene og lager en liste over StandResult
        Map<Stand,List<Vote>> stands = votes.stream().collect(Collectors.groupingBy(Vote::getStand));
        this.standResults = stands.entrySet().stream()
                .map(x -> new StandResult(x.getKey(),x.getValue()))
                .collect(Collectors.toList());


        this.studyResults =  standResults.stream()
                .collect(Collectors.groupingBy(StandResult::getStudy))
                .entrySet()
                .stream()
                .map(x -> new StudyResult(x.getValue(),x.getKey()))
                .collect(Collectors.toList());

        this.instituteResults =  standResults.stream()
                .collect(Collectors.groupingBy(StandResult::getInstitute))
                .entrySet()
                .stream()
                .map(x -> new InstituteResult(x.getValue(),x.getKey()))
                .collect(Collectors.toList());

        this.votes = votes;
    }

    /**
     * Henter alle stand resultater og returnerer en liste over disse
     * @return List<StandResult> liste over alle standresultater
     */
    public List<StandResult> getStandResults() {
        return standResults;
    }

    /**
     * Henter alle studieresultater og returnerer en liste over disse
     * @return List<StudyResult> liste over alle studieresultater
     */
    public List<StudyResult> getStudyResults() {
        return studyResults;
    }

    /**
     * Henter alle instituttresultater og returnerer en liste over disse
     * @return List<InstituteResult> liste over alle instituttresultater 
     */
    public List<InstituteResult> getInstituteResults() {
        return instituteResults;
    }

    /**
     * Finner de beste standene for hele expoen og returnerer en liste over disse
     * @param Integer limit angir hvor mange du vil ha med i toppresultatene
     * @return
     */
    // Baserer seg på gjennomsnitt
    public List<StandResult> getTopStandsMean(Integer limit){
        return standResults.stream()
                .filter(x -> x.getVotes().size() >= MINSTE_ANTALL_STEMMER)
                .sorted(Comparator.comparing(x -> -x.getWeightedAverage()))
                .limit(limit)
                .collect(Collectors.toList());
    }

    public List<StandResult> getTopStandsTotal(Integer limit){
        return standResults.stream()
                .filter(x -> x.getVotes().size() >= MINSTE_ANTALL_STEMMER)
                .sorted(Comparator.comparing(x -> -x.getTotalPoints()))
                .limit(limit)
                .collect(Collectors.toList());
    }


}

