import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.JOptionPane;
//hay mucho comentario guia en el cual quize dejar ciertas cosas las cuales queria dejar en claro y decidi dejarlo anotado

public class BancoSinSincronizar {//ya esta sincronizado, hasta antes de agregar el LockRetrantLock esta sin sincrinozar
  public static void main(String[] args) {
    Banco bc = new Banco();
  //bc.transferencia(58, 14, 568.42);
  //Runnable ej=new EjecucionTransferencias(bc, 5, 2000);
  //EjecucionTransferencias ej=new EjecucionTransferencias(bc, 5, 2000);//esto funciona igual que lop de arriba, nada mas que en caso tuviera mas metodos en esta clase, pues al ser esta declaracioon el tipo de a calse directe,mten poddria acceder a esos metodos, en vcambio arriba solo accederia con ej. solo a run y no a los demas metodos
  //Thread hilo1=new Thread(ej);
  //hilo1.start();
    for (int i = 0; i < 100; i++) {
      Runnable r = new EjecucionTransferencias(bc, i, 2000);
      // EjecucionTransferencias r =new EjecucionTransferencias(bc, i, 2000);
      Thread t = new Thread(r);
      t.start();
    }

   //JOptionPane.showMessageDialog(null, bc, null, 0);//este joptioon pane solo se mmuestra parea hacer ver eque e hilo principal continua disponible para seguir con demastareas
  }
}

class Banco {
 //propiosinsynchronized  private Lock cierreBanco = new ReentrantLock();
    // private ReentrantLock cierreBanco=new ReentrantLock();
  private final double[] cuentas;
  //propiosinsynchronized private Condition saldoSuficiente;//ahora con esto, todos os hilos de nuestrro programa no mueren y no ahcen su trabajo, aqui todos los hilos qu entran  dentro del metodo transfrencia tarde o temprano terminan realizando la transfrencia, cuando otro hillo u optros hillos qvayan realizando ingresos en la cuenta que  se quedo sin saldo para que en un mometno dado sea capz de realizar la transefrencia
  public Banco() {
    cuentas = new double[100];
    for (int i = 0; i < cuentas.length; i++) {
      cuentas[i] = 2000;
    }
   //propiosinsynchronized  saldoSuficiente=cierreBanco.newCondition();//nos deveuelve  el objeto que nos devuevle en la impolemtracion de newCondition en retarnt lock el cual es del tipo condition que  si bien es un ainterfaz pero lo que nos devuelve dentro de le implementacion es un objetico de un tipo de clase el cual implemeta a Condition, portatno lo que nos viene es un objeto de una clase que implemetna la interfz Condition, por ello el retorno Condition ya trae el objeto
     /*    public Condition newCondition() {//esto es la implenetacion en retrantlock, lo cual devuelve  el obejto de la imolemntacion en el  metodo llamado igual dentro de la calse del tipo del que es sync el cual esta abajo
        return sync.newCondition();
    }*///nose deuvel un tipo de ojeto el dek tipo el cual si es una clase y si revisamos esta clase, es aca donde implementa la interfaz condition , por tanto esta calse es la que tiene la imoplemnetnacion de todos los metodos de la interfaz condition, y por ende apliando poo, este tipo de objeto puede estar el amecenado  en el mismo tipo de dato de la   interfaz que implelmtea, Condition con = new ConditionObjetc(); por asi decirllo
    /*  final ConditionObject newCondition() {
            return new ConditionObject();
        }*/
  }

  public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException {
    //propiosinsynchronized cierreBanco.lock();
   //propiosinsynchronized  try {
      /*if (cuentas[cuentaOrigen] < cantidad) {
        System.out.println("----CANTIDAD INSUFICIENTE:"+cuentaOrigen+"....SALDO:"+cuentas[cuentaOrigen]+"....."+cantidad);

        return;
      }else{
        System.out.println("--------CANTIDAD OK---------"+cuentaOrigen);
      }*/
     // if(cuentas[cuentaOrigen] < cantidad) {//funicoana pero si hay "despertadas espurias" (spurious wakeups) esto daria incosdistencias y errres, al no ahber otra forma de verificar de nuevo la condicion, ya que puede que despierte sin necesariemente porque  otro hiuklo  haya logado satisfrcacer ell saldo y asi poder  conditnuar  la tranferancia, y por  ende nos puede lleavr a errores ya que el if soo  despierta y comoes u if pues ya soo salse del if y contiunua sin perrcaatarse de nuevo si deberdad se cumplio o ono la copndicion, en cambio un whiler pues dluego del await de nuevo vuele aiterar y vealua la ocndicion
      while(cuentas[cuentaOrigen] < cantidad) {
     //propiosinsynchronized   saldoSuficiente.await();//se pone a la espera y ademas se libera el bloqueo para que acceda ell siguietne hilo
      wait();
    }
    
      System.out.println(Thread.currentThread());
      cuentas[cuentaOrigen] -= cantidad;// dinero que sale de la cuenta origen
      System.out.printf("%10.2f de %d para %d ", cantidad, cuentaOrigen, cuentaDestino);
      cuentas[cuentaDestino] += cantidad;
      System.out.printf("Saldo total: %10.2f%n", getSaldoTotal());
      notifyAll();
     //propiosinsynchronized  saldoSuficiente.signalAll();
  //propiosinsynchronized   } finally {
    //propiosinsynchronized   cierreBanco.unlock();
    //propiosinsynchronized }
  }

  public double getSaldoTotal() {
    double sumaCuentas = 0;
    for (double d : cuentas) {
      sumaCuentas += d;
    }
    return sumaCuentas;
  }
}

class EjecucionTransferencias implements Runnable {
  private Banco banco;
  private int deLaCuenta;
  private double cantidadMax;

  public EjecucionTransferencias(Banco banco, int deLaCuenta, double cantidadMax) {
    this.banco = banco;
    this.deLaCuenta = deLaCuenta;
    this.cantidadMax = cantidadMax;
  }

  @Override
  public void run() {
    try {
     while (true) {
       int paraLaCuenta = (int) (100 * Math.random());
       double cantidad = cantidadMax * Math.random();
       banco.transferencia(deLaCuenta, paraLaCuenta, cantidad);
        Thread.sleep((int) (Math.random() * 10));
     }
   } catch (InterruptedException e) {
        e.printStackTrace();
   }
  }
}
