package no.hvl.dat109.expo.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema="exposystem",name="faculty")
public class Faculty {

    @Id
    private String facultyId;
    private String facultyName;


    @OneToMany(fetch= FetchType.LAZY)
    @JoinColumn(name="standid")
    private List<Stand> stands;


    public String getFacultyId() {
        return facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public List<Stand> getStands() {
        return stands;
    }
}
