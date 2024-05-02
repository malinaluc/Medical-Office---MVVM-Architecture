package org.example.repository;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import static org.example.utils.ExtensionFunctions.logDebug;
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    /**
     * If the sessionFactory object is not yet initialized,
     * then a new instance is created using the default configuration from the hibernate.cfg.xml file.
     */

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {

                // The configuration is specified in the hibernate.cfg.xml file.
                StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
                sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
            } catch (Exception e) {
                logDebug("getSessionFactory exception = " + e);
            }
        }
        return sessionFactory;
    }
}
