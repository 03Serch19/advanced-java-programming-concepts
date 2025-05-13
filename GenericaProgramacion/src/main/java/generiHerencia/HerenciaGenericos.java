package generiHerencia;

public class HerenciaGenericos {
    
    public static void main(String[] args) {
    //    Empleado administrativa =new Empleado("Elena", 35, 900.50);
  //      Jefe directoraComercial= new Jefe("Vanesa", 26, 3500);
        
        //Un objeto puede usar solo los métodos y atributos definidos en su tipo de referencia, no en su tipo real.
  //      Empleado nuevoEmpleado= directoraComercial;//aunque aca es valido pues no puedo acceder al metodo incentivo propio del objeto tipo Jefe
 //       ((Jefe)nuevoEmpleado).incentico(65);//para poderusar incentivo usariamos estouin casting explicito
        //Aunque nuevoEmpleado almacena un objeto Jefe, Java solo ve la variable como un Empleado.
         //Solo puedes llamar métodos que existen en Empleado (aunque en tiempo de ejecución siga siendo un Jefe).
        
     //Jefe nuevoJefe=directoraComercial;//valido
        //Jefe nuevoJefe=administrativa;//no valido por principio de sustitucion
        
      //con calse geneicas no funciona igual la herencia, o al menos no se expresa de igual forma  
      
      Pareja2<Empleado> administrativa=new Pareja2<>();
       Pareja2<Jefe> directoraComercial=new Pareja2<>();
       //equivalente a
   //    Pareja2<Empleado> administrativa=new Pareja2<Empleado>();
      // Pareja2<Jefe> directoraComercial=new Pareja2<Jefe>();
      
                 //Pareja2<Empleado> administrativa2=new Empleado("sara", 25, 45.25);//novaloido esto no teien sentido//esto es invento mio
      
    // Pareja2<Empleado> nuevoEmpleado=directoraComercial;//no valido 
      //     Pareja2<Empleado> nuevoJefe=administrativa;//sivalido
      //otra forma
     // Pareja2<? extends Empleado> nuevoEmpleado=directoraComercial;//ahora si, valido
       //tomar en cuenta que si queremos setear otro generico no podriamos ya que al permitirle pasarle varios genricos subhijosmsi seteamos uno no sabra java cual estamos seteando
       // 
        Pareja2.imprimirTrabajador(administrativa);
       Pareja2.imprimirTrabajador(directoraComercial);//errormetodogenerico hemso espedicifcado que admita solo genricos tipo empleado
   
        
    //con forma 2  //no valida
  /*   Pareja2<Empleado> administrativa=new Pareja2<Empleado>();
       Pareja2<Jefe> directoraComercial=new Pareja2<Jefe>();
       
       Pareja2.imprimirTrabajador(administrativa);
        Pareja2.imprimirTrabajador(directoraComercial);*/
  
   /*//con forma 3  
     Pareja2<Empleado> administrativa=new Pareja2<Empleado>();
       Pareja2<Jefe> directoraComercial=new Pareja2<Jefe>();
       // Pareja2<Empleado> nuevoEmpleado=directoraComercial;//no valido 
        // Pareja2<Empleado> nuevoJefe=administrativa;//sivalido
       //la diferefncia que ahora los unicos genericos permitidos deben ser empleado o sus subcalses, nada mas
       //pero de ahi se manteien por que enm gfenericas es dieferetne oya estariamos mandando un tipo genrico jefe al tipo generico ya establecido empleado y no es valido, el generico se adapta aun tipo, que sea su hjo no triene anda que ver y la felxibilad extends tampoco, ya que eso solo determian que el tipo debe ser empelado o sus subcalses pero sosea un solo tipo, y en la declaracion java toma el tipo generico de la ointancia para ambos lados ya que asi funciona, entonces ews como si trataramos de que en un aldo diga empelado y en el otro jefe, y java eso no es posible, ya que en jkava las genericas no tienen nin guna relacion en lo absoluto,Cada tipo genérico se trata como un tipo completamente distinto.
       
    //   Pareja2.imprimirTrabajador(administrativa);
      //  Pareja2.imprimirTrabajador(directoraComercial);
        
        */
    }
}
