package lesson29.service;

import lesson29.dao.AccountDao;
import lesson29.dao.AccountDaoImpl;
import lesson29.model.Account;

public class AccountService {

    AccountDao accountDao = new AccountDaoImpl();

    public void save(Account account) {
        if (account == null) {
            System.out.println("Account is null");
        }
        // logic here
        System.out.println("Saving account: " + account.toString());
        accountDao.save(account);
    }

    public Account getById(int id) {
        System.out.println("Getting account by ID: " + id);
        return accountDao.getById(id);
    }

    public void update(Account account) {
        System.out.println("Updating account: " + account.toString());
        accountDao.update(account);
    }

    public void delete(Account account) {
        System.out.println("Deleting account: " + account.toString());
        accountDao.delete(account);
    }

}
