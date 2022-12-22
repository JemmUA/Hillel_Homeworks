package lesson30.dao;

import lesson30.entity.Owner;
import lesson30.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class OwnerDao {

    public void save(final Owner owner) {
        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final Session session = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();

        session.save(owner);

        transaction.commit();
        session.close();
    }
}
