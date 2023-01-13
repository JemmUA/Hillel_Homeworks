package lesson31.dao;

import lesson31.domain.DriverLicense;
import lesson31.util.HibernateConfiguration;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DriverLicenseDao {
    private Logger logger = Logger.getLogger(DriverLicenseDao.class);

    public void save(DriverLicense driverLicense) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        if (driverLicense.getHumanInfo().getSurname() == null) {
            logger.debug(String.format("Surname is null: %s, id = %d", driverLicense.getHumanInfo().getSurname(), driverLicense.getId()));
        }
        if (driverLicense.getCategory() == null) {
            logger.debug(String.format("Category is null: %s, id = %d", driverLicense.getCategory(), driverLicense.getId()));
        }
        session.save(driverLicense);

        transaction.commit();
        session.close();
    }
}
