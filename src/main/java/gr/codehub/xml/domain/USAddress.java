package gr.codehub.xml.domain;

import jakarta.xml.bind.annotation.XmlAccessOrder;
import jakarta.xml.bind.annotation.XmlAccessorOrder;

import java.math.BigInteger;

@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
//@XmlType(propOrder = {"name", "city"})
public class USAddress {

    public String getCity() {
        return "no private field 'city' defined yet";
    }

    public void setCity(String city) {
        throw new RuntimeException("no private field 'city' defined yet");
    }

    public String getName() {
        return "no private field 'name' defined yet";
    }

    public void setName(String name) {
        throw new RuntimeException("no private field 'name' defined yet");
    }
    
    // If you do not include both getter and setter, property will not appear in xml
    // This is done with refletion - get all methods, find the ones with get/set, shared name and...
    // ... proper method signature, and make them xml elements
    // But then, if you do not include this property in propOrder, an IllegalAnnotationExceptions will be thrown
    public BigInteger getPopulation() {
        throw new RuntimeException("no private field 'population' defined yet");
    }

    public void setPopulation(BigInteger population) {
        throw new RuntimeException("no private field 'population' defined yet");
    }
    
    // then change int to BigInteger and see that the xml file will change 'int' to 'integer'
    // the important thing is the reverse mapping - java sees 'decimal' and converts it to BigDecimal
}
