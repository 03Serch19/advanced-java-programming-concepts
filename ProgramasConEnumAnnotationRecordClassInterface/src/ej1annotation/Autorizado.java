package ej1annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) 
@Retention(RetentionPolicy.RUNTIME)
public @interface Autorizado {
 Rol[] rolesPermitidos() default {}; // Array de roles permitidos
  String condicionPersonalizada() default ""; // Expresión que se evaluará
  Class<?> evaluadorCondicion() default Void.class;// Clase para evaluar la condición
   String mensajeError() default "Acceso no autorizado";
}
// Define una interfaz para el evaluador de condiciones personalizadas
interface CondicionEvaluador {
    boolean evaluar(Object contexto);
}