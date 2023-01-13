package lesson31.service;

import lesson31.dao.LanguageDao;
import lesson31.domain.Language;
import org.apache.log4j.Logger;

public class LanguageService {
    LanguageDao languageDao = new LanguageDao();
    private Logger logger = Logger.getLogger(LanguageService.class);

    public void save(Language language) {
        if (languageDao == null) {
            logger.debug("Language is null");
        }
        System.out.println("Saving language: " + languageDao.toString());
        languageDao.save(language);
    }
}
