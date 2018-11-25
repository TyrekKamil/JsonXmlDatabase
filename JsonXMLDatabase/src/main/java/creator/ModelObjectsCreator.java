package creator;

import model.Course;
import model.CourseCity;
import model.Payments;
import model.Person;
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


    List<Payments> paymentsList;
    List<CourseCity> courseCityList;
    List<Course> courseList;
    List<Person> people;


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
        emp.setBirth(DateTime.now().minusYears(18));
        emp.setMiasto("Poznań");
        emp.setPesel("98030408259");

        emp2 = new Person();
        emp2.setId(2);
        emp2.setImie("Marian");
        emp2.setNazwisko("Wiejski");
        emp2.setBirth(DateTime.now());
        emp2.setMiasto("Częstochowa");
        emp2.setPesel("98030401239");

        emp3 = new Person();
        emp3.setId(3);
        emp3.setImie("Marlena");
        emp3.setNazwisko("Zarzycka");
        emp3.setBirth(DateTime.now().minusYears(20));
        emp3.setMiasto("Bolesławiec");
        emp3.setPesel("98072108123");

        people = new ArrayList<Person>();
        people.add(emp);
        people.add(emp2);
        people.add(emp3);

    }

    public void addCourse()
    {
        course = new Course();
        course.setId(1);
        course.setName("C# - poznaj to!");
        course.setHour(12);

        course2 = new Course();
        course2.setId(2);
        course2.setName("Java - to Twoja przyszłość");
        course2.setHour(20);

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
        courseCity.setCity("Poznań");
        courseCity.setId(2);

        courseCityList = new ArrayList<CourseCity>();
        courseCityList.add(courseCity);
        courseCityList.add(courseCity2);
    }

   /* public void addPayment()
    {

    }
*/
    public ModelObjectsCreator(){
        init();
        addCourse();
        addCourseCity();
    }


}
