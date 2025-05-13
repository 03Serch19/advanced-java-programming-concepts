package genericOficial;

import java.io.File;

public class UsoArrayListt {//tratando de crear arrayList sin progra generica
    public static void main(String[] args) {
        
        ArrayListt arrayli=new ArrayListt(6);
       arrayli.add("Juan");
        arrayli.add("andrea");
        arrayli.add("Sofia");
        arrayli.add("Karen");
        arrayli.add("ricardo");
        arrayli.add(new File("ruta.txt"));//en tienmpo de compilacion no ,arca error, no pasira si se usara progra generica osea un araylist ya que ahi si especificamos que sea de tipo string y por tanto nos marcaria error en tiempo de compilacion
        
        String nombre=(String)arrayli.get(2);
        System.out.println(nombre);
        String nombre2=(String)arrayli.get(5);
        System.out.println(nombre2);
      
       /* arrayli.add(new File("gestiion_invento.txt"));
        
        File nombre=(File)arrayli.get(0);
         System.out.println(nombre);*/
         
       /*  arrayli.add(45.26);
         double nombre=(double)arrayli.get(0);*/
         //System.out.println(nombre);
    }
}
