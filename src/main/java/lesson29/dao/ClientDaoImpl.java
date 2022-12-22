package lesson29.dao;

import lesson29.model.Client;
import lesson29.util.HibernateConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ClientDaoImpl implements ClientDao{
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

        Client client = session.byId(Client.class).getReference(id);

        transaction.commit();
        session.close();

        return client;
    }

    @Override
    public List<Client> getAll() {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Client> clients = session.createNativeQuery("select * from Clients").list();

        transaction.commit();
        session.close();

        return clients;
    }
}
