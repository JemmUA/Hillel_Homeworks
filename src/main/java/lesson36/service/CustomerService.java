package lesson36.service;

import lesson36.exception.WrongAgeException;
import lesson36.exception.WrongGenderException;
import lesson36.exception.WrongNameException;
import lesson36.exception.WroongIdException;
import lesson36.model.Customer;
import lesson36.model.Human;

public class CustomerService {
    HumanService humanService = new HumanService();

    public Customer createCustomer(Human human, String email) throws WrongNameException, WrongAgeException, WrongGenderException {
        humanService.validateName("Alex");
        humanService.validateAge(32);
        humanService.validateGender("man");
        return new Customer(1, human, email);
    }

    public void validateCustomerId(Integer id) throws WroongIdException {
        if (id == null) {
            throw new WroongIdException("Id is null");
        }
    }

}
