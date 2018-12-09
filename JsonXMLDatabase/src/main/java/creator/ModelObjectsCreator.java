package creator;

import model.*;
import org.joda.time.DateTime;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Helper class which provides methods to create instances of hibernate.model classes
 */
public class ModelObjectsCreator {


    private Person emp;
    private Person emp2;
    private Person emp3;

    private Address adr1;
    private Address adr2;
    private Address adr3;
    private Address adr4;
    private Address adr5;

    private Course course1;
    private Course course2;
    private Course course3;

    private Opinion opinion1;
    private Opinion opinion2;

    private Speaker speaker1;
    private Speaker speaker2;
    List<Address> addresses;
    List<Course> courses;
    List<Opinion> opinions;
    List<Person> people;
    List<Speaker> speakers;
    public List<Address> getAddresses() {
        return addresses;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Opinion> getOpinions() {
        return opinions;
    }

    public List<Person> getPeople() {
        return people;
    }

    public List<Speaker> getSpeakers() {
        return speakers;
    }
    public void init(){

        //=================ADRES=======================================\\
        adr1 = new Address();
        adr1.setMiasto("Poznań");
        adr1.setNumer("12A");
        adr1.setUlica("Wrocławska");

        adr2 = new Address();
        adr2.setMiasto("Szczecin");
        adr2.setUlica("Malwinowska");
        adr2.setNumer("61");

        adr3 = new Address();
        adr3.setMiasto("Bolesławiec");
        adr3.setUlica("Marlenkowa");
        adr3.setNumer("123");

        adr4 = new Address();
        adr4.setMiasto("Warszawa");
        adr4.setUlica("Wiejska");
        adr4.setNumer("4/6/8");

        adr5 = new Address();
        adr5.setMiasto("Wrocław");
        adr5.setNumer("15G");
        adr5.setUlica("Miejska");

        addresses = new ArrayList<Address>();
        addresses.add(adr1);
        addresses.add(adr2);
        addresses.add(adr3);
        addresses.add(adr4);
        addresses.add(adr5);

//==============SPEAKER=================================\\
        course1 = new Course();
        course2 = new Course();
        course3 = new Course();

        List<Course> speaker1Course = new ArrayList<Course>();
        List<Course> speaker2Course = new ArrayList<Course>();
        speaker1Course.add(course1);
        speaker1Course.add(course3);
        speaker2Course.add(course2);

        speaker1 = new  Speaker();
        speaker1.setImie("Adam");
        speaker1.setNazwisko("Nowak");
        speaker1.setPesel("87121209012");
        speaker1.setAdres(adr4);


        speaker2 = new Speaker();
        speaker2.setImie("Mariusz");
        speaker2.setNazwisko("Wierzbicki");
        speaker2.setPesel("85110909122");
        speaker2.setAdres(adr5);

        speakers = new ArrayList<Speaker>();
        speakers.add(speaker1);
        speakers.add(speaker2);



//==============COURSE=================================\\

        course1.setName("Java - wygraj życie!");
        course1.setHour(25);
        course1.setSpeaker(speaker1);

        course2.setName("C# - krok po kroku");
        course2.setHour(20);
        course2.setSpeaker(speaker2);

        course3.setName("Java - jak ją poznać?");
        course3.setHour(15);
        course3.setSpeaker(speaker1);

        speaker1.setCourse(speaker1Course);
        speaker2.setCourse(speaker2Course);

        courses = new ArrayList<Course>();
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);

//==============PERSON=================================\\

        List<Course> coursesPerson1 = new ArrayList<>();
        List<Course> coursesPerson2 = new ArrayList<>();
        List<Course> coursesPerson3 = new ArrayList<>();

        coursesPerson1.add(course1);
        coursesPerson1.add(course2);
        coursesPerson3.add(course3);
        coursesPerson2.add(course1);
        coursesPerson3.add(course2);
        coursesPerson3.add(course3);

        emp = new Person();
        emp.setImie("Jan");
        emp.setNazwisko("Polak");
        emp.setAdres(adr1);
        emp.setPesel("98030408259");
        emp.setDate(new DateTime(1991-5-12));

        emp2 = new Person();
        emp2.setImie("Marian");
        emp2.setNazwisko("Wiejski");
        emp2.setAdres(adr2);
        emp2.setPesel("98030401239");
        emp2.setDate(new DateTime(1990-12-12));

        emp3 = new Person();
        emp3.setImie("Marlena");
        emp3.setNazwisko("Zarzycka");
        emp3.setAdres(adr3);
        emp3.setPesel("98072108123");
        emp3.setDate(new DateTime(1998-7-21));

        people = new ArrayList<Person>();
        people.add(emp);
        people.add(emp2);
        people.add(emp3);
//==============Opinions=================================\\

        List<Opinion> opinionsOfCourse1 = new ArrayList<Opinion>();
        List<Opinion> opinionsOfCourse2 = new ArrayList<Opinion>();

        opinion1 = new Opinion();
        opinion2 = new Opinion();

        opinion1.setPerson(emp);
        opinion1.setCourse(course1);
        opinion1.setText("super kurs!");
        opinionsOfCourse1.add(opinion1);

        opinion2.setPerson(emp3);
        opinion2.setCourse(course2);
        opinion2.setText("za duzo teorii, za malo praktyki");
        opinionsOfCourse2.add(opinion2);

        opinions = new ArrayList<Opinion>();
        opinions.add(opinion1);
        opinions.add(opinion2);

        course1.setOpinions(opinionsOfCourse1);
        course2.setOpinions(opinionsOfCourse2);


    }


    public ModelObjectsCreator(){
        init();

    }


}
