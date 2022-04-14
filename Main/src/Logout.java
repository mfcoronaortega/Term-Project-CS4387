import java.util.Scanner;

public class Logout {
    public static void logout_Account(Account user){
        Scanner scanner = new Scanner(System.in);
        String uxinput = "";
        do {
            try {
                System.out.println("Are you sure you want to log out: y/n ");
                uxinput = scanner.next();
                if(uxinput.matches("y")) {
                    System.out.println("You have successfully logged out. Goodbye!");
                    System.exit(0);
                }
            }
            catch (Exception e)
            {
                System.out.println("Invalid input, try again.");
            }
        }
        while (true);
    }
}
