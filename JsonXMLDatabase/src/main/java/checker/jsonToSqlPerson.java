package checker;

import creator.ModelObjectsCreator;
import model.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class jsonToSqlPerson {

    public static Boolean ifCorrect = false;

    public static void main(String[] args)
    {
        ModelObjectsCreator model = new ModelObjectsCreator();
        List<Person> listOfPeople = new ArrayList<Person>();
        listOfPeople = model.getPeople();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        try {

            //rozpocznij transakcje
            entityManager.getTransaction().begin();
            for(int i=0;i<listOfPeople.size();i++)
                entityManager.persist(listOfPeople.get(i));
            entityManager.flush();
            entityManager.getTransaction().commit();



            System.out.println("Done");
            Query query = entityManager.createQuery("SELECT k FROM Person k");
            List<Person> peopleFromSql = query.getResultList();

            if(peopleFromSql.equals(listOfPeople))
                ifCorrect = true;
            else
                ifCorrect = false;

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
