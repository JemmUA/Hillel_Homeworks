package lesson10.service;

import lesson10.entity.Client;
import lesson10.util.Helper;

public class TransactionService {
    public void sendMoney(Client client, String clientAccountID) {
        Helper.checkUsers(client.getClientAccountID(),clientAccountID);
    }
}
