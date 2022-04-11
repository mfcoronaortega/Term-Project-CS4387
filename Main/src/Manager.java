import javax.lang.model.type.NullType;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;


public class Manager{
    public static String file_name = "/Users/mariacorona/IdeaProjects/Term-Project-CS4387/Main/src/Mock_BankDB.txt";
    public static int number_of_accouts = fileLines();
    public static Account [] myaccounts =  new Account[number_of_accouts];

    public static int fileLines(){ //Helper method to get the number of accounts accurately
        Path path = Paths.get(file_name);

        long lines = 0;
        try {

            // much slower, this task better with sequence access
            //lines = Files.lines(path).parallel().count();

            lines = Files.lines(path).count();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return (int)lines;
    }

    public static Account [] readData(){ //Reads a text file with account information and turns it into an array of accounts
        String [] myData =  new String[5];
        try {
            File myObj = new File(file_name);
            Scanner myReader = new Scanner(myObj);
            int x = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                myData = data.split(" ");
                Account myAccount = new Account(myData[0],myData[1],myData[2],Double.parseDouble(myData[3]),myData[4]);
                myaccounts[x] = myAccount;
                x++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return myaccounts;
    }

    public static void writeData(Account myAccount){ //writes new account onto file
        try(FileWriter fw = new FileWriter(file_name, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.print("\n"+myAccount.getUsername() + " ");
            out.print(myAccount.getPassword()  + " ");
            out.print(myAccount.getAccount_number() + " ");
            out.print(myAccount.getAccount_balance()+ " ");
            out.print(myAccount.getType());

        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }

    // update the Balance in the text file(database)
    // NOTE THIS METHOD WILL WRITE UNDER THE EXISTING CONTENTS IN A TEXT FILE
    // NEED TO EDIT IT TO OVERWRITE EXISTINING CONTENTS IN THE TEXT FILE
    public static void updateBalance(Account myAccount, double money) {
        double oldLine = myaccounts[3].getAccount_balance();
        myaccounts[3].subtract_balance(myAccount.getAccount_balance(), money);
        // printAccounts();

        for (int x = 0; x < myaccounts.length; x++) {
            if (myaccounts[x].getAccount_number() == myAccount.getAccount_number()) {
                System.out.println("ignoring" + myaccounts[x].getUsername());
            }
            Account newAccount = myaccounts[x];
            writeData(newAccount);
        } // end for

    }// end update_balance method

    public Account findAccount(String account_number){ //Method to find an account thorugh account number
        Account newAccount = new Account("Null","Null","Null",0.00,"Null");

        for(int x =0; x < myaccounts.length; x++){
            if (myaccounts[x].getAccount_number().matches(account_number)){
                return myaccounts[x];
            }
        }
        System.out.println("Sorry, no account with that account number was found.");
        return newAccount;

    }

    public static void printAccounts(){ //Test method to print current accounts list

        for(int x =0; x < myaccounts.length; x++){
            System.out.print(myaccounts[x].getUsername() + " ");
            System.out.print(myaccounts[x].getAccount_number()+ " ");
            System.out.print(myaccounts[x].getPassword()+ " ");
            System.out.print(myaccounts[x].getAccount_balance()+ " ");
            System.out.println(myaccounts[x].getType());
        }

    }

}
