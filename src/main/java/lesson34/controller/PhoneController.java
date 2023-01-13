package lesson34.controller;

import lesson34.model.Phone;
import lesson34.service.PhoneService;
import org.apache.log4j.Logger;

//import java.util.logging.Level;
//import java.util.logging.Logger;

public class PhoneController {
    private PhoneService phoneService = new PhoneService();
    //    private Logger logger = LoggerUtil.getLogger(PhoneController.class);
    private Logger logger = Logger.getLogger(PhoneController.class);

    public void checkPhoneNumber(Phone phone) {
//        logger.log(Level.INFO, phone.getNumber().toString());
        if (phone.getNumber() == null) {
            logger.error(String.format("Phone id = %d, number is NULL", phone.getId()));
        }
        phoneService.checkPhoneNumber(phone.getNumber());
    }
}
