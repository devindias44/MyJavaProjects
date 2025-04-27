import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankBalanceApp {
    private double balance = 0.0;
    
    // GUI Components
    private JFrame frame;
    private JPanel panel;
    private JLabel balanceLabel;
    private JTextField amountField;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton displayButton;
    private JButton exitButton;
    
    public BankBalanceApp() {
        // Create and set up the main frame
        frame = new JFrame("Bank Balance Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        
        // Create the main panel
        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Initialize components
        balanceLabel = new JLabel("Current Balance: $0.00", SwingConstants.CENTER);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 16));
        
        JLabel amountLabel = new JLabel("Enter Amount:");
        amountField = new JTextField();
        
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        displayButton = new JButton("Display Balance");
        exitButton = new JButton("Exit");
        
        // Add action listeners
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performTransaction(true);
            }
        });
        
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performTransaction(false);
            }
        });
        
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBalanceLabel();
                JOptionPane.showMessageDialog(frame, 
                    String.format("Current Balance: $%.2f", balance),
                    "Account Balance", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, 
                    String.format("Final Balance: $%.2f\nThank you for banking with us!", balance),
                    "Goodbye", 
                    JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        });
        
        // Add components to panel
        panel.add(balanceLabel);
        panel.add(amountLabel);
        panel.add(amountField);
        
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);
        panel.add(buttonPanel);
        
        JPanel bottomButtonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        bottomButtonPanel.add(displayButton);
        bottomButtonPanel.add(exitButton);
        panel.add(bottomButtonPanel);
        
        // Add panel to frame and display
        frame.add(panel);
        frame.setVisible(true);
    }
    
    private void performTransaction(boolean isDeposit) {
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (amount <= 0) {
                JOptionPane.showMessageDialog(frame, 
                    "Amount must be positive", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (isDeposit) {
                balance += amount;
                JOptionPane.showMessageDialog(frame, 
                    String.format("Deposited $%.2f successfully", amount),
                    "Deposit", 
                    JOptionPane.INFORMATION_MESSAGE);
            } else {
                if (amount > balance) {
                    JOptionPane.showMessageDialog(frame, 
                        "Insufficient funds for withdrawal", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
                balance -= amount;
                JOptionPane.showMessageDialog(frame, 
                    String.format("Withdrew $%.2f successfully", amount),
                    "Withdrawal", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
            
            updateBalanceLabel();
            amountField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, 
                "Please enter a valid number", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void updateBalanceLabel() {
        balanceLabel.setText(String.format("Current Balance: $%.2f", balance));
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BankBalanceApp();
            }
        });
    }
}
