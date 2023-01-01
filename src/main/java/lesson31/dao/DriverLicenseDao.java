package lesson31.dao;

import lesson31.domain.DriverLicense;
import lesson31.util.HibernateConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DriverLicenseDao {
    public void save(DriverLicense driverLicense) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(driverLicense);

        transaction.commit();
        session.close();
    }
}
