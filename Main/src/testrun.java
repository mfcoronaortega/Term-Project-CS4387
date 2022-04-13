import java.util.LinkedList;

public class testRun {

    public static void main(String[] args) {

//        SignIn.acceptInput();

        Manager.readData();
        Account missingAccount = Manager.findAccount("12345678");

        double oldLine = missingAccount.getAccount_balance();
        missingAccount.subtract_balance(missingAccount.getAccount_balance(), 1000.00);
        // printAccounts();

        System.out.println("Previous balance: " + oldLine);
        System.out.println("New Balance: " + missingAccount.getAccount_balance());

        Manager.createNewAccount("maria_corona","maria123", "checking");
        Manager.printAccounts();

        Account myNewAccount = Manager.findAccount("60517978");

        oldLine = myNewAccount.getAccount_balance();
        myNewAccount.add_balance(myNewAccount.getAccount_balance(), 100.00);
        System.out.println("Previous balance: " + oldLine);
        System.out.println("New Balance: " + myNewAccount.getAccount_balance());

        Manager.deleteAccount("maria_corona", "maria123", "29476124");

        Manager.printAccounts();

        Manager.writeData(missingAccount);





    }
}
