import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class Withdraw_Test {
    private static LinkedList<Account> listofacc = Manager.readData();

    @Test
    void InvalidDeposit() {
        String input = "-10.0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String account_number = "12345678";
        Account acc = Manager.findAccount(account_number);
        assertEquals(acc.getAccount_balance(), Deposit.userInput(acc)); //The account balance stays the same as it was an invalid amount
    }

    @Test
    void validWithdrawal() {
        String input = "10.0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String account_number = "12345678";
        Account acc = Manager.findAccount(account_number);
        assertEquals(acc.getAccount_balance() - 10.0, Withdraw.withdrawal(acc)); //The account balance should be updated
    }

    @Test
    void InvalidWithdrawal() {
        String input = "1000000.0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String account_number = "12345678";
        Account acc = Manager.findAccount(account_number);
        assertEquals(acc.getAccount_balance(), Withdraw.withdrawal(acc)); //The account balance stays the same as it was an invalid amount
    }
}
