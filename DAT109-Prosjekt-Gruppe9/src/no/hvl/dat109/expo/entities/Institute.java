package no.hvl.dat109.expo.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="exposystem",name="institute")
public class Institute {
    @Id
    private String instituteid;
    private String institutename;

    public String getInstituteid() {
        return instituteid;
    }

    public String getInstitutename() {
        return institutename;
    }
}
