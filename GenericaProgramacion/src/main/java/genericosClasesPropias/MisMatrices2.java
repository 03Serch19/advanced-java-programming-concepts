package genericosClasesPropias;

public class MisMatrices2 /*<T>*/{
   // private T unvalor=null;
   // String sfsf="fsfs";
    /*public static <T> String getLongitud(T[] a){
        return "La longitud es: "+a.length;
    }*/
    //En genéricos, siempre usamos extends, incluso para interfaces.
    //Java no permite implements en la declaración del tipo genérico.
    //T debe implementar Comparable<T>, lo que garantiza que podemos usar compareTo().
    // implements solo se usa cuando una clase implementa una interfaz, pero no en genéricos.
    /*Aunque Comparable es una interfaz, en genéricos Java usa extends tanto para clases como para interfaces.*/
        public static <T extends Comparable> T getMenorElemtento(T[] a){ //y como un generico T no implemtnea esta interfaz y debemos asegurarnos que el generico que recibamos tiene que tenerla implementada
            if(a.length==0 || a==null)return null;  //entocnes agregamos extends,  y nos aseguramos que todo generico que venga deba de tener implementada la interfaz por la cual tendran una implementacion de compare to y asi poder usara en sus objetos
            //int ban;
            T elementoMenor=a[0];
             for (int i = 1; i < a.length; i++) {
                if(elementoMenor.compareTo(a[i])>0){
                    elementoMenor=a[i];
                }
            }
            // int nume =4,nume2=11;
          /*   Integer nume=new Integer(6);//compareTo se aplica a las clases que implementan la interfaz comparable, por eso String date, y las calses envoltorias de primiticos datos de estods tipos de calses objetods este tipo permiten usarlo ya qesra clases lo implementen, en caso de primitivos no funcionaria, o en caso de calses creadas por nosotros como Empelado, no podraiusarse ya que nuestra clase no implementamos compareTo, con lo que a obkjetos del tipo de mi calsepodrian  usar el emtodo compareTo
               Integer nume2=new Integer(9);  
             if(nume.compareTo(nume2)<0)System.out.println("es menor");*/
          
           // return unvalor;
        return elementoMenor;//"El valor menor es ";
    }
       /* public static String sfsf(){
            return sfsf;//valores capos de clase no estaticas no pueden ser accedidos desde contextos static
        }*/
}
