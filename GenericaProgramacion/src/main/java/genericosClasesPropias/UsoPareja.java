package genericosClasesPropias;

public class UsoPareja {
    public static void main(String[] args) {
        Pareja<String> una=new Pareja<>();
        
        una.setPrimero("texto");
       // String primero=una.getPrimero();
        System.out.println(una.getPrimero());
        //System.out.println(primero);
        
        Persona persona1=new Persona("hellowwww");
        Pareja<Persona> otraInstancia = new Pareja<>();
        
        otraInstancia.setPrimero(persona1);
        
        System.out.println(otraInstancia.getPrimero());
    }
}
class Persona{
    private String nombre;
    public Persona(String nombre){
        this.nombre=nombre;
    }
   /* @Override
    public String toString(){
        return nombre;
    }*/
}
