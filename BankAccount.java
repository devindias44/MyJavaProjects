
public class BankAccount {
	 private String firstName;
	    private String lastName;
	    private int accountID;
	    private double balance;
	    
	    // Constructor initializes balance to zero
	    public BankAccount() {
	        this.balance = 0.0;
	    }
	    
	    // Deposit method
	    public void deposit(double amount) {
	        if (amount > 0) {
	            balance += amount;
	        }
	    }
	    
	    // Withdrawal method
	    public void withdrawal(double amount) {
	        if (amount > 0) {
	            balance -= amount;
	        }
	    }
	    
	    // Setters and Getters
	    public String getFirstName() {
	        return firstName;
	    }
	    
	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }
	    
	    public String getLastName() {
	        return lastName;
	    }
	    
	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }
	    
	    public int getAccountID() {
	        return accountID;
	    }
	    
	    public void setAccountID(int accountID) {
	        this.accountID = accountID;
	    }
	    
	    public double getBalance() {
	        return balance;
	    }
	    
	    // Account summary method
	    public void accountSummary() {
	        System.out.println("Account Summary:");
	        System.out.println("First Name: " + firstName);
	        System.out.println("Last Name: " + lastName);
	        System.out.println("Account ID: " + accountID);
	        System.out.println("Balance: $" + balance);
	    }
	
}
