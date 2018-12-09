import checker.jsonToSqlPerson;
import checker.withoutPesel;
import model.Person;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class withoutDatas
{
    withoutPesel a;
    @Before
    public void before()
    {
        a = new withoutPesel();
    }

    @Test
    public void Test() throws IOException {

        assertFalse(a.checkPerson("json"));
    }

    @Test
    public void Test2() throws IOException {

        assertFalse(a.checkPerson("xml"));
    }
}

