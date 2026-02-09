package bank;

/**
 * Excepción personalizada para operaciones con fondos insuficientes.
 * Mejora opcional del ejercicio 1.
 */
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}