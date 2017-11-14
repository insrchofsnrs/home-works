package by.academy.it.util;

import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMUtil {

    private static final EntityManagerFactory emFactory;
    private static final EntityManagerFactory emFactoryTest;


    // EMF
    static {
        emFactory = Persistence.createEntityManagerFactory("by.academy.it");
    }

    //Test EMF
    static {
        emFactoryTest = Persistence.createEntityManagerFactory("by.academy.it.test");
    }

    public static EntityManager getEntityManager() {
        return emFactory.createEntityManager();
    }

    public static EntityManager getTestEntityManager() {
        return emFactoryTest.createEntityManager();
    }

    public static void close() {
        emFactory.close();
        emFactoryTest.close();

    }
}
