package creator;

import model.*;
import org.joda.time.DateTime;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Helper class which provides methods to create instances of hibernate.model classes
 */
public class ModelObjectsCreator {

    private Person emp;
    private Person emp2;
    private Person emp3;


    private Course course;
    private Course course2;

    private CourseCity courseCity;
    private CourseCity courseCity2;

    private Payments payment;
    private Payments payment2;
    private Payments payment3;
    private Payments payment4;

    private PersonCourse personCourse;
    private PersonCourse personCourse2;
    private PersonCourse personCourse3;
    private PersonCourse personCourse4;

    List<PersonCourse> personCoursesList;
    List<Payments> paymentsList;
    List<CourseCity> courseCityList;
    List<Course> courseList;
    List<Person> people;

    public List<PersonCourse> getPersonCoursesList() {
        return personCoursesList;
    }

    public void setPersonCoursesList(List<PersonCourse> personCoursesList) {
        this.personCoursesList = personCoursesList;
    }


    public List<Payments> getPaymentsList() {
        return paymentsList;
    }

    public List<CourseCity> getCourseCityList() {
        return courseCityList;
    }


    public Person getEmp3() {
        return emp3;
    }

    public Course getCourse() {
        return course;
    }

    public Course getCourse2() {
        return course2;
    }

    public List<Course> getCourseList() {
        return courseList;
    }


    public Person getEmp() {
        return emp;
    }

    public Person getEmp2() {
        return emp2;
    }

    public List<Person> getEmployees() {
        return people;
    }

    public void init(){
        emp = new Person();
        emp.setId(1);
        emp.setImie("Jan");
        emp.setNazwisko("Polak");
       // emp.setBirth(DateTime.now().minusYears(18));
        emp.setMiasto("Poznań");
        emp.setPesel("98030408259");

        emp2 = new Person();
        emp2.setId(2);
        emp2.setImie("Marian");
        emp2.setNazwisko("Wiejski");
       // emp2.setBirth(DateTime.now());
        emp2.setMiasto("Częstochowa");
        emp2.setPesel("98030401239");

        emp3 = new Person();
        emp3.setId(3);
        emp3.setImie("Marlena");
        emp3.setNazwisko("Zarzycka");
        //emp3.setBirth(DateTime.now().minusYears(20));
        emp3.setMiasto("Bolesławiec");
        emp3.setPesel("98072108123");

        people = new ArrayList<Person>();
        people.add(emp);
        people.add(emp2);
        people.add(emp3);

    }

    public void addCourse()
    {
        List<CourseCity> x = new ArrayList<>();
        x.add(courseCity2);
        x.add(courseCity);
        course = new Course();
        course.setId(1);
        course.setName("C# - poznaj to!");
        course.setHour(12);
       // course.setCities(x);

        List<CourseCity> x2 = new ArrayList<>();
        x2.add(courseCity2);
        course2 = new Course();
        course2.setId(2);
        course2.setName("Java - to Twoja przyszłość");
        course2.setHour(20);
        //course2.setCities(x2);

        courseList = new ArrayList<Course>();
        courseList.add(course);
        courseList.add(course2);

    }

    public void addCourseCity()
    {
        courseCity = new CourseCity();
        courseCity.setId(1);
        courseCity.setCity("Warszawa");

        courseCity2 = new CourseCity();
        courseCity2.setId(2);
        courseCity2.setCity("Poznań");


        courseCityList = new ArrayList<CourseCity>();
        courseCityList.add(courseCity);
        courseCityList.add(courseCity2);
    }

    public void addPayment()
    {
        payment = new Payments();
        payment.setId(1);
        payment.setIdPersonCourse(1);
        payment.setDayPayment(new DateTime(2018,10,15,0,0));
        payment.setMoney(350);

        payment2 = new Payments();
        payment2.setId(2);
        payment2.setIdPersonCourse(2);
        payment2.setDayPayment(new DateTime(2018,11,2,0,0));
        payment2.setMoney(520);

        payment3 = new Payments();
        payment3.setId(3);
        payment3.setIdPersonCourse(3);
        payment3.setDayPayment(new DateTime(2018,9,12,0,0));
        payment3.setMoney(1110);

        payment4 = new Payments();
        payment4.setId(4);
        payment4.setIdPersonCourse(4);
        payment4.setDayPayment(new DateTime(2018,12,12,0,0));
        payment4.setMoney(3550);

        paymentsList = new ArrayList<>();
        paymentsList.add(payment);
        paymentsList.add(payment2);
        paymentsList.add(payment3);
        paymentsList.add(payment4);

    }

    public void addPersonCourse()
    {

        personCourse = new PersonCourse();
        personCourse.setId(1);
        personCourse.setIdPerson(1);
        personCourse.setIdCityCourse(1);
        personCourse.setIdCourse(1);

        personCourse2 = new PersonCourse();
        personCourse2.setId(2);
        personCourse2.setIdPerson(3);
        personCourse2.setIdCityCourse(2);
        personCourse2.setIdCourse(2);

        personCourse3 = new PersonCourse();
        personCourse3.setId(3);
        personCourse3.setIdPerson(2);
        personCourse3.setIdCityCourse(1);
        personCourse3.setIdCourse(2);

        personCourse4 = new PersonCourse();
        personCourse4.setId(4);
        personCourse4.setIdPerson(3);
        personCourse4.setIdCityCourse(2);
        personCourse4.setIdCourse(1);

        personCoursesList = new ArrayList<>();
        personCoursesList.add(personCourse);
        personCoursesList.add(personCourse2);
        personCoursesList.add(personCourse3);
        personCoursesList.add(personCourse4);


    }

    public ModelObjectsCreator(){
        init();
        addCourseCity();
        addCourse();
        addPersonCourse();
        addPayment();

    }


}
