package lesson31.dao;

import lesson31.domain.Language;
import lesson31.util.HibernateConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class LanguageDao {
    public void save(Language language) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(language);

        transaction.commit();
        session.close();
    }
}
