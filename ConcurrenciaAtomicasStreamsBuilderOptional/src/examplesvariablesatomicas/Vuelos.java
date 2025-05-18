package examplesvariablesatomicas;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Vuelos {
    private static Map<String, Double> preciosAerolineas;

    public static void init() {
        preciosAerolineas = new HashMap<>();
        preciosAerolineas.put("Avianca", 150.75);
        preciosAerolineas.put("Copa Airlines", 120.50);
        preciosAerolineas.put("United Airlines", 180.99);
        preciosAerolineas.put("American Airlines", 165.20);
        preciosAerolineas.put("Volaris", 95.00);
        preciosAerolineas.put("Aeroméxico", 135.80);
        preciosAerolineas.put("Iberia", 250.00);
        preciosAerolineas.put("LATAM Airlines", 140.30);

    }

    public static void main(String[] args) {

        init();
        double preciooIberia=getPrecio("Iberia");
        System.out.println(preciooIberia);
        double menorPrecio=menorPrecio();
        System.out.println("EL menor precio es "+menorPrecio);
        double precioPromedio=precioPromedio();
        System.out.println("El precio promedio es "+precioPromedio);


    }
   private static double getPrecio(String airline){
        return preciosAerolineas.get(airline);
   }
     private static double precioPromedio() {
         AtomicReference<Double> sum=new AtomicReference<>(0.0);
         AtomicInteger count= new AtomicInteger(0);//con multiples hilos esto mejora el rendimiento en procesos mucho mas grandes o complejos,en este caso es apra ejempificasr su usop pero en la rpactica serai mejor evitar paralelismo o usar ,mutlipoles jhilos o programcion conurrente cuando se trata de problemas pequeños, esto es mas enofacado a grandes proyectos donde se manejan m,uchos datos
      preciosAerolineas.keySet().stream().parallel().forEach((aero)->{
         Double precio=getPrecio(aero);
         Double result= sum.get()+precio;
         sum.set(result);
         count.incrementAndGet();
      });
      return sum.get()/count.get();
    }

     private static double menorPrecio() {
        AtomicReference<Double> menorPrecio= new AtomicReference<>(null);
        // AtomicReference<Double> menorPrecio=null;//esta malo esto//da nullpointer
        preciosAerolineas.keySet().stream().parallel().forEach(v->{
            double precio= getPrecio(v);
            if(menorPrecio.get() ==null||menorPrecio.get()>precio){
                menorPrecio.set(precio);
            }
        });
        return menorPrecio.get();



         //expicaicon apra entender lo de los accesos a variables locales desde las calses internas o lambads
         /*
         La Naturaleza de las Clases (Anónimas o No) y el Ámbito:

Cuando defines una clase (ya sea una clase con nombre o una clase anónima generada por una lambda), esta clase tiene su propio ámbito. Las variables declaradas dentro de un método pertenecen al ámbito de ese método. Cuando una instancia de una clase (incluida una instancia de una clase anónima) necesita acceder a variables que están fuera de su propio ámbito (es decir, variables del método donde se definió), se produce una captura.

El Problema con la Mutación Directa:

Imagina que una clase anónima (o una lambda) pudiera acceder y modificar directamente una variable local del método circundante. Esto generaría varios problemas:

Estado Compartido Mutable y Concurrencia: Si la variable del método es accedida y modificada tanto por el método en sí como por la instancia de la clase anónima (que podría estar ejecutándose en un hilo diferente, especialmente en el caso de streams paralelos), tendríamos un escenario de estado compartido mutable sin control. Esto es la receta para las condiciones de carrera, donde el resultado de la ejecución dependería del orden impredecible en que los hilos acceden y modifican la variable.

Ciclo de Vida de las Variables: Las variables locales de un método generalmente existen solo durante la ejecución de ese método (están en la pila). Una instancia de una clase anónima podría sobrevivir a la ejecución del método que la creó (por ejemplo, si la lambda se pasa a otro método o se ejecuta en un hilo separado). Si la lambda mantuviera una referencia directa a una variable local que ya no existe, tendríamos un problema grave.

Cómo se Resuelve con la Captura (Variables Finales o Efectivamente Finales):

Para evitar estos problemas, Java impone la restricción de que las lambdas (y clases anónimas) solo pueden capturar variables que sean final o efectivamente final. ¿Por qué esto soluciona el problema?

Inmutabilidad (o Cuasi-Inmutabilidad): Si una variable es final, su valor nunca cambia después de la inicialización. Si es efectivamente final, su valor no cambia después de la primera asignación. Esto significa que la lambda captura un valor constante. No hay riesgo de que la variable sea modificada por el método circundante mientras la lambda la está usando, y no hay riesgo de inconsistencia entre lo que la lambda "ve" y el valor real de la variable en el método.

Copia por Valor (Implícita): Aunque la implementación exacta puede variar, conceptualmente, la lambda está trabajando con una copia del valor de la variable capturada en el momento en que se crea la lambda. Al ser el valor inmutable (o cuasi-inmutable), no importa si la variable original cambia después (lo cual no puede ocurrir si es final o efectivamente final).

Analogía con Pasar Argumentos a un Método:

Piensa en cómo pasas argumentos a un método. Generalmente, pasas una copia del valor de la variable. El método puede modificar el valor del parámetro dentro de su propio ámbito, pero esto no afecta a la variable original en el método que realizó la llamada. La captura de variables por una lambda funciona de manera similar, pero con la restricción adicional de que la variable original debe ser esencialmente constante.

¿Por qué entonces las variables atómicas y los arrays finales son una "trampa" permitida?

Las variables atómicas y los arrays finales permiten la mutación del estado interno sin violar la regla de captura.

AtomicReference: La referencia a la AtomicReference es final o efectivamente final. Lo que se modifica es el valor dentro del objeto al que apunta esa referencia, utilizando métodos atómicos que garantizan la seguridad en entornos concurrentes.

final double[]: La referencia al array es final. Lo que se modifica es el contenido del array. La lambda no está reasignando la variable menorPrecio (la referencia al array).

En resumen:

La restricción de capturar solo variables final o efectivamente final en las lambdas se basa en la necesidad de evitar problemas de estado compartido mutable y garantizar la seguridad y la consistencia, especialmente en escenarios concurrentes. Permite que la lambda funcione con una "instantánea" segura del valor de la variable en el momento de su creación. Las variables atómicas y los arrays finales son mecanismos que permiten la modificación indirecta del estado sin violar esta regla de captura de la referencia en sí.
         */
        /* Double menorPrecio=null;//malo
         preciosAerolineas.keySet().forEach(v->{
             double precio= getPrecio(v);
             if(menorPrecio ==null||menorPrecio>precio){
                 menorPrecio=precio;
             }
         });
         return menorPrecio;*/

      /*  Double precioMenor=null;
         for (Double value : preciosAerolineas.values()) {
             if(precioMenor==null||precioMenor>value)precioMenor=value;
         }
       return precioMenor;*/
     }

}
