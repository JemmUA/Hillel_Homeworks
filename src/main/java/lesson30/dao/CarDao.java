package lesson30.dao;

import lesson30.entity.Car;
import lesson30.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CarDao {

    public void save(final Car car) {
        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final Session session = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();

        session.save(car);

        transaction.commit();
        session.close();
    }

    public Car getById(int id) {
        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final Session session = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();

        final Car car = session.get(Car.class, id);

        transaction.commit();
        session.close();

        return car;
    }

    public void update(final Car car) {
        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final Session session = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();

        session.update(car);

        transaction.commit();
        session.close();
    }

    public void delete(final Car car) {
        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final Session session = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();

        session.delete(car);

        transaction.commit();
        session.close();
    }

    public Car getByVinCode(final String vinCode) {
        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final Session session = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();

        final Query query = session.createNativeQuery(
                "SELECT * FROM cars WHERE vin_code = :vinCode",
                Car.class
        );
        query.setParameter("vinCode", vinCode);
        Car car = (Car) query.getSingleResult();

        transaction.commit();
        session.close();

        return car;
    }

    public List<Car> getAll() {
        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final Session session = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();

        final Query query = session.createNamedQuery("getAll");
        List<Car> cars = query.getResultList();

        transaction.commit();
        session.close();

        return cars;
    }

    public Car getByModel(final String model) {
        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final Session session = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();

        final Query query = session.createNamedQuery("getByModel");
        query.setParameter("model", model);
        Car car = (Car) query.getSingleResult();

        transaction.commit();
        session.close();

        return car;
    }
}
