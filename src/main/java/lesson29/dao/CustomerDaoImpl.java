package lesson29.dao;

import lesson29.model.Customer;
import lesson29.util.HibernateConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerDaoImpl implements CustomerDao{
    @Override
    public void save(Customer customer) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(customer);

        transaction.commit();
        session.close();
    }

    @Override
    public Customer getById(int id) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = session.byId(Customer.class).getReference(id);

        transaction.commit();
        session.close();

        return customer;
    }

    @Override
    public List<Customer> getAll() {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Customer> customers = session.createNativeQuery("select * from Client").list();

        transaction.commit();
        session.close();

        return customers;
    }
}
