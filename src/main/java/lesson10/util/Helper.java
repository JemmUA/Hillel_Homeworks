package lesson10.util;

import lesson10.exception.UserExpectedError;
import lesson10.exception.WrongFieldException;
import lesson10.exception.WrongSumException;

public class Helper {

    public static void checkUsers(String senderAccID, String recipientAccID) {
        // check account IDs that sender and recipient are not the same
        if (senderAccID.equals(recipientAccID)) {
            throw new UserExpectedError("Unexpected sender-recipient verification error.");
        }
    }

    public void checkAccountID(String accountID) throws WrongFieldException {
        if (accountID.length() != 10) {
            throw new WrongFieldException();
        }
    }

    public void checkSum(double sum) throws WrongSumException {
        if (sum > 10_000 || sum < 0.01) {
            throw new WrongSumException();
        }
    }
}
