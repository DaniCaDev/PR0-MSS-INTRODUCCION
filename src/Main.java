import bank.*;
import people.*;
import vehicles.*;

/**
 * Clase principal que demuestra todos los conceptos OOP de la práctica.
 */
public class Main {

    public static void main(String[] args) {

        // ============================================================
        // EJERCICIO 1: BankAccount (Encapsulación)
        // ============================================================
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║        EJERCICIO 1: BankAccount (Encapsulación)          ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝\n");

        BankAccount acc1 = new BankAccount("ES001", "Ana", 0);
        BankAccount acc2 = new BankAccount("ES002", "Luis", 10);

        System.out.println("--- Pruebas cuenta Ana ---");
        // Prueba 1: Depósito correcto
        try {
            acc1.deposit(100);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Prueba 2: Retirada correcta
        try {
            acc1.withdraw(30);
        } catch (InsufficientFundsException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Prueba 3: Retirada incorrecta (más que el saldo)
        try {
            acc1.withdraw(200);
        } catch (InsufficientFundsException e) {
            System.out.println("Error esperado (fondos insuficientes): " + e.getMessage());
        }

        // Prueba 4: Depósito incorrecto (valor negativo)
        try {
            acc1.deposit(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Error esperado (valor inválido): " + e.getMessage());
        }

        // Prueba 5: Depósito incorrecto (valor 0)
        try {
            acc1.deposit(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Error esperado (valor cero): " + e.getMessage());
        }

        System.out.println("\nBalance final Ana: " + acc1.getBalance());
        System.out.println(acc1);  // Usa toString()
        acc1.showHistory();

        System.out.println("\n--- Pruebas cuenta Luis ---");
        // Prueba 6: Retirada incorrecta (más que el saldo)
        try {
            acc2.withdraw(50);
        } catch (InsufficientFundsException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }

        System.out.println("Balance final Luis: " + acc2.getBalance());

        // ============================================================
        // EJERCICIO 2: Person/Student (Herencia + Polimorfismo)
        // ============================================================
        System.out.println("\n╔══════════════════════════════════════════════════════════╗");
        System.out.println("║     EJERCICIO 2: Person/Student (Herencia + Polimorfismo) ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝\n");

        // Prueba 1: Crear una Person y llamar a introduceYourself()
        System.out.println("--- Prueba 1: Person ---");
        Person persona1 = new Person("María García", "612345678", 35);
        persona1.introduceYourself();

        // Prueba 2: Crear un Student y llamar a introduceYourself()
        System.out.println("\n--- Prueba 2: Student ---");
        Student estudiante1 = new Student("Carlos López", "698765432", 21, "ALU001234", "Calle Principal 15, La Laguna");
        estudiante1.introduceYourself();

        // Prueba 3: POLIMORFISMO - Variable de tipo Person que referencia a Student
        System.out.println("\n--- Prueba 3: Polimorfismo (Person que referencia Student) ---");
        /*
         * POLIMORFISMO EN ACCIÓN:
         * La variable 'personaQueEsEstudiante' es de tipo Person,
         * pero apunta a un objeto Student.
         * 
         * Cuando llamamos a introduceYourself(), Java NO ejecuta
         * el método de Person, sino el de Student.
         * 
         * Esto es porque Java resuelve qué método llamar EN TIEMPO DE EJECUCIÓN
         * basándose en el tipo REAL del objeto (Student), no en el tipo de la variable (Person).
         */
        Person personaQueEsEstudiante = new Student("Elena Martín", "655443322", 22, "ALU005678", "Avenida Trinidad 42");
        personaQueEsEstudiante.introduceYourself();  // ¡Ejecuta el método de Student!

        System.out.println("\n¿Por qué funciona así?");
        System.out.println("- La variable es de tipo Person");
        System.out.println("- El objeto real es de tipo Student");
        System.out.println("- Java llama al método del OBJETO REAL (Student)");

        // ============================================================
        // EJERCICIO 3: Vehicle (Abstracción) - OPCIONAL
        // ============================================================
        System.out.println("\n╔══════════════════════════════════════════════════════════╗");
        System.out.println("║         EJERCICIO 3: Vehicle (Abstracción) [OPCIONAL]     ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝\n");

        // No se puede instanciar Vehicle directamente (es abstracta):
        // Vehicle v = new Vehicle("Generic"); // ERROR de compilación

        // Creamos objetos concretos
        Car coche1 = new Car("Toyota", 4);
        Car coche2 = new Car("BMW", 2);
        Bike bici1 = new Bike("BH", true);
        Bike bici2 = new Bike("Orbea", false);

        // Creamos un array de Vehicle (tipo base) con distintos vehículos
        System.out.println("--- Polimorfismo con array de Vehicle ---");
        Vehicle[] vehiculos = { coche1, bici1, coche2, bici2 };

        /*
         * POLIMORFISMO + ABSTRACCIÓN:
         * Recorremos el array usando el tipo base (Vehicle).
         * Cada objeto ejecuta SU PROPIA versión de move().
         * El mismo código funciona para coches y bicis.
         * 
         * Esto demuestra que:
         * 1. La abstracción define QUÉ deben hacer los vehículos (moverse)
         * 2. Las clases concretas definen CÓMO lo hacen
         * 3. El polimorfismo permite tratar distintos tipos de forma uniforme
         */
        for (Vehicle v : vehiculos) {
            v.move();
        }

        System.out.println("\n--- También podemos usar referencias de tipo Vehicle ---");
        Vehicle miVehiculo = new Car("Mercedes", 4);
        miVehiculo.move();  // Ejecuta el move() de Car

        miVehiculo = new Bike("Giant", true);
        miVehiculo.move();  // Ahora ejecuta el move() de Bike

        // ============================================================
        // RESUMEN DE CONCEPTOS
        // ============================================================
        System.out.println("\n╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                   RESUMEN DE CONCEPTOS                    ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        System.out.println("• ENCAPSULACIÓN: balance es private, solo se modifica con métodos");
        System.out.println("• HERENCIA: Student extends Person (reutiliza código)");
        System.out.println("• POLIMORFISMO: Person p = new Student() ejecuta método de Student");
        System.out.println("• ABSTRACCIÓN: Vehicle define contrato, Car/Bike lo implementan");
    }
}