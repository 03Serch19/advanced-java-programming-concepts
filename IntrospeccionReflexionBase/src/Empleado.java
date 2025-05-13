public class Empleado extends Persona {
    private double salario;
    private String puesto;
    private String departamento;
    private int antiguedad;
    private int horasExtra;

    public Empleado(String nombre, String apellidos, int edad, String dni, String direccion, String telefono, double salario, String puesto, String departamento, int antiguedad, int horasExtra) {
        super(nombre, apellidos, edad, dni, direccion, telefono);
        this.salario = salario;
        this.puesto = puesto;
        this.departamento = departamento;
        this.antiguedad = antiguedad;
        this.horasExtra = horasExtra;
    }

    // Getters y Setters
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public int getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }

}
