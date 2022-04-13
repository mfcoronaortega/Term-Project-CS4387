import java.util.Scanner;

public class Withdraw {
    static Boolean user_account = false;

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
    }
    public static int amount = 0;
    public static void withdrawal(boolean user_access, Account user){
        double balance = user.getAccount_balance();
        System.out.println("Your current balance is: " + balance);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the amount: ");
        amount = scanner.nextInt();

        if(balance > amount ){
            user.subtract_balance(user.getAccount_balance(), amount);
        }
        else{
            System.out.println("Invalid amount");
        }
    }
}
