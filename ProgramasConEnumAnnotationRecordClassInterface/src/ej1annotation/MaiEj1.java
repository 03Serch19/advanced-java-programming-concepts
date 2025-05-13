package ej1annotation;

/*Objetivo: Crear un sistema de autorización basado en roles, donde los roles permitidos para acceder a un método se definen mediante una anotación compleja y se verifican en tiempo de ejecución. */
public class MaiEj1 {
public static void main(String[] args) throws Throwable {
   /* String rol;// = "Noexiste";
    rol = Rol.ADMIN.toString();

    Servicio servicio = new Servicio();
    try {
      AutorizacionInterceptor interceptor = new AutorizacionInterceptor(rol);
      // Simulación de la invocación de métodos con autorización
      servicio.operacionAdmin();
      servicio.obtenerContenidoEditado();
      servicio.operacionUsuarioEspecifico(new Usuario(1));
      servicio.verInformacion(new HttpRequest(true));
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
      // e.printStackTrace();
    }*/
Servicio servicio = new Servicio();

        // Simulación de diferentes roles de usuario
        AutorizacionInterceptor adminInterceptor = new AutorizacionInterceptor(Rol.ADMIN);
        AutorizacionInterceptor editorInterceptor = new AutorizacionInterceptor(Rol.EDITOR);
        AutorizacionInterceptor viewerInterceptor = new AutorizacionInterceptor(Rol.VIEWER);
        AutorizacionInterceptor guestInterceptor = new AutorizacionInterceptor(Rol.GUEST);
        AutorizacionInterceptor usuarioEspecificoInterceptor = new AutorizacionInterceptor(Rol.VIEWER); // Otro rol

        Usuario usuario1 = new Usuario(1);
        Usuario usuario2 = new Usuario(2);
        HttpRequest requestSeguro = new HttpRequest(true);
        HttpRequest requestInseguro = new HttpRequest(false);

        // Pruebas con el rol de ADMIN
      /*  System.out.println("--- Pruebas con rol ADMIN ---");
        adminInterceptor.interceptar(servicio, Servicio.class.getMethod("operacionAdmin"), null);
        System.out.println(adminInterceptor.interceptar(servicio, Servicio.class.getMethod("obtenerContenidoEditado"), null));
        adminInterceptor.interceptar(servicio, Servicio.class.getMethod("operacionUsuarioEspecifico", Usuario.class), new Object[]{usuario1});
        try {
          adminInterceptor.interceptar(servicio, Servicio.class.getMethod("operacionUsuarioEspecifico", Usuario.class), new Object[]{usuario2});
        } catch (AccesoDenegadoException e) {
          System.out.println("Error esperado: " + e.getMessage());
        }
      //  adminInterceptor.interceptar(servicio, Servicio.class.getMethod("operacionUsuarioEspecifico", Usuario.class), new Object[]{usuario2});
      //el programa treuna ya qyue nos mmuestra a exepcion inicial al verificar que esste mmetodo solo puede ser ejecutado  por viewer y guest
        adminInterceptor.interceptar(servicio, Servicio.class.getMethod("verInformacion", HttpRequest.class), new Object[]{requestSeguro});
         try {
            adminInterceptor.interceptar(servicio, Servicio.class.getMethod("verInformacion", HttpRequest.class), new Object[]{requestInseguro});
        } catch (AccesoDenegadoException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }*/

     /*  // Pruebas con el rol de EDITOR
        System.out.println("\n--- Pruebas con rol EDITOR ---");
        try {
            editorInterceptor.interceptar(servicio, Servicio.class.getMethod("operacionAdmin"), null);
        } catch (AccesoDenegadoException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }
        System.out.println(editorInterceptor.interceptar(servicio, Servicio.class.getMethod("obtenerContenidoEditado"), null));
        try {
            editorInterceptor.interceptar(servicio, Servicio.class.getMethod("operacionUsuarioEspecifico", Usuario.class), new Object[]{usuario1});
        } catch (AccesoDenegadoException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }
         try {
            editorInterceptor.interceptar(servicio, Servicio.class.getMethod("operacionUsuarioEspecifico", Usuario.class), new Object[]{usuario2});
        } catch (AccesoDenegadoException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }
        //lo mismo aun que la conexion va a segura, internamente no verfica a un editor ya que el rol pra verinformcaioin son views y guest, editores no
        try {
            editorInterceptor.interceptar(servicio, Servicio.class.getMethod("verInformacion", HttpRequest.class), new Object[]{requestSeguro});
        } catch (AccesoDenegadoException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }*/

      // Pruebas con el rol de VIEWER
     /*    System.out.println("\n--- Pruebas con rol VIEWER ---");
        try {
            viewerInterceptor.interceptar(servicio, Servicio.class.getMethod("operacionAdmin"), null);
        } catch (AccesoDenegadoException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }
        try {
            viewerInterceptor.interceptar(servicio, Servicio.class.getMethod("obtenerContenidoEditado"), null);
        } catch (AccesoDenegadoException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }
        try {
            viewerInterceptor.interceptar(servicio, Servicio.class.getMethod("operacionUsuarioEspecifico", Usuario.class), new Object[]{usuario1});
        } catch (AccesoDenegadoException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }
            try {
            viewerInterceptor.interceptar(servicio, Servicio.class.getMethod("operacionUsuarioEspecifico", Usuario.class), new Object[]{usuario2});
        } catch (AccesoDenegadoException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }
        viewerInterceptor.interceptar(servicio, Servicio.class.getMethod("verInformacion", HttpRequest.class), new Object[]{requestSeguro});
        try {
            viewerInterceptor.interceptar(servicio, Servicio.class.getMethod("verInformacion", HttpRequest.class), new Object[]{requestInseguro});
        } catch (AccesoDenegadoException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }*/

      /*  // Pruebas con el rol de GUEST
        System.out.println("\n--- Pruebas con rol GUEST ---");
        try {
            guestInterceptor.interceptar(servicio, Servicio.class.getMethod("operacionAdmin"), null);
        } catch (AccesoDenegadoException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }
        try {
            guestInterceptor.interceptar(servicio, Servicio.class.getMethod("obtenerContenidoEditado"), null);
        } catch (AccesoDenegadoException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }
        try {
            guestInterceptor.interceptar(servicio, Servicio.class.getMethod("operacionUsuarioEspecifico", Usuario.class), new Object[]{usuario1});
        } catch (AccesoDenegadoException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }
         try {
            guestInterceptor.interceptar(servicio, Servicio.class.getMethod("operacionUsuarioEspecifico", Usuario.class), new Object[]{usuario2});
        } catch (AccesoDenegadoException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }
        guestInterceptor.interceptar(servicio, Servicio.class.getMethod("verInformacion", HttpRequest.class), new Object[]{requestSeguro});
        try {
            guestInterceptor.interceptar(servicio, Servicio.class.getMethod("verInformacion", HttpRequest.class), new Object[]{requestInseguro});
        } catch (AccesoDenegadoException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }*/

       // Prueba con rol diferente para la condición personalizada
        System.out.println("\n--- Prueba con rol diferente para condición personalizada ---");
         try {
            usuarioEspecificoInterceptor.interceptar(servicio, Servicio.class.getMethod("operacionUsuarioEspecifico", Usuario.class), new Object[]{usuario1});
        } catch (AccesoDenegadoException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }
        try {
            usuarioEspecificoInterceptor.interceptar(servicio, Servicio.class.getMethod("operacionUsuarioEspecifico", Usuario.class), new Object[]{usuario2});
        } catch (AccesoDenegadoException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }
        //usuarioEspecificoInterceptor.interceptar(servicio, Servicio.class.getMethod("verInformacion", HttpRequest.class), new Object[]{requestSeguro});


  }
}

