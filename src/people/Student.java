package people;

/**
 * Clase Student que HEREDA de Person (extends).
 * Demuestra herencia y polimorfismo sobreescribiendo introduceYourself().
 * 
 * ¿Por qué extends? Porque un Student ES un Person con atributos adicionales.
 * Reutilizamos name, phone, age de Person sin duplicar código.
 */
public class Student extends Person {
  //Atributos especificos de Student (no estan en Person).
  private String studentNumber;
  private String address;

  /**
   * Constructor de Student.
   * Usa super(...) para llamar al constructor de Person y asignar name, phone, age.
   * Esto evita duplicar codigo y asegura que Person se inicialice correctamente.
   */
  public Student(String name, String phone, int age, String studentNumber, String address) {
    super(name, phone, age); //Llama al constructor de Person
    this.studentNumber = studentNumber;
    this.address = address;
  }

  // Getters especificos de Student
  public String getStudentNumber() {
    return studentNumber;
  }

  public String getAddress() {
    return address;
  }

  /**
   * POLIMORFISMO: Sobrescribimos el metodo Person.
   * @Override indica al compilador que estamos sobrescribiendo un metodo heredado.
   * Si la firma no coincide, el compilador dara error (Seguridad).
   * 
   * Cuando se llame introduceYourself() desde una variable de tipo Person
   * que referencie a un Student, se ejecutara ESTE metodo, no el de Person.
   */
  @Override
  public void introduceYourself() {
    System.out.println("¡Hi! I'm " + getName() + ", student number " + studentNumber + ".");
    System.out.println("I am " + getAge() + " years old, i live in " + address + " and my phone number is " + getPhone() + ".");
  }
}