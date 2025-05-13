package generic;

public class Empleado {
   private String nombre;
    private int edad;
    private double sueldo;
 /*public String nombre;
   public int edad;
    public double sueldo;*/
    public Empleado(String nombre, int edad, double sueldo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", edad=" + edad + ", sueldo=" + sueldo + '}';
    }
    
}
