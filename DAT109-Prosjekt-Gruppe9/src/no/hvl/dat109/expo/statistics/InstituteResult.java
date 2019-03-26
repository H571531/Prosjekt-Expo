package no.hvl.dat109.expo.statistics;

import no.hvl.dat109.expo.entities.Institute;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author
 *
 */
public class InstituteResult {

    private List<StandResult> standResults;

    private Institute institute;

    /**
     * Lager et nytt resultat objekt for et institutt
     * @param List<StandResult> standResults resultatene for stands
     * @param Institute institute hvilket institutt standene er fra
     */
    protected InstituteResult(List<StandResult> standResults, Institute institute) {
        this.standResults = standResults;
        this.institute = institute;
    }

    /**
     * Henter ut de beste standene i en liste av standresultater basert på snittet.
     * @param Integer limit angir hvor mange du vil ha med i toppresultatene
     * @return
     */
    public List<StandResult> getTopStandsMean(Integer limit){
        return standResults.stream()
                .filter(x -> x.getVotes().size() >= Result.MINSTE_ANTALL_STEMMER)
                .sorted(Comparator.comparing(x -> -x.getWeightedAverage()))
                .limit(limit)
                .collect(Collectors.toList());
    }
    /**
     * Henter ut de beste standene i en liste av standresultater basert på total antall poeng.
     * @param Integer limit angir hvor mange du vil ha med i toppresultatene
     * @return
     */
    public List<StandResult> getTopStandsTotal(Integer limit){
        return standResults.stream()
                .filter(x -> x.getVotes().size() >= Result.MINSTE_ANTALL_STEMMER)
                .sorted(Comparator.comparing(x -> -x.getTotalPoints()))
                .limit(limit)
                .collect(Collectors.toList());
    }

    /**
     * Henter instituttet for et resultat
     * @return Institute institute for et resultat av stemmer paa stands
     */
    public Institute getInstitute() {
        return institute;
    }

    /**
     * Henter resultatene for et institutt og returnerer en liste over disse
     * @return List<StandResult> liste over resultater for stands til instituttet
     */
    public List<StandResult> getStandResults() {
        return standResults;
    }
}
