package no.hvl.dat109.expo.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema="exposystem",name="institute")
public class Institute {

    @Id
    private String instituteId;
    private String instituteName;


    @OneToMany(fetch= FetchType.LAZY)
    @JoinColumn(name="standid")
    private List<Stand> stands;


    public String getInstituteId() {
        return instituteId;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public List<Stand> getStands() {
        return stands;
    }
}
