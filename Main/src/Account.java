public class Account{
    private String username;
    private String password;
    private String account_number;
    private double account_balance;
    private String type;

    public Account() {
    }

    public Account(String username, String password, String account_number, double account_balance, String type) {
        this.username = username;
        this.password = password;
        this.account_number = account_number;
        this.account_balance = account_balance;
        this.type = type;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public double getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(double account_balance) {
        this.account_balance = account_balance;
    }
    
    //used for transfer money to subtract the balance
    public void subtract_balance(double account_balance, double sub) {
        this.account_balance = account_balance - sub;
    }

    //used for transfer money to add to the balance
    public void add_balance(double account_balance, double add) {
        this.account_balance = account_balance + add;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean isAdmin(){
        if(this.type.matches("admin")){
            return true;
        }
        else{
            return false;
        }
    }
}
