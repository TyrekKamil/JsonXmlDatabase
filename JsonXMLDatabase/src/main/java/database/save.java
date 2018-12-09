package database;

//import hibernate.model.Person;
import model.*;
import org.apache.log4j.Logger;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


public class save {

    static EntityManager entityManager;
    static EntityManagerFactory entityManagerFactory;
    final static Logger logger = Logger.getLogger(save.class);
    public static void main(String[] args)
    {
        init();
    }

    public static void getAllPerson()
    {
        Query query = entityManager.createQuery("SELECT k FROM Person k");
        System.out.println("\n\nLista klientów");
        List<Person> result = query.getResultList();
        for(int i = 0;i<result.size();i++)
            System.out.println(result.get(i).getAllInformation());
    }

    public static void getAllCourse()
    {
        Query query = entityManager.createQuery("SELECT c FROM Course c");
        System.out.println("\nLista kursów z prowadzącymi");
        List<Course> result = query.getResultList();
        for(int i = 0;i<result.size();i++)
            System.out.println(result.get(i).getAllInformation());
    }

    public static void opinionByIdCourse()
    {

    }

    public static void courseSpeaker()
    {

    }

    public static void peopleFromCity()
    {

    }

    public static void opinionPages(int pageNr)
    {
        Query queryTotal = entityManager.createQuery
                ("Select count(o) from Opinion o");
        long countResult = (long)queryTotal.getSingleResult();

        //create query
        Query query = entityManager.createQuery("Select e FROM Opinion e");
        //set pageSize
        int pageSize = 5;
        //calculate number of pages
        int pageNumber = (int) ((countResult / pageSize) + 1);

        if (pageNr > pageNumber) pageNr = pageNumber;
        query.setFirstResult((pageNr-1) * pageSize);
        query.setMaxResults(pageSize);

        List<Opinion> opinions = new ArrayList<Opinion>();
        for(int i = 0; i<query.getResultList().size();i++)
            System.out.println(opinions.get(i).getCourse() + " " + opinions.get(i).getPerson() + "\n" + opinions.get(i).getText());
    }


    public static void init()
    {
        System.out.println("Start");

        entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
        entityManager = entityManagerFactory.createEntityManager();

        try {

            //rozpocznij transakcje
            entityManager.getTransaction().begin();

//=================ADRES=======================================\\
            Address adr1 = new Address();
            adr1.setMiasto("Poznań");
            adr1.setNumer("12A");
            adr1.setUlica("Wrocławska");

            Address adr2 = new Address();
            adr2.setMiasto("Szczecin");
            adr2.setUlica("Malwinowska");
            adr2.setNumer("61");

            Address adr3 = new Address();
            adr3.setMiasto("Bolesławiec");
            adr3.setUlica("Marlenkowa");
            adr3.setNumer("123");

            Address adr4 = new Address();
            adr4.setMiasto("Warszawa");
            adr4.setUlica("Wiejska");
            adr4.setNumer("4/6/8");

            Address adr5 = new Address();
            adr5.setMiasto("Wrocław");
            adr5.setNumer("15G");
            adr5.setUlica("Miejska");

//==============SPEAKER=================================\\
            Course course1 = new Course();
            Course course2 = new Course();
            Course course3 = new Course();

            List<Course> speaker1Course = new ArrayList<Course>();
            List<Course> speaker2Course = new ArrayList<Course>();
            speaker1Course.add(course1);
            speaker1Course.add(course3);
            speaker2Course.add(course2);

            Speaker speaker1 = new  Speaker();
            speaker1.setImie("Adam");
            speaker1.setNazwisko("Nowak");
            speaker1.setPesel("87121209012");
            speaker1.setAdres(adr4);


            Speaker speaker2 = new Speaker();
            speaker2.setImie("Mariusz");
            speaker2.setNazwisko("Wierzbicki");
            speaker2.setPesel("85110909122");
            speaker2.setAdres(adr5);



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

            Person emp = new Person();
            emp.setImie("Jan");
            emp.setNazwisko("Polak");
            emp.setAdres(adr1);
            emp.setPesel("98030408259");
            //emp.setCourses(coursesPerson1);

            Person emp2 = new Person();
            emp2.setImie("Marian");
            emp2.setNazwisko("Wiejski");
            emp2.setAdres(adr2);
            emp2.setPesel("98030401239");
            //emp2.setCourses(coursesPerson2);

            Person emp3;
            emp3 = new Person();
            emp3.setImie("Marlena");
            emp3.setNazwisko("Zarzycka");
            emp3.setAdres(adr3);
            emp3.setPesel("98072108123");
            //emp3.setCourses(coursesPerson3);
//==============Opinions=================================\\

            Opinion opinion1 = new Opinion();
            Opinion opinion2 = new Opinion();

            opinion1.setPerson(emp);
            opinion1.setCourse(course1);
            opinion1.setText("super kurs!");

            opinion2.setPerson(emp3);
            opinion2.setCourse(course2);
            opinion2.setText("za duzo teorii, za malo praktyki");



//==============ADD=================================\\


            entityManager.persist(emp);
            entityManager.persist(emp2);
            entityManager.persist(emp3);

            entityManager.persist(adr1);
            entityManager.persist(adr2);
            entityManager.persist(adr3);
            entityManager.persist(adr4);
            entityManager.persist(adr5);




            entityManager.persist(speaker1);
            entityManager.persist(speaker2);

            entityManager.persist(course1);
            entityManager.persist(course2);
            entityManager.persist(course3);

            entityManager.persist(opinion1);
            entityManager.persist(opinion2);





            ///////////////////////////ZAPYTANIA\\\\\\\\\\\\\\\\\\\\\\\\\

            getAllPerson();
            getAllCourse();
            Opinion n = new Opinion();
            for (int i = 1; i<20; i++) {

                n = opinion1;
                entityManager.persist(n);
            }

            //opinionPages(5);

            entityManager.flush();
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





