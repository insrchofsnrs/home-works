package by.academy.it.withkeys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@NoArgsConstructor
@Data
@Entity
@Table(name = "CAT")

public class Cat extends Animal {
    private static final long serialVersionUID = 3L;

    private int lives;

    public Cat(Long id, int age, String name, int lives) {
        super(id, age, name);
        this.lives = lives;
    }
}
