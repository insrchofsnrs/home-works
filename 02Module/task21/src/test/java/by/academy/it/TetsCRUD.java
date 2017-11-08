package by.academy.it;

import org.junit.Test;

import javax.persistence.EntityManager;

public class TetsCRUD {
    @Test
    public void saveTest(){
        Person person = new Person(null,28,"Evgeni","vavilkin");
        EntityManager entityManager = HUtil.getEntityManager("by.academy.it.test");
        entityManager.persist(person);
        entityManager.close();

        entityManager.getTransaction().begin();
       // entityManager.find(person.getId())
    }

}
