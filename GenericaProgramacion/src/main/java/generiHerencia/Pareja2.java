package generiHerencia;

public class Pareja2 <T> {
    
    private T primero=null;
   
    public Pareja2(){
        primero=null;
    }
   
    public void setPrimero(T nuevoValor){
        this.primero=nuevoValor;
    }
    public T getPrimero(){
        return primero;   
    }                                       //indicamos que es paraaremtro admita empleado y ademas todas las subclases de empleado,osea todas las clases que hereden de empleado
    public static void imprimirTrabajador(Pareja2<? extends Empleado> p){//cuadnoi queremos hacer queun metodo de una calse generica reciba un argumento de una calse o de suws subcalses
     Empleado primero=p.getPrimero();       //tipos comodines                                //ya que la herenfcia funciona de forma diferente , si no se especifica asi no funcionaria
        System.out.println(primero);
    }
}
/*public class Pareja2 <? extends T>{//novalido
    
    private T primero=null;
   
    public Pareja2(){
        primero=null;
    }
   
    public void setPrimero(T nuevoValor){
        this.primero=nuevoValor;
    }
    public T getPrimero(){
        return primero;   
    }                                    
    public static void imprimirTrabajador(Pareja2<? extends Empleado> p){
     Empleado primero=p.getPrimero();      
        System.out.println(primero);
    }
}*/

/*public class Pareja2 <T extends Empleado> {
    
    private T primero=null;
   
    public Pareja2(){
        primero=null;
    }
   
    public void setPrimero(T nuevoValor){
        this.primero=nuevoValor;
    }
    public T getPrimero(){
        return primero;   
    }                                       
    /*public static void imprimirTrabajador(Pareja2<? extends Empleado> p){
     Empleado primero=p.getPrimero();       
        System.out.println(primero);
    }*/
//}
