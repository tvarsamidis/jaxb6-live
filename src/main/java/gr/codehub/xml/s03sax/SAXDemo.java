package gr.codehub.xml.s03sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/*

The SAX (Simple API for XML) parser is another great option for reading 
large XML files incrementally in Java. SAX is an event-driven parser, 
meaning it reads the XML document sequentially and triggers events 
when it encounters start elements, end elements, and text data. 
It’s memory efficient because it doesn’t load the entire XML document into memory.


 */
public class SAXDemo {

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            SAXPersonHandler handler = new SAXPersonHandler();
            saxParser.parse("data_in/people.xml", handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
