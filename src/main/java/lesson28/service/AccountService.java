package lesson28.service;

import lesson28.entity.Account;
import lesson28.util.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountService {
    private String QUERY_GET_ALL = "SELECT * FROM accounts";
    private String QUERY_SAVE = "INSERT INTO accounts(client_id, number, value) VALUES (?, ?, ?)";
    private String QUERY_UPDATE_CLIENTID_BY_ID = "UPDATE accounts SET client_id = ? WHERE id = ?";
    private String QUERY_DELETE_BY_ID = "DELETE FROM accounts WHERE id = ?";
    private String QUERY_GET_LONGER_NUMBER = "SELECT * FROM accounts WHERE LENGTH(number) > ?;";

    public List<Account> getAll() {
        List<Account> accounts = new ArrayList<>();

        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(QUERY_GET_ALL);
            while (resultSet.next()) {
                connection.setAutoCommit(false);
                Account account = new Account();
                account.setId(resultSet.getInt("id"));
                account.setClient_id(resultSet.getInt("client_id"));
                account.setNumber(resultSet.getString("number"));
                account.setValue(resultSet.getDouble("value"));
                accounts.add(account);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public void save(Account account) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY_SAVE)) {
            connection.setAutoCommit(false);
            preparedStatement.setInt(1, account.getClient_id());
            preparedStatement.setString(2, account.getNumber());
            preparedStatement.setDouble(3, account.getValue());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateClientIdById(int clientId, int id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE_CLIENTID_BY_ID)) {
            connection.setAutoCommit(false);
            preparedStatement.setInt(1, clientId);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE_BY_ID)) {
            connection.setAutoCommit(false);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Account> getLongerNumber(int length) {
        List<Account> accounts = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY_GET_LONGER_NUMBER)) {
            preparedStatement.setLong(1, length);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                connection.setAutoCommit(false);
                Account account = new Account();
                account.setId(resultSet.getInt("id"));
                account.setClient_id(resultSet.getInt("client_id"));
                account.setNumber(resultSet.getString("number"));
                account.setValue(resultSet.getDouble("value"));
                accounts.add(account);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

}
