package vehicles;

/**
 * Clase ABSTRACTA Vehicle.
 * 
 * ¿Por qué abstracta? Porque:
 * 1. Un "vehículo" genérico no tiene sentido instanciarlo (¿cómo se mueve un vehículo abstracto?)
 * 2. Queremos OBLIGAR a las clases hijas (Car, Bike) a implementar move()
 * 3. Define un "contrato": todo Vehicle DEBE saber moverse, pero cada uno a su manera
 * 
 * No puedes hacer: Vehicle v = new Vehicle("Toyota"); // ERROR de compilación
 * Sí puedes hacer: Vehicle v = new Car("Toyota");     // OK, Car es concreto
 */
public abstract class Vehicle {

    // Atributo común a todos los vehículos
    // Protected: visible en las clases hijas (Car, Bike)
    protected String brand;

    /**
     * Constructor de Vehicle.
     * Aunque es abstracta, tiene constructor porque las clases hijas
     * lo usarán con super(brand).
     */
    public Vehicle(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    /**
     * Método ABSTRACTO: no tiene cuerpo (implementación).
     * Las clases que hereden de Vehicle DEBEN implementarlo.
     * Esto garantiza que todo vehículo sepa moverse.
     */
    public abstract void move();
}