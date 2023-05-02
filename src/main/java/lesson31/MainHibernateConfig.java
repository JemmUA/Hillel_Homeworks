package lesson31;

import lesson31.domain.*;
import lesson31.service.CarService;
import lesson31.service.ClientService;
import lesson31.service.DriverLicenseService;
import lesson31.service.LanguageService;

import java.util.HashSet;

public class MainHibernateConfig {

    public static void main(String[] args) {
        CarService carService = new CarService();
        LanguageService languageService = new LanguageService();
        ClientService clientService = new ClientService();
        DriverLicenseService driverLicenseService = new DriverLicenseService();

        HashSet<Language> languages = new HashSet<>();

        HashSet<Car> cars = new HashSet<>();
//
//        for (LanguageWorld currentLanguage : LanguageWorld.values()) {
//            Language language = new Language();
//            language.setLanguage(currentLanguage);
//            languages.add(language);
//            languageService.save(language);
//        }

        HumanInfo humanInfo = new HumanInfo();
        humanInfo.setName("Alex");
        humanInfo.setSurname("Nice");
        humanInfo.setAge(21);
        humanInfo.setSex(Sex.MAN);
        humanInfo.setNationality(Nationality.AMERICAN);

        DriverLicense driverLicense = new DriverLicense();
        driverLicense.setHumanInfo(humanInfo);
        driverLicense.setCategory(Category.C);

        Client client = new Client();
        client.setHumanInfo(humanInfo);
        client.setEmail("alex@gmail.com");
        client.setPhone(80975557733L);
        client.setAbout("good man");

        client.setDriverLicense(driverLicense);
        client.setLanguages(languages);
        client.setCars(cars);
        clientService.save(client);

        Car car = new Car();
        car.setModel("Ferrari");
        car.setColor("Red");
        car.setClient(client);
        carService.save(car);

    }
}
