import java.util.Scanner;

public class Admin {

    public static void menu(Account admin){
        String user_answer = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome Admin! Select an option (1-5): \n1: Create Account\n2: Delete Account\n3: See a Single Account\n4: See All Accounts\n5: Logout"); //Deposit, withdraw, transfer, logout
            user_answer = scanner.nextLine();

            switch (user_answer) {
                case "1":
                    createAccount();
                    break;
                case "2":
                    deleteAccount();
                    break;
                case "3":
                    seeAccount();
                    break;
                case "4":
                    Manager.printAccounts();
                    break;
                case "5":
                    Logout.logout_Account(admin);
                default:
                    System.out.println("Invalid Input, please select a valid option");
                    break;
            }
            Manager.writeData();
        }
    }

    public static void createAccount(){
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        String uxInput = "";

        do {
            System.out.println("To create an account you need the following information:");
            System.out.println("Create a Username:");
            String un = scanner.nextLine();

            System.out.println("Create a Password:");
            String pw = scanner.nextLine();

            System.out.println("Enter account type (saving or checking): ");
            String account_type = scanner2.nextLine();

            System.out.println("Confirm (y) that you would like to proceed creating this account (this action cannot be undone):");
            uxInput = scanner.nextLine();

            if(uxInput.matches("y")){
                Manager.createNewAccount(un,pw,account_type);
                break;
            }
            else {
                System.out.println("You have cancelled this action, returning to admin menu.");
                break;
            }
        }
        while (true);

    }

    public static void deleteAccount(){
        Scanner scanner = new Scanner(System.in);
        String uxInput = "";
        do {
            System.out.println("To delete an account you need the following information:");
            System.out.println("Enter the Username:");
            String un = scanner.nextLine();

            System.out.println("Enter the Password:");
            String pw = scanner.nextLine();

            System.out.println("Enter the account number:");
            String ac = scanner.nextLine();

            System.out.println("Confirm (y) that you would like to proceed deleting this account (this action cannot be undone):");
            uxInput = scanner.nextLine();

            if(uxInput.matches("y")){
                Manager.deleteAccount(un,pw,ac);
                break;
            }
            else {
                System.out.println("You have cancelled this action, returning to admin menu.");
                break;
            }
        }
        while (true);

    }

    public static void seeAccount(){
        Scanner scanner = new Scanner(System.in);
        String uxInput = "";
        do {
            System.out.println("Please enter account number:");
            uxInput = scanner.nextLine();
            Account accountfound = Manager.findAccount(uxInput);

            if(!accountfound.getUsername().matches("Null")){ //if account is found
                Manager.printSingleAccount(accountfound);
                break;
            }else {
                System.out.println("This account does not exist, please try again.");
            }
        }
        while (true);
    }

}
