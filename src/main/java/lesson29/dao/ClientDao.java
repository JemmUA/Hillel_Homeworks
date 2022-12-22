package lesson29.dao;

import lesson29.model.Client;

import java.util.List;

public interface ClientDao {
    void save (Client client);
    Client getById(int id);
    List<Client> getAll();
    List<Client> deleteById (int id);
}
