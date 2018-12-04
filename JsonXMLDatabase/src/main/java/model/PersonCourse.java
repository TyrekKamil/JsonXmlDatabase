/*package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PERSONCOURSE")
public class PersonCourse{



    @Id
    @GeneratedValue(generator = "gen3")
    @SequenceGenerator(name="gen3", sequenceName = "author_seq3")
    @Column
    private int id;
    @Column
    private List<Person> person = new ArrayList<Person>();
    @Column
    private List<Course> course = new ArrayList<Course>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }


    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public int getIdCityCourse() {
        return idCityCourse;
    }

    public void setIdCityCourse(int idCityCourse) {
        this.idCityCourse = idCityCourse;
    }
}
*/