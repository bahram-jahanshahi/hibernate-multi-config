package ir.mctab.java32.hibernate.projects.multiconfig.config.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactoryOne;
    private static SessionFactory sessionFactoryTwo;
    private static SessionFactory sessionFactoryH2;
    private static Session sessionOne;
    private static Session sessionTwo;
    private static Session sessionH2;

    static {
        sessionFactoryOne = new Configuration()
                .configure("hibernate.db1.cfg.xml")
                .buildSessionFactory();

        sessionFactoryTwo = new Configuration()
                .configure("hibernate.db2.cfg.xml")
                .buildSessionFactory();

        sessionFactoryH2 = new Configuration()
                .configure("hibernate.h2.cfg.xml")
                .buildSessionFactory();


        sessionOne = sessionFactoryOne.openSession();
        sessionTwo = sessionFactoryTwo.openSession();
        sessionH2 = sessionFactoryH2.openSession();
    }

    public static Session getSessionOne(){
        return sessionOne;
    }

    public static Session getSessionTwo(){
        return sessionTwo;
    }

    public static Session getSessionH2() { return sessionH2; }
}
