package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COURSE")
public class Course
{

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "nazwa")
    private String name;
    @Column(name = "godziny")
    private int hour;
    @Column(name = "miasta")
    private List<CourseCity> cities;

    public void addToList(CourseCity a)
    {
        cities.add(a);
    }
    public List<CourseCity> getCities() {
        return cities;
    }

    public void setCities(List<CourseCity> cities) {
        this.cities = cities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



}
