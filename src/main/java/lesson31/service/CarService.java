package lesson31.service;

import lesson31.dao.CarDao;
import lesson31.domain.Car;
import org.apache.log4j.Logger;

public class CarService {
    CarDao carDao = new CarDao();
    private Logger logger = Logger.getLogger(CarService.class);

    public void save(Car car) {
        if (car == null) {
            logger.debug("Car is null");
        }
        System.out.println("Saving car: " + car.toString());
        carDao.save(car);
    }
}
