package no.hvl.dat109.expo.entities;


import javax.persistence.*;
import java.util.List;

/**
 * @author
 *
 */
@Entity
@Table(schema="exposystem",name="study")
public class Study {

    @Id
    private String studyid;
    private String studyname;

    @ManyToOne
    @JoinColumn(name="instituteid")
    private Institute institute;


	@OneToMany(mappedBy="study", fetch=FetchType.EAGER)
    private List<Stand> stands;

    /**
     * Henter id'en til et studie
     * @return String studyid id'en til et studie
     */
    public String getStudyid() {
        return studyid;
    }

    /**
     * Henter navnet til et studie
     * @return String studyname navnet til et studie
     */
    public String getStudyname() {
        return studyname;
    }

    /**
     * Henter alle stands til et study og returnerer et List objekt over disse
     * @return List<Stand> liste liste over alle stands til studiet
     */
    public List<Stand> getStands() {
        return stands;
    }

    /**
     * Henter instituttet til studiet
     * @return Institute institute instituttet til studiet
     */
    public Institute getInstitute() {
        return institute;
    }

    // Study sin egen hashCode metode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((studyid == null) ? 0 : studyid.hashCode());
		return result;
	}

	// Study sin egen equals metode
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Study other = (Study) obj;
		if (studyid == null) {
			if (other.studyid != null)
				return false;
		} else if (!studyid.equals(other.studyid))
			return false;
		return true;
	}
    
    
    
}
