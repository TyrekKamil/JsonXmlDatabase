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
    private static List<Speaker> deserializedSpeaker;
    private static List<Address> deserializedAddress;
    private static List<Course> deserializedCourse;
    private static List<Opinion> deserializedOpinion;

    private static List<Person> deserializedPerson2;
    private static List<Speaker> deserializedSpeaker2;
    private static List<Address> deserializedAddress2;
    private static List<Course> deserializedCourse2;
    private static List<Opinion> deserializedOpinion2;

    public static List<Person> getDeserializedPerson() {
        return deserializedPerson;
    }

    public static void setDeserializedPerson(List<Person> deserializedPerson) {
        toJsonXml.deserializedPerson = deserializedPerson;
    }

    public static List<Speaker> getDeserializedSpeaker() {
        return deserializedSpeaker;
    }

    public static void setDeserializedSpeaker(List<Speaker> deserializedSpeaker) {
        toJsonXml.deserializedSpeaker = deserializedSpeaker;
    }

    public static List<Address> getDeserializedAddress() {
        return deserializedAddress;
    }

    public static void setDeserializedAddress(List<Address> deserializedAddress) {
        toJsonXml.deserializedAddress = deserializedAddress;
    }

    public static List<Course> getDeserializedCourse() {
        return deserializedCourse;
    }

    public static void setDeserializedCourse(List<Course> deserializedCourse) {
        toJsonXml.deserializedCourse = deserializedCourse;
    }

    public static List<Opinion> getDeserializedOpinion() {
        return deserializedOpinion;
    }

    public static void setDeserializedOpinion(List<Opinion> deserializedOpinion) {
        toJsonXml.deserializedOpinion = deserializedOpinion;
    }

    public static List<Person> getDeserializedPerson2() {
        return deserializedPerson2;
    }

    public static void setDeserializedPerson2(List<Person> deserializedPerson2) {
        toJsonXml.deserializedPerson2 = deserializedPerson2;
    }

    public static List<Speaker> getDeserializedSpeaker2() {
        return deserializedSpeaker2;
    }

    public static void setDeserializedSpeaker2(List<Speaker> deserializedSpeaker2) {
        toJsonXml.deserializedSpeaker2 = deserializedSpeaker2;
    }

    public static List<Address> getDeserializedAddress2() {
        return deserializedAddress2;
    }

    public static void setDeserializedAddress2(List<Address> deserializedAddress2) {
        toJsonXml.deserializedAddress2 = deserializedAddress2;
    }

    public static List<Course> getDeserializedCourse2() {
        return deserializedCourse2;
    }

    public static void setDeserializedCourse2(List<Course> deserializedCourse2) {
        toJsonXml.deserializedCourse2 = deserializedCourse2;
    }

    public static List<Opinion> getDeserializedOpinion2() {
        return deserializedOpinion2;
    }

    public static void setDeserializedOpinion2(List<Opinion> deserializedOpinion2) {
        toJsonXml.deserializedOpinion2 = deserializedOpinion2;
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
/*
    public static void deserialize(ObjectMapper mapper) throws IOException {

        String fileSuffix = "json";
        String fileSuffix2 = "xml";
        deserializedPerson = mapper.readValue(new File("/home/kamil/IdeaProjects/JsonXmlDatabasePPR/person." + fileSuffix), new TypeReference<List<Person>>() { } );
        System.out.println(deserializedPerson);
        deserializedCourse = mapper.readValue(new File("/home/kamil/IdeaProjects/JsonXmlDatabasePPR/course." + fileSuffix), new TypeReference<List<Course>>() { } );
        deserializedSpeaker = mapper.readValue(new File("/home/kamil/IdeaProjects/JsonXmlDatabasePPR/speakers." + fileSuffix), new TypeReference<List<Speaker>>() { } );
        deserializedAddress = mapper.readValue(new File("/home/kamil/IdeaProjects/JsonXmlDatabasePPR/address." + fileSuffix), new TypeReference<List<Address>>() { } );
        deserializedOpinion = mapper.readValue(new File("/home/kamil/IdeaProjects/JsonXmlDatabasePPR/opinion." + fileSuffix), new TypeReference<List<Opinion>>() { } );
        deserializedPerson2 = mapper.readValue(new File("/home/kamil/IdeaProjects/JsonXmlDatabasePPR/person." + fileSuffix), new TypeReference<List<Person>>() { } );
        deserializedCourse2 = mapper.readValue(new File("/home/kamil/IdeaProjects/JsonXmlDatabasePPR/course." + fileSuffix), new TypeReference<List<Course>>() { } );
        deserializedSpeaker2 = mapper.readValue(new File("/home/kamil/IdeaProjects/JsonXmlDatabasePPR/speakers." + fileSuffix), new TypeReference<List<Speaker>>() { } );
        deserializedAddress2 = mapper.readValue(new File("/home/kamil/IdeaProjects/JsonXmlDatabasePPR/address." + fileSuffix), new TypeReference<List<Address>>() { } );
        deserializedOpinion2 = mapper.readValue(new File("/home/kamil/IdeaProjects/JsonXmlDatabasePPR/opinion." + fileSuffix), new TypeReference<List<Opinion>>() { } );

    }


*/

    public static void main(String[] args) throws IOException {

       init();

    }

    public static void init() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        ObjectMapper xmlMapper = new XmlMapper();
        jsonMapper.registerModule(new JodaModule());
        //serializeDemo(jsonMapper, "json");
        //serializeDemo(xmlMapper, "xml");
        // deserialize(jsonMapper);

        serialJson(jsonMapper);
        serialXML(xmlMapper);

    }


    public static void serialJson(ObjectMapper jsonMapper) throws IOException {
        serializePerson(jsonMapper, "json");
        serializeAdress(jsonMapper, "json");
        serializeCourse(jsonMapper, "json");
        serializeOpinion(jsonMapper, "json");
        serializeSpeaker(jsonMapper, "json");
    }
    public static void serialXML(ObjectMapper xmlMapper) throws IOException {
        serializePerson(xmlMapper, "xml");
        serializeAdress(xmlMapper, "xml");
        serializeCourse(xmlMapper, "xml");
        serializeOpinion(xmlMapper, "xml");
        serializeSpeaker(xmlMapper, "xml");;
    }

    public static void serializePerson(ObjectMapper mapper, String fileSuffix) throws IOException {

        //Set mapper to pretty-print
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        //Create objects to serialize
        ModelObjectsCreator objectsCreator = new ModelObjectsCreator();
        objectsCreator.init();

        List<Person> people = new ArrayList<Person>();
        people = objectsCreator.getPeople();

        //Serialize to file and string
        mapper.writeValue(new File("person." + fileSuffix), people);

        //ToString Serial
        String jsonPeople = mapper.writeValueAsString(people);


    }

    public static void serializeAdress(ObjectMapper mapper, String fileSuffix) throws IOException {

        //Set mapper to pretty-print
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        //Create objects to serialize
        ModelObjectsCreator objectsCreator = new ModelObjectsCreator();
        objectsCreator.init();

        List<Address> list = new ArrayList<Address>();
        list = objectsCreator.getAddresses();

        //Serialize to file and string
        mapper.writeValue(new File("address." + fileSuffix), list);

        //ToString Serial
        String jsonPeople = mapper.writeValueAsString(list);


    }

    public static void serializeCourse(ObjectMapper mapper, String fileSuffix) throws IOException {

        //Set mapper to pretty-print
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        //Create objects to serialize
        ModelObjectsCreator objectsCreator = new ModelObjectsCreator();
        objectsCreator.init();

        List<Course> list = new ArrayList<Course>();
        list = objectsCreator.getCourses();

        //Serialize to file and string
        mapper.writeValue(new File("course." + fileSuffix), list);

        //ToString Serial
        String jsonPeople = mapper.writeValueAsString(list);


    }

    public static void serializeOpinion(ObjectMapper mapper, String fileSuffix) throws IOException {

        //Set mapper to pretty-print
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        //Create objects to serialize
        ModelObjectsCreator objectsCreator = new ModelObjectsCreator();
        objectsCreator.init();

        List<Opinion> list = new ArrayList<Opinion>();
        list = objectsCreator.getOpinions();

        //Serialize to file and string
        mapper.writeValue(new File("opinion." + fileSuffix), list);

        //ToString Serial
        String jsonPeople = mapper.writeValueAsString(list);


    }

    public static void serializeSpeaker(ObjectMapper mapper, String fileSuffix) throws IOException {

        //Set mapper to pretty-print
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        //Create objects to serialize
        ModelObjectsCreator objectsCreator = new ModelObjectsCreator();
        objectsCreator.init();

        List<Speaker> list = new ArrayList<Speaker>();
        list = objectsCreator.getSpeakers();

        //Serialize to file and string
        mapper.writeValue(new File("speakers." + fileSuffix), list);

        //ToString Serial
        String jsonPeople = mapper.writeValueAsString(list);


    }



}