package bank;
import java.util.ArrayList;

public class BankAccount {

    private String accountNumber;
    private String ownerName;
    private double balance;
    private ArrayList<String> history;


    public BankAccount(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = Math.max(initialBalance, 0);
        this.history = new ArrayList<>();
    }

    public void deposit(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than 0");
        }
        balance += amount;
        history.add("Deposited " + amount + ". New balance: " + balance);
        System.out.println("Deposited " + amount + ". New balance: " + balance);
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be greater than 0");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds. Current balance: " + balance);
            return;
        }
        balance -= amount;
        history.add("Withdrawn " + amount + ". New balance: " + balance);
        System.out.println("Withdrawn " + amount + ". New balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }

    public void showHistory() {
        System.out.println("=== Operations History ===");
        for (String someoperations : historial) {
            System.out.println(someoperations);
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", balance=" + balance +
                '}';
    }
}