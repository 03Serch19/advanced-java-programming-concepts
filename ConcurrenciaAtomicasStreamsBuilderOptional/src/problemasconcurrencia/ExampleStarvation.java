package problemasconcurrencia;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExampleStarvation {
    public static void main(String[] args) {
        Fox3 fox1=new Fox3();
        Fox3 fox2=new Fox3();
        Food3 food=new Food3();
        Elephant ele1=new Elephant();
        ExecutorService service=null;
        try {
            service = Executors.newScheduledThreadPool(10);
            service.submit(() -> fox1.eat(food));//subtmi recibe un onjeto runnable,//por ende es un  obejt oqmue implemente su metodo run loq ue recibe, por tanto le mandamo la funcion de una vbez a traves de la almbda
            service.submit(() -> fox2.eat(food));
            service.submit(() -> ele1.eat(food));

        }finally {
            if (service!=null)service.shutdown();
        }
    }
}
class Food3{
}
class Elephant{
    public void eat(Food3 food){
        synchronized (food){
            System.out.println("hi soy elefante tengo la comida");
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class Fox3{

    public void eat(Food3 food){
        move();
        synchronized (food){
            System.out.println("hi soy zorro tengo la comida");
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
