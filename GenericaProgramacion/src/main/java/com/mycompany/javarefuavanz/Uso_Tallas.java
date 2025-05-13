package com.mycompany.javarefuavanz;

import java.util.Scanner;

public class Uso_Tallas {
    //dentro del main no puede declararse un enum
    /*enum Talla{//realmente estamos creando una instancia pertenecietne a la clase enum, variable onbjeto denominada talla solo podra alamcenar estos valores
        MINI,MEDIANO,GRANDE,MUYGRANDE
    };*/
   enum Talla{
       MINI("S"),MEDIANO("M"),GRANDE("L"),MUYGRANDE("XL");
       //PRIVATE PORQUE LOS ENUM NO permiten crear instamcias como sifueran objetos, osea usar el operadoer new no, por eso si se usara constructor debe ser private
      private Talla(String abreviatura){
        this.abreviatura=abreviatura;
      }
      public String dameAbreviatura(){
          return abreviatura;
      }
      private String abreviatura;
      //nop haria falta el setter pues ya el constructor esta funcionando como setter pero si nececitamos los getter
      
   }
    public static void main(String[] args) {
      /* //alamcenar 
       String talla;
       talla="pequeña";
       talla="mediana";
       talla="grande";
       
       talla="azul";//queremos asegurarnnos que solo se alamcenen un deertminado tipo de valoraes, y que noi se alamcene nada diferente a esos n valores
    */
      
    /*  Talla s = Talla.MINI;//no es mas ni menos que un objeto
      Talla m= Talla.MEDIANO;
      Talla l=Talla.GRANDE;
      Talla xl= Talla.MUYGRANDE;*/
      
       // System.out.println(s);
        
       //los tipos enumerados permiten lamprogramcion de constructores y setters y getters
       Scanner sc = new Scanner(System.in);
        System.out.println("Escribe una talla:, MINI, MEDIANO, GRANDE, MUYGRANDE");
        String entr=sc.next().toUpperCase();
        Talla la_talla=Enum.valueOf(Talla.class, entr);
        System.out.println("Talla= "+la_talla);
        System.out.println("Abreviatura= "+ la_talla.dameAbreviatura());
    }
}
