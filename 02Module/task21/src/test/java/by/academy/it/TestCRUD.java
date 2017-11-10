package by.academy.it;

import org.junit.Assert;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class TestCRUD {
    @Test
    public void saveTest() {
        Person person = new Person(null, 28, "Evgeni", "vavilkin");
        EntityManager entityManager = HUtil.getTestEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
        entityManager.getTransaction().begin();
        Person person1 = new Person();
        person1 = entityManager.find(Person.class, person.getId());
        entityManager.getTransaction().commit();
        Assert.assertEquals(person1, person);
        entityManager.close();
    }

    @Test
    public void deleteTest() {
        Person person = new Person(null, 28, "Evgeni", "vavilkin");
        EntityManager entityManager = HUtil.getTestEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
        entityManager.clear();
        entityManager.getTransaction().begin();
        Person person1 = new Person();
        person1 = entityManager.find(Person.class, person.getId());
        System.out.println(person1);
        entityManager.remove(person1);
        entityManager.getTransaction().commit();
        entityManager.clear();
        Person person2 = new Person();
        person2 = entityManager.find(Person.class, person.getId());
        Assert.assertEquals(null, person2);
        entityManager.close();
    }

    @Test
    public void readTest() {
        Person person1 = new Person(null, 12, "Max", "Mad");
        Person person2 = new Person(null, 22, "Evgeni", "Vavilkin");
        Person person3 = new Person(null, 32, "Sam", "Smith");
        EntityManager entityManager = HUtil.getTestEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(person1);
        entityManager.persist(person2);
        entityManager.persist(person3);
        entityManager.getTransaction().commit();
        entityManager.clear();

        entityManager.getTransaction().begin();
        Person perFromDB1 = new Person();
        Person perFromDB2 = new Person();
        Person perFromDB3 = new Person();
        perFromDB1 = entityManager.find(Person.class, person1.getId());
        perFromDB2 = entityManager.find(Person.class, person2.getId());
        perFromDB3 = entityManager.find(Person.class, person3.getId());
        entityManager.getTransaction().commit();
        entityManager.clear();
        HUtil.close();
        Assert.assertEquals(person1,perFromDB1);
        Assert.assertEquals(person2,perFromDB2);
        Assert.assertEquals(person3,perFromDB3);
    }

    @Test
    public void updateTest() {
        Person person1 = new Person(null, 12, "Max", "Mad");
        EntityManager entityManager = HUtil.getTestEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(person1);
        entityManager.getTransaction().commit();
        entityManager.clear();

        //entityManager.getTransaction().begin();
        Person perForUpdateFromDB1 = entityManager.find(Person.class, person1.getId());
        perForUpdateFromDB1.setAge(22);
        perForUpdateFromDB1.setName("Vasiliy");
        //entityManager.merge(perForUpdateFromDB1);
        //entityManager.getTransaction().commit();
        //entityManager.clear();

        //entityManager.getTransaction().begin();
        Person perFromDB1 = entityManager.find(Person.class, person1.getId());

        HUtil.close();
        Assert.assertEquals(person1,perFromDB1);
    }
}
