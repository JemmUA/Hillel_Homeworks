package lesson30.service;

import lesson30.dao.CarDao;
import lesson30.entity.Car;

import java.util.List;

public class CarService {
    private CarDao carDao = new CarDao();

    public void save(final Car car) {
        System.out.println("Car date for save: " + car.toString());
        carDao.save(car);
    }

    public Car gerById(final int id) {
        System.out.println("Id for getting car: " + id);
        return carDao.getById(id);
    }

    public void update(final Car car) {
        System.out.println("Car date for update: " + car.toString());
        carDao.update(car);
    }

    public void delete(final Car car) {
        System.out.println("Car for deleting: " + car.toString());
        carDao.delete(car);
    }

    public Car getByVinCode(final String vinCode) {
        System.out.println("vinCode for getting car: " + vinCode);
        return carDao.getByVinCode(vinCode);
    }

    public List<Car> getAll() {
        System.out.println("getting all cars...");
        return carDao.getAll();
    }

    public Car getByModel(final String model) {
        System.out.println("Model for getting car: " + model);
        return carDao.getByModel(model);
    }
}
