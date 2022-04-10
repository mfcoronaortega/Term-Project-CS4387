import java.util.Scanner;
    class Deposit{
        public static double amt = 0.0;

        public static void userInput(Account acc){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the amount to be deposited: ");
            amt = scanner.nextInt();

            if(amt<=0){
                System.out.println("Invalid Deposit Amount");

            }else{
                acc.setAccount_balance(acc.getAccount_balance() + amt);
                System.out.println(acc.getAccount_balance());
            }
        }
    }