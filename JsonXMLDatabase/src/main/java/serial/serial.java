package serial;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import creator.ModelObjectsCreator;
import model.Person;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class serial {

    final static Logger logger = Logger.getLogger(serial.class);

    public static void serializeDemo(ObjectMapper mapper, String fileSuffix) throws IOException {
        //Set mapper to pretty-print
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        //Create objects to serialize
        ModelObjectsCreator objectsCreator = new ModelObjectsCreator();
        List<Person> people = new ArrayList<>();
        people = objectsCreator.getEmployees();

        //Serialize to file and string
        mapper.writeValue(new File("result." + fileSuffix), people);
        String jsonString = mapper.writeValueAsString(people);
        logger.info("Printing serialized original object " + fileSuffix);
        System.out.println(jsonString);

        //Deserialize from file
        Person deserializedEmployee = mapper.readValue(
                new File("result." + fileSuffix), Person.class);

        //Serialize back
        mapper.writeValue(new File("result-modified." + fileSuffix), deserializedEmployee);
        String modifiedJsonString = mapper.writeValueAsString(deserializedEmployee);
        logger.info("Printing serialized modified object " + fileSuffix);
        System.out.println(modifiedJsonString);
    }

    public static void serializeListDemo(ObjectMapper mapper, String fileSuffix) throws IOException {
        //Set mapper to pretty-print
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        //Create objects to serialize
        ModelObjectsCreator objectsCreator = new ModelObjectsCreator();
        List<Person> employee = new ArrayList<>();
        employee.add(objectsCreator.getEmp());
        employee.add(objectsCreator.getEmp2());

        //Serialize to file and string
        mapper.writeValue(new File("result." + fileSuffix), employee);

        //Deserialize from file
        List<Person> deserializedEmployee = mapper.readValue(
                new File("result." + fileSuffix), new TypeReference<List<Person>>() { } );
    }

    public static void deserializeDemo(ObjectMapper mapper, String fileSuffix) throws IOException {
        //Deserialized employee object from employees.* file in resources
        InputStream employeeIs = serial.class.getClassLoader().
                getResourceAsStream("employee." + fileSuffix);

        //Read value - set class type of serialization
        Person deserializedEmployee = mapper.readValue(employeeIs, Person.class);

        String modifiedSerialzied = mapper.writeValueAsString(deserializedEmployee);
        logger.info("Printing modified re-serialized employee to" + fileSuffix);

        System.out.println(modifiedSerialzied);
    }

    public static void main(String[] args) throws IOException {

        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.registerModule(new JodaModule());
        serializeListDemo(jsonMapper, "json");
        serializeDemo(jsonMapper, "json");
        //deserializeDemo(jsonMapper, "json");

    }
}