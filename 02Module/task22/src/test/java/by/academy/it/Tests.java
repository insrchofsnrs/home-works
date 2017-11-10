package by.academy.it;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.SecondaryTable;

public class Tests {

    private Cat cat;

    @Before
    public void init() {
        Session session = HibernateUtil.getTestSession();
        cat = new Cat(1L, "Tom", 10);
        session.beginTransaction();
        session.save(cat);
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void getLoadTests() {
        DAO dao = new DAO();
        Cat cat1 = dao.getCat(2L);
        Cat cat2 = dao.loadCat(2L);
        System.out.println(cat1);
        try {
            System.out.println(cat2);
        } catch (HibernateException e) {
            System.out.println("Не удалось найти кота  " + e);
        }
    }

    @Test
    public void saveTest() {
        Session session = HibernateUtil.getTestSession();
        Assert.assertNotNull(session);
        Cat cat = new Cat(30L, "Toms", 12);
        session.beginTransaction();
        session.save(cat);
        session.getTransaction().commit();
        session.evict(cat);

        Cat personFromDb = session.get(Cat.class, cat.getId());
        Assert.assertEquals(cat, personFromDb);

        session.close();
    }


    @Test
    public void lazyLoadTest() {
        Session session = HibernateUtil.getTestSession();
        Cat loadedCat = session.load(Cat.class, 1L);
        session.clear();
        session.update(loadedCat);
        loadedCat.getAge();
        session.close();
    }

    @Test
    public void isDirtyTest() {
        Session session = HibernateUtil.getTestSession();
        session.getTransaction().begin();
        Cat loadedCat1 = session.get(Cat.class, 1L);

        loadedCat1.setAge(11);


        System.out.println(session.isDirty());
        //не очень понятно
        Cat loadedCat2 = session.get(Cat.class, 1L);
        System.out.println(loadedCat2.getAge());
        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void deleteTest() {
        Session session = HibernateUtil.getTestSession();
        Cat catDeleted = new Cat(44L, "Good Boy", 3);
        System.out.println("Count before save " + session.createQuery("Select count(*) from Cat").getSingleResult());
        session.beginTransaction();
        session.save(catDeleted);
        System.out.println("Count after save " + session.createQuery("Select count(*) from Cat").getSingleResult());
        session.delete(catDeleted);
        session.getTransaction().commit();
        System.out.println("Count after delete " + session.createQuery("Select count(*) from Cat").getSingleResult());

        session.close();
    }

    @Test
    public void deleteExistedTest() {
        Session session = HibernateUtil.getTestSession();
        session.beginTransaction();
        Cat cat = session.get(Cat.class, 1L);
        session.delete(cat);
        session.getTransaction().commit();
        //session.flush();
        session.clear();
        Cat cat2 = session.get(Cat.class, 1L);
        System.out.println(cat2);

        session.close();
    }

    @Test
    public void flushCommitTest() {
        Session session = HibernateUtil.getTestSession();
        Cat cat = new Cat(3l, "Kitty", 22);
        session.getTransaction().begin();
        session.save(cat);
        //session.flush();
        Cat cat1 = session.get(Cat.class, 3l);
        System.out.println("Person is persisted before commit.  " + cat1);
        session.getTransaction().commit();
        session.close();
    }


    @After
    public void closeSessionFactory() {
        HibernateUtil.getTestSession().delete(cat);
    }
}
