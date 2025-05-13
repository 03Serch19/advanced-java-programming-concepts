package eje1.of;

import java.util.ArrayList;

public class Ejerc {
  public static void main(String[] args) {
     ArrayList<Alumno> lista = new ArrayList<>();
     lista.add(new Alumno("Juan", "Pérez", 20, "12345678A", "Calle Falsa 123", "123456789", "juan@refe.com", "Lenguaje", 7.5));
     lista.add(new Alumno("Joaquin", "García", 22, "87654321B", "Calle Verdadera 456", "987654321", "joa@edds.com", "Numeros", 8.0));
    lista.add(new Alumno("Ana", "García", 22, "87654321B", "Calle Verdadera 456", "987654321", "ana@edds.com", "Matematicas", 8.0));
    lista.add(new Alumno("Luis", "Martínez", 21, "23456789C", "Calle Real 789", "456789123","luis@essf.sf", "Historia", 6.5));
    lista.add(new Alumno("lizet", "Torres", 25, "78901234G", "Calle Creada 404", "321987654", "liz@gami.lt", "Lenguaje", 9.5));
    lista.add(new Alumno("Maríafafafafafafa", "López", 19, "34567890D", "Calle Imaginaria 101", "321654987", "maria@fsfs.bn", "Geografía", 9.0));
    lista.add(new Alumno("Laura", "Sánchez", 24, "56789012E", "Calle Soñada 202", "654321987", "laura@gmail.la", "Física", 8.5));
    lista.add(new Alumno("Toret", "Torres", 25, "78901234G", "Calle Creada 404", "321987654", "to@gami.lt", "Geologia", 9.5));
    lista.add(new Alumno("Carlos", "Ramírez", 23, "67890123F", "Calle Inventada 303", "789654321", "carlos@sfsfs.lk", "Química", 7.0));
    lista.add(new Alumno("Gabriela", "Torres", 25, "78901234G", "Calle Creada 404", "321987654", "gaby@gami.gb", "Literatura", 9.5));
    lista.add(new Alumno("Pedro", "Gómez", 23, "45678901E", "Calle Inventada 202", "654321789", "pedro@gmail.com", "Biología", 7.0));

    lista.forEach(alumno -> {
      System.out.println(alumno.toString());
        /*  System.out.println("Nombre: " + alumno.getNombre());
        System.out.println("Apellido: " + alumno.getApellido());
        System.out.println("Edad: " + alumno.getEdad());
        System.out.println("DNI: " + alumno.getDni());
        System.out.println("Dirección: " + alumno.getDireccion());
        System.out.println("Teléfono: " + alumno.getTelefono());
        System.out.println("Email: " + alumno.getEmail());
        System.out.println("Curso: " + alumno.getCurso());
        System.out.println("Nota Media: " + alumno.getNotaMedia());*/
        System.out.println("------------------------------");
    });
   /*  System.out.println("Alumnos con nombre que empieza por L o G:");
     System.out.println("------------------------------");
    lista.forEach(alumno -> {
      if('L'==alumno.getNombre().charAt(0)||
         'G'==alumno.getNombre().charAt(0)){
          System.out.println(alumno.toString());
     System.out.println("------------------------------");
      }
 });*/
 //forma funcoional con streams
 System.out.println("Alumnos con nombre que empieza por L o G: by stream");
 lista.stream().filter(alumno ->'L'==alumno.getNombre().charAt(0)||
         'G'==alumno.getNombre().charAt(0)).forEach(alumno->System.out.println(alumno.toString()));
 System.out.println("------------------------------");

System.out.println("La cantidad de alumnos es: " + lista.size());
System.out.println("La cantidad de alumnos es: " + lista.stream().count());
System.out.println("La cantidad de alumnos con nombre que empieza por L o G es: " + lista.stream().filter(alumno -> 'L'==alumno.getNombre().charAt(0)||'G'==alumno.getNombre().charAt(0)).count());
String nombreMenorEdad= lista.stream().min((alumno1, alumno2) -> Integer.compare(alumno1.getEdad(), alumno2.getEdad())).get().getNombre();
System.out.println("El alumno con menor edad es"+ " " + nombreMenorEdad);
System.out.println("El alumno con menor edad es"+ " " + lista.stream().min((alumno1,alumno2)->alumno1.getEdad()-alumno2.getEdad()));//recordad que la lamda mede min lo quebusca es retrorna r un negativo si el primero es menor o 0 si son iguales o un positivo si el segundo es menor, por eso se le pone el signo menos a la resta y directaemten opera eso y eso sera su valor devuelto, o podriasmos usarlo mediante Integer.compare(alumno1.getEdad(), alumno2.getEdad()) que es lo que hace el metodo min, pero en este caso no es necesario ya que la resta ya nos da el resultado deseado, pero si quisieramos hacer una comparacion de cadenas o algo mas complejo tendriamos que usar Integer.compare o String.compareTo() o algo similar.

System.out.println("------------------------------");
String nombreMayorEdad= lista.stream().max((alumno1, alumno2) -> Integer.compare(alumno1.getEdad(), alumno2.getEdad())).get().getNombre();
System.out.println("El alumno con mayor edad es"+ " " + nombreMayorEdad);
System.out.println("El alumno con mayor edad es"+ " " + lista.stream().max((alumno1,alumno2)->alumno1.getEdad()-alumno2.getEdad()));
System.out.println("------------------------------");
//System.out.println("El primer alumno es "+lista.get(0).getNombre());
//System.out.println("El primer alumno es "+lista.getFirst().getNombre());
System.out.println("El primer alumno es "+lista.stream().findFirst().get().getNombre());
/*System.out.println("********************cursos con nombre que termina en t y curso Lenguaje");
lista.forEach(alumno -> {
    if(alumno.getNombre().charAt(alumno.getNombre().length()-1)=='t'&&alumno.getCurso()== "Lenguaje"){
      System.out.println(alumno.toString());
        System.out.println("------------------------------");
    }
});*/
System.out.println("********************cursos con nombre que termina en t y curso Lenguaje by stream");
lista.stream().filter(alumno->alumno.getNombre().charAt(alumno.getNombre().length()-1)=='t'&&alumno.getCurso()== "Lenguaje").forEach(alumno->System.out.println(alumno.toString()));
/*System.out.println("********************donde alumnos solo terminan t");
lista.forEach(alumno -> {
    if(alumno.getNombre().charAt(alumno.getNombre().length()-1)=='t'){
      System.out.println(alumno.toString());
        System.out.println("------------------------------");
    }
});*/
System.out.println("********************donde alumnos solo terminan t by stream");
lista.stream().filter(alumno->alumno.getNombre().charAt(alumno.getNombre().length()-1)=='t').forEach(alumno->System.out.println(alumno.toString()));
System.out.println("********************donde alumnos solo terminan t by stream2");
lista.stream().filter(alumno->alumno.getNombre().endsWith("t")).forEach(alumno->System.out.println(alumno.toString()));
/*System.out.println("********************donde alumnos solo contieenen a");
lista.forEach(alumno -> {
    if(alumno.getNombre().contains("a")){
      System.out.println(alumno.toString());
        System.out.println("------------------------------");
    }
});*/
System.out.println("********************donde alumnos solo contieenen a by stream");
lista.stream().filter(alumno->alumno.getNombre().contains("a")).forEach(alumno->System.out.println(alumno.toString()));
System.out.println(lista.stream().filter(alumno->alumno.getNombre().contains("a")).count());
//alumnos con nombre que tiene mas de 10 caracteres

/*System.out.println("********************alumnos con nombre que tiene mas de 10 caracteres");
lista.forEach(alumno -> {
  if(alumno.getNombre().length()>10){
    System.out.println(alumno.toString());
      System.out.println("------------------------------");
  }
});*/
System.out.println("********************alumnos con nombre que tiene mas de 10 caracteres by stream");
lista.stream().filter(alumno->alumno.getNombre().length()>10).forEach(alumno->System.out.println(alumno.toString()));
System.out.println("********************alumnos con nombre que tiene mas de 10 caracteres by stream2");
lista.stream().filter(alumno->alumno.getNombre().length()>10).forEach(System.out::println);//aca pues se asume que impiime el objeto yeste ay la ya tene imnpmenteo tosting pues me impira los objeto en fomrato string
System.out.println("********************alumnos dopnde nombrrecurrso temr,nia con e");
lista.stream().filter(alumno->alumno.getCurso().endsWith("e")).forEach(alumno->System.out.println(alumno.toString()));

/*System.out.println("********************alumnos dopnde nombrrecurrso temr,nia con e");
lista.stream().filter(alumno->alumno.getCurso().endsWith("e")).forEach(Alumno::toString);*///si toString  fuera un metodo que imprimierra y no etnoanra texto, solo asi funcioanria, ya que  con esta linea bastaria para ejecuta el metodo, por ejemplo apra imprimi el objeto,mosea eln el metodo ya estan los piunt, peo en este caso no es asi, ya que tostringno imprime, asi que quedara como esta riba

   }
   
}
