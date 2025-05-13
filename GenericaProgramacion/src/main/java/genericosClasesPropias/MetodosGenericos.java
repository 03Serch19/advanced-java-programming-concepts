package genericosClasesPropias;

import generic.Empleado;

public class MetodosGenericos {
    public static void main(String[] args) {
     
        //usando la forma 1
       String nombres[]={
            "Jose","Andrea","pepe"
        };
        String elementos=MisMatrices.getElementos(nombres);
        
                                    //esto se podria ignorar ya que al pasarle el parametro nombres el compilador java sabe que lo qud ebe manejar es un string asi que podemos omitir esta instruccion redundadnte que se puede ignoara
      //  String elementos=MisMatrices.<String>getElementos(nombres);
       
      System.out.println(elementos);
      
        Empleado empleados[] ={
      new Empleado("Aaron", 25, 63.55),
       new Empleado("Aaron", 25, 63.55),
        new Empleado("Aaron", 25, 63.55),
         new Empleado("Aaron", 25, 63.55)
    };
      
       System.out.println(MisMatrices.getElementos(empleados));
     
        
     
     ////forma udando metodos genericos forma clase 3 para ejemplicar la 2 conmayor claridad en mis matrices
        
//uso del metododo estatico T y comprobando que no es el mismto t que siu calse generica
       /* 
     //  MisMatrices mimatri=new MisMatrices();//coemtnado esto ahora si en setCont que usa el t de la calse generica ya se adapata al tipo enviado enmla instancia en la liena de abajo
        MisMatrices<String> mimatri=new MisMatrices();
      //  mimatri.setContenido(63);//mala practica ya que akl no definierle el generico java toma atodos por object
        //mimatri.setContenido(56.56);
        mimatri.setContenido("hdshdhd");//aujn asi aca no improta ya que pues es uno solo quien imprime al final osea vamos reemplazando pero el punto es que java no marca error en teimpo de compilacion//pero al ya agregar el <String> en la intancai ya me amrcaria errores entiemnpod e compilacion
        System.out.println(mimatri.getContenido()); //si le definimos el genrico ahi si no nos dejharia*/
        
        //usando el statico
       // mimatri.metodoEstatico(42);      // "Valor: 42" //si vemos este siendo incluso diferente no marca error ya que el T declarado en este emtodo generico ESTATICO es un t local para el metodo y por eso  se determina en cada llamada del metodo y por puede tomar distimntos vañlores
       // mimatri.metodoEstatico("Hola");  // "Valor: Hola"
        //mimatri.metodoEstatico(args);
       /* MisMatrices.metodoEstatico(42); ///observacion esto es la manera correcta dse usar etaticos aunque notamos que java permnite usar la intancia poara llamarlos aunque no es recomendado
        MisMatrices.metodoEstatico(56.6); //y ademas no es convencion, la jvm lo permite por compatibilidad pero no se deberia hacer
        MisMatrices.metodoEstatico("dSergio");
        MisMatrices.metodoEstatico("6565");*/
    
       
      //forma udando metodos genericos forma clase 4 en mis matrices
      
    /*     String nombres[]={
            "Jose","Andrea","pepe"
        };
          MisMatrices<String> misMatrices= new MisMatrices();//ahora solo el de string me funcionara y en el segundo sout com empelados ya ,me tirara enrror enteimepo de compliacion y netbeans me lo podnra en rojo
         //MisMatrices misMatrices= new MisMatrices(); //usasno el emtodo de preuba 4 esto funcionaria ya que de nuevo no especificamos el tipo dgenerico y por eos la jvm acepta tanto el string copmo el empleado
        String elementos=misMatrices.getElementos(nombres); //pero si lo definimos, es timepo de compilacion ahora si nos amrcara error y ay asoi controlamos que solos ea stering u emepolado
        
          
       
      System.out.println(elementos);
      
        Empleado empleados[] ={
      new Empleado("Aaron", 25, 63.55),
       new Empleado("Aaron", 25, 63.55),
        new Empleado("Aaron", 25, 63.55),
         new Empleado("Aaron", 25, 63.55)
    };
      
      // System.out.println(misMatrices.getElementos(empleados));
    */
    
    
    
      //forma udando metodos genericos forma clase 5 en mis matrices
      
        /*   String nombres[]={ //y usando el emtodo 5 en amtricers vemos que se comporta a como usar el primero solo que pues se crea la isntancia
            "Jose","Andrea","pepe" //ya que igaul por cada lamada crear local mente a t y por eso acepta diferentes valores ya que es de una calse no genreica y debemos defeinir en su metodo el paraemetro t similar xomo si el emtodo fuera estatico
        };
          MisMatrices misMatrices= new MisMatrices();
        String elementos=misMatrices.getElementos(nombres); 
        
          
       
      System.out.println(elementos);
      
        Empleado empleados[] ={
      new Empleado("Aaron", 25, 63.55),
       new Empleado("Aaron", 25, 63.55),
        new Empleado("Aaron", 25, 63.55),
         new Empleado("Aaron", 25, 63.55)
    };
      
       System.out.println(misMatrices.getElementos(empleados));*/
        
        
    }
}
