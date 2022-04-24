import java.util.Scanner;

public class Controller {

    public static void SystemRun() {
        String user_answer = "";

        Scanner scanner = new Scanner(System.in);
        Account userAccount = new Account();

        System.out.println("Welcome! ");
        userAccount = SignIn.acceptInput();

        if(userAccount.isAdmin()){
            Admin.menu(userAccount);
        }
        else {

            while (true) {
                System.out.println("Welcome! Select an option (1-5): \n1: Check Balance\n2: Deposit\n3: Withdraw\n4: Transfer\n5: Logout"); //Deposit, withdraw, transfer, logout
                user_answer = scanner.nextLine();

                switch (user_answer) {
                    case "1":
                        money_transfer.checkBalance(userAccount);
                        Manager.customerFacingPrint(userAccount);
                        break;
                    case "2":
                        Deposit.userInput(userAccount);
                        Manager.customerFacingPrint(userAccount);
                        break;
                    case "3":
                        Withdraw.withdrawal(userAccount);
                        Manager.customerFacingPrint(userAccount);
                        break;
                    case "4":
                        //money_transfer.transfer_money(userAccount);
                        Manager.customerFacingPrint(userAccount);
                        break;
                    case "5":
                        Logout.logout_Account(userAccount);
                    default:
                        System.out.println("Invalid Input, please select a valid option");
                        break;
                }
                Manager.writeData();
            }
        }
    }
}
