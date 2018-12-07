package model;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"pesel"})})
public class Person
{
    @Id @GeneratedValue
    @Column
    private int id;

    @Column
    private String imie;

    @Column
    private String nazwisko;



    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="add_id", referencedColumnName = "id")
    Address adres;

    @Column(nullable = false, unique = true)
    private String pesel;

    @JsonIgnore
    public String getAllInformation()
    {
        return imie + " " + nazwisko + " " + adres.getMiasto() + " " + adres.getUlica() + " " +  adres.getNumer() + " " + pesel;
    }

  /* @ManyToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Course> courses = new ArrayList<Course>();

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }*/
   // @Column(name="data urodzenia")
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    //private DateTime birth;


   /* public DateTime getBirth() {
        return birth;
    }

    public void setBirth(DateTime birth) {
        this.birth = birth;
    }

*/
   public Address getAdres() {
       return adres;
   }

    public void setAdres(Address adres) {
        this.adres = adres;
    }

   public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }


}
