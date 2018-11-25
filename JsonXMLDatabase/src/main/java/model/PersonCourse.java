package model;

public class PersonCourse{


    private int id;
    private int idPerson;
    private int idCityCourse;
    private int idCourse;

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
