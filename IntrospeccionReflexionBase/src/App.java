public class App {
  public static void main(String[] args) throws Exception {
   
    Persona juan = new Persona("Juan", "Pérez", 30, "12345678A", "Calle Falsa 123", "123456789");
    System.out.println(juan.getNombre() + " " + juan.getApellidos() + ", " + juan.getEdad() + " años, DNI: "
        + juan.getDni() + ", Dirección: " + juan.getDireccion() + ", Teléfono: " + juan.getTelefono());
    Empleado ana = new Empleado("Ana", "Gómez", 25, "87654321B", "Avenida Siempre Viva 456", "987654321", 30000,
        "Desarrollador", "IT", 5, 2);
    System.out.println(ana.getNombre() + " " + ana.getApellidos() + ", " + ana.getEdad() + " años, DNI: " + ana.getDni()
        + ", Dirección: " + ana.getDireccion() + ", Teléfono: " + ana.getTelefono() + ", Salario: " + ana.getSalario()
        + ", Puesto: " + ana.getPuesto() + ", Departamento: " + ana.getDepartamento() + ", Antigüedad: "
        + ana.getAntiguedad() + " años, Horas Extra: " + ana.getHorasExtra());
        System.out.println("**************************************");
       // System.out.println(juan.getClass());
       // System.out.println(juan.getClass().getName());
      // Class<?> juanClass = juan.getClass();
    //   System.out.println("Clase de juan: " + juanClass.getName());
   // String nombreClase="Empleadod";
    String nombreClase="Empleado";
    Class<?> clase;
    try {
      clase = Class.forName(nombreClase);
      System.out.println(clase);
        System.out.println("Clase de Ana: " + clase.getName());
    } catch (ClassNotFoundException e) {
        System.out.println("Clase no encontrada: " + e.getMessage());
    }
    nombreClase="Persona";
    try {
      clase = Class.forName(nombreClase);
      System.out.println(clase);
        System.out.println("Clase de Juan: " + clase.getName());
    } catch (ClassNotFoundException e) {
        System.out.println("Clase no encontrada: " + e.getMessage());
    }
  }
}
