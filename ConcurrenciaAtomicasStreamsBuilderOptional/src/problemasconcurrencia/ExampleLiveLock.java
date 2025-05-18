package problemasconcurrencia;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExampleLiveLock {
    public static void main(String[] args) {
        Fox2 fox1=new Fox2("Zorro1");
        Fox2 fox2=new Fox2("Zorro2");
        Food2 food=new Food2();
        Water2 water=new Water2();
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
class Food2{

}
class Water2{

}
class Fox2{

    String name;
    public Fox2(String n){
        this.name=n;
    }
    public void drinkAndEat(Food2 food,Water2 water){
        synchronized (water){
            System.out.println("Soy "+this.name+" tengo el agua");
            move();
        }
        eatAndDrink(food, water);

    }
    public void eatAndDrink(Food2 food,Water2 water){
        synchronized (food){
            System.out.println("Soy "+this.name+" tengo la comida");
            move();
        }
        drinkAndEat(food, water);
    }
    public void move(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
