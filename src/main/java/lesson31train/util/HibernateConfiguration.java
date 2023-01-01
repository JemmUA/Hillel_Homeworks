package lesson31train.util;

import lesson31.domain.Car;
import lesson31.domain.Client;
import lesson31.domain.DriverLicense;
import lesson31.domain.Language;
import lesson31train.domain.Licuha;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateConfiguration {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {

                Configuration configuration = new Configuration().configure(); // Для файла hibernate.cfg.xml

//                configuration.addAnnotatedClass(Client.class);
//                configuration.addAnnotatedClass(DriverLicense.class);
//                configuration.addAnnotatedClass(Car.class);
//                configuration.addAnnotatedClass(Language.class);

                configuration.addAnnotatedClass(Licuha.class);

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
