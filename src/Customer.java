import java.util.ArrayList;

public class Customer {
    private String firstName;
    private String lastName;
    private ArrayList<Account> accounts;

    public Customer(String f, String l) {
        this.firstName = f;
        this.lastName = l;
        this.accounts = new ArrayList<Account>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAccount(Account acct) {
        accounts.add(acct);
    }

    public Account getAccount(int accountIndex) {
        return accounts.get(accountIndex);
    }

    public int getNumOfAccounts() {
        return accounts.size();
    }
}
