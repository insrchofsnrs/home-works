package by.academy.it;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HUtil {
    private static EntityManagerFactory emFactory;

    public static EntityManager getEntityManager(String classPath) {
        if (classPath == null) {
            emFactory = Persistence.createEntityManagerFactory("by.academy.it");
        } else {
            emFactory = Persistence.createEntityManagerFactory(classPath);
        }
        return emFactory.createEntityManager();
    }

    public static EntityManager getEntityManager() {
        emFactory = Persistence.createEntityManagerFactory("by.academy.it");
        return emFactory.createEntityManager();
    }

    public static void close() {
        emFactory.close();
    }
}
