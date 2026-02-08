import bank.BankAccount;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== EJERCICIO 1: BankAccount ===");

        BankAccount acc1 = new BankAccount("ES001", "Ana", 0);
        BankAccount acc2 = new BankAccount("ES002", "Luis", 10);

        acc1.deposit(100);
        acc1.withdraw(30);
        acc1.withdraw(200);
        acc1.deposit(-5);
        System.out.println("Final balance Ana: " + acc1.getBalance());
        acc1.showHistory();

        acc2.withdraw(50);
        acc2.deposit(20);
        System.out.println("Final balance Luis: " + acc2.getBalance());
    }
}