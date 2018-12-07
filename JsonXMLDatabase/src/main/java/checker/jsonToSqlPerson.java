package checker;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import creator.ModelObjectsCreator;
import model.Address;
import model.Opinion;
import model.Person;
import serial.toJsonXml;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class jsonToSqlPerson {


    public static void main(String[] args)
    { }

    public static Boolean checkPersonFalse(List<Person> listOfPeople, String fileSuffix) throws IOException {
        toJsonXml checker = new toJsonXml();
        checker.init();
        listOfPeople = new ArrayList<Person>();
        listOfPeople = serialize(fileSuffix,1);
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        Boolean ifCorrect = true;
        try {

            //rozpocznij transakcje
            entityManager.getTransaction().begin();


            for (int i = 0; i < listOfPeople.size(); i++)
                entityManager.persist(listOfPeople.get(i));
            entityManager.flush();
            entityManager.getTransaction().commit();


            System.out.println("Done");


            entityManager.close();

        } catch (Throwable ex) {
            ifCorrect = false;
        } finally {
            entityManagerFactory.close();
        }

        return ifCorrect;
    }


    public static Boolean c0heckPersonTrue(List<Person> listOfPeople) throws IOException {
        toJsonXml checker = new toJsonXml();
        checker.init();
        listOfPeople = new ArrayList<Person>();
        listOfPeople = serialize("json",0);
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        Boolean ifCorrect = true;
        try {

            //rozpocznij transakcje
            entityManager.getTransaction().begin();
            for (int i = 0; i < listOfPeople.size(); i++)
                entityManager.persist(listOfPeople.get(i));
            entityManager.flush();
            entityManager.getTransaction().commit();

            entityManager.close();

        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            ifCorrect = false;
        } finally {
            entityManagerFactory.close();
        }

        return ifCorrect;
    }

    public static List<Person> serialize(String fileSuffix, int i) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        //Create objects to serialize
        ModelObjectsCreator objectsCreator = new ModelObjectsCreator();
        objectsCreator.init();

        List<Person> people = new ArrayList<Person>();
        people = objectsCreator.getPeople();

        if(i==0)
        {
            Person makeFake = new Person();
            makeFake.setImie("Mar");
            makeFake.setNazwisko("Wasd");
            people.add(makeFake);
        }

        //Serialize to file and string
        mapper.writeValue(new File("person_test." + fileSuffix), people);
        List<Person> deserial = new ArrayList<Person>();
        deserial = mapper.readValue(new File("/home/kamil/IdeaProjects/JsonXmlDatabasePPR/person_test." + fileSuffix), new TypeReference<List<Person>>() { } );
        return deserial;
    }



}
