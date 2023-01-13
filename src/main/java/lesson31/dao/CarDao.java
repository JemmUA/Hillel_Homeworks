package lesson31.dao;

import lesson31.domain.Car;
import lesson31.util.HibernateConfiguration;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CarDao {
    private Logger logger = Logger.getLogger(CarDao.class);

    public void save(Car car) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        if (car.getModel() == null) {
            logger.debug(String.format("Car model is null: %s, id = %d", car.getModel(), car.getId()));
        }
        session.save(car);

        transaction.commit();
        session.close();
    }

}
