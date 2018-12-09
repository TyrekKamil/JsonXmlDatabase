import checker.jsonToSqlPerson;
import model.Person;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.*;

public class toDatabase
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

        assertFalse(a.checkPerson(fileSuffix,0));
    }

    @Test
    public void personFalseJson() throws IOException {
        String fileSuffix = "json";
        assertFalse(a.checkPerson(fileSuffix,0));
    }

    @Test
    public void personTrueJson() throws IOException
    {
        String fileSuffix = "json";
        assertTrue(a.checkPerson(fileSuffix,1));
    }

    @Test
    public void personTrueXml() throws IOException
    {
        String fileSuffix = "xml";
        assertTrue(a.checkPerson(fileSuffix,1));
    }
}
