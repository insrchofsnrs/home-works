package by.academy.it.tables;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Cat extends Animal {
    private static final long serialVersionUID = 4L;
    private int lives;

    public Cat(Long id, int age, String name, int lives) {
        super(id, age, name);
        this.lives = lives;
    }
}
