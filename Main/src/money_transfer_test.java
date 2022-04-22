import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class money_transfer_test {
    int balance;

    //String account_number = "98663859";
    //Account foundAccount = Manager.findAccount(account_number);

    money_transfer acc = new money_transfer();

    @Test
    public void valid_transfer_test(){
        double money = 10;
        Account main_acc = new Account();
        main_acc.setUsername("johndoe2");
        main_acc.setPassword("johnPW12");
        main_acc.setAccount_number("98663859");
        main_acc.setAccount_balance(10.09);
        main_acc.setType("checking");


        //Account sec_acc = Manager.findAccount("00932734");

        //change the transfer money to force input instead of using the scanner
        assertTrue(acc.transfer_money(main_acc,money, "98663859"));


        //assertEquals(foundAccount, acc.account_accessed(account_number));
    }

}
