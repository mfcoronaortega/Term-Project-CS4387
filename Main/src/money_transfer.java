import java.util.Scanner;

public class money_transfer {
    static Boolean user_account = false;
    static Boolean sender_account = false;

    // this method will check if the user's account was accessed by using
    // manager.findAccount
    public static Account account_accessed(String account_number) {
        Boolean found = true;

        if (found) {
            Account accountfound = Manager.findAccount(account_number);
            System.out.println("your account has been accessed: " + accountfound.getUsername());
            user_account = true;
            return accountfound;
        }
        System.out.println("your account was not found");

        return null;
    }// end account_accessed method

    // using the manager.findAccount method this method will let the user know if
    // the account to transfer money exists
    public static Account transer_acc_exists(String account_number) {
        Boolean found = true;

        if (found) {
            Account accountfound = Manager.findAccount(account_number);
            System.out.println("the account you were looking for has been found: " + accountfound.getUsername());
            sender_account = true;
            return accountfound;
        }
        System.out.println("your account was not found");

        return null;
    }// end transer_acc_exis method

    // transfer money to another user
    public static double transfer_money(boolean user_access, boolean receiving_acc, Account Main_user,
            Account Second_user) {
        Scanner input = new Scanner(System.in);
        // Scanner input2 = new Scanner(System.in);

        if (user_access && receiving_acc == true) {// check if both accounts are valid
            System.out.println("Your balance: " + Main_user.getAccount_balance());
            System.out.println("how much do you want to send?: "); // user will select how much money to send into the
                                                                   // other account
            Double money = input.nextDouble();
            System.out.println("confirm money transfer with y/n: ");
            // String decision = input2.nextLine();

            Main_user.subtract_balance(Main_user.getAccount_balance(), money);// subtract money from the account balance
            System.out.println("Balance is: " + Main_user.getAccount_balance());// display new balance
            Manager.updateBalance(Main_user, money); // update the balance via manager class

            Second_user.add_balance(Second_user.getAccount_balance(), money); // add money into the account's balance
                                                                              // that is receiving
            System.out.println("Balance for second user is: " + Second_user.getAccount_balance());// display receivers
                                                                                                  // balance(REMOVE
                                                                                                  // BEFORE DUE DATE)

            input.close();
            return 1;
        } // end if statement
        input.close();
        return 0;
    }// end transfer_money method

    public static void main(String[] args) {
        Manager.readData();
        Manager.printAccounts();

        Account Main_user = account_accessed("98663859");

        Account Second_user = transer_acc_exists("00932734");

        transfer_money(user_account, sender_account, Main_user, Second_user);

    }// end main
}// end money_transfer class