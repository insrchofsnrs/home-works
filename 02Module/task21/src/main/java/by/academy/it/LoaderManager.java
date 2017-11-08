package by.academy.it;



import javax.persistence.EntityManager;

public class LoaderManager {
    public static void main(String[] args) throws Exception {
        Person person = new Person (null,35, "Yuli", "Slabko");
        EntityManager em = HUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        HUtil.close();
    }
}
