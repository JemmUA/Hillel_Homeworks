package lesson29.util;

import lesson29.model.Account;
import lesson29.model.Client;
import lesson29.model.Status;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class HibernateConfiguration {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {

//                Properties properties = new Properties(); // для файла hibernate.properties
//                Configuration configuration = new Configuration().addProperties(properties); // для файла hibernate.properties
                Configuration configuration = new Configuration().configure(); // Для файла hibernate.cfg.xml

                configuration.addAnnotatedClass(Account.class);
                configuration.addAnnotatedClass(Client.class);
                configuration.addAnnotatedClass(Status.class);

                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                System.out.println("Session factory Error: " + e);
            }
        }
        return sessionFactory;
    }
}
