package by.academy.it.tables;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Animal")
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public class Animal {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private int age;

    @Column
    private String name;
}
