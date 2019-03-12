package no.hvl.dat109.expo.eao;


import no.hvl.dat109.expo.entities.Faculty;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class FacultyEAO {

    @PersistenceContext(name = "expoPU")
    private EntityManager em;

    public List<Faculty> findAllFaculty(){
        return em.createQuery("SELECT f from Faculty f",Faculty.class).getResultList();
    }

    public Faculty findFaculty(String facultyId) {
        return em.find(Faculty.class, facultyId);
    }

    public boolean facultyExists(String facultyId) {
        return (findFaculty(facultyId) != null);
    }

    public void addFaculty(Faculty faculty) {
        em.persist(faculty);
    }

}
