import java.util.Scanner;

    public class SignIn {
        public static String un;
        public static String pw;
        public static String ac;
        private static Account[] listofacc = Manager.readData() ;


        public static Account acceptInput() {
            while(true) {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Enter the Username:");
                un = scanner.nextLine();

                System.out.println("Enter the Password:");
                pw = scanner.nextLine();

                System.out.println("Enter the account number:");
                ac = scanner.nextLine();

                for (Account account : listofacc) {
                    if (un.equals(account.getUsername()) && pw.equals(account.getPassword()) && ac.equals(account.getAccount_number())) {
                        System.out.println("Login Successful!");
                        return account;
                    }
                }
                System.out.println("Retry Login");
            }
        }
    }