import checker.fromSql;
import checker.jsonToSqlPerson;
import model.Person;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.*;

public class fromDatabase
{

    fromSql a;
    List<Person> list;

    @Before
    public void before()
    {
        a = new fromSql();
        list  = new ArrayList<Person>();
    }


    @Test
    public void personTrueJson() throws IOException
    {
        String fileSuffix = "json";
        assertTrue(a.checkPerson(fileSuffix));
    }

    @Test
    public void personTrueXml() throws IOException
    {
        String fileSuffix = "xml";
        assertTrue(a.checkPerson(fileSuffix));
    }
}
