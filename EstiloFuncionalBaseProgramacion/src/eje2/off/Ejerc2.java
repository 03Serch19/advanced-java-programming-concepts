package eje2.off;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Ejerc2 {
public static void main(String[] args) {
    ArrayList<Vehiculo> lista = new ArrayList<>();
    lista.add(new Vehiculo("1234ABC", "Toyota", 10000));
    lista.add(new Vehiculo("5678DEF", "Honda", 20000));
    lista.add(new Vehiculo("9101GHI", "Ford", 30000));
    lista.add(new Vehiculo("1122JKL", "Chevrolet", 40000));
    lista.add(new Vehiculo("3344MNO", "Nissan", 50000));
    lista.add(new Vehiculo("5566PQR", "Hyundai", 60000));
    lista.add(new Vehiculo("7788STU", "Kia", 70000));
    lista.add(new Vehiculo("9900VWX", "Mazda", 80000));
    lista.add(new Vehiculo("1234YZA", "Subaru", 90000));
    lista.add(new Vehiculo("5678BCD", "Volkswagen", 100000));
  System.out.println("*************************************");
    // Mostrar todos los vehículos
    /*for (Vehiculo vehiculo : lista) {
        System.out.println(vehiculo.toString());
    }*/
  //lista.forEach(vh->System.out.println(vh.getKilometros()*2));
  //lista.forEach(System.out::println); 
  /*lista.forEach(vh->{    //aca ahora los objetos orignales se modifican el lista, y si se ve la lofgica es obvio
    vh.setKilometros(vh.getKilometros()*2);
    System.out.println(vh.getKilometros());
  });
  lista.forEach(System.out::println);*/

  /*lista.stream().forEach( vh->{
    vh.setKilometros(vh.getKilometros()*2);
    System.out.println(vh.getKilometros());
     });
     lista.forEach(System.out::println);*///aca igualla lista resuklta modificada
    /*  ArrayList<Vehiculo> lista2 = new ArrayList<>(lista.stream().map(vh->{
        vh.setKilometros(vh.getKilometros()*2);return vh;}).collect(Collectors.toList()));
        lista2.forEach(System.out::println);*/
        
       /* ArrayList<Vehiculo> lista2 = new ArrayList<>(lista.stream().map(vh->{
          vh.setKilometros(vh.getKilometros()*2);return vh;}).toList());
          lista2.forEach(System.out::println);*/
  /*lista.stream().map(vh->{
    vh.setKilometros(vh.getKilometros()*2);return vh;}).forEach(System.out::println);*/
    //lista.forEach(System.out::println); 

      //en todas estas forrmas aunque los tream no modificquen por si mismo llas coleceiion oiiginal, las operaciones internas all se objetos los ellementos pues usan as mismas rerfrenias po tanto lal lista si se modifca en ese sentido
      //para evatia esa modifcacion lo haremos de la sigueitne formas
    System.out.println("*************************************");
    lista.stream().map(vh->new Vehiculo(vh.getMatriculla(),vh.getModelo(),vh.getKilometros()*2)).forEach(System.out::println);
    //lista.forEach(System.out::println);  
    /*System.out.println("*************************************");
    lista.stream().map(vh->new Vehiculo(vh.getMatriculla(),vh.getModelo(),vh.getKilometros()*2)).collect(Collectors.toList()).forEach(System.out::println);*/
    System.out.println("*************************************");
   lista.forEach(System.out::println); 
}
}
