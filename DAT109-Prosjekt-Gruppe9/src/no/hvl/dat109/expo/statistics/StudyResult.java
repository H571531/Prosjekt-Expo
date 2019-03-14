package no.hvl.dat109.expo.statistics;

import no.hvl.dat109.expo.entities.Study;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author
 *
 */
public class StudyResult {

    private List<StandResult> standResults;
    private Study study;

    /**
     * Lager et nytt resultat for et studie
     * @param List<StandResult> standResults liste over stand sine resultater som er fra studiet
     * @param Study study studiet som har standene
     */
    protected StudyResult(List<StandResult> standResults, Study study) {
        this.standResults = standResults;
        this.study = study;
    }

    /**
     * Henter ut de beste standene i en liste av standresultater
     * @param Integer limit angir hvor mange du vil ha med i toppresultatene
     * @return
     */
    public List<StandResult> getTopStands(Integer limit){
        return standResults.stream()
                .filter(x -> x.getVotes().size() >= Result.MINSTE_ANTALL_STEMMER)
                .sorted(Comparator.comparing(x -> -x.getWeightedAverage()))
                .limit(limit)
                .collect(Collectors.toList());
    }

    /**
     * Henter studiet for et studieresultat
     * @return Study study som fikk resultatet
     */
    public Study getStudy() {
        return study;
    }

    /**
     * Henter resultatene fra alle stands fra studiet og returnerer en liste over disse
     * @return List<StandResult> liste over stand sine resultater
     */
    public List<StandResult> getStandResults() {
        return standResults;
    }
}
