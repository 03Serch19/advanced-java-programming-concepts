package generic;

//import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
//import sun.misc.Unsafe;

public class UsoEmpleado {                 
    public static void main(String[] args){
     //  try{
     //     Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
     //     unsafeField.setAccessible(true);
    //      Unsafe unsafe = (Unsafe) unsafeField.get(null);//peligroso usarla si se usa Unsafe debe ser concuidado
          
     //    Field field = ArrayList.class.getDeclaredField("elementData");
        //field.setAccessible(true); // Acceder al array interno//pero al doia de hoy 16/3/2025 no fue valido, asi que todco usar unsafe q pra la fecha de ahora aun puedo acceder a esa api interna de java
    //     long fieldOffset = unsafe.objectFieldOffset(field);
        
   // Empleado[] empleados=new Empleado[3];     //<>operador diamentae java infiere que el tipo de datos es del mismo especificado al otro lafdo, asi que no es necesario ponerlo 2 veces                                                                                                                                                     
        ArrayList<Empleado> empleados=new ArrayList<>();//parentesis aungulas, los array list solo pueden almacenar objetos, si queremos datos primitivos tocarianusar calses envoltorias, Integer, Double, etc        //otra copia dpmde quepan esos elementos, mas no sabemos las nuevas dimensionase de este nuevo array y puede ser llenado y lueggo de llenado y se aquiere agregar otro mas , se repite de nuevo,el proceso y asi sucecivamente y esto consume recursos
   // empleados[0]=new Empleado("Juan", 25, 230.2);  //los array list con costructor vacio inician con una reserva de 10 inicialemten, pero cuadno se agrega  un  undecimo elemento pues lo que hace java es crar otra array ocsea otra copia diferente  donde almacena todos los elemnentos del anterior y agregar el nuevo y luego destruye el anterior y asi suceviamente, ojo con esto porqque a nivel de consumo de recursos puede ser compkicadito, tener en cuenta
  //  empleados[1]=new Empleado("Maria", 45, 632.25);
   // empleados[2]=new Empleado("Andres", 33, 6324);
    //empleados[3]=new Empleado("Johana", 24, 566.25);                                                                                                                                                                                                                                                                                                                      
  
      //empleados.ensureCapacity(13);//esto ayuda un poco el hecho de optimizar asi evitando que vaya creando copias y elimando las enteriroes, por cada elemento que se agregue fuera de la capacidad inicial, aunque calro si agregas y te excedes de este limite, pues volveriamos a lo anterori crara otro array de x elemetos y copoiara este arrya ahi y agregara el nuevo elemento
    empleados.add(new Empleado("Juan", 25, 230.2));
    empleados.add(new Empleado("Maria", 45, 632.25));
    empleados.add(new Empleado("Andres", 33, 6324));
    empleados.add(new Empleado("Johana", 24, 566.25));
    
   // Empleado emp=empleados.get(2);
      /* empleados.add(new Empleado("Maria", 45, 632.25));
    empleados.add(new Empleado("Andres", 33, 6324));
    empleados.add(new Empleado("Johana", 24, 566.25));
        empleados.add(new Empleado("Maria", 45, 632.25));
    empleados.add(new Empleado("Andres", 33, 6324));
    empleados.add(new Empleado("Johana", 24, 566.25));
        empleados.add(new Empleado("Maria", 45, 632.25));
    empleados.add(new Empleado("Andres", 33, 6324));
    empleados.add(new Empleado("Johana", 24, 566.25));
     empleados.add(new Empleado("Johana", 24, 566.25));*/
        /*for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }*/      
       // System.out.println(emp.toString());
      // System.out.println(empleados.get(1).toString());
       // empleados.set(1, new Empleado("Ariana",24,56.36));
       // System.out.println(empleados.get(2).toString());
      //  Empleado empl=empleados.get(2);
        //System.out.println(empleados.get(1).toString());
      //  System.out.println(empleados.get(2).toString());
      //  System.out.println(empl.toString());
     //   empleados.set(2, new Empleado("Sara", 26, 745.21));
         //empleados.set(2, new Empleado("Andres", 33, 6324));
      //  Empleado emp2=empleados.get(2);
      //  Empleado empln = new Empleado(emp2.nombre,emp2.edad,emp2.sueldo);
       // System.out.println(emp2.toString());
       //emp2.nombre="sdsdfs"; //aca soo comprobamos que get devuelve el objeto en el el array list y si lo modificaramos cambiauria ya que apuntamos a este objeto en la referefncia
        //empln.nombre="sdsdfs";// para evitar eso a veces en el retorno hacemos un ,metodo intermedio e cual crara un nuevo objeto pero con los mismo valores, asi si este nuevo oobjeto lo modificariamos  y no afectara al original del array, en este caso hicimos en este mismo lugar la creacion manual de este nuevo objeto
      //  System.out.println(empleados.get(2).toString());
      //  System.out.println(emp2.toString());
      //  System.out.println(empln);
     //   System.out.println(empl.nombre);
      //    System.out.println(empl.toString());//acva obbniuamente imprimiremos el objeto al que apunta que es al que estaba en la posicion 2 inicialmente, en lo actual este objeto fue removido del array y en la posicion 2 esta otro nuevo objeto que se creo, no hay frorma que esta referecnia apunte a los valores del reempolazo que esta en el array ya qyue es un nuevo objeto difecetne al que devolvio get en la posicon antes de ser remmplazado, para logra esto de nuevo tenemos que pedir que nos alamcene en la refrenmcia emp la refrencia a l nuevo obkjeto que esta en la posicon 2
       // if(empl == emp2)System.out.println("si");
       // else System.out.println("no");
                                           //la formad dinamica de los arays puede que al llenarse vaya crecienmdo un 50% de su camaopcidad anteriros es un mencaniusmo deficmnido en el codigo fuete de arrayslist , por ejemplol, uno de 10 al lleanrse el nuevo sera de 15 al llenarse el nuevo sera de 22 luego el nuevo de 33, y asi sucedivcametne                                                         //array que digamos sus ciemnsiones no fueron llenadas total mente ya sea de los piremros 10 o de los que dinamincamten se van creando yy los cuales no sabemos si se llenan  ono
      // empleados.trimToSize();//para optimizar recursos, esto lo que hace es que el recolector de basura borre el esapcion de memoria sobrante, corta el exceso de memoria  al array en caso que estemos dseguros no se agregaran mas elementos, aunque si luego de esto se argega otro mas pues de nuevo, creara otro array donde podra alamcenar este array y agragr ekl nuevo elemento que queremos agregar y de nuevo epuede que este nuevo array no se use toda su acapcidad y este la memoria asignada gastando recurso de forma innecesaria
        System.out.println(empleados.size());                 //se calcula por la forma  int newCapacity = ArraysSupport.newLength(oldCapacity,
                                                       //  minCapacity - oldCapacity, /* minimum growth */
                                                     //oldCapacity >> 1           /* preferred growth */);/pero lo seguro es que la primera longitud incrementada es de 10 luego a 15 y pues de ahi supomngo la siguieten sera en base a la formula sucedivamente tal y como se oibtubvo este 15
       //Iterator iterador=empleados.iterator();//mala practica no decirle al iterado el tipo de datos entre<> ya que en este caso toma un generico de tipo Objetc y no un genrico en especifico como mseria Empelado en este caso
      Iterator<Empleado> iterador=empleados.iterator();//asi ya no habria nececidad del cast y dejamos especificado el generico tipo de dato para el iterador  y evitramos problemas poir usar raw type osea no especificando el tipo de dato y dejando genrico lo cual podria traer problemas para el compilador que no poderua verificar que solo iteramos por empelados
       
         //dependera tambien de la laomngitud inicial indicada, porejemplo peude que iniciemos con un array inial de1 13 con esunsercapacity(13♦1 y al llenarse ahora segun el calculo el segundo interno sea de 19
        while (iterador.hasNext()) {
            //Object next = iterador.next();//sin especificar tipo de dato aoperador tocaria usar esto o si no casteaar el objetc para que se haga del tipo de dato del iterador
          //  Empleado next= (Empleado) iterador.next();//ahora si funcionaria, pero la buean practica es mejor especificar el tipo de dato y asi no hanria nececidadl casting tak y como la liena de abajo
           Empleado next= iterador.next();
            System.out.println(next.toString());
           // System.out.println(iterador.next().toString());
            //iterador.remove();
            
           // int capacity = ((Object[]) field.get(empleados)).length;//forma no valida a la fecha de hoy 16/3/2025
       //   Object[] elementData = (Object[]) unsafe.getObject(empleados, fieldOffset);
       //    System.out.println(iterador.next().toString()+"capacidad array interno "+elementData.length);
           //System.out.println(iterador.next().toString()+"capacidad array interno "+capacity);//forma no valida a la fecha de hoy 16/3/2025
        }
    //    }catch(NoSuchFieldException | IllegalAccessException | IllegalArgumentException e){
      //      e.printStackTrace();
      //  }
      
      /*Empleado[] empleadoArraynormal=new Empleado[empleados.size()];//recordar, size me duvuele la cantidad de elementos en el array, no la logittud interna de este array que inicialemnte en un constuctor vacio y sin esusar ensureCapacity, es de 10
      empleados.toArray(empleadoArraynormal);//copiamos lo del arraylist empleados al nuevo areglo de tipo empleado creado
        for (int i = 0; i < empleadoArraynormal.length; i++) {
            System.out.println(empleadoArraynormal[i]);
        }*/
    }
}
