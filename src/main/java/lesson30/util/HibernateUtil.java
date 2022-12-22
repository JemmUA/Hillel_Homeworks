package lesson30.util;

import lesson30.entity.Car;
import lesson30.entity.Owner;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {

                Properties properties = new Properties(); // для файла hibernate.properties
                Configuration configuration = new Configuration().addProperties(properties); // для файла hibernate.properties
//                Configuration configuration = new Configuration().configure(); // Для файла hibernate.cfg.xml
                configuration.addAnnotatedClass(Car.class);
                configuration.addAnnotatedClass(Owner.class);

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
