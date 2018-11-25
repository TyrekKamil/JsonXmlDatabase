package serial;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import creator.ModelObjectsCreator;
import model.Course;
import model.CourseCity;
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

        List<Course> courseList = new ArrayList<>();
        courseList = objectsCreator.getCourseList();

        List<CourseCity> courseCityList = new ArrayList<>();
        courseCityList = objectsCreator.getCourseCityList();

        //Serialize to file and string
        mapper.writeValue(new File("person." + fileSuffix), people);
        mapper.writeValue(new File("course." + fileSuffix), courseList);
        //mapper.writeValue(new File("courseCity." + fileSuffix), courseCityList);
        //ToString Serial
        String jsonPeople = mapper.writeValueAsString(people);
        String jsonCourse = mapper.writeValueAsString(courseList);
        //String jsonCourseCity = mapper.writeValueAsString(courseCityList);
        //Write
        System.out.println(jsonPeople);
        System.out.println(jsonCourse);
        //System.out.println(jsonCourseCity);

        //Deserialize from file
        /*Person deserializedEmployee = mapper.readValue(
                new File("result." + fileSuffix), Person.class);

        //Serialize back
        mapper.writeValue(new File("result-modified." + fileSuffix), deserializedEmployee);
        String modifiedJsonString = mapper.writeValueAsString(deserializedEmployee);
        logger.info("Printing serialized modified object " + fileSuffix);
        System.out.println(modifiedJsonString);*/
    }

    public static void deserializeDemo(ObjectMapper mapper, String fileSuffix) throws IOException {
        //Deserialized employee object from employees.* file in resources
        /*InputStream employeeIs = serial.class.getClassLoader().
                getResourceAsStream("person." + fileSuffix);*/
    try {


        //Read value - set class type of serializationmapper.writeValueAsString(deserializedEmployee);
        Person deserialize = mapper.readValue(new File("person." + fileSuffix), Person.class);

        String modifiedSerialzied = mapper.writeValueAsString(deserialize);
        logger.info("Printing modified re-serialized employee to" + fileSuffix);

        System.out.println(modifiedSerialzied);
    }
    catch (JsonGenerationException e) {
        e.printStackTrace();
    } catch (JsonMappingException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    public static void main(String[] args) throws IOException {

        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.registerModule(new JodaModule());
        serializeDemo(jsonMapper, "json");
        deserializeDemo(jsonMapper, "json");

    }
}