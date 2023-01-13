package lesson31.dao;

import lesson31.domain.Language;
import lesson31.util.HibernateConfiguration;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class LanguageDao {
    private Logger logger = Logger.getLogger(LanguageDao.class);

    public void save(Language language) {
        SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        if (language.getLanguage() == null) {
            logger.debug(String.format("Language is null: %s, id = %d", language.getLanguage(), language.getId()));
        }
        session.save(language);

        transaction.commit();
        session.close();
    }
}
