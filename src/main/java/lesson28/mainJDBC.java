package lesson28;


import lesson28.entity.Account;
import lesson28.entity.Client;
import lesson28.entity.ClientStatus;
import lesson28.service.AccountService;
import lesson28.service.ClientService;
import lesson28.service.ClientStatusService;
import lesson28.service.StatusService;

import java.util.List;

public class mainJDBC {

    public static void main(String[] args) {
//         jdbc

        AccountService accountService = new AccountService();
        ClientService clientService = new ClientService();
        ClientStatusService clientStatusService = new ClientStatusService();
        StatusService statusService = new StatusService();

//        CRUD

        //get
//
//        List<Account> accounts = accountService.getAll();
//        accounts.forEach(System.out::println);
//
//        List<Client> clients = clientService.getAll();
//        clients.forEach(System.out::println);
//
//
//        List<ClientStatus> clientsStatuses = clientStatusService.getAll();
//        clientsStatuses.forEach(System.out::println);
//
//        List<Status> statuses = statusService.getAll();
//        statuses.forEach(System.out::println);

        //save

//        Client clientOne = new Client("Alex", "alex@mail.ua", 380953334455L, "cool");
//        clientService.save(clientOne);

//        Client client = new Client();
//        client.setName("Andrew");
//        client.setEmail("andrew@mail.ua");
//        client.setPhone(380673217831L);
//        client.setAbout("Student");
//        clientService.save(client);
//
//        client.setName("Arny");
//        client.setEmail("arny@mail.ua");
//        client.setPhone(380953324233L);
//        client.setAbout("somebody");
//        clientService.save(client);
//
//        client.setName("Ola");
//        client.setEmail("ola@mail.ua");
//        client.setPhone(380959872344L);
//        client.setAbout("girl");
//        clientService.save(client);

//        Account account = new Account();
//        account.setClient_id(12);
//        account.setNumber("aa342WD5");
//        account.setValue(38230432.23);
//        accountService.save(account);

        //delete

        accountService.deleteById(19);
        clientService.deleteById(18); // clients protected from deleting by link with key "client_fk" from table "client_status"

        ClientStatus clientStatus = new ClientStatus();
        clientStatusService.deleteByClientId(19);
        clientStatusService.deleteByStatusId(1);

        //update
        accountService.updateClientIdById(1111, 3);

        clientService.updateNameById("Billy", 12);

        clientStatusService.updateStatusIdByClientIdAndStatusId(3, 10, 1);

        statusService.updateDescriptionByAlias("Advanced rights", "VIP");
        statusService.updateDescriptionByAlias("Wide rights", "PREMIUM");
        statusService.updateDescriptionByAlias("Limited rights", "STANDARD");


        System.out.println("Task #4");
        Client client = new Client();
//        System.out.println(clientService.getByPhone(380968568843L));
        client = clientService.getByPhone(380675267512L);
        System.out.println("Client " + client.getName() + " has found by number: " + client.getPhone());

        System.out.println("Task #5");
        List<Account> accounts = accountService.getLongerNumber(7);
        accounts.forEach(System.out::println);

        System.out.println("Task #6");
        List<Client> clIdEqualAccId = clientService.getIdEqualAccountId();
        clIdEqualAccId.forEach(System.out::println);

        System.out.println("Task #7");

        //Here doing something to get ages ))
//        clientService.addColumnAge();
        clientService.setAge(22, 1);
        clientService.setAge(11, 2);
        clientService.setAge(7, 3);
        clientService.setAge(34, 4);
        clientService.setAge(24, 5);
        clientService.setAge(43, 6);
        clientService.setAge(22, 7);
        clientService.setAge(11, 8);
        clientService.setAge(8, 9);
        clientService.setAge(32, 10);

        //join tables
        System.out.println("Data from joined tables");
        clientService.joinTables();
        List clientsJoined = clientService.joinTables();
        for (int i = 0; i < clientsJoined.size(); i++) {
            String[] splitStr = clientsJoined.get(i).toString().split(", ");
            System.out.println(splitStr[1] + ", " + splitStr[3] + ", " + splitStr[5]);
        }
    }
}
