package bank;
import java.util.ArrayList;

/**
 * Clase que representa una cuenta bancaria.
 * 
 * ENCAPSULACIÓN: balance es PRIVATE porque:
 * 1. Evita que se modifique directamente desde fuera (account.balance = 9999)
 * 2. Obliga a usar deposit() y withdraw() que tienen VALIDACIONES
 * 3. Mantiene el estado de la cuenta siempre coherente y válido
 */
public class BankAccount {

    private String accountNumber;
    private String ownerName;
    // PRIVATE: solo se puede modificar mediante deposit() y withdraw()
    private double balance;
    private ArrayList<String> history;


    public BankAccount(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = Math.max(initialBalance, 0);
        this.history = new ArrayList<>();
    }

    public void deposit(double amount) {
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
        }
        balance -= amount;
        history.add("Withdrawn " + amount + ". New balance: " + balance);
        System.out.println("Withdrawn " + amount + ". New balance: " + balance);
    }

    // Solo lectura: no hay setBalance(), el saldo solo cambia con operaciones válidas
    public double getBalance() {
        return balance;
    }

    public void showHistory() {
        System.out.println("=== Operations History ===");
        for (String operation : history) {
            System.out.println(operation);
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