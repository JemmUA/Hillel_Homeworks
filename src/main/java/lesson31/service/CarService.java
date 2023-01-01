package lesson31.service;

import lesson31.dao.CarDao;
import lesson31.domain.Car;

public class CarService {
    CarDao carDao = new CarDao();

    public void save(Car car) {
        if (car == null) {
            System.out.println("Car is null");
        }
        System.out.println("Saving car: " + car.toString());
        carDao.save(car);
    }
}
