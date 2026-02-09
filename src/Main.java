import bank.*;


public class Main {

    public static void main(String[] args) throws InsufficientFundsException {

        System.out.println("=== EJERCICIO 1: BankAccount ===");

        BankAccount acc1 = new BankAccount("ES001", "Ana", 0);
        BankAccount acc2 = new BankAccount("ES002", "Luis", 10);
        try {
            acc1.deposit(100);
            acc1.withdraw(30);
            acc1.withdraw(200);
            acc1.deposit(-5);
        } catch (InsufficientFundsException e) {
            System.out.println("Funds error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Argument error: " + e.getMessage());
        }
        // Estas líneas SIEMPRE se ejecutan
        System.out.println("Final balance Ana: " + acc1.getBalance());
        acc1.showHistory();
        try {
            acc2.withdraw(50);
            acc2.deposit(20);
        } catch (InsufficientFundsException e) {
            System.out.println("Funds error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Argument error: " + e.getMessage());
        }
        System.out.println("Final balance Luis: " + acc2.getBalance());
    }
}