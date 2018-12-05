package java;

import checker.jsonToSqlPerson;
import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.assertTrue;

public class jsonToSql {

    jsonToSqlPerson a = new jsonToSqlPerson();
    @Test
    public void person()
    {

        assertTrue(a.ifCorrect);
    }
}
