package model;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.joda.time.DateTime;

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

    @Column
    private String miasto;

    @JsonIgnore
    @Column(nullable = false, unique = true)
    private String pesel;

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

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }


}
