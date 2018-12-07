import checker.jsonToSqlPerson;
import model.Person;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class jsonXmlData {

    jsonToSqlPerson a = new jsonToSqlPerson();
   /* @Test
    public void personTrue() throws IOException {

        List<Person> listPeople = new ArrayList<Person>();
        toJsonXml help = new toJsonXml();
        listPeople = help.getDeserializedPerson();
        assertTrue(a.checkPersonTrue(listPeople));
    }

    @Test
    public void personFalse() throws IOException {

        List<Person> listPeople = new ArrayList<Person>();
        toJsonXml help = new toJsonXml();
        listPeople = help.getDeserializedPerson();

        listPeople.remove(0);
        assertFalse(a.checkPersonTrue(listPeople));
    }
*/
/*
   @Test
    public void personFalseXML() throws IOException {
    List<Person> list = new ArrayList<Person>();
    list = a.serialLize("xml",0);

    assertFalse(a.checkPersonFalse(list,"xml"));
   }
*/
    @Test
    public void personFalseJson() throws IOException {
        List<Person> list = new ArrayList<Person>();
        list = a.serialize("json",0);

        assertFalse(a.checkPersonFalse(list, "json"));
    }

    @Test
    public void personTrue() throws IOException {
        List<Person> list = new ArrayList<Person>();
        list = a.serialize("json",1);

        assertTrue(a.checkPersonFalse(list, "json"));
    }
}
