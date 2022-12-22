package lesson29;

import lesson29.model.Client;
import lesson29.service.ClientService;

public class MainHibernate {
    public static void main(String[] args) {

        ClientService clientService = new ClientService();
//        Client client = new Client();
//        client.setName("Oleg");
//        client.setAge(32);
//        client.setEmail("oleg@mail.ua");
//        client.setPhone(380963242317L);
//        client.setAbout("mechanic");
//        clientService.save(client);

//        clientService.getById(1);
//        clientService.getAll();
        clientService.deleteById(20);
    }
}
