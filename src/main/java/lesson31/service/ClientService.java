package lesson31.service;

import lesson31.dao.ClientDao;
import lesson31.domain.Client;
import org.apache.log4j.Logger;

public class ClientService {
    ClientDao clientDao = new ClientDao();
    private Logger logger = Logger.getLogger(ClientService.class);

    public void save(Client client) {
        if (client == null) {
            logger.debug("Client is null");
        }
        System.out.println("Saving client: " + client.toString());
        clientDao.save(client);
    }
}
