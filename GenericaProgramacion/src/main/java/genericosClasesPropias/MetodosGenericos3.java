package genericosClasesPropias;

import generic.Empleado;
import java.util.GregorianCalendar;

public class MetodosGenericos3 {
    public static void main(String[] args) {  
        
        //F1 mas detalles en MetododsGenericos2
      String nombres[]={
            "Ezequiel","Jose","Andrea","pepe"
        };
      

        System.out.println(MisMatrices3.getMenorElemtento(nombres));
  
        GregorianCalendar fechas[]={
            new GregorianCalendar(2015, 11,25),
            new GregorianCalendar(2012, 6,22),
            new GregorianCalendar(2019, 1,21),
            new GregorianCalendar(2016, 6,26),
        };
       System.out.println(MisMatrices3.getMenorElemtento(fechas));
   
     
     //F2 //mismo iusao opracticamente que f1 pero para esto mejor usar metodo estatic
   /* String nombres[]={
            "Ezequiel","Jose","Andrea","pepe"
        };
       MisMatrices3 misMatrices3=new MisMatrices3();

        System.out.println(misMatrices3.getMenorElemtento(nombres));
  
        GregorianCalendar fechas[]={
            new GregorianCalendar(2015, 11,25),
            new GregorianCalendar(2012, 6,22),
            new GregorianCalendar(2019, 1,21),
            new GregorianCalendar(2016, 6,26),
        };
       System.out.println(misMatrices3.getMenorElemtento(fechas));*/
   
//F3//casio similar a F2 ya al redfinir en el metodo ekl tipo T estamos creando otro t difernte al t de la calse generica
   /*String nombres[]={
            "Ezequiel","Jose","Andrea","pepe"
        };
       //MisMatrices3 misMatrices3=new MisMatrices3();
    MisMatrices3<String> misMatrices3=new MisMatrices3();//inclsuoi esto funcionaria porque aunque en este caso3 la calse sea generica en mis matrices3, el tener en el emtodo especificado quer sea tipo t estamos redefiniendo otro t diferente al de la calse, asi que no afecta que estemos creando la isntancia con generico de tipo string o si n o se lo pasaramos,que tomaria object en ese cso, no afectaria
        System.out.println(misMatrices3.getMenorElemtento(nombres));
  
        GregorianCalendar fechas[]={
            new GregorianCalendar(2015, 11,25),
            new GregorianCalendar(2012, 6,22),
            new GregorianCalendar(2019, 1,21),
            new GregorianCalendar(2016, 6,26),
        };
       System.out.println(misMatrices3.getMenorElemtento(fechas));*/
   
   
   //F4 usando el t especificado de la clase, ya no podriamos hacer esa mezcla de enviar cualquier generic cuando ya se define uno en el<> de la instancia
  /* String nombres[]={
            "Ezequiel","Jose","Andrea","pepe"
        };
      // MisMatrices3 misMatrices3=new MisMatrices3();//si dejamos asi , si nos permitira ambos ya que pues tomaria un tipo object y pyues mientras no hagamos operaciones que recquierean alamencar los devueltos en variables especificas que nos tacria usar casting, non habrai probnlema, aun asi, la practica buean y proposito de esto es especificar entrre<> eñl tipo de datos
    MisMatrices3<String> misMatrices3=new MisMatrices3(); //aca sia fectaria ya que n el caso 4 usam,os el t de la genericam y la extends la hacemos desde ahi para todas la t de la casle, osea ya no nececitamos redfeinir t en el metodo, por lo tanto no estamops creando otro t para el emtodo, si no que se usaria el de la clase
       System.out.println(misMatrices3.getMenorElemtento(nombres)); //y calsero si no especificamos genrico al intamnciar no marcara error enntiempo de compilacion pero si esepcificamos el genrico, pues nos marca errorr en ee de tipo gerogrian calendar
  
        GregorianCalendar fechas[]={
            new GregorianCalendar(2015, 11,25),
            new GregorianCalendar(2012, 6,22),
            new GregorianCalendar(2019, 1,21),
            new GregorianCalendar(2016, 6,26),
        };
      // System.out.println(misMatrices3.getMenorElemtento(fechas));//marac error en tiempo de compilacion al ya especificar que el generico a envciar sera un tipo String
    */
  
  //F5 no es necvesario, 
  //F6
 /* String nombres[]={
            "Ezequiel","Jose","Andrea","pepe"
        };
  
      MisMatrices3<Empleado> misMatrices3=new MisMatrices3();//ahora solo esto pega error pero es por que empelados no implementa comparable, pero siquitamos el extendes de la generica ya no marcara en rojo, y si lo permitira, y no tendra nada que ver con el t que  implementa comparable dem metodo, porque si ahoi lo intentmos enviar, veremos como nos marca error
       //MisMatrices3 misMatrices3=new MisMatrices3();
    //MisMatrices3<String> misMatrices3=new MisMatrices3();//aca de poco sirve esto ya que al final el emtodo es estatico y lo accederemos desde la clase 
       System.out.println(MisMatrices3.getMenorElemtento(nombres));  //pero tener en cuetrna que si envia con parametro la instancia debe ser tambnien un tipo que implemente comparable, en cso se haya dejado el extendes comparable en el t de la clase genereica
                                                                       //si no se declara el qeu toma es iun object yu este tambien implementea comparable
        GregorianCalendar fechas[]={
            new GregorianCalendar(2015, 11,25),
            new GregorianCalendar(2012, 6,22),
            new GregorianCalendar(2019, 1,21),
            new GregorianCalendar(2016, 6,26),
        };
       System.out.println(MisMatrices3.getMenorElemtento(fechas));//aunque permita empleado en la intancia es porque el t de ahi en este caso ha de ser el que esta sin extender en el de clase , no teine nada que ver con el t de este metopdo ya que este t esta definido localmente y este si requiere que sus genericos implemeten comparable
  */
    } 
}
