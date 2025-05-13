package ej2enum;

import java.util.Map;

/*Objetivo: Modelar un sistema de procesamiento de pagos con diferentes métodos de pago, cada uno con su propia lógica de procesamiento y validación, encapsulada dentro de un enum.*/
public class MaiEj2 {
  public static void main(String[] args) {
    
    {
// Ejemplo de uso con tarjeta de crédito
    Map <String, Object> detalles = Map.of(
        "numero", "1234567812345678",
        "cvv", "123",
        "fecha_expiracion", "12/25"
    );
    double monto = 100.0;
    MetodoPago metodoPago = MetodoPago.TARJETA_CODIGO;
    ProcesadorDePagos procesador = new ProcesadorDePagos();
        
    procesador.metodoPago(detalles, monto, metodoPago);
    }
    {
 // Ejemplo de uso con PayPal
    Map <String, Object> detalles = Map.of(
        "email", "sfsaf@sfsafs.com"
    );
    double monto = 400.0;
    MetodoPago metodoPago = MetodoPago.PAYPAL;
    ProcesadorDePagos procesador = new ProcesadorDePagos();
        
    procesador.metodoPago(detalles, monto, metodoPago);
    }
   {  // Ejemplo de uso con transferencia bancaria
     Map <String, Object> detalles = Map.of(
        "cuenta_origen", "123456789",
        "cuenta_destino", "987654321",
        "banco", "Banco Ejemplo"
    );
    double monto = 300.0;
    MetodoPago metodoPago = MetodoPago.TRANSFERENCIA_BANCARIA;
    ProcesadorDePagos procesador = new ProcesadorDePagos();
        
    procesador.metodoPago(detalles, monto, metodoPago);}


  }
}

