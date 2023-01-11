package lesson29.dao;

import lesson29.model.Client;

import java.util.List;

public interface ClientDao {
    List<Client> getAll();

    void save(Client client);

    Client getById(int id);

    void update(Client client);

    void delete(Client client);

    Client getByName(String name);

    List<Client> getByAge(int age);

    Client getByPhone(Long name);
}
