package lambadas;

import model.Person;
import org.joda.time.DateTime;
import creator.ModelObjectsCreator;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOperations {

    public static void main(String[] args) throws IOException {

        ModelObjectsCreator objectsCreator = new ModelObjectsCreator();

        List<Person> employeeList = new ArrayList<>();

        employeeList.add(objectsCreator.getEmp());
        employeeList.add(objectsCreator.getEmp2());
        employeeList.addAll(addEmp());



    }

    private static List<Person> addEmp() {

        List<Person> people = new ArrayList<>();

        Person emp;
        Person emp2;
        emp = new Person();
        emp.setImie("Janusz");
        emp.setNazwisko("Włoch" + new Random().nextInt());
        emp.setBirth(DateTime.now().minusYears(28));
        emp.setMiasto("Wrocław");
        emp.setPesel("98120408259");

        emp2 = new Person();
        emp2.setImie("Marian");
        emp2.setNazwisko("Grzyb" + new Random().nextInt());
        emp2.setBirth(DateTime.now().minusMonths(201));
        emp2.setMiasto("Szczecin");
        emp2.setPesel("780304015123");

        people = new ArrayList<Person>();
        people.add(emp);
        people.add(emp2);

        return people;
    }
}
