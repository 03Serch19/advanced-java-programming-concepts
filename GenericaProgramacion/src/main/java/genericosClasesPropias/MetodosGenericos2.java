package genericosClasesPropias;

import generic.Empleado;
import java.util.GregorianCalendar;

public class MetodosGenericos2 {
    public static void main(String[] args) {    
      String nombres[]={
            "Ezequiel","Jose","Andrea","pepe"
        };
      

        System.out.println(MisMatrices2.getMenorElemtento(nombres));

      
          Empleado empleados[] ={
      new Empleado("Leonardo", 25, 63.55),
       new Empleado("Aaron", 25, 63.55),
        new Empleado("Arnoldo", 25, 63.55),
         new Empleado("Bet", 25, 63.55)
    };
      
      // System.out.println(MisMatrices2.getMenorElemtento(empleados));
       //errror emn tieumpo de compilacion, ya que estos objetos no impleklentean la interfaz compareble osea la calse empleado no impklementa laminterfaz por lo tandto no tenemos este metodo, 
       //y amraca error ya que en la definmicion del metodo generico le dijimos al generico que los tipos genericos que nreciba(que deben ser de tipos objetos) implementen a comparable
     //y tiene sentido, ´porque como sabemos que criterio usar para ordenar estos objetos, entocnes aca es donde se deberia implemntear compareble
      //y asi em em´pleado estariamos aobligado a relaizar la impolemnetnacion de compareTo en la cual definiiramos el algoriutmo apra comparar entre los valores
      // yn asi opbjetos de este tipo se podrian compara con compare to y estarian cumpliaendo lo que el tipo generico que reciba por parametro el metodo get menor debe implementar a Comparable
   
        GregorianCalendar fechas[]={
            new GregorianCalendar(2015, 11,25),
            new GregorianCalendar(2012, 6,22),
            new GregorianCalendar(2019, 1,21),
            new GregorianCalendar(2016, 6,26),
        };
       System.out.println(MisMatrices2.getMenorElemtento(fechas));
    }
    
}
