package optionalinjava;

import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class Promedio {
    public static Optional<Double> promedioNotas(Double ...notas){
       if (notas.length==0){return Optional.empty();}
        double sum=0.0;
        for (Double nota : notas) {
            sum+=nota;
        }
          return Optional.of(sum / notas.length);
    }
    public static void main(String[] args) {

     Optional<Double> result= promedioNotas(4.3,4.0,1.2,9.3,3.9,4.1);
        result.ifPresent(System.out::println);
        if(result.isEmpty()) System.out.println("No se devolvio valor");
    }
}
