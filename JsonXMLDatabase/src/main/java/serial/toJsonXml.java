package serial;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import creator.ModelObjectsCreator;
import model.*;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class toJsonXml {


    private static List<Person> deserializedPerson;

    public static List<Person> getDeserializedPerson() {
        return deserializedPerson;
    }



    final static Logger logger = Logger.getLogger(toJsonXml.class);

    public static void serializeDemo(ObjectMapper mapper, String fileSuffix) throws IOException {

        //Set mapper to pretty-print
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        //Create objects to serialize
        ModelObjectsCreator objectsCreator = new ModelObjectsCreator();
        objectsCreator.init();

        List<Address> addresses = new ArrayList<>();
        addresses = objectsCreator.getAddresses();

        List<Course> courses = new ArrayList<Course>();
        courses = objectsCreator.getCourses();

        List<Opinion> opinions = new ArrayList<Opinion>();
        opinions = objectsCreator.getOpinions();

        List<Person> people = new ArrayList<Person>();
        people = objectsCreator.getPeople();


        List<Speaker> speakers = new ArrayList<Speaker>();
        speakers = objectsCreator.getSpeakers();

        //Serialize to file and string
        mapper.writeValue(new File("person." + fileSuffix), people);
        mapper.writeValue(new File("addresses." + fileSuffix), addresses);
        mapper.writeValue(new File("opinions." + fileSuffix), opinions);
        mapper.writeValue(new File("courses." + fileSuffix), courses);
        mapper.writeValue(new File("speakers." + fileSuffix), speakers);

        //ToString Serial
        String jsonPeople = mapper.writeValueAsString(people);
        String jsonCourse = mapper.writeValueAsString(courses);
        String jsonAddress = mapper.writeValueAsString(addresses);
        String jsonSpeakers = mapper.writeValueAsString(speakers);
        String jsonOpinions = mapper.writeValueAsString(opinions);

        //Write
       // System.out.println(jsonPeople);
        //System.out.println(jsonCourse);
       // System.out.println(jsonAddress);
        //System.out.println(jsonSpeakers);
        //System.out.println(jsonOpinions);

    }

    public static void deserializeDemo(ObjectMapper mapper, String fileSuffix) throws IOException {

        deserializedPerson = mapper.readValue(new File("person." + fileSuffix), new TypeReference<List<Person>>() { } );

        mapper.writeValue(new File("person-copy." + fileSuffix), deserializedPerson);
        String modifiedJsonString = mapper.writeValueAsString(deserializedPerson);
        logger.info("Printing serialized modified object " + fileSuffix);
        System.out.println(modifiedJsonString);
    }

    public static void main(String[] args) throws IOException {

       init();

    }

    public static void init() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        ObjectMapper xmlMapper = new XmlMapper();
        jsonMapper.registerModule(new JodaModule());
        serializeDemo(jsonMapper, "json");
        serializeDemo(xmlMapper, "xml");
        deserializeDemo(jsonMapper, "json");
    }
}