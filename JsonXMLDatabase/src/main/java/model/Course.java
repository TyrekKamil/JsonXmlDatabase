package model;

import java.util.List;

public class Course
{

    private int id;
    private String name;
    private int hour;
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
