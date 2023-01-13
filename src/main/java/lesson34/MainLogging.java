package lesson34;

import lesson34.controller.PhoneController;
import lesson34.model.Phone;

public class MainLogging {
    public static void main(String[] args) {

        //  !!! Homework performed in "lesson31" !!!

        // Rest are just examples from lesson 34

//        System.err.println("test");
//        Logger logger = Logger.getLogger(Name.class.getName());
//        logger.log(level.INFO, "info log");
        PhoneController phoneController = new PhoneController();
//        Phone phone = new Phone(1, "mobile", 380673459871L);
        Phone phone = new Phone(1, "mobile", null);
        phoneController.checkPhoneNumber(phone);
    }
}
