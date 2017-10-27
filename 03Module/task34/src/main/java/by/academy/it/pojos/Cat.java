package by.academy.it.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Component("pet")
public class Cat implements IPet {

    @Value("Tom")
    private String name;

    @Value("#{person}")
    private Person person;

    public String getPersonName() {
        return person.getName();
    }
}
