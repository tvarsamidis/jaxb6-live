package gr.codehub.xml.s04stax;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.Characters;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


/*

When working with large XML files in Java, it's essential to read the 
XML data incrementally to avoid memory issues. One way to achieve this is by 
using StAX (Streaming API for XML), which reads the XML file in a 
streaming manner rather than loading the entire document into memory. 
This allows for efficient, low-memory processing of large XML files.


 */
public class StaxDemoPeople {

    public static void main(String[] args) {
        String fileName = "data_in/people.xml";

        try {
            // Create an XMLInputFactory instance
            XMLInputFactory factory = XMLInputFactory.newInstance();

            // Create an XMLEventReader for reading the XML file
            XMLEventReader eventReader
                    = factory.createXMLEventReader(new FileInputStream(fileName));

            // Variables to hold the content of person elements
            String id = null, name = null, age = null;

            // Loop through the XML elements
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();

                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();

                    // Check for the <person> tag and extract the id attribute
                    if (startElement.getName().getLocalPart().equals("person")) {
                        id = startElement
                                .getAttributeByName(javax.xml.namespace.QName.valueOf("id"))
                                .getValue();
                    }

                    // Check for <name> tag
                    if (startElement.getName().getLocalPart().equals("name")) {
                        event = eventReader.nextEvent(); // Move to the content of <name>
                        if (event instanceof Characters) {
                            name = event.asCharacters().getData();
                        }
                    }

                    // Check for <age> tag
                    if (startElement.getName().getLocalPart().equals("age")) {
                        event = eventReader.nextEvent(); // Move to the content of <age>
                        if (event instanceof Characters) {
                            age = event.asCharacters().getData();
                        }
                    }
                }

                // Handle the end of the <person> element and print the result
                if (event.isEndElement()) {
                    if (event.asEndElement().getName().getLocalPart().equals("person")) {
                        System.out.println("Person ID: " + id + ", Name: " + name + ", Age: " + age);
                        // Reset variables for the next <person> element
                        id = name = age = null;
                    }
                }
            }

        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
