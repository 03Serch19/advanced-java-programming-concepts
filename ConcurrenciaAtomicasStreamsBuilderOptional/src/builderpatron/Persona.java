package builderpatron;

import java.util.Objects;

public class Persona {
 private String name;
 private int edad;
 private double salario;
 private String telefono;
 private String direccion;

    private Persona(String name, int edad, double salario, String telefono, String direccion) {
        this.name = name;
        this.edad = edad;
        this.salario = salario;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public double getSalario() {
        return salario;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getEdad() {
        return edad;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return edad == persona.edad && Double.compare(salario, persona.salario) == 0 && Objects.equals(name, persona.name) && Objects.equals(telefono, persona.telefono) && Objects.equals(direccion, persona.direccion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, edad, salario, telefono, direccion);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "name='" + name + '\'' +
                ", edad=" + edad +
                ", salario=" + salario +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }

    static  class Builder{
     private String name;
     private int edad;
     private double salario;
     private String telefono;
     private String direccion;

   public static Builder asPersona(){
       return new Builder();
   }
   public Builder name(String name){
    this.name=name;
    return  this;
   }
   public Builder edad(int edad){
         this.edad=edad;
         return  this;
   }
     public Builder salario(int salario){
         this.salario=salario;
         return  this;
     }
     public Builder telefono(String telefono){
         this.telefono=telefono;
         return  this;
     }
     public Builder direccion(String direccion){
         this.direccion=direccion;
         return  this;
     }
     public Persona build(){
         return new Persona(name,edad,salario,telefono,direccion);
     }
  }
}
