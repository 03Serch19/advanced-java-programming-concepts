package generiHerencia;

public class Jefe extends Empleado{
    
    public Jefe(String nombre, int edad, double sueldo) {
        super(nombre, edad, sueldo);
    }
    public double incentico(int inc){
        return inc;
    }
}
