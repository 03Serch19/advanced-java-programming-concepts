package ej2enum;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;
//recordar que los enum sus contructores se cran en tiempo dde compilacion cuando se cargan las clases yabqueddan cargados en memoria
// y no se pueden modificar
public enum MetodoPago {
  TARJETA_CODIGO(
      (detalles, monto) -> detalles.containsKey("numero") && detalles.containsKey("cvv")
          && detalles.containsKey("fecha_expiracion"),
      (detalles, monto) -> {
        System.out.println("Procesando pago con tarjeta de crédito por $" + monto);
        // Simulación de procesamiento de tarjeta
        return true;
      },
      detalles -> detalles.containsKey("numero") && detalles.get("numero") instanceof String
          && ((String) detalles.get("numero")).matches("\\d{16}")),
  PAYPAL((detalles, monto) -> detalles.containsKey("email"),
        (detalles, monto) -> {
            System.out.println("Redirigiendo a PayPal para procesar pago de $" + monto + " con email: " + detalles.get("email"));
            // Simulación de redirección a PayPal
            return true;
        },
        detalles -> detalles.containsKey("email") && detalles.get("email") instanceof String && ((String) detalles.get("email")).contains("@")
    ),
  TRANSFERENCIA_BANCARIA((detalles, monto) -> detalles.containsKey("cuenta_origen") && detalles.containsKey("cuenta_destino") && detalles.containsKey("banco"),
        (detalles, monto) -> {
            System.out.println("Iniciando transferencia bancaria por $" + monto + " de " + detalles.get("cuenta_origen") + " a " + detalles.get("cuenta_destino"));
            // Simulación de inicio de transferencia
            return true;
        },
        detalles -> detalles.containsKey("cuenta_origen") && detalles.get("cuenta_origen") instanceof String &&
                   detalles.containsKey("cuenta_destino") && detalles.get("cuenta_destino") instanceof String &&
                   detalles.containsKey("banco") && detalles.get("banco") instanceof String
    );

  private final BiFunction<Map<String, Object>, Double, Boolean> validacionDetalles;
  private final BiFunction<Map<String, Object>, Double, Boolean> procesadorPago;
  private final Predicate<Map<String, Object>> validadorFormatoDetalles;

  MetodoPago(BiFunction<Map<String, Object>, Double, Boolean> validacionDetalles,
               BiFunction<Map<String, Object>, Double, Boolean> procesadorPago,
               Predicate<Map<String, Object>> validadorFormatoDetalles) {
        this.validacionDetalles = validacionDetalles;
        this.procesadorPago = procesadorPago;
        this.validadorFormatoDetalles = validadorFormatoDetalles;
    }
    public boolean validarDetalles(Map<String, Object> detalles, double monto) {
        return validacionDetalles.apply(detalles, monto);
    }

    public boolean procesarPago(Map<String, Object> detalles, double monto) {
        return procesadorPago.apply(detalles, monto);
    }

    public boolean validarFormatoDetalles(Map<String, Object> detalles) {
        return validadorFormatoDetalles.test(detalles);
    }

}
