package lesson31.dao;

import lesson31.domain.Client;
import lesson31.util.HibernateConfiguration;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ClientDao {
    private Logger logger = Logger.getLogger(ClientDao.class);

    public void save(Client client) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        if (client.getHumanInfo().getSurname() == null) {
            logger.debug(String.format("Surname is null: %s, id = %d", client.getHumanInfo().getSurname(), client.getId()));
        }
        if (client.getEmail() == null) {
            logger.debug(String.format("Email is null: %s, id = %d", client.getEmail(), client.getId()));
        }
        session.save(client);

        transaction.commit();
        session.close();
    }
}
