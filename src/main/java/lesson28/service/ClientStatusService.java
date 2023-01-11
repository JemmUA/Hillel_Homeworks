package lesson28.service;

import lesson28.entity.ClientStatus;
import lesson28.util.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientStatusService {
    private String QUERY_GET_ALL = "SELECT * FROM client_status";
    private String QUERY_SAVE = "INSERT INTO client_status(client_id, status_id) VALUES (?, ?)";
    private String QUERY_UPDATE_STATUSID_BY_CLIENTID_AND_STATUSID = "UPDATE client_status SET status_id = ? WHERE client_id = ? AND status_id = ?";
    private String QUERY_DELETE_BY_CLIENTID = "DELETE FROM client_status WHERE client_id = ?";
    private String QUERY_DELETE_BY_STATUSID = "DELETE FROM client_status WHERE status_id = ?";


    public List<ClientStatus> getAll() {
        List<ClientStatus> clientsStatuses = new ArrayList<>();

        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(QUERY_GET_ALL);
            while (resultSet.next()) {
                connection.setAutoCommit(false);
                ClientStatus client = new ClientStatus();
                client.setClient_id(resultSet.getInt("client_id"));
                client.setStatus_id(resultSet.getInt("status_id"));
                clientsStatuses.add(client);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientsStatuses;
    }

    public void save(ClientStatus clientStatus) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY_SAVE)) {
            connection.setAutoCommit(false);
            preparedStatement.setInt(1, clientStatus.getClient_id());
            preparedStatement.setInt(2, clientStatus.getStatus_id());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStatusIdByClientIdAndStatusId(int newStatus, int clientId, int statusId) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE_STATUSID_BY_CLIENTID_AND_STATUSID)) {
            connection.setAutoCommit(false);
            preparedStatement.setInt(1, newStatus);
            preparedStatement.setInt(2, clientId);
            preparedStatement.setInt(3, statusId);
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteByClientId(int clientId) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE_BY_CLIENTID)) {
            connection.setAutoCommit(false);
            preparedStatement.setInt(1, clientId);
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteByStatusId(int statusId) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE_BY_STATUSID)) {
            connection.setAutoCommit(false);
            preparedStatement.setInt(1, statusId);
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
