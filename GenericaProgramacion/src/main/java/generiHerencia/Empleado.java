package generiHerencia;

public class Empleado {
    private String nombre;
    private int edad;
    private double sueldo;

    public Empleado(String nombre, int edad, double sueldo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sueldo = sueldo;
    }

   public String dameDatos(){
       return "Nombre: "+nombre+" Edad: "+edad+" Sueldo: "+sueldo;
   }
    
}
