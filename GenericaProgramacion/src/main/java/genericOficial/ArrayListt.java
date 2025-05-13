package genericOficial;

public class ArrayListt {

    private int i=0;
    private Object[] datosElemento;
    
    public ArrayListt(int z){
      datosElemento=new Object[z];
    }
    public Object get(int i){
        return datosElemento[i];
    }
    public void add(Object o){
        datosElemento[i]=o;
        i++;
    }
   
}
