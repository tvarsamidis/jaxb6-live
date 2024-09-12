package gr.codehub.xml.s02io;

import gr.codehub.xml.domain.Hobby;
import gr.codehub.xml.domain.Person;
import jakarta.xml.bind.JAXBContext;  // javax for Java EE, Oracle, up to version 8
import jakarta.xml.bind.JAXBException; // Jakarta, Eclipse, from version 9
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;

public class XmlIo {
    
    public static void main(String[] args) throws JAXBException {
        Person person = readXmlFile("data_in/person.xml");
        Hobby hobby = new Hobby("Cooking", 7);
        person.setHobby(hobby);
        System.out.println("Person data = " + person);
        writeXmlFile(person, "data_out/person-duplicate.xml");
        System.out.println("Done!");
    }

    private static Person readXmlFile(String filename) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        File xmlFile = new File(filename);
        Person person = (Person)unmarshaller.unmarshal(xmlFile);
        return person;
    }

    private static void writeXmlFile(Person person, String filename) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        File xmlFile = new File(filename);
        marshaller.marshal(person, xmlFile);
    }
    
}
