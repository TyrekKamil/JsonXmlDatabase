package database;

//import hibernate.model.Person;
import model.Person;
import org.joda.time.DateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;


class save {

    public static void main(String[] args) {

        System.out.println("Start");

        EntityManager entityManager;

        EntityManagerFactory entityManagerFactory = null;


                try {
            //taka nazwa jak w persistence.xml
            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
            //utworz entityManagera
            entityManager = entityManagerFactory.createEntityManager();

            //rozpocznij transakcje
            entityManager.getTransaction().begin();

            Person emp, emp2, emp3;

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

            entityManager.persist(emp);
            entityManager.persist(emp2);

            Person person = entityManager.find(Person.class, emp.getId());

            entityManager.remove(emp);

            System.out.println("Employee " + person.getId() + " " + person.getImie() + " " + person.getNazwisko());

            //zakoncz transakcje
            entityManager.getTransaction().commit();

            System.out.println("Done");

            entityManager.close();

        }

        catch (Throwable ex)
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
        }

        finally
        {
            entityManagerFactory.close();
        }

    }

}





