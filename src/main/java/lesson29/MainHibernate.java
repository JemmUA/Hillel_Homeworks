package lesson29;

import lesson29.model.Customer;
import lesson29.service.CustomerService;
import lesson29.util.HibernateConfiguration;

public class MainHibernate {
    public static void main(String[] args) {
//        HibernateConfiguration.getSessionFactory();

        CustomerService customerService = new CustomerService();
        Customer customer = new Customer();
        customer.setName("Hellen");
        customer.setAge(18);
        customer.setEmail("hellen@mail.ua");
        customer.setPhone(380951232232L);
        customer.setAbout("barber");
        customerService.save(customer);
    }
}
