package lesson31.service;

import lesson31.dao.DriverLicenseDao;
import lesson31.domain.DriverLicense;

public class DriverLicenseService {
    DriverLicenseDao driverLicenseDao = new DriverLicenseDao();

    public void save(DriverLicense driverLicense) {
        if (driverLicense == null) {
            System.out.println("Driver license is null");
        }
        System.out.println("Saving driver license: " + driverLicense.toString());
        driverLicenseDao.save(driverLicense);
    }
}
