package gr.codehub.xml.domain;

import jakarta.xml.bind.annotation.XmlAccessOrder;
import jakarta.xml.bind.annotation.XmlAccessorOrder;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@XmlRootElement(name = "person")
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
//@XmlType(propOrder = {"id", "name", "age"} )
@NoArgsConstructor
@Data
@ToString
@AllArgsConstructor
public class Person {
    private int id;
    private String name;
    private int age;
    private Hobby hobby;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    


}
