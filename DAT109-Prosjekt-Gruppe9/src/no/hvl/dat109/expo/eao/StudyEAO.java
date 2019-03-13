package no.hvl.dat109.expo.eao;


import no.hvl.dat109.expo.entities.Study;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class StudyEAO {

    @PersistenceContext(name = "expoPU")
    private EntityManager em;

    public List<Study> findAllStudy(){
        return em.createQuery("SELECT i from Study i", Study.class).getResultList();
    }

    public Study findStudy(String studyId) {
        return em.find(Study.class, studyId);
    }

    public boolean studyExist(String studyId) {
        return (findStudy(studyId) != null);
    }

    public void addStudy(Study study) {
        em.persist(study);
    }

}
