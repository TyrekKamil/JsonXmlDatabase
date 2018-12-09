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

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class fromSql {


    public static void main(String[] args)
    { }

    public static Boolean checkPerson(String fileSuffix) throws IOException {
        save database = new save();
        save.init();
        List<Person> listOfPeople = new ArrayList<Person>();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        Boolean ifCorrect = true;
        try {

            //rozpocznij transakcje
            entityManager.getTransaction().begin();

            Query query = entityManager.createQuery("SELECT k FROM Person k");
            listOfPeople=query.getResultList();

            entityManager.getTransaction().commit();

            System.out.println("Done");

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(new File("person_test." + fileSuffix), listOfPeople);

            entityManager.close();

        } catch (Throwable ex) {
            ifCorrect = false;
        } finally {
            entityManagerFactory.close();
        }

        return ifCorrect;
    }





}
