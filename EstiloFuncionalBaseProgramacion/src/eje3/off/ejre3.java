package eje3.off;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ejre3 {
public static void main(String[] args) {
  List<Pelicula> listPelis = new java.util.ArrayList<>();
  listPelis.add(new Pelicula ("E.T.", "Steven Spielberg", 1982)); 
  listPelis.add(new Pelicula("Avatar", "James Cameron", 2009));
  listPelis.add(new Pelicula("Salvar al soldado Ryan", "Steven Spielberg", 1998)); 
  listPelis.add(new Pelicula("Origen", "Christopher Nolan", 2010)); 
  listPelis.add(new Pelicula ("L.A. Confidential", "Curtis Hanson", 1997));
  
  System.out.println("*********************************");
  listPelis.forEach(System.out::println);
  System.out.println("*********************************");
  List<Pelicula> listPelisSigloXXI=listPelis.stream().filter(p->p.getEstreno()>=2000).toList();
  listPelisSigloXXI.forEach(System.out::println);
  System.out.println("*********************************");
  //usando el reemp´lazo de la calse String
  //List<String> listTitulosPelisSteven=listPelis.stream().filter(p->p.getDirector().equals("Steven Spielberg")).map(p->p.getTitulo().replace(" ", ",")).toList();
                                     //replace("", ",")si queda asi separra practicnamte desde el inicio cada caracterr po comas

 String listTitulosPelisSteven=listPelis.stream().filter(p->p.getDirector().equals("Steven Spielberg")).map(Pelicula::getTitulo)
 //map(p->p.getTitulo())
 .collect(Collectors.joining(", ","Nombres de las peliculas de Steven Spielberg: "," solo por probar el sufijo"));
 System.out.println(listTitulosPelisSteven);
  System.out.println("*********************************");//varias formas de prrsentar el orden
  //listPelis.stream().sorted((p1,p2)->p1.getTitulo().compareTo(p2.getTitulo())).peek(System.out::println).collect(Collectors.toList());
  //List<Pelicula> listPelisOrdenadas=listPelis.stream().sorted((p1,p2)->p1.getTitulo().compareTo(p2.getTitulo())).peek(System.out::println).collect(Collectors.toList());
  System.out.println("*********************************");
  //List<Pelicula> listPelisOrdenadas=listPelis.stream().sorted((p1,p2)->p1.getTitulo().compareTo(p2.getTitulo())).collect(Collectors.toList());
  //listPelisOrdenadas.forEach(System.out::println);
  System.out.println("*********************************");                      //lambdacon mas de 2 parametros deben ir entre parentesis
 List<String> listTituloPelisOrdenadas=listPelis.stream().map(Pelicula::getTitulo).sorted((p1,p2)->p1.compareTo(p2)).collect(Collectors.toList());                  //sin usar metodo de referencia,en el daarriba si uso
 // List<String> listTituloPelisOrdenadas=listPelis.stream().map(p->p.getTitulo()).sorted((p1,p2)->p1.compareTo(p2)).collect(Collectors.toList());
 //mostrar peliculas ordenas alfabeticamente
  listTituloPelisOrdenadas.forEach(System.out::println);
  System.out.println("*********************************");
 //mostrar el estreno mas reciente
  //Pelicula peliReciente=listPelis.stream().max((p1,p2)->p1.getEstreno()-p2.getEstreno()).get();
  //System.out.println("El estreno mas reciente es: "+peliReciente.toString());

 /*Optional<Pelicula> peliculaEstrenada=listPelis.stream().max((p1,p2)->Integer.compare(p1.getEstreno(), p2.getEstreno()));                                                       //recordar que valueOf de string interrnamente usa toString(), en este caso usara el toiStirng impementado en pelicula, por eso se le pasa el objeto pelicula que se obiuente al aplicar get() al objeto optional obtenido
  String respuestaPeliculaEstrenada=(peliculaEstrenada.isPresent())?String.valueOf(peliculaEstrenada.get()):"No hay pelicula que cumpla el requisito";
  System.out.println("El estreno mas reciente es: "+respuestaPeliculaEstrenada);*/
  Optional<Pelicula> peliculaEstrenada=listPelis.stream().max((p1,p2)->Integer.compare(p1.getEstreno(), p2.getEstreno()));                                                //este orElse de ceurta dforma evalua si el ampeo logro asigar un objeto generico T a al value de tipo T en Optional, en este caso el genrriico sera un String, si el mapero se logra el value ya no serra null, por ende el orElse devovlere el objeto t diurectaemtent osea el String pero si es value es null entonces se devolvera el argumento pasado al orElse, por ahi va la idea  
  String respuestaPeliculaEstrenada=peliculaEstrenada.map(Pelicula::toString).orElse("No hay pelicula que cumpla el requisito");
  //String respuestaPeliculaEstrenada=peliculaEstrenada.map(p->p.toString()).orElse("No hay pelicula que cumpla el requisito");
  System.out.println("El estreno mas reciente es: "+respuestaPeliculaEstrenada);
  System.out.println("*********************************");
  listPelis.forEach(System.out::println);
  }
}
