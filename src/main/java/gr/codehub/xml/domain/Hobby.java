package gr.codehub.xml.domain;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement(name = "hobby")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hobby {
    private String name;
    private int years;
}
