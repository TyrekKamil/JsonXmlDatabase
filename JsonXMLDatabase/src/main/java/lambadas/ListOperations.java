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

        //For loop through list
      IntStream.range(0,employeeList.size())
                .forEach(iter -> System.out.println(employeeList.get(iter).getImie()));

        System.out.println("**************************");

        //Foreach type loop through the list
        employeeList.forEach(emploee -> System.out.println(emploee.getImie()));

        System.out.println("**************************");

        //Loop filtering only those people which name start with A
        employeeList.stream()
                .filter(emploee -> emploee.getImie().startsWith("A"))
                .forEach(element -> System.out.println(element.getImie()));

        System.out.println("**************************");

        //Loop, map object to strings -> names and filtering only those people which name start with B
        employeeList.stream()
                .map(employee -> employee.getImie())
                .filter(name -> name.startsWith("B"))
                .forEach(element -> System.out.println(element));

        System.out.println("**************************");

        //Loop, map object to address city names and return distinct
        employeeList.stream()
                .map(employee -> employee.getMiasto())
                .distinct()
                .forEach(element -> System.out.println(element));

        System.out.println("**************************");

        //Loop writing names sorted
        employeeList.stream()
                .sorted(Comparator.comparing(Person::getImie))
                .forEach(element -> System.out.println(element.getImie()));

        System.out.println("**************************");

        //Loop get person with the first alphabetical name
        System.out.println(employeeList.stream()
                .sorted(Comparator.comparing(Person::getImie))
                .findFirst().get().getImie());

        System.out.println("**************************");

        //Create List of names
        List<String> list = employeeList.stream()
                .map(employee -> employee.getImie())
                .collect(Collectors.toList());

        System.out.println("**************************");

        //Create Map name -> employee
        Map<String, Person> map = employeeList.stream()
                .collect(Collectors.toMap(employee -> employee.getImie(), employee -> employee, (a, b) -> a));

        System.out.println(map.entrySet());

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
