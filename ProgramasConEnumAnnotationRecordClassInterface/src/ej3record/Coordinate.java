package ej3record;

import java.util.List;

public record Coordinate(double latitude,double longitude) {
      // Constructor compacto para validación
    public Coordinate {
        if (latitude < -90 || latitude > 90) {
            throw new IllegalArgumentException("Latitud inválida: " + latitude);
        }
        if (longitude < -180 || longitude > 180) {
            throw new IllegalArgumentException("Longitud inválida: " + longitude);
        }
    }

 public double distanceTo(Coordinate other) {
        // Implementación de la fórmula de Haversine para calcular la distancia entre dos coordenadas
        double earthRadius = 6371e3; // en metros
        double lat1Rad = Math.toRadians(this.latitude);
        double lon1Rad = Math.toRadians(this.longitude);
        double lat2Rad = Math.toRadians(other.latitude);
        double lon2Rad = Math.toRadians(other.longitude);

        double deltaLat = lat2Rad - lat1Rad;
        double deltaLon = lon2Rad - lon1Rad;

        double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2) +
                   Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                   Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return earthRadius * c; // Distancia en metros
    }


      public Coordinate midpoint(Coordinate other) {
        double lat1Rad = Math.toRadians(this.latitude);
        double lon1Rad = Math.toRadians(this.longitude);
        double lat2Rad = Math.toRadians(other.latitude);
        double lon2Rad = Math.toRadians(other.longitude);

        double bx = Math.cos(lat2Rad) * Math.cos(lon2Rad - lon1Rad);
        double by = Math.cos(lat2Rad) * Math.sin(lon2Rad - lon1Rad);
        double latMidRad = Math.atan2(Math.sin(lat1Rad) + Math.sin(lat2Rad),
                                      Math.sqrt((Math.cos(lat1Rad) + bx) * (Math.cos(lat1Rad) + bx) + by * by));
        double lonMidRad = lon1Rad + Math.atan2(by, Math.cos(lat1Rad) + bx);

        return new Coordinate(Math.toDegrees(latMidRad), Math.toDegrees(lonMidRad));
    }
    public boolean isWithin(Coordinate center, double radiusKm) {
        return distanceTo(center) <= radiusKm * 1000; // Convertir km a metros
    }
    public static Coordinate centroid(List<Coordinate> coordinates) {
        if (coordinates == null || coordinates.isEmpty()) {
            throw new IllegalArgumentException("La lista de coordenadas no puede ser nula o vacía.");
        }
        double sumLat = 0;
        double sumLon = 0;
        for (Coordinate c : coordinates) {
            sumLat += c.latitude();
            sumLon += c.longitude();
        }
        return new Coordinate(sumLat / coordinates.size(), sumLon / coordinates.size());
    }
}
