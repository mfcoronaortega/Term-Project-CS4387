import java.util.Scanner;

    class Withdraw {
        public static double amount = 0.0;

        public static Double withdrawal(Account user){
            Scanner scanner = new Scanner(System.in);
            String uxinput = "";
            do {
                try {
                    money_transfer.checkBalance(user);
                    System.out.println("Enter the amount to be withdrawn: ");
                    uxinput = scanner.nextLine();
                    amount = Double.parseDouble(uxinput);
                    Double blc = user.getAccount_balance();
                    if(amount>blc){
                        System.out.println("Invalid amount has been entered. make sure the amount of your withdrawal, does not exceed your balance.");
                        return user.getAccount_balance();
                    } else{
                        System.out.println("Withdrawing " + amount + " from your account.....");
                        user.subtract_balance(user.getAccount_balance(), amount);
                        System.out.println("Withdrawal has been Successful!\nYour new account balance is: " + user.getAccount_balance());
                        return user.getAccount_balance();
                    }
                }
                catch (Exception e)
                {
                    System.out.println("Invalid amount has been entered, try again. (eg. 00.00)");
                }
            }
            while (true);
           // return user.getAccount_balance();
        }
    }
