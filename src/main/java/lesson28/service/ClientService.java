package lesson28.service;

import lesson28.entity.Client;
import lesson28.util.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private String QUERY_GET_ALL = "SELECT * FROM clients";
    private String QUERY_SAVE = "INSERT INTO clients(name, email, phone, about, age) VALUES (?, ?, ?, ?, ?)";
    private String QUERY_UPDATE_NAME_BY_ID = "UPDATE clients SET name = ? WHERE id = ?";
    private String QUERY_DELETE_BY_ID = "DELETE FROM clients WHERE id = ?";
    private String QUERY_GET_BY_PHONE = "SELECT * FROM clients WHERE phone = ?";
    private String QUERY_GET_ID_EQUAL_TO_ACCOUNTID  =
            "select clients.id, clients.name, clients.email, clients.phone, clients.about, clients.age from clients, accounts where clients.id = accounts.client_id";
    private String QUERY_JOIN_TABLES  = "select c.name, c.email, s.alias from clients as c inner join client_status as cs on c.id = cs.client_id inner join statuses as s on s.id = cs.status_id where c.age > 18;";
    private String QUERY_ADD_COLUMN_AGE  = "ALTER TABLE clients ADD age int ";
    private String QUERY_FILL_COLUMN_AGE  = "UPDATE clients SET age = ? WHERE id = ?";

    public List<Client> getAll() {
        List<Client> clients = new ArrayList<>();

        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(QUERY_GET_ALL);
            while (resultSet.next()) {
                connection.setAutoCommit(false);
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
                client.setPhone(resultSet.getLong("phone"));
                client.setAbout(resultSet.getString("about"));
                client.setAge(resultSet.getInt("age"));
                clients.add(client);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }
    public void save (Client client){
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY_SAVE)) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getEmail());
            preparedStatement.setLong(3, client.getPhone());
            preparedStatement.setString(4, client.getAbout());
            preparedStatement.setInt(5, client.getAge());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateNameById (String name, int id){
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE_NAME_BY_ID)) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteById (int id){
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
    public Client getByPhone(long phone) {
        Client client = new Client();
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY_GET_BY_PHONE)) {
            connection.setAutoCommit(false);
            preparedStatement.setLong(1, phone);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            client.setId(resultSet.getInt("id"));
            client.setName(resultSet.getString("name"));
            client.setEmail(resultSet.getString("email"));
            client.setPhone(resultSet.getLong("phone"));
            client.setAbout(resultSet.getString("about"));
            client.setAge(resultSet.getInt("age"));
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return client;
    }

    public List<Client> getIdEqualAccountId() {
        List<Client> clients = new ArrayList<>();

        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(QUERY_GET_ID_EQUAL_TO_ACCOUNTID);
            while (resultSet.next()) {
                connection.setAutoCommit(false);
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
                client.setPhone(resultSet.getLong("phone"));
                client.setAbout(resultSet.getString("about"));
                client.setAge(resultSet.getInt("age"));
                clients.add(client);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public List joinTables() {
        List clients = new ArrayList<>();

        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(QUERY_JOIN_TABLES);
            while (resultSet.next()) {
                connection.setAutoCommit(false);
                Client client = new Client();
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
                client.setAbout(resultSet.getString("alias"));
                clients.add(client);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public void addColumnAge (){
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ADD_COLUMN_AGE)) {
            connection.setAutoCommit(false);
//            preparedStatement.setString(1, column);
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void setAge (int age, int id){
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY_FILL_COLUMN_AGE)) {
            connection.setAutoCommit(false);
            preparedStatement.setInt(1, age);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
