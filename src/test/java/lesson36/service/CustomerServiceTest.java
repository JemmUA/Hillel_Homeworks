package lesson36.service;

import lesson36.exception.WrongAgeException;
import lesson36.exception.WrongGenderException;
import lesson36.exception.WrongNameException;
import lesson36.exception.WroongIdException;
import lesson36.model.Customer;
import lesson36.model.Human;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;


class CustomerServiceTest {

    Human human = new Human("Alex", 23, "man");
    CustomerService customerService = new CustomerService();
    HumanService humanService = Mockito.mock(HumanService.class);

    @Test
    void ifCustomerNull() throws WrongNameException, WrongGenderException, WrongAgeException {
        when(humanService.validateName(anyString())).thenThrow(WrongNameException.class);
        when(humanService.validateAge(anyInt())).thenThrow(WrongAgeException.class);
        when(humanService.validateGender(anyString())).thenThrow(WrongGenderException.class);
        Customer customer = customerService.createCustomer(human, "human@mail.ua");
        assertNotNull(customer,"Customer not null");
        assertEquals(1,customer.getId());
        assertEquals("Alex",customer.getHuman().getName());
        assertEquals(23,customer.getHuman().getAge());
        assertEquals("man",customer.getHuman().getGender());
    }

    @Test
    void ifCustomerIdNull() {
        WroongIdException wroongIdException = assertThrows(WroongIdException.class, () -> customerService.validateCustomerId(null));
        assertEquals("Id is null", wroongIdException.getMessage());
    }
}