package model;

import javax.persistence.*;
@Entity
@Table(name = "Opinion")
public class Opinion {


    @Id
    @GeneratedValue(generator = "gen5")
    @SequenceGenerator(name="gen5", sequenceName = "author_seq5")
    private int id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="person_id", referencedColumnName = "id")
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;

    @Column
    private String text;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }



}
