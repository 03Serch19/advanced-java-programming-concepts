package genericosClasesPropias;

                  //parametro de tipo//le indicamos que manejara un argumento de tipo que en principio es generico
public class Pareja <T>{//argumento de tipo
    //por convenio se suelen usar letras en mayuscula y suelen ser la T la U y la K, por convencion, pero podria ser cualquier letra
      
  private T primero;

    public Pareja() {
        primero = null;
    }
  
    public void setPrimero(T nuevoValor){
        primero=nuevoValor;
    }
    //indicamos que en pricipio esto retornara un generico
    public T getPrimero(){
        return primero; 
    }
}
