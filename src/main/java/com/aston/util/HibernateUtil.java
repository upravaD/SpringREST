package com.aston.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = initSessionFactory();

    private HibernateUtil() {
    }

    private static SessionFactory initSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();
        return configuration.buildSessionFactory();
    }


    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
