public class testRun {

    //HEADS UP
    // the text file can be appended to but must not end in a new line

    public static void main(String[] args) {
        
        Manager.readData();
        Manager.printAccounts();
        //need to test find account still
        Account newAccount = new Account("Null","Null","Null",0.00,"Null");
        Manager.writeData(newAccount);

        Account acc = SignIn.acceptInput();
        Deposit.userInput(acc);
        System.out.println("hi :D");
    }
}
