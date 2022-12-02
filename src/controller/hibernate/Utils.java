package controller.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;
import java.util.List;

public class Utils {
    public static Configuration getConfig() {
        Configuration configuration = new Configuration();
        configuration.configure();
        return configuration;
    }

    public static void save(Object object) {
        SessionFactory sessionFactory = getConfig().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //Save object
        session.save(object);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    public static void delete(Object object) {
        SessionFactory sessionFactory = getConfig().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //Delete object
        session.delete(object);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    public static void update(Object object) {
        SessionFactory sessionFactory = getConfig().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //Update object
        session.update(object);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    public static Object get(Class clase, int id) {
        SessionFactory sessionFactory = getConfig().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //Get object
        Object object = session.get(clase, id);

        transaction.commit();
        session.close();
        sessionFactory.close();

        return object;
    }

    public static Object getRelation(Class clase, Object object) {
        SessionFactory sessionFactory = getConfig().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //Get object
        Object object1 = session.get(clase, (Serializable) object);

        transaction.commit();
        session.close();
        sessionFactory.close();

        return object1;
    }


    public static List<Object> getAll(Class clase) {
        SessionFactory sessionFactory = getConfig().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //Get object
        List<Object> objects = session.createQuery("from " + clase.getName()).list();

        transaction.commit();
        session.close();
        sessionFactory.close();

        return objects;
    }

    public static List<Object> getAllWithWhere(Class clase, String where) {
        SessionFactory sessionFactory = getConfig().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //Get object
        List<Object> objects = session.createQuery("from " + clase.getName() + " where " + where).list();

        transaction.commit();
        session.close();
        sessionFactory.close();

        return objects;
    }

    public static List<Object> getQuery(String query) {
        SessionFactory sessionFactory = getConfig().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Object> objects = session.createSQLQuery(query).list();

        transaction.commit();
        session.close();
        sessionFactory.close();

        return objects;
    }
}
