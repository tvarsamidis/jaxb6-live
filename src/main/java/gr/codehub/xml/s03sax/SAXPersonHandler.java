package gr.codehub.xml.s03sax;

import gr.codehub.xml.domain.Person;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXPersonHandler extends DefaultHandler {

    private static final int PERSON_DATA = 3; // a complete person element must have 3 data

    private String currentElement;
    private int id;
    private int age = 0;
    private String name;
    private int personDataCount = 0; // a complete person element must have 3 data

    @Override
    public void startDocument() throws SAXException {
        // System.out.println("The parser has found the start of an XML document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        // System.out.println("Current element: " + currentElement);
        if ("person".equals(currentElement)) {
            id = myParseInt(attributes.getValue("id"));
            if (id != 0) {
                personDataCount++;
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String text = new String(ch, start, length);
        if ("name".equals(currentElement)) {
            name = text;
            personDataCount++;
        }
        if ("age".equals(currentElement)) {
            age = myParseInt(text);
            if (age != 0) {
                personDataCount++;
            }
        }
    }

    private int myParseInt(String text){
        try {
            return Integer.parseInt(text);
        } catch(NumberFormatException e) {
            return 0;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("person".equals(qName)) {
            Person p = new Person();
            p.setId(id);
            p.setName(name);
            p.setAge(age);
            if (personDataCount != PERSON_DATA) {
                System.out.println("There was an XML error");
            }
            System.out.println("Person = " + p);
            id = 0;
            age = 0;
            name = null;
            personDataCount = 0;
        }
        currentElement = "";
    }

}
