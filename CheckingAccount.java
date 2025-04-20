
public class CheckingAccount extends BankAccount {
private double interestRate;
    
    // Process withdrawal with overdraft fee
    public void processWithdrawal(double amount) {
        withdrawal(amount);
        if (getBalance() < 0) {
            System.out.println("Overdraft fee charged: $30");
            withdrawal(30); // Additional $30 fee
            System.out.println("Current balance after fee: $" + getBalance());
        }
    }
    
    // Display account with interest rate
    public void displayAccount() {
        accountSummary();
        System.out.println("Interest Rate: " + (interestRate * 100) + "%");
    }
    
    // Getter and Setter for interest rate
    public double getInterestRate() {
        return interestRate;
    }
    
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
	
}
