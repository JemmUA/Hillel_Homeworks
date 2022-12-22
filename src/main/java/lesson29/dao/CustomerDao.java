package lesson29.dao;

import lesson29.model.Customer;

import java.util.List;

public interface CustomerDao {
    void save (Customer customer);
    Customer getById(int id);
    List<Customer> getAll();

}
