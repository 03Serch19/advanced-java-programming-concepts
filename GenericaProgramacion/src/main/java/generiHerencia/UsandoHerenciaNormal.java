package generiHerencia;

import java.util.ArrayList;
import java.util.List;

public class UsandoHerenciaNormal {
    public static void main(String[] args) {
        List<Animal> listaAni=new ArrayList<>();
        //listaAni.add(new Animal("Animal general", "sin color"));//ojo que si hacemos abstract la clase esto ya no es ´posible ya que de calses abstractas no se pueden crar intancias
        listaAni.add(new Leon("leon", "dorado"));  //pero si no es abtracat comnopporbamos que puede adapatrase tanto al mertodo del padre como de las hijas, ya que en tiempo de ejecucion determina el metodo a ejecutar segun el objeto que tenga alamcenado,y como en teimpo de ejecucion es que logra esto, por eso si el metodo solo esta en la hijas y no en el padre, pues daria error ya que las variable tipo padre en tiempo de compilacion no podran acceder  alos metodos en su hijas aunqeu loque este almacenadno sea un objeto de estas, osea temndria qwue ejecutarse a la fuerza y ya emn teimpo de ejecucion funcionaria, pero esto no se puede obiviamente porque es un error de compilcion, asi que debe estar o abstracto o un metodo defidmnido en eopadre, y enm teimpo de ejecucion ahora si, se determkinara cual metodo usar segun elmobjeto real almacenado en la variable padre, ya sea uno de padre o uno de sus hijos
       //listaAni.add(new Animal("Animal general2", "sin color"));//
       listaAni.add(new Venado("Venado", "cafe"));
     //  listaAni.add(new Leopardo("leopardo", "con puntos"));//no permitido
        for (Animal animal : listaAni) {
            animal.hacerSonido();
        }
    }
}
  abstract class Animal{
    private String nombre;
    private String color;

    public Animal(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
    }
   /* public void hacerSonido(){
        System.out.println("Sonido general");
    }*/
    public abstract void hacerSonido();
}
class Venado extends Animal{
        
        public Venado(String nombre, String color) {
            super(nombre, color);
        }
        
        @Override
        public void hacerSonido(){
            System.out.println("Sonido de venado");
        }
        public void metodoVenado(){
            System.out.println("venadoo");
        }
    }
class Leon extends Animal{
        
        public Leon(String nombre, String color) {
            super(nombre, color);
        }
        
        @Override
        public void hacerSonido(){
            System.out.println("Sonido de leon");
        }
        public void metodoVenado(){
            System.out.println("leon");
        }
    }
class Leopardo{
        //no heradbndo tendria sus propios campos
    private String nombre;
    private String color;
        public Leopardo(String nombre, String color) {//no heredadndo
           // super(nombre, color);
           this.nombre=nombre;
           this.color=color;
        }
        
        //@Override
        public void hacerSonido(){
            System.out.println("Sonido de leopardo");
        }
        public void metodoVenado(){
            System.out.println("leopardo");
        }
    }