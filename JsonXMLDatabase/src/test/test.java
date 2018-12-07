import checker.jsonToSqlPerson;
import model.Person;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.*;

public class test
{

    jsonToSqlPerson a;
    List<Person> list;

    @Before
   public void before()
   {
       a = new jsonToSqlPerson();
        list  = new ArrayList<Person>();
   }

    @Test
    public void personFalseXML() throws IOException {

        String fileSuffix = "xml";

        assertFalse(a.checkPerson(fileSuffix,"f"));
    }

    @Test
    public void personFalseJson() throws IOException {
        String fileSuffix = "json";
        assertFalse(a.checkPerson(fileSuffix,"f"));
    }

    @Test
    public void personTrueJson() throws IOException
    {
        String fileSuffix = "json";
        assertTrue(a.checkPerson(fileSuffix,"t"));
    }

    @Test
    public void personTrueXml() throws IOException
    {
        String fileSuffix = "xml";
        assertTrue(a.checkPerson(fileSuffix,"t"));
    }
}
