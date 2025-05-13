package eje2.of;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class pruebaVehi {
  public static void main(String[] args) {
    ArrayList<VehiculoOf> vehiculos = new ArrayList<>();
    vehiculos.add(new VehiculoOf("3536RST", Modelo.BMW, 90000));
    vehiculos.add(new VehiculoOf("5678DEF", Modelo.MERCEDES, 20000));
    vehiculos.add(new VehiculoOf("9101GHI", Modelo.AUDI, 25000));
    vehiculos.add(new VehiculoOf("1718STU", Modelo.MERCEDES, 45000));
    vehiculos.add(new VehiculoOf("1122JKL", Modelo.VOLKSWAGEN, 30000));
    vehiculos.add(new VehiculoOf("1314MNO", Modelo.FORD, 35000));
    vehiculos.add(new VehiculoOf("1516PQR", Modelo.BMW, 40000));
    vehiculos.add(new VehiculoOf("1920VWX", Modelo.AUDI, 50000));
    vehiculos.add(new VehiculoOf("1234ABC", Modelo.BMW, 15000));
    vehiculos.add(new VehiculoOf("2728FGH", Modelo.MERCEDES, 70000));
    vehiculos.add(new VehiculoOf("2324BCD", Modelo.FORD, 60000));
    vehiculos.add(new VehiculoOf("2526CDE", Modelo.BMW, 65000));
    vehiculos.add(new VehiculoOf("2122YZA", Modelo.VOLKSWAGEN, 55000));
    vehiculos.add(new VehiculoOf("2930IJK", Modelo.AUDI, 75000));
    vehiculos.add(new VehiculoOf("3132LMN", Modelo.VOLKSWAGEN, 80000));
    vehiculos.add(new VehiculoOf("3334OPQ", Modelo.FORD, 85000));
    vehiculos.add(new VehiculoOf("3738UVW", Modelo.MERCEDES, 95000));
    vehiculos.add(new VehiculoOf("3940XYZ", Modelo.AUDI, 100000));

    System.out.println("listado de kilometos multiplciados por 2");
    /*vehiculos.stream().map(vehiculo -> vehiculo.getKilometros() * 2)
        .forEach(kilometros -> System.out.println(kilometros));*/
        List<Double> listaKilometros = vehiculos.stream()
            .map(vehiculo -> vehiculo.getKilometros() * 2)
            .toList();
    listaKilometros.forEach(System.out::println);
    System.out.println("********************************");
   // vehiculos.forEach(vehiculo -> System.out.println(vehiculo.getKilometros()));
    vehiculos.forEach(System.out::println);
    System.out.println("********************************2");
    List<Double> listaKilometrosOrig = vehiculos.stream()
    .map(VehiculoOf::getKilometros)
    .toList();
    listaKilometrosOrig.forEach(System.out::println);
    System.out.println("********************************3");
    //vehiculos.stream().filter(vh->vh.getModelo()==Modelo.AUDI).forEach(System.out::println);
    vehiculos.stream().filter(vh->vh.getModelo().equals(Modelo.AUDI)).forEach(System.out::println);
    System.out.println("********************************4");
    //vehiculos.forEach(System.out::println);
    /*List<VehiculoOf> vehOrdernad=new ArrayList<>(vehiculos.stream().sorted((o1, o2) ->(int)(o1.getKilometros()-o2.getKilometros())).toList());
    vehOrdernad.forEach(System.out::println);*/
    List<VehiculoOf> vehOrdernad=new ArrayList<>(vehiculos.stream().sorted((o1, o2) ->Integer.compare((int)(o1.getKilometros()),(int) (o2.getKilometros()))).toList());
    vehOrdernad.forEach(System.out::println);
    
    System.out.println("*********************************5");
    /*List<Modelo> modelos=vehiculos.stream().map(vh->vh.getModelo()).distinct().toList();
    modelos.forEach(System.out::println);*/
    /* List<Modelo> modelos=vehiculos.stream().map(VehiculoOf::getModelo).distinct().toList();
    modelos.forEach(System.out::println);*/
    //List<Modelo> modelos=new ArrayList<>(vehiculos.stream().map(VehiculoOf::getModelo).distinct().toList());
    /*List<Modelo> modelos=new ArrayList<>(vehiculos.stream().map(VehiculoOf::getModelo).distinct().collect(Collectors.toList()));
    modelos.forEach(System.out::println);*/
    vehiculos.stream().map(VehiculoOf::getModelo).distinct().forEach(System.out::println);

    System.out.println("********************************6");
    //vehiculos.stream().filter(vh->vh.getKilometros()>40000).forEach(System.out::println);
   /* vehiculos.stream().filter(v->v.getKilometros()>40000).peek(v->System.out.println(v)).map(v->v.getKilometros()).forEach(System.out::println);*/
    /*ArrayList<Double> kilometros=new ArrayList<>(vehiculos.stream().filter(vh->vh.getKilometros()>40000).peek(vh->System.out.println(vh)).map(vh->vh.getKilometros()).peek(v->System.out.println(v)).collect(Collectors.toList()));
    kilometros.forEach(System.out::println);*/
   // List<Double> kilometros=vehiculos.stream().filter(vh->vh.getKilometros()>40000).peek(vh->System.out.println(vh)).map(vh->vh.getKilometros()).peek(v->System.out.println(v)).collect(Collectors.toList());
    /*List<Double> kilometros=vehiculos.stream().filter(vh->vh.getKilometros()>40000).peek(vh->System.out.println(vh)).map(vh->vh.getKilometros()).peek(v->System.out.println(v)).forEach(System.out::println);*///malo un foeach ercodad devuelve void por tanto es elte no puede aplicarse en una ceacion como esta en al cual asignamos a una lista
    vehiculos.stream().filter(vh->vh.getKilometros()>40000).peek(vh->System.out.println(vh)).map(vh->vh.getKilometros()).peek(v->System.out.println(v)).forEach(System.out::println);//aca si
    //kilometros.forEach(System.out::println);
    System.out.println("********************************7");
    Map<Modelo,List<VehiculoOf>> vehiculosAgrupados=vehiculos.stream().collect(Collectors.groupingBy(VehiculoOf::getModelo));
    // Map<Modelo,List<VehiculoOf>> vehiculosAgrupados=vehiculos.stream().collect(Collectors.groupingBy(v->v.getModelo()));
    
    vehiculosAgrupados.forEach((K,V)->{
      System.out.println("Modelo: " + K);
     // V.forEach(vehiculo -> System.out.println(vehiculo));
      V.forEach(System.out::println);
     });
     System.out.println("********************************8");
     // int sumaKilometros=vehiculos.stream().map(v->(int)v.getKilometros()).reduce(0,Integer::sum);
     Integer sumaKilometros=vehiculos.stream().map(v->(int)v.getKilometros()).reduce(0,Integer::sum);
     //Integer sumaKilometros=vehiculos.stream().map(v->(int)v.getKilometros()).reduce(0,((v1,v2)->Integer.sum(v1, v2)));
     System.out.println(sumaKilometros);
     System.out.println("********************************9");
      vehiculos.stream().filter(v1->v1.getKilometros()<=60000).limit(4).forEach(System.out::println);
     vehiculos.stream().filter(v1->v1.getKilometros()<=60000).map(v1->v1.getModelo()).limit(4).forEach(System.out::println);
     System.out.println("**********************************");
    //vehiculos.forEach(System.out::println);

  }
}
