package ej3record;

import java.util.Arrays;
import java.util.List;

/*Objetivo: Extender el record Coordinate para incluir lógica geométrica más compleja y métodos específicos. */
public class MaiEj3 {
  
   public static void main(String[] args) {
        Coordinate punto1 = new Coordinate(10, 20);
        Coordinate punto2 = new Coordinate(30, 40);
        Coordinate centro = new Coordinate(15, 25);

        GeometricCalculator calculator = new GeometricCalculator();

        // Usando la interfaz a través de la implementación por defecto (distancia)
        SpatialOperation operation = calculator;
        double distancia = (Double) operation.operate(punto1, punto2);
        System.out.println("Distancia entre punto1 y punto2: " + distancia + " metros");

        // Usando métodos específicos de GeometricCalculator
        Coordinate puntoMedio = calculator.calculateMidpoint(punto1, punto2);
        System.out.println("Punto medio entre punto1 y punto2: " + puntoMedio);
      
        String text;
        boolean dentroRadio = calculator.isCoordinateWithinRadius(punto1, centro, 2000); // Radio de 2 km
        System.out.println("¿Punto1 está dentro del radio de centro? " + (text=(dentroRadio)? " Sí" : " No"));

        List<Coordinate> puntos = Arrays.asList(punto1, punto2, centro, new Coordinate(0, 0));
        Coordinate centroide = calculator.calculateCentroid(puntos);
        System.out.println("Centroide de la lista de puntos: " + centroide);

        double rumbo = calculator.calculateBearing(punto1, punto2);
        System.out.println("Rumbo de punto1 a punto2: " + rumbo + " grados");
  }
}

