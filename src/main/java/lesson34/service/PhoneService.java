package lesson34.service;

import org.apache.log4j.Logger;

public class PhoneService {
    private Logger logger = Logger.getLogger(PhoneService.class);

    public void checkPhoneNumber(Long number) {
        logger.error(String.format("Validating phone number is %d", number));
    }
}
