public class money_transfer {
    static Boolean user_account = false;
    static Boolean sender_account = false;

    // method to check the current balance accessed
    public static void checkBalance(Account Main_user) {
        Boolean found = true;

        System.out.println("Your current balance is: " + Main_user.getAccount_balance());

    }// end account_accessed method

    // using the manager.findAccount method this method will let the user know if
    // the account to transfer money exists
    public static Account transfer_acc_exists(String num) {
        // scanner = new Scanner(System.in);
        //String uxinput = "";
        do {
            System.out.println("Enter the account number to which you would like to transfer money to:");
            //uxinput = scanner.nextLine();
            Account accountfound = Manager.findAccount(num);
            if (accountfound.getAccount_number().matches(num)) { //IF already exists
                sender_account = true;
                return accountfound;
            }
            else{
                System.out.println("That account does not exist, try again.");
            }
        }
        while (true);
    }// end transer_acc_exis method

    // transfer money to another user
    public static boolean transfer_money(Account sourceAccount,double money, String number){
        user_account = true;
        //Scanner scanner = new Scanner(System.in);
        //String uxinput = "";

        System.out.println("Initiating account transfer.");
        Account destinationAccount = transfer_acc_exists(number);//Once we have the transfer account

        do {
            if (user_account == true &&  user_account == true) {// check if both accounts are valid
                System.out.println("Your balance: " + sourceAccount.getAccount_balance());
                System.out.println("how much do you want to send?: "); // user will select how much money to send
                try {
                    //Double money = scanner.nextDouble();
                    if((money > 0) && (money <= sourceAccount.getAccount_balance())){ //Not negative, and not more than balance
                        sourceAccount.subtract_balance(sourceAccount.getAccount_balance(), money);// subtract money from the account balance
                        System.out.println("Balance is: " + sourceAccount.getAccount_balance());// display new balance
                        destinationAccount.add_balance(destinationAccount.getAccount_balance(), money); // add money into the account's balance
                        // that is receiving
                        System.out.println("Balance for second user is: " + destinationAccount.getAccount_balance());// display receivers
                        return true;
                    }
                    else {
                        System.out.println("Invalid transfer amount. Make sure your transfer amount does not exceed your account balance.");
                        return false;
                    }
                }
                catch (Exception e)
                {
                    System.out.println("Invalid amount has been entered, try again. (eg. 00.00)");
                }
            } // end if statement
        }
        while (true);
    }// end transfer_money method

}// end money_transfer class
