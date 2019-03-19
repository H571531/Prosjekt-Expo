package no.hvl.dat109.expo.entities;


import javax.persistence.*;
import java.util.List;

/**
 * @author
 *
 */
@Entity
@Table(schema="exposystem",name="institute")
public class Institute {
    @Id
    private String instituteid;
    private String institutename;
    
    @OneToMany(mappedBy="institute", fetch=FetchType.EAGER)
    private List<Study> studies;
    
    /**
     * Henter id'en til et institutt
     * @return String instituteid id til instituttet
     */
    public String getInstituteid() {
        return instituteid;
    }

    /**
     * Henter navnent til et institutt
     * @return String institutename navnet til instituttet
     */
    public String getInstitutename() {
        return institutename;
    }
    
    /**
     * Henter studiene til et institutt og returnerer en liste over disse
     * @return List<Study> liste over studiene til et institutt
     */
    public List<Study> getStudies(){
    	return studies;
    }

    // Egen hashCode metode for institutt objekt
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((instituteid == null) ? 0 : instituteid.hashCode());
		return result;
	}

	// Egen equals metode for institutt objekt
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Institute other = (Institute) obj;
		if (instituteid == null) {
			if (other.instituteid != null)
				return false;
		} else if (!instituteid.equals(other.instituteid))
			return false;
		return true;
	}
    
    
}
