import javax.lang.model.type.NullType;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;


public class Manager{
    public static String file_name = "/Users/mariacorona/IdeaProjects/Term-Project-CS4387/Main/src/Mock_BankDB.txt";
    public static LinkedList <Account> myAccounts = new LinkedList<Account>();


    public static LinkedList <Account> readData(){ //Reads a text file with account information and turns it into an array of accounts
        String [] myData =  new String[5];
        try {
            File myObj = new File(file_name);
            Scanner myReader = new Scanner(myObj);
            int x = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                myData = data.split(" ");
                Account myAccount = new Account(myData[0],myData[1],myData[2],Double.parseDouble(myData[3]),myData[4]);
                myAccounts.add(myAccount);
                x++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return myAccounts;
    }

    public static void writeData(Account myAccount){ //writes new account onto file

        try(FileWriter fw = new FileWriter(file_name, false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            for(int x =0; x < myAccounts.size(); x++){
                out.print(myAccounts.get(x).getUsername() + " ");
                out.print(myAccounts.get(x).getPassword()+ " ");
                out.print(myAccounts.get(x).getAccount_number()+ " ");
                out.print(myAccounts.get(x).getAccount_balance()+ " ");
                out.println(myAccounts.get(x).getType());
            }

        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }

    public static Account findAccount(String account_number){ //Method to find an account thorugh account number
        Account empty = new Account("Null","Null","Null",0.00,"Null");

        for(int x =0; x < myAccounts.size(); x++){
            if (myAccounts.get(x).getAccount_number().matches(account_number)){
                System.out.println("Account was successfully found:");
                printSingleAccount(myAccounts.get(x));
                return myAccounts.get(x);
            }
        }
        System.out.println("Sorry, no account with that account number was found. \nCreating a new account:");
//        printSingleAccount(newAccount);
//        myAccounts.add(newAccount);
        return empty;
    }

    public static Boolean findUsername(String username){ //Method to find an account through username
        for(int x =0; x < myAccounts.size(); x++){
            if (myAccounts.get(x).getUsername().matches(username)){
                System.out.println("Account was successfully found:");
                printSingleAccount(myAccounts.get(x));
                return true;
            }
        }
        System.out.println("Sorry, no account with that username was found.");
        return false;
    }


    public static void printAccounts(){ //Test method to print current accounts list
        System.out.println("PRINTING ALL ACCOUNTS:");

        for(int x =0; x < myAccounts.size(); x++){
            System.out.print("Username: " + myAccounts.get(x).getUsername() + " ");
            System.out.print("Password: " + myAccounts.get(x).getPassword()+ " ");
            System.out.print("Account Number: " + myAccounts.get(x).getAccount_number()+ " ");
            System.out.print("Account Balance: " + myAccounts.get(x).getAccount_balance()+ " ");
            System.out.println("Account Type: " + myAccounts.get(x).getType());
        }

    }

    public static void printSingleAccount(Account singleAccount){ //Test method to print current accounts list
            System.out.print("Username: " + singleAccount.getUsername() + " ");
            System.out.print("Password: " + singleAccount.getPassword()+ " ");
            System.out.print("Account Number: " + singleAccount.getAccount_number()+ " ");
            System.out.print("Account Balance: " + singleAccount.getAccount_balance()+ " ");
            System.out.println("Account Type: " + singleAccount.getType());
    }

    public static void createNewAccount(String newUsername, String newPassword, String type){
        String newAccountNo = generateAccountNumber();
        Double balance = 0.00;
        Account newAccount = new Account();

        if (findUsername(newUsername) == false){//Username is unique
            newAccount.setUsername(newUsername);
            newAccount.setPassword(newPassword);
            newAccount.setAccount_number(newAccountNo);
            newAccount.setAccount_balance(balance);
            newAccount.setType(type);
            System.out.println("You have successfully created a new account");
            myAccounts.add(newAccount);
        }else{
            System.out.println("Unable to create account, try a different username");
        }
    }

    public static String generateAccountNumber(){
        Random rnd = new Random();
        int number = rnd.nextInt(99999999);
        String account_number = String.format("%08d", number);

        while(!findAccount(account_number).getUsername().matches("Null")){
            number = rnd.nextInt(99999999);
            account_number = String.format("%08d", number);
        }
        return account_number;
    }

    public static void deleteAccount(String username, String password, String account_number){
        Account toDelete= findAccount(account_number);

        if(toDelete.getUsername().matches(username) && toDelete.getPassword().matches(password)){
            myAccounts.remove(toDelete);
            System.out.println("Your account was successfully deleted.");

        }else{
            System.out.println("Unable to delet this account, double check your credentials.");
        }

    }

}
