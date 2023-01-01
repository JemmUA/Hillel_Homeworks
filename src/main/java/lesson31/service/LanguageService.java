package lesson31.service;

import lesson31.dao.LanguageDao;
import lesson31.domain.Language;

public class LanguageService {
    LanguageDao languageDao = new LanguageDao();

    public void save(Language language) {
        if (languageDao == null) {
            System.out.println("Language is null");
        }
        System.out.println("Saving language: " + languageDao.toString());
        languageDao.save(language);
    }
}
