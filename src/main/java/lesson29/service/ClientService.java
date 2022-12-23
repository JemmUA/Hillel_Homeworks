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
        System.out.println("Saving client: " + client.toString());
        clientDao.save(client);
    }
    public Client getById(int id) {
        System.out.println("Getting client by ID: " + id);
        return clientDao.getById(id);
    }
    public void update (Client client) {
        System.out.println("Updating client: " + client.toString());
        clientDao.update(client);
    }
    public void delete (Client client) {
        System.out.println("Deleting client: " + client.toString());
        clientDao.delete(client);
    }
    public List<Client> getAll() {
        System.out.println("Getting all clients");
        return clientDao.getAll();
    }
    public Client getByName (String name) {
        System.out.println("Getting client by Name: " + name);
        return clientDao.getByName(name);
    }
    public List<Client> getByAge (int age) {
        System.out.println("Getting clients by Age: " + age);
        return clientDao.getByAge(age);
    }
    public Client getByPhone (Long phone) {
        System.out.println("Getting client by Phone: " + phone);
        return clientDao.getByPhone(phone);
    }

}
