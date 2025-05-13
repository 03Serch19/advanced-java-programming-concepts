package eje1.of;
public class Alumno {
    private String nombre;
    private String apellido;
    private int edad;
    private String dni;
    private String direccion;
    private String telefono;
    private String email;
    private String curso;
    private double notaMedia;

    public Alumno(String nombre, String apellido, int edad, String dni, String direccion, String telefono, String email, String curso, double notaMedia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.curso = curso;
        this.notaMedia = notaMedia;
    }

    public String getNombre() {
      return nombre;
    }

    public void setNombre(String nombre) {
      this.nombre = nombre;
    }

    public String getApellido() {
      return apellido;
    }

    public void setApellido(String apellido) {
      this.apellido = apellido;
    }

    public int getEdad() {
      return edad;
    }

    public void setEdad(int edad) {
      this.edad = edad;
    }

    public String getDni() {
      return dni;
    }

    public void setDni(String dni) {
      this.dni = dni;
    }

    public String getDireccion() {
      return direccion;
    }

    public void setDireccion(String direccion) {
      this.direccion = direccion;
    }

    public String getTelefono() {
      return telefono;
    }

    public void setTelefono(String telefono) {
      this.telefono = telefono;
    }

    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }

    public String getCurso() {
      return curso;
    }

    public void setCurso(String curso) {
      this.curso = curso;
    }

    public double getNotaMedia() {
      return notaMedia;
    }

    public void setNotaMedia(double notaMedia) {
      this.notaMedia = notaMedia;
    }

    @Override
    public String toString() {
      return "Alumno [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", dni=" + dni + ", direccion="
          + direccion + ", telefono=" + telefono + ", email=" + email + ", curso=" + curso + ", notaMedia=" + notaMedia
          + "]";
    }
  
 
}
