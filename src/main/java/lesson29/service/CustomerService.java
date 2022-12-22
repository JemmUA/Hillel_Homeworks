package lesson29.service;

import lesson29.dao.CustomerDao;
import lesson29.dao.CustomerDaoImpl;
import lesson29.model.Customer;

import java.util.List;

public class CustomerService {
    CustomerDao customerDao = new CustomerDaoImpl();

    public void save(Customer customer) {
        if (customer == null) {
            System.out.println("Customer is null");
        }
        // logic here
        customerDao.save(customer);
    }
    public Customer getById(int id) {
        Customer customer = customerDao.getById(id);
        return customer;
    }
    public List<Customer> getAll() {
        return customerDao.getAll();
    }

}
