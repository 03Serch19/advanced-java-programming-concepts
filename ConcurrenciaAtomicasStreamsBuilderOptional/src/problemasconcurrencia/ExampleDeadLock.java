package problemasconcurrencia;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExampleDeadLock {
    public static void main(String[] args) {
        Fox fox1=new Fox();
        Fox fox2=new Fox();
        Food food=new Food();
        Water water=new Water();
        ExecutorService service=null;
try {
    service = Executors.newScheduledThreadPool(10);
    service.submit(() -> fox1.drinkAndEat(food, water));//subtmi recibe un onjeto runnable,//por ende es un  obejt oqmue implemente su metodo run loq ue recibe, por tanto le mandamo la funcion de una vbez a traves de la almbda
    service.submit(() -> fox2.eatAndDrink(food, water));
}finally {
    if (service!=null)service.shutdown();
}
    }
}
class Food{

}
class Water{

}
class Fox{
    public void drinkAndEat(Food food,Water water){
     synchronized (water){
         System.out.println("hi1 tengo el agua");
          move();
          synchronized (food){
              System.out.println("hi1 tengo la comida");
          }
     }
    }
    public void eatAndDrink(Food food,Water water){
        synchronized (food){
            System.out.println("hi2 tengo la comida");
            move();
            synchronized (water){
                System.out.println("hi2 tengo el agua");
            }
        }
    }
 public void move(){
     try {
         Thread.sleep(2);
     } catch (InterruptedException e) {
         throw new RuntimeException(e);
     }
 }
}
