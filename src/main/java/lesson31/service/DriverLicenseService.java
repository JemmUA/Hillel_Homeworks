package lesson31.service;

import lesson31.dao.DriverLicenseDao;
import lesson31.domain.DriverLicense;
import org.apache.log4j.Logger;

public class DriverLicenseService {
    DriverLicenseDao driverLicenseDao = new DriverLicenseDao();
    private Logger logger = Logger.getLogger(DriverLicenseService.class);

    public void save(DriverLicense driverLicense) {
        if (driverLicense == null) {
            logger.debug("Driver license is null");
        }
        System.out.println("Saving driver license: " + driverLicense.toString());
        driverLicenseDao.save(driverLicense);
    }
}
