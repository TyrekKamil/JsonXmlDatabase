package database;

//import hibernate.model.Person;
import model.Person;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;


class save {


    final static Logger logger = Logger.getLogger(save.class);
    public static void main(String[] args) {

        System.out.println("Start");




        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


                try {

            //rozpocznij transakcje
          entityManager.getTransaction().begin();



            Person emp = new Person();
            emp.setId(1);
            emp.setImie("Jan");
            emp.setNazwisko("Polak");
            //emp.setBirth(DateTime.now().minusYears(18));
            emp.setMiasto("Poznań");
            emp.setPesel("98030408259");

            Person emp2 = new Person();
            emp2.setId(2);
            emp2.setImie("Marian");
            emp2.setNazwisko("Wiejski");
            //emp2.setBirth(DateTime.now());
            emp2.setMiasto("Częstochowa");
            emp2.setPesel("98030401239");

            Person emp3;
            emp3 = new Person();
            emp3.setId(3);
            emp3.setImie("Marlena");
            emp3.setNazwisko("Zarzycka");
           // emp3.setBirth(DateTime.now().minusYears(20));
            emp3.setMiasto("Bolesławiec");
            emp3.setPesel("98072108123");

            entityManager.merge(emp);
            entityManager.merge(emp2);
            entityManager.merge(emp3);
            /*Person person;
            person = new Person();
            person = entityManager.find(Person.class, emp.getId());

            entityManager.remove(emp);

            System.out.println("Employee " + person.getId() + " " + person.getImie() + " " + person.getNazwisko());
*/


            System.out.println("Done");
           entityManager.flush();
           entityManager.getTransaction().commit();
                    getThemAll(entityManager);

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

    static void getThemAll(EntityManager entityManager)  {
        Query query = entityManager.createQuery("SELECT k FROM Person k");

        List<Person> result = query.getResultList();
        System.out.println("Lista: " + result.get(1).getImie());
    }

}





