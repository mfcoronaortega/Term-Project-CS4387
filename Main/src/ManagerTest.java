import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    private static LinkedList<Account> listofacc = Manager.readData();

    @Test
    void findAccount() { //Check if findAccount is yielding correctly when the account is found
        String account_number = "98663859";
        Account foundAccount = Manager.findAccount(account_number);
        assertEquals( "johndoe2", foundAccount.getUsername());
        assertEquals( "johnPW12", foundAccount.getPassword());
        assertEquals( "98663859", foundAccount.getAccount_number());
        assertEquals( 10.09, foundAccount.getAccount_balance());
        assertEquals( "checking", foundAccount.getType());
    }

    @Test
    void AccountNotFound() { //Check if findAccount is yielding correctly when the account is NOT found
        String account_number = "01010101";
        Account foundAccount = Manager.findAccount(account_number);
        assertEquals( "Null", foundAccount.getUsername());
        assertEquals( "Null", foundAccount.getPassword());
        assertEquals( "Null", foundAccount.getAccount_number());
        assertEquals( 0.0, foundAccount.getAccount_balance());
        assertEquals( "Null", foundAccount.getType());
    }

    @Test
    void findUsername() { //Checks if find username is yielding correctly when username is found
        Boolean check = true;

        String username1 = "johndoe1";
        Boolean foundUsername1 = Manager.findUsername(username1);
        assertEquals( check, foundUsername1);

        String username2 = "johndoe2";
        Boolean foundUsername2 = Manager.findUsername(username2);
        assertEquals( check, foundUsername2);

        String username3 = "johndoe3";
        Boolean foundUsername3 = Manager.findUsername(username3);
        assertEquals( check, foundUsername3);
    }
    
    
    @Test
    public void valid_transfer_test(){
        double money = 10.0;
        money_transfer acc = new money_transfer();

        //Account main_acc = new Account();
        Account main_acc = Manager.findAccount("12345678");
        System.out.println(main_acc.getUsername());


        //Account sec_acc = Manager.findAccount("00932734");

        //change the transfer money to force input instead of using the scanner
        assertTrue(money_transfer.transfer_money(main_acc,money, "98663859"));
    }

    @Test
    public void invalid_transfer_test(){
        double money = 10.0;
        money_transfer acc = new money_transfer();

        //Account main_acc = new Account();
        Account main_acc = Manager.findAccount("0000000000");
        System.out.println(main_acc.getUsername());


        //Account sec_acc = Manager.findAccount("00932734");

        //change the transfer money to force input instead of using the scanner
        assertFalse(money_transfer.transfer_money(main_acc,money, "98663859"));
    }
    
     @Test
    void UsernameNotFound() { //Checks if find username is yielding correctly when username is found
        Boolean check = true;

        String username1 = "alexis";
        Boolean foundUsername1 = Manager.findUsername(username1);
        assertNotEquals( check, foundUsername1);

        String username2 = "alex";
        Boolean foundUsername2 = Manager.findUsername(username2);
        assertNotEquals( check, foundUsername2);

        String username3 = "alexander";
        Boolean foundUsername3 = Manager.findUsername(username3);
        assertNotEquals( check, foundUsername3);
    }


}
