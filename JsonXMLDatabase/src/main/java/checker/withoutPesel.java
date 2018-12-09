package checker;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import creator.ModelObjectsCreator;
import database.save;
import model.Address;
import model.Opinion;
import model.Person;
import serial.toJsonXml;

import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class withoutPesel {


    public static void main(String[] args)
    { }

    public static Boolean checkPerson(String fileSuffix) throws IOException {
        //save database = new save();
        //save.init();
        ModelObjectsCreator a = new ModelObjectsCreator();
        List<Person> listOfPeople = new ArrayList<Person>();
        a.init();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        Boolean ifCorrect = true;
        try {

            //rozpocznij transakcje
            entityManager.getTransaction().begin();

           listOfPeople = a.getPeople();
           Person makeFake = new Person();
           makeFake.setImie("Włodek");
           makeFake.setNazwisko("WW");
           listOfPeople.add(makeFake);

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(new File("person_test2." + fileSuffix), listOfPeople);
            List<Person> list2 = new ArrayList<Person>();
            list2 = mapper.readValue(new File("person_test." + fileSuffix), new TypeReference<List<Person>>() { } );
            entityManager.persist(a);
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





}
