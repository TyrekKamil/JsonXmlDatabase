package creator;

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

    Person emp;
    Person emp2;

    List<Person> people;

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
        emp2.setBirth(DateTime.now().minusMonths(150));
        emp2.setMiasto("Częstochowa");
        emp2.setPesel("98030401239");

        people = new ArrayList<Person>();
        people.add(emp);
        people.add(emp2);

    }

    public ModelObjectsCreator(){
        init();
    }


}
