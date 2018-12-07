import checker.jsonToSqlPerson;
import model.Person;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class test
{

    jsonToSqlPerson a;

   @Before
   public void before()
   {
       a = new jsonToSqlPerson();
   }
    @Test
    public void personFalseXML() throws IOException {
        List<Person> list = new ArrayList<Person>();
        String fileSuffix = "xml";
        list = a.serialize("xml",0);

        assertFalse(a.checkPersonFalse(list,fileSuffix));
    }

    @Test
    public void personFalseJson() throws IOException {
        List<Person> list = new ArrayList<Person>();
        list = a.serialize("json",0);
        String fileSuffix = "json";
        assertFalse(a.checkPersonFalse(list, fileSuffix));
    }

    @Test
    public void personTrue() throws IOException {
        List<Person> list = new ArrayList<Person>();
        list = a.serialize("json",1);
        String fileSuffix = "json";
        assertTrue(a.checkPersonFalse(list, fileSuffix));
    }
}
