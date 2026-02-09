package vehicles;

/**
 * Clase concreta Car que hereda de Vehicle.
 * Al heredar de una clase abstracta, DEBE implementar todos los métodos abstractos.
 */
public class Car extends Vehicle {

    private int numDoors;

    public Car(String brand, int numDoors) {
        super(brand);  // Llama al constructor de Vehicle
        this.numDoors = numDoors;
    }

    public int getNumDoors() {
        return numDoors;
    }

    /**
     * Implementación OBLIGATORIA del método abstracto move().
     * Cada tipo de vehículo se mueve de forma diferente.
     */
    @Override
    public void move() {
        System.out.println("El carro " + brand + " avanza por la carretera con sus " + numDoors + " puertas.");
    }
}
