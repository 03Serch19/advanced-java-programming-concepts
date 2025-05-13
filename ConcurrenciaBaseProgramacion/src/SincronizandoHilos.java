public class SincronizandoHilos {
  public static void main(String[] args) {
    /*HilosVarios hilo1 = new HilosVarios();
    HilosVarios hilo2 = new HilosVarios();
    hilo1.start();
    try {
      hilo1.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    hilo2.start();
    try {
      hilo2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }*/
    HilosVarios hilo1 = new HilosVarios();
    HilosVarios2 hilo2 = new HilosVarios2(hilo1);
    //hilo1.start();
    hilo2.start();//da igual el orden al menos en este caso , ya que la sicronizaciuon ya esta entre ellos y el que se ejecutar aprimnero sera el hilo 1, y luego hilo 2, aquqnue en este coidgo el sout sera el pirmero que se ejhecuta, mostrandonos que queda liberado el hilo principal apra seguir en su ejhecucion
    /*    public Condition newCondition() {
        return sync.newCondition();
        esto esta en retarntlock y synk esta accedeidno a l emtodo que esta en su ipo de calse el cual se llama igual ya que este
    } */
    hilo1.start();
    System.out.println("Terminadas las tareas");
  }
}
class HilosVarios extends Thread{
  
  public void run(){  
    for (int i = 0; i < 15; i++) {
      System.out.println("Ejecutando hilo "+getName());
    try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

class HilosVarios2 extends Thread{
  public HilosVarios2(Thread hilo){
   this.hilo=hilo;
  }
  public void run(){  
    try {
      hilo.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    for (int i = 0; i < 15; i++) {
      System.out.println("Ejecutando hilo"+getName());
    try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private Thread hilo;
}
