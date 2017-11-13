package by.academy.it;


import org.junit.Test;

import javax.persistence.EntityManager;


public class TestEntities {



    @Test
    public void printId(){
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        Person person = new Person(null, "Evgeny");
        Cat cat = new Cat(null, "Tom");
        Doc doc = new Doc(null, "Docvet");

        em.persist(person);
        em.persist(cat);
        em.persist(doc);

        em.getTransaction().commit();
        em.clear();


        em.getTransaction().begin();
        Person perBd = em.find(Person.class, person.getId());
        System.out.println("id person:" + perBd.getId());

        Cat catBd = em.find(Cat.class, cat.getId());
        System.out.println("id cat:"+catBd.getId());

        Doc docBd = em.find(Doc.class, doc.getId());
        System.out.println("id doc:"+docBd.getId());
        em.getTransaction().commit();
        em.close();
    }
}
