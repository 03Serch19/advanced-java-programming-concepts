package ej3record;

import java.util.List;

public class GeometricCalculator implements SpatialOperation {
  @Override
  public Double operate(Coordinate c1, Coordinate c2) {

    return c1.distanceTo(c2);
  }

  // Método específico para calcular el punto medio
  public Coordinate calculateMidpoint(Coordinate c1, Coordinate c2) {
    return c1.midpoint(c2);
  }

  // Método específico para verificar si un punto está dentro de un radio de otro
  public boolean isCoordinateWithinRadius(Coordinate point, Coordinate center, double radiusKm) {
    return point.isWithin(center, radiusKm);
  }

  // Método específico para calcular el centroide de una lista de coordenadas
  public Coordinate calculateCentroid(List<Coordinate> coordinates) {
    return Coordinate.centroid(coordinates);
  }
// Podríamos añadir más métodos para otras operaciones geométricas aquí,
    // como calcular el área de un polígono (si tuviéramos una lista de Coordinates
    // representando los vértices), verificar colisiones, etc.

    // Ejemplo de una operación más compleja que podría encajar en la interfaz
    // (aunque la interfaz actual es genérica)
  public double calculateBearing(Coordinate origin, Coordinate destination) {
    double lat1 = Math.toRadians(origin.latitude());
    double lon1 = Math.toRadians(origin.longitude());
    double lat2 = Math.toRadians(destination.latitude());
    double lon2 = Math.toRadians(destination.longitude());

    double deltaLon = lon2 - lon1;

    double y = Math.sin(deltaLon) * Math.cos(lat2);
    double x = Math.cos(lat1) * Math.sin(lat2) - Math.sin(lat1) * Math.cos(lat2) * Math.cos(deltaLon);

    double bearingRad = Math.atan2(y, x);
    return Math.toDegrees((bearingRad + 360) % 360); // Bearing en grados (0-360)
  }
}

