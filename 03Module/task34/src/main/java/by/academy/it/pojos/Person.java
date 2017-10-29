package by.academy.it.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Person implements IPerson {

    @Value("Evgeny")
    private String name;

    @Value("28") //Вопрос: что сетается если тип int. long, boolean
    private int age;

    @Value("#{pet}")
    private IPet pet;

    public String getPetName() {
        return pet.getName();
    }

}
