package lesson29.dao;

import lesson29.model.Account;

import java.util.List;

public interface AccountDao {
    void save (Account account);
    Account getById(int id);
    void update(Account account);
    void delete(Account account);
}
