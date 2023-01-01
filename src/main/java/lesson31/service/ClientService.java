package lesson31.service;

import lesson31.dao.ClientDao;
import lesson31.domain.Client;

public class ClientService {
    ClientDao clientDao = new ClientDao();

    public void save(Client client) {
        if (client == null) {
            System.out.println("Client is null");
        }
        System.out.println("Saving client: " + client.toString());
        clientDao.save(client);
    }
}
