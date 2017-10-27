package by.academy.it.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("dog")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dog implements IPet {
    @Value("Rambo")
    private String name;
    @Value("#{person}")
    private Person person;

    public String getPersonName() {
        return person.getName();
    }
}
