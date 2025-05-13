package ej3record;

public interface SpatialOperation {
    // Una operación espacial que toma dos coordenadas y devuelve un resultado (genérico por ahora)
    <T> T operate(Coordinate c1, Coordinate c2);
}
