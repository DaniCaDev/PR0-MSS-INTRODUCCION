package vehicles;

/**
 * Clase concreta Bike que hereda de Vehicle.
 * Implementa move() de forma diferente a Car (polimorfismo).
 */
public class Bike extends Vehicle {

    private boolean hasBasket;

    public Bike(String brand, boolean hasBasket) {
        super(brand);  // Llama al constructor de Vehicle
        this.hasBasket = hasBasket;
    }

    public boolean hasBasket() {
        return hasBasket;
    }

    /**
     * Implementación del método abstracto move().
     * Una bici se mueve de forma distinta a un coche.
     */
    @Override
    public void move() {
        String basketInfo = hasBasket ? " (con cesta)" : "";
        System.out.println("La bici " + brand + basketInfo + " se mueve pedaleando por el carril bici.");
    }
}