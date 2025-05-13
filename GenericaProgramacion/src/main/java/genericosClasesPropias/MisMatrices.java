package genericosClasesPropias;

//forma 1
public class MisMatrices{
   //METODOS GENERICOS
    
    //un metodo generico no necesariamente tiene que estar dentro de una calse generica, peude estar dentro de una calse ordinaria tambien
    public static <T> String getElementos(T[]a){//si es estatico se debe definir su tipo ya sea este dentro o no de una clase generica ya que es un genrico local que se crea en el emtodo en cada llamada aunque se llame igual que el genrico de la clase en caso estuviera dentro de una calse generica, yaa al ser estatico este no accede a al t de la clase
        return "La Longitud del array es: "+(a.length);
    }
    
}
//forma 2
 /*public class MisMatrices <T>{
     private T primero;
           //si esta dentro de una clase generica pero es estatico tambien se le debe declarar el tipo generico T, pero este T no es el mismo T que el T de la clase
    public static <T> String getElementos(T[]a){
        return "La Longitud del array es: "+(a.length);
    }   
}*/
//forma 3
/*public class MisMatrices <T>{
    private T contenido;

    public void setContenido(T contenido) {
        this.contenido = contenido;
    }

    public T getContenido() {
        return contenido;
    }

    //  Método estático genérico que usa el mismo tipo de la clase
    public static <T> void metodoEstatico(T valor) { 
        System.out.println("Valor: " + valor);
    }
}*/


//forma4
/*public class MisMatrices<T>{
   //METODOS GENERICOS
     //ojo que si aca agregamos <T>, de nuevo al metodo es como si este metodo fuera estatico, osea seria otra T diferente al t de la clase, lo cual seria mejor usar metodos estaticos
   //si es de clase generica y no es estaico se puede no especidfifcar el parametro t ya que tomara el  t de la clase
    public String getElementos(T[]a){
        return "La Longitud del array es: "+(a.length);
    }
      
}*/

//forma 5
/*public class MisMatrices{
   //METODOS GENERICOS
    
   //si la clase no es generica, y el metodo no es estatico tambien se debe deejar el aprametro definido
    public <T> String getElementos(T[]a){ //ya que pues no hay un tipo definido de genrico ya que no es clase generica y pues tocaria usar el generico local del metodo
        return "La Longitud del array es: "+(a.length);
    }
    
}*/
