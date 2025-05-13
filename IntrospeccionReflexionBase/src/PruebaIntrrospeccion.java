import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class PruebaIntrrospeccion {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Introduce el nombre de la clase (Empleado o Persona) u otra: "); 
    String nombreClase = scanner.nextLine(); 
    /*Class (tipo crudo): Pierdes toda la seguridad de tipo de los genéricos. El código compila sin advertencias relacionadas con genéricos, pero eres completamente responsable de realizar los casts correctos en tiempo de ejecución, con el riesgo de ClassCastException.
Class<?> (tipo comodín): Es más seguro que el tipo crudo. El compilador sabe que estás trabajando con alguna clase, aunque no sepa cuál. Esto proporciona una ligera mejora en la seguridad de tipo y es la forma idiomática de manejar el resultado de Class.forName cuando el tipo es desconocido.
Class<T> (tipo parametrizado): Proporciona la máxima seguridad de tipo en tiempo de compilación, pero requiere que conozcas el tipo exacto o lo verifiques y castes cuidadosamente desde un Class<?>.
Por lo tanto, aunque tu código con el tipo crudo (Class clase = ...) podría "funcionar" en algunos casos, es mucho menos seguro y más propenso a errores en tiempo de ejecución en comparación con el uso de Class<?> o Class<T> con las verificaciones adecuadas. El uso de tipos crudos generalmente se desaconseja en código Java moderno. */
    try {
      Class<?> clase = Class.forName(nombreClase);
      Class<?> superClase = clase.getSuperclass();
      System.out.println( "Nombre de clalse introducido"+nombreClase);
      System.out.println(clase);
      System.out.println(superClase);
      System.out.println("Clase padre: " + superClase.getName());
      if(superClase != null && superClase != Object.class) {      
       System.out.println("Clase padre: " + superClase.getName());
      } else {
        System.out.println("No tiene clase padre o es la clase Object."); 
      }
      System.out.println("*************************");
      imprimirConstructores(clase);
      System.out.println("*************************");
      imprimirMetodos(clase);
      System.out.println("*************************");
      imprimirCampos(clase);

        //System.out.println("Clase de Juan: " + clase.getName());
    } catch (ClassNotFoundException e) {
        System.out.println("Clase no encontrada: " + e.getMessage());
    }finally {
      System.out.println("Fin del programa.");
      scanner.close();
    } 
    
  }

  private static void imprimirCampos(Class<?> clase) {
    Field[] campos = clase.getDeclaredFields();
    for (Field campo : campos) {
      System.out.println("Modificador: " + Modifier.toString(campo.getModifiers()));
      System.out.println("Campo: " + campo.getName());
      System.out.println("Tipo: " + campo.getType().getName());
     // System.out.println("Tipooooo: " + campo.getType());
      System.out.println("Valor por defecto: " + campo.getType().getName() + " 0");
    }
    System.out.println("Número de campos: " + campos.length);
  }

  private static void imprimirMetodos(Class<?> clase) {
   Method[] metodos = clase.getDeclaredMethods();
    for (Method metodo : metodos) {
      System.out.println("Modificador: " + Modifier.toString(metodo.getModifiers()));
      System.out.println("Método: " + metodo.getName());
      Class<?>[] parametros = metodo.getParameterTypes();
      System.out.print("Parámetros: ");
      for (Class<?> parametro : parametros) {
        System.out.print(parametro.getName() + " ");
      }
      System.out.println();
      System.out.println("Tipo de retorno: " + metodo.getReturnType().getName());
      System.out.println("Tipo de retornoooo: " + metodo.getReturnType());
      System.out.println();
    }   
  }

  private static void imprimirConstructores(Class<?> clase) {
    Constructor<?>[] constructores =clase.getDeclaredConstructors();
    for (Constructor<?> constructor : constructores) {
      System.out.println("Modificador: " + Modifier.toString(constructor.getModifiers()));
      System.out.println("Constructor: " + constructor.getName());
      Class<?>[] parametros = constructor.getParameterTypes();
      System.out.print("Parámetros: ");
      for (Class<?> parametro : parametros) {
        System.out.print(parametro.getName() + " ");
      }
      System.out.println();
    }
  }
}
