package lesson29.service;

import lesson29.dao.ClientDao;
import lesson29.dao.ClientDaoImpl;
import lesson29.model.Client;

import java.util.List;

public class ClientService {
    ClientDao clientDao = new ClientDaoImpl();

    public void save(Client client) {
        if (client == null) {
            System.out.println("Client is null");
        }
        // logic here
        clientDao.save(client);
    }
    public Client getById(int id) {
        Client client = clientDao.getById(id);
        return client;
    }
    public List<Client> getAll() {
        return clientDao.getAll();
    }

    public List<Client> deleteById(int id) {
        return clientDao.deleteById(id);
    }
}
