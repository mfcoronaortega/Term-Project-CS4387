import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedList;


import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    private static LinkedList<Account> listofacc = Manager.readData();

    @Test
    void correctAccount() { //testing correct account information
        String account_number = "12345678";
        Account foundAccount = Manager.findAccount(account_number);
        String username = "johndoe1";
        Boolean foundUsername = Manager.findUsername(username);
        assertEquals( true, foundUsername);
        assertEquals( "johnPW12", foundAccount.getPassword());
        assertEquals( "12345678", foundAccount.getAccount_number());
        assertEquals( foundAccount.getAccount_balance(), foundAccount.getAccount_balance());
        assertEquals( "saving", foundAccount.getType());
    }

    @Test
    void incorrectAccount() { //testing incorrect account information
        String account_number = "01010101";
        Account foundAccount = Manager.findAccount(account_number);
        String username = "Null";
        Boolean foundUsername = Manager.findUsername(username);
        assertEquals( false, foundUsername);
        assertEquals( "Null", foundAccount.getPassword());
        assertEquals( "Null", foundAccount.getAccount_number());
        assertEquals( 0.0, foundAccount.getAccount_balance());
        assertEquals( "Null", foundAccount.getType());
    }

    @Test //need clarification
    void validDeposit() { //Checks if deposit is valid based on user input
        String input = "10.0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String account_number = "12345678";
        Account acc = Manager.findAccount(account_number);
        assertEquals( acc.getAccount_balance() + 10.0, Deposit.userInput(acc)); //check if deposit is updated
    }

}