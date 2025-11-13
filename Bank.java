import java.util.Scanner;

// Base class for all accounts
class Account {
    String customerName;
    int accountNumber;
    String accountType;
    double balance;

    // Constructor
    Account(String name, int accNo, String type, double bal) {
        customerName = name;
        accountNumber = accNo;
        accountType = type;
        balance = bal;
    }

    // Deposit method
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Display balance
    void displayBalance() {
        System.out.println("Account Holder: " + customerName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Current Balance: ₹" + balance);
    }
}

// Savings Account Class
class SavAcct extends Account {
    final double interestRate = 0.05; // 5% annual interest

    SavAcct(String name, int accNo, double bal) {
        super(name, accNo, "Savings", bal);
    }

    // Compute and add interest (compound interest for simplicity)
    void computeInterest(int years) {
        double interest = balance * Math.pow((1 + interestRate), years) - balance;
        balance += interest;
        System.out.println("Interest of ₹" + interest + " added for " + years + " year(s).");
    }

    // Withdrawal
    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: ₹" + amount);
        }
    }
}

// Current Account Class
class CurAcct extends Account {
    final double minimumBalance = 1000;
    final double serviceCharge = 100;

    CurAcct(String name, int accNo, double bal) {
        super(name, accNo, "Current", bal);
    }

    // Check and impose penalty if below minimum balance
    void checkMinimumBalance() {
        if (balance < minimumBalance) {
            balance -= serviceCharge;
            System.out.println("Balance below minimum! Service charge of ₹" + serviceCharge + " imposed.");
        }
    }

    // Withdrawal with penalty check
    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: ₹" + amount);
            checkMinimumBalance();
        }
    }
}

// Main Class
public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create Accounts
        SavAcct savings = new SavAcct("Ravi Kumar", 101, 5000);
        CurAcct current = new CurAcct("Neha Sharma", 202, 2000);

        System.out.println("=== BANK ACCOUNT OPERATIONS ===");

        // Savings Account Operations
        System.out.println("\n--- Savings Account ---");
        savings.displayBalance();
        savings.deposit(2000);
        savings.computeInterest(2);
        savings.withdraw(1500);
        savings.displayBalance();

        // Current Account Operations
        System.out.println("\n--- Current Account ---");
        current.displayBalance();
        current.deposit(3000);
        current.withdraw(4500);
        current.displayBalance();

        sc.close();
    }
}
