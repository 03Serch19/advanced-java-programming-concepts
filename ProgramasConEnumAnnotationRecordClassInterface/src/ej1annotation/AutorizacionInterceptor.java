package ej1annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

public class AutorizacionInterceptor {
 // private String rol;
 /* public AutorizacionInterceptor(String rol) throws Exception {
    this.rol = rol;
    if (!verificaExistecnciaRol()) {
      throw new Exception("El rol no existe");
    }
    else{
    }
  }*/

  // Simulación de un interceptor de autorización
  /*Class<?> classs = Servicio.class;
  Method[] methods = classs.getDeclaredMethods();*/

  /*public boolean verificaExistecnciaRol()  { 
    Rol[] rolesPermitidos =Rol.values();  
    for (Rol rol : rolesPermitidos) {
      if (rol.toString().equals(this.rol)) {
        return true;
      }
    }
     return false;
  }*/
   private Rol rolUsuarioActual; // Simulación del rol del usuario actual
   public AutorizacionInterceptor(Rol rolUsuarioActual) {
        this.rolUsuarioActual = rolUsuarioActual;
    }

   public Object interceptar(Object servicio, Method metodo, Object[] args) throws Throwable {
        if (metodo.isAnnotationPresent(Autorizado.class)) {
            Autorizado autorizado = metodo.getAnnotation(Autorizado.class);

            // Verificar roles permitidos
            if (autorizado.rolesPermitidos().length > 0 &&
                !Arrays.asList(autorizado.rolesPermitidos()).contains(rolUsuarioActual)) {
                throw new AccesoDenegadoException(autorizado.mensajeError());
            }

            // Verificar condición personalizada
            if (!autorizado.condicionPersonalizada().isEmpty() &&
                autorizado.evaluadorCondicion() != Void.class) {
                try {
                    CondicionEvaluador evaluador = (CondicionEvaluador) autorizado.evaluadorCondicion().getDeclaredConstructor().newInstance();
                    Object contexto = (args != null && args.length > 0) ? args[0] : null; // Asumimos que el contexto es el primer argumento
                    if (!evaluador.evaluar(contexto)) {
                        throw new AccesoDenegadoException(autorizado.mensajeError());
                    }
                } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                    System.err.println("Error al instanciar o ejecutar el evaluador de condición: " + e.getMessage());
                    throw new AccesoDenegadoException("Error interno de autorización.");
                }
            }
        }

        try {
            return metodo.invoke(servicio, args);
        } catch (InvocationTargetException e) {
            throw e.getTargetException(); // Propagar la excepción original del método invocado
        }
    }

}
