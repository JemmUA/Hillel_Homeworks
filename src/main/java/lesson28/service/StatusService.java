package lesson28.service;

import lesson28.entity.Status;
import lesson28.util.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StatusService{
    private String QUERY_GET_ALL = "SELECT * FROM statuses";
    private String QUERY_SAVE = "INSERT INTO statuses(alias, description) VALUES (?, ?)";
    private String QUERY_UPDATE_DESCRIPTION_BY_ALIAS = "UPDATE statuses SET description = ? WHERE alias = ?";
    private String QUERY_DELETE_BY_ID = "DELETE FROM statuses WHERE id = ?";

    public List<Status> getAll() {
        List<Status> statuses = new ArrayList<>();

        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(QUERY_GET_ALL);
            while (resultSet.next()) {
                connection.setAutoCommit(false);
                Status status = new Status();
                status.setId(resultSet.getInt("id"));
                status.setAlias(resultSet.getString("alias"));
                status.setDescription(resultSet.getString("description"));
                statuses.add(status);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statuses;
    }

    public void save (Status status){
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY_SAVE)) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, status.getAlias());
            preparedStatement.setString(2, status.getDescription());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById (Status status, int id){
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

    public void updateDescriptionByAlias (String description, String alias){
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE_DESCRIPTION_BY_ALIAS)) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, description);
            preparedStatement.setString(2, alias);
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


}
