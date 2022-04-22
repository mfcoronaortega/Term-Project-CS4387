import java.util.Scanner;
    class Deposit{
        public static double amt = 0.0;

        public static Double userInput(Account acc){
            Scanner scanner = new Scanner(System.in);
            String uxinput = "";
            do {
                try {
                    money_transfer.checkBalance(acc);
                    System.out.println("Enter the amount to be deposited: ");
                    uxinput = scanner.nextLine();
                    amt = Double.parseDouble(uxinput);
                    if(amt<=0){
                        System.out.println("Invalid amount has been entered, try again. (eg. 00.00)");
                    } else{
                        System.out.println("Depositing " + amt + " into your account.....");
                        //acc.setAccount_balance(acc.getAccount_balance() + amt);
                        acc.add_balance(acc.getAccount_balance() , amt);
                        System.out.println("Deposit has been Successful!\nYour new account balance is: " + acc.getAccount_balance());
                        break;
                    }
                }
                catch (Exception e)
                {
                    System.out.println("Invalid amount has been entered, try again. (eg. 00.00)");
                }
            }
            while (true);
            return acc.getAccount_balance();
        }
    }