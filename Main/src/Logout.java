import java.util.Scanner;

public class Logout {
    public static void logout_Account(Account user){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you sure you want to log out: y/n ");
        String lg = scanner.next();

        if(lg == "y"){
            System.out.println("You have successfully logged out");
            System.exit(0);
        }
    }
}
