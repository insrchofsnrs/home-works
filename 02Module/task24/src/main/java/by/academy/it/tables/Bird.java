package by.academy.it.tables;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "BIRD")
public class Bird extends Animal {
    private static final long serialVersionUID = 3L;
    private boolean canFly;

    public Bird(Long id, int age, String name, boolean canFly) {
        super(id, age, name);
        this.canFly = canFly;
    }
}
