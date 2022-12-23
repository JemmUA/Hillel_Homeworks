package lesson29;

import lesson29.model.Account;
import lesson29.model.Client;
import lesson29.model.Status;
import lesson29.service.AccountService;
import lesson29.service.ClientService;
import lesson29.service.StatusService;

import java.util.List;

public class MainHibernate {
    public static void main(String[] args) {

        ClientService clientService = new ClientService();
        AccountService accountService= new AccountService();
        StatusService statusService= new StatusService();
//
//        List<Client> clients = clientService.getAll();
//        clients.forEach(System.out::println);

//        Client client = new Client();
//        client.setName("Molly");
//        client.setAge(4);
//        client.setEmail("molly@mail.ua");
//        client.setPhone(380963242352L);
//        client.setAbout("little girl");
//        clientService.save(client);

//        Account account = new Account();
//        account.setClient_id(22);
//        account.setNumber("SG34378272");
//        account.setValue(2134151.23);
//        accountService.save(account);
//
//        Status status = new Status();
//        status.setAlias("TEST");
//        status.setDescription("status without responsibility");
//        statusService.save(status);

//        System.out.println(clientService.getById(1));
//        System.out.println(accountService.getById(3));
//        System.out.println(statusService.getById(5));
//
//        Client clientById = clientService.getById(2);
//        clientById.setAbout("kind");
//        clientService.update(clientById);
//
//        Account accountById = accountService.getById(2);
//        accountById.setValue(333000333.31);
//        accountService.update(accountById);
//
//        Status statusById = statusService.getById(5);
//        statusById.setDescription("status without responsibility and restrictions ... omg ))");
//        statusService.update(statusById);

//        Client wrongClient = new Client();
//        wrongClient.setName("Ken");
//        wrongClient.setAge(22);
//        wrongClient.setEmail("ken@mail.ua");
//        wrongClient.setPhone(380961234567L);
//        wrongClient.setAbout("not our client");
//        clientService.save(wrongClient);

        // !!! To delete client - foreign key 'client_fk' from 'client_status' must be removed to brake link
//        clientService.delete(clientService.getById(53));
//        statusService.delete(statusService.getById(5));
//        accountService.delete(accountService.getById(16));

//        System.out.println(clientService.getByName("Bob"));
//
//        List<Client> clientsByAge = clientService.getByAge(33);
//        clientsByAge.forEach(System.out::println);

//        System.out.println(clientService.getByPhone(380972342155L));

    }
}
