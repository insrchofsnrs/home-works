package by.academy.it;

import by.academy.it.tables.Animal;
import by.academy.it.tables.Bird;
import by.academy.it.tables.Cat;
import by.academy.it.util.EMUtil;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class TestsTables {

    @Test
    public void saveTest() {
        Animal animal = new Animal(null, 10, "Chupakabra");
        Cat cat = new Cat(null, 25, "Tom", 9);
        Bird bird = new Bird(null, 2, "Orlan", true);

        EntityManager em = EMUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(animal);
        em.persist(cat);
        em.persist(bird);
        em.getTransaction().commit();
        em.clear();

        em.getTransaction().begin();
        Animal animalFromDb = em.find(Animal.class, animal.getId());
        Assert.assertEquals(animal, animalFromDb);
        em.getTransaction().commit();
    }

    @Test
    //Как достать из базы всех поля, а не только те что прописаны в
    public  void readTest(){
        Animal animal = new Animal(null, 10, "Chupakabra");
        Cat cat = new Cat(null, 25, "Tom", 9);
        Bird bird1 = new Bird(null, 2, "Orlan", true);
        Bird bird2 = new Bird(null, 3, "Prichka", true);
        Bird bird3 = new Bird(null, 4, "Kurica", false);
        Bird bird4= new Bird(null, 5, "Straus", false);

        EntityManager em = EMUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(animal);
        em.persist(cat);
        em.persist(bird1);
        em.persist(bird2);
        em.persist(bird3);
        em.persist(bird4);
        em.getTransaction().commit();
        em.clear();
        List<Bird> birds = new ArrayList<>();
        birds = em.createQuery("SELECT c FROM Bird c").getResultList();
        System.out.println(birds);
        em.close();
    }

    @Test
    public void updateTest() {

        Cat cat = new Cat(null, 25, "Tom", 9);
        Bird bird = new Bird(null, 2, "Orlan", true);

        EntityManager em = EMUtil.getEntityManager();
        em.getTransaction().begin();

        em.persist(cat);
        em.persist(bird);
        em.getTransaction().commit();
        em.clear();

        em.getTransaction().begin();
        Bird animalFromDb = em.find(Bird.class, bird.getId());
        animalFromDb.setAge(12);
        animalFromDb.setCanFly(false);
        em.getTransaction().commit();
        em.clear();

        em.getTransaction().begin();
        Bird animalFromDb2 = em.find(Bird.class, bird.getId());

        Assert.assertEquals(animalFromDb.isCanFly(), animalFromDb.isCanFly());
        em.getTransaction().commit();
        em.close();
    }

}
