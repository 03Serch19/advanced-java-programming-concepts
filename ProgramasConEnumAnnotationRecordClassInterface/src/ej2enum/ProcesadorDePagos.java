package ej2enum;

import java.util.Map;

public class ProcesadorDePagos {
  public void metodoPago(Map<String, Object> detalles, double monto, MetodoPago metodoPago) {
    if (metodoPago.validarDetalles(detalles, monto)) {
      if (metodoPago.validarFormatoDetalles(detalles)) {
        metodoPago.procesarPago(detalles, monto);
      } else {
        System.out.println("Formato de detalles inválido");
      }
    }else {
      System.out.println("Detalles de pago inválidos");
    }
  }
}