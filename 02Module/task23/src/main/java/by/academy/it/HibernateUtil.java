package by.academy.it;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class HibernateUtil {

    private static final EntityManagerFactory emFactory;
    private static final EntityManagerFactory emFactoryTest;
    private static final SessionFactory sessionFactory;
    private static final SessionFactory sessionFactoryTest;



    // EMF
    static {
        emFactory = Persistence.createEntityManagerFactory("by.academy.it");
    }
    //Test EMF
    static {
        emFactoryTest = Persistence.createEntityManagerFactory("by.academy.it.test");
    }


    /*
        SessionFactory initialization
     */
    static {
        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();

        // Hibernate settings equivalent to hibernate.cfg.xml's properties
        Map<String, String> settings = new HashMap<>();
        settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        settings.put(Environment.URL, "jdbc:mysql://localhost:3306/mysql2");
        settings.put(Environment.USER, "root");
        settings.put(Environment.PASS, "root");
        settings.put(Environment.HBM2DDL_AUTO, "validate");
        settings.put(Environment.SHOW_SQL, "true");
        settings.put(Environment.STORAGE_ENGINE, "innodb");

        // Apply settings
        serviceRegistryBuilder.applySettings(settings);

        // Create registry
        ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();

        // Create MetadataSources
        MetadataSources sources = new MetadataSources(serviceRegistry);
        sources.addAnnotatedClass(Cat.class);

        // Create Metadata
        Metadata metadata = sources.getMetadataBuilder().build();

        // Create SessionFactory
        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }

    /*
        TEST SessionFactory initialization
     */
    static {
        StandardServiceRegistryBuilder serviceRegistryBuilderTest = new StandardServiceRegistryBuilder();

        // Hibernate settings equivalent to hibernate.cfg.xml's properties
        Map<String, String> settings = new HashMap<>();
        settings.put(Environment.DRIVER, "org.h2.Driver");
        settings.put(Environment.URL, "jdbc:h2:mem:jpadb");
        settings.put(Environment.USER, "root");
        settings.put(Environment.PASS, "");
        settings.put(Environment.HBM2DDL_AUTO, "create");
        settings.put(Environment.SHOW_SQL, "true");
        settings.put(Environment.STORAGE_ENGINE, "innodb");

        // Apply settings
        serviceRegistryBuilderTest.applySettings(settings);

        // Create registry
        ServiceRegistry serviceRegistry = serviceRegistryBuilderTest.build();

        // Create MetadataSources
        MetadataSources sources = new MetadataSources(serviceRegistry);
        sources.addAnnotatedClass(Cat.class);

        // Create Metadata
        Metadata metadata = sources.getMetadataBuilder().build();

        // Create SessionFactory
        sessionFactoryTest = metadata.getSessionFactoryBuilder().build();
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

    public static Session getSession() {
        return sessionFactory.openSession();
    }
    public static Session getTestSession() {
        return sessionFactoryTest.openSession();
    }

    public static void closeSessionFactory() {
        sessionFactory.close();
        sessionFactoryTest.close();
    }
}





































