package lesson31.util;

import lesson31.domain.Car;
import lesson31.domain.Client;
import lesson31.domain.DriverLicense;
import lesson31.domain.Language;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateConfiguration {
    private static Logger logger = Logger.getLogger(HibernateConfiguration.class);
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {

                Configuration configuration = new Configuration().configure(); // Для файла hibernate.cfg.xml

                configuration.addAnnotatedClass(Client.class);
                configuration.addAnnotatedClass(DriverLicense.class);
                configuration.addAnnotatedClass(Car.class);
                configuration.addAnnotatedClass(Language.class);

                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                logger.error(String.format("Session factory Error: " + e));
            }
        } else {
            logger.info(String.format("Session factory already exists"));
        }
        return sessionFactory;
    }
}
