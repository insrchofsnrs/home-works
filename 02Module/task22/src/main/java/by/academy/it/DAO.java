package by.academy.it;

import org.hibernate.Session;

import java.io.Serializable;

public class DAO {

public Cat getCat(Serializable id){
    //if (HibernateUtil.getTestEntityManager() != null)
    Session session = HibernateUtil.getTestSession();
    Cat cat = session.get(Cat.class, id);
    return cat;
}

public Cat loadCat(Serializable id){
    Cat cat = HibernateUtil.getTestSession().load(Cat.class, id);
    return cat;
}

}
