package lesson30;

import lesson30.entity.Gender;
import lesson30.entity.Info;
import lesson30.entity.Owner;
import lesson30.service.CarService;
import lesson30.service.OwnerService;

import java.time.LocalDateTime;

public class MainHibernatePractice {
    public static void main(String[] args) {
        final CarService carService = new CarService();
//        final Car car = new Car();
//        car.setModel("Toyota");
//        car.setVinCode("RG777777555");
//        car.setType("truck");
//        carService.save(car);
//
//        final Car carById = carService.gerById(1);
//        System.out.println(carById);
//
//        carById.setModel("Lexus");
//        carService.update(carById);
//
//        final Car carForDelete = carService.gerById(4);
//        carService.delete(carForDelete);

//        final Car carByVinCode = carService.getByVinCode("FG123456789");
//        System.out.println(carByVinCode);

//        final List<Car> cars = carService.getAll();
//        System.out.println(cars);

//        final Car lexus = carService.getByModel("Lexus");
//        System.out.println(lexus);

        final OwnerService ownerService = new OwnerService();
        final Owner owner = new Owner();
        owner.setName("Alex");
        owner.setGender(Gender.MAN);
        owner.setInfo(new Info(
                "Kyiv",
                "Ukraine",
                LocalDateTime.of(2000, 8, 23, 15, 38),
                null
        ));

        ownerService.save(owner);
    }
}
