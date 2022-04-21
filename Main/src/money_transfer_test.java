import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class money_transfer_test {
    int balance;

    //String account_number = "98663859";
    //Account foundAccount = Manager.findAccount(account_number);

    money_transfer acc = new money_transfer();

    @Test
    public void account_accessed_test(){
        String account_number = "98663859";
        Account foundAccount = acc.account_accessed(account_number);
        assert foundAccount != null;
        assertSame(foundAccount.getAccount_number(), acc.account_accessed(account_number).getAccount_number());
        //assertEquals(foundAccount, acc.account_accessed(account_number));
    }
    @Test
    public void account_not_accessed_test(){
        String account_number = "98663859";
        Account foundAccount = Manager.findAccount("12345678");
        assertNotSame(foundAccount, acc.account_accessed(account_number));
        //assertEquals(foundAccount, acc.account_accessed(account_number));
    }
}
