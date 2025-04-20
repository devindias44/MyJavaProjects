public class TestBankAccount {
    public static void main(String[] args) {
        // Test BankAccount
        System.out.println("Testing BankAccount class:");
        BankAccount myAccount = new BankAccount();
        myAccount.setFirstName("Devin");
        myAccount.setLastName("Dias");
        myAccount.setAccountID(12345);
        
        myAccount.deposit(500.00);
        myAccount.withdrawal(200.00);
        myAccount.accountSummary();
        System.out.println("Current balance: $" + myAccount.getBalance());
        
        // Test CheckingAccount
        System.out.println("\nTesting CheckingAccount class:");
        CheckingAccount myChecking = new CheckingAccount();
        myChecking.setFirstName("Devin");
        myChecking.setLastName("Dias");
        myChecking.setAccountID(67890);
        myChecking.setInterestRate(0.02); // 2% interest rate
        
        myChecking.deposit(300.00);
        System.out.println("Attempting to withdraw $350...");
        myChecking.processWithdrawal(350.00);
        
        System.out.println("\nAccount Details:");
        myChecking.displayAccount();
    }
}
