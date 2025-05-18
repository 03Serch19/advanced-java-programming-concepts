package atomicc;

import java.util.concurrent.atomic.AtomicInteger;

public class MainAtomic {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("start");
        Count cou=new Count();
        Thread proices1=new Thread(cou);
        Thread proices2=new Thread(cou);
        proices1.start();

        proices2.start();
        proices1.join();
        proices2.join();
        System.out.println(cou.count);
        System.out.println("stop");

    }

    static class Count implements Runnable{
        public AtomicInteger count=new AtomicInteger(0);
        public void run(){
            for (int i = 0; i < 100_000_000; i++) {
                count.addAndGet(1);//delta es un cambio, un incremento
            }
           // System.out.println("count final "+count);
        }
    }
}

/*public class atomicc.MainAtomic {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("start");
        Count cou=new Count();
        Thread proices1=new Thread(cou);
        Thread proices2=new Thread(cou);
        proices1.start();
        //   Thread.sleep(2000);
        proices2.start();
        proices1.join();
        proices2.join();
        System.out.println(cou.count);
        System.out.println("stop");

    }

    static class Count implements Runnable{
        public int count=0;
        public void run(){
            for (int i = 0; i < 100_000_000; i++) {
                count++;
            }
            System.out.println("count final "+count);
        }
    }
}*/

/*public class atomicc.MainAtomic {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("start");
        Thread proices1=new Thread(()->{
            int count=0;
            for (int i = 0; i < 100_000_000; i++) {
                count++;
            }
            System.out.println(count);
        });
        proices1.start();
        Thread.sleep(200);

        System.out.println("stop");

    }

}*/

/*public class atomicc.MainAtomic {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("start");
        Count cou=new Count();
      //  Count cou2=new Count();
        Thread proices1=new Thread(cou);
        Thread proices2=new Thread(cou);
       // Thread proices2=new Thread(cou2);
        proices1.start();
     //   Thread.sleep(2000);
        proices2.start();
        Thread.sleep(2000);
        System.out.println(cou.count);
       // System.out.println(cou2.count);
        System.out.println("stop");

    }

    static class Count implements Runnable{
        public int count=0;
        public void run(){
            for (int i = 0; i < 100_000_000; i++) {
                count++;
            }
            System.out.println("count final "+count);
        }
    }
}*/



/*public class atomicc.MainAtomic {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("start");
        Count cou=new Count();
         cou.start();
        Thread.sleep(20);
        System.out.println(cou.count);
        System.out.println("stop");

    }

    static class Count extends Thread{
        public int count=0;
        public void run(){
            for (int i = 0; i < 100_000_000; i++) {
                count++;
            }
        }
    }
}
*/
