package optionalinjava;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Ciudad {

    public static void main(String[] args) {
        List<String> ciudades = new ArrayList<>();
        ciudades.add("Santa Ana");
        ciudades.add("San Salvador");
        ciudades.add("Sonsonate");
        ciudades.add("San Miguel");
        ciudades.add("Ahuachapán");
        ciudades.add("Usulután");
        ciudades.add("Chalatenango");
        ciudades.add("La Libertad");
      Optional<String> ciud= ciudades.stream().filter(c->c.startsWith("San")).findFirst();
             ciud.ifPresent(System.out::println);
    }
}
