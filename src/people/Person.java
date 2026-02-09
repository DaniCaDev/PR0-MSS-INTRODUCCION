package people;

/**
 * Clase base que representa una persona generica.
 * Demuestra encapsulacion con atributos privados y acceso mediante getters.
 */
public class Person {
  //Atributos privados para encapsulacion
  private String name;
  private String phone;
  private int age;

  /**
   * Constructor que inicializa todos los atributos de Person.
   */
  public Person(String name, String phone, int age) {
    this.name = name;
    this.phone = phone;
    this.age = age;
  }
  
  //Getters para acceder a los atributos desde fuera
  public String getName() {
    return name;
  }
  
  public String getPhone() {
    return phone;
  }

  public int getAge() {
    return age;
  }

  /**
   * Metodo que sera sobrescrito por las clases hijas (polimorfismo).
   * En person, muestra una presentacion generica.
   */
  public void introduceYourself() {
    System.out.println("Hi, i'm " + name + ", I am " + age + " years old and my phone number is " + phone + ".");
  }
}