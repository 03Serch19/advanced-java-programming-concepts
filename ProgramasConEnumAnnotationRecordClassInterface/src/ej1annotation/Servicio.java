package ej1annotation;

public class Servicio {

    @Autorizado(rolesPermitidos = {Rol.ADMIN})
    public void operacionAdmin() {
        System.out.println("Operación solo para administradores.");
    }

    @Autorizado(rolesPermitidos = {Rol.ADMIN, Rol.EDITOR})
     public String obtenerContenidoEditado() {
        return "Contenido editado.";
    }

    @Autorizado(condicionPersonalizada = "usuario.getId() == 1", evaluadorCondicion = UsuarioIdEvaluador.class, mensajeError = "Solo el usuario con ID 1 puede acceder.")
     public void operacionUsuarioEspecifico(Usuario usuario) {
        System.out.println("Operación para usuario específico.");
    }

    @Autorizado(rolesPermitidos = {Rol.VIEWER, Rol.GUEST}, condicionPersonalizada = "request.isSecure()", evaluadorCondicion = RequestSeguroEvaluador.class, mensajeError = "Requiere conexión segura para viewers y guests.")
     public void verInformacion(HttpRequest request) {
        System.out.println("Visualizando información.");
    }

}

// Implementaciones de los evaluadores de condiciones personalizadas
 class UsuarioIdEvaluador implements CondicionEvaluador {
    @Override
    public boolean evaluar(Object contexto) {
        return contexto instanceof Usuario &&((Usuario) contexto).getId() == 1;
    }
}

 class RequestSeguroEvaluador implements CondicionEvaluador {
    @Override
    public boolean evaluar(Object contexto) {
        return contexto instanceof HttpRequest && ((HttpRequest) contexto).isSecure();
    }
}
///////////////////////
/// // Clases auxiliares (simuladas)

