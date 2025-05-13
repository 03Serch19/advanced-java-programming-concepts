package eje0.of;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PruebasIteraciones {
    public static void main(String[] args) throws Exception {
      /* for (int valor :Arrays.asList(1, 2, 3, 4, 5)) {
            System.out.println(valor);
        }*/
        /*for (Integer valor :Arrays.asList(1, 2, 3, 4, 5)) {
          System.out.println(valor);
        }*/

       // Arrays.asList(1, 2, 3, 4, 5).forEach(valor -> System.out.println(valor)); // lambda expression
                
         //  Arrays.asList(1, 2, 3, 4, 5).forEach(System.out::println); // lambda expression
          // Arrays.asList(1, 2, 3, 4, 5).forEach(System.out::println); // lambda expression

  //ArrayList<Integer> lista = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
      //  lista.forEach(System.out::println);
     /*  ArrayList<Integer> lista = new ArrayList<> ();
      for (Integer numero : Arrays.asList(1, 2, 3, 4, 5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)) {
          if(numero % 2 == 0) {
              lista.add(numero);
          }       
      }
   for (Integer integer : lista) {
    System.out.println(integer);
   }*/
   ArrayList<Integer> lista = new ArrayList<> (Arrays.asList(1, 2, 3, 4, 5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20).stream()
   .filter(numero -> numero % 2 == 0).toList());
    //lista.forEach(System.out::println);
    
   // ArrayList<Integer> lista =(ArrayList<Integer>)Arrays.asList(1, 2, 3, 4, 5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20).stream().filter(numero -> numero % 2 == 0).toList();//esto tiro una exepcion
   //List<Integer> lista =(ArrayList<Integer>)Arrays.asList(1, 2, 3, 4, 5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20).stream().filter(numero -> numero % 2 == 0).toList();//tambien exepcion
  // ArrayList<Integer> lista =(ArrayList<Integer>)Arrays.asList(1, 2, 3, 4, 5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20).stream().filter(numero -> numero % 2 == 0).collect(Collectors.toList());//esto no tira exepcion
   //ArrayList<Integer> lista =(ArrayList<Integer>)Arrays.asList(1, 2, 3, 4, 5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20).stream().filter(numero -> numero % 2 == 0).collect(Collectors.toCollection(()->new ArrayList<>()));//esto no tira exepcion
     lista.forEach(System.out::println);
    }
}
