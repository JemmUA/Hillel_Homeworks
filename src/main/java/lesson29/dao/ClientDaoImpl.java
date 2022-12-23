package lesson29.dao;

import lesson29.model.Client;
import lesson29.util.HibernateConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

public class ClientDaoImpl implements ClientDao{
    @Override
    public List<Client> getAll() {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

//        List<Client> clients = session.createNativeQuery("select * from Clients").list();
//        Query query = session.createNativeQuery("select * from Clients", Client.class);
        Query query = session.createNamedQuery("getAll");
        List<Client> clients = query.getResultList();

        transaction.commit();
        session.close();

        return clients;
    }

    @Override
    public void save(Client client) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(client);

        transaction.commit();
        session.close();
    }

    @Override
    public Client getById(int id) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Client client = session.get(Client.class, id);

        transaction.commit();
        session.close();

        return client;
    }

    @Override
    public void update(Client client) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(client);

        transaction.commit();
        session.close();

    }

    @Override
    public void delete(Client client) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(client);

        transaction.commit();
        session.close();
    }

    @Override
    public Client getByName(String name) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

//        Query query = session.createNativeQuery( "SELECT * FROM clients WHERE name = :name", Client.class);
        Query query = session.createNamedQuery("getByName");
        query.setParameter("name", name);
        Client client = (Client) query.getSingleResult();

        transaction.commit();
        session.close();

        return client;
    }

    @Override
    public List<Client> getByAge(int age) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createNamedQuery("getByAge");
        query.setParameter("age", age);
        List<Client> clients = query.getResultList();

        transaction.commit();
        session.close();

        return clients;
    }

    @Override
    public Client getByPhone(Long phone) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createNamedQuery("getByPhone");
        query.setParameter("phone", phone);
        Client client = (Client) query.getSingleResult();

        transaction.commit();
        session.close();

        return client;
    }


}
