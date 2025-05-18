package webscrapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
public class Websrappe{

    public static  void mostrarSitios(String uri) throws IOException {
        URL url = new URL(uri);
        HttpURLConnection conexion= (HttpURLConnection) url.openConnection();
        String enconding= conexion.getContentEncoding();

        InputStream input =conexion.getInputStream();
        String result = new BufferedReader(new InputStreamReader(input)).lines().collect(Collectors.joining());

        //System.out.println(result);
        // Expresión regular para encontrar el título dentro de las etiquetas <title>
        Pattern pattern = Pattern.compile("<title>(.*?)</title>", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(result);
        String title = "";

        if (matcher.find()) {
            title = matcher.group(1).trim(); // Obtener el texto dentro de las etiquetas <title> y eliminar espacios en blanco
            System.out.println("\nTítulo de la página: " + title);
        } else {
            System.out.println("\nNo se encontró el título de la página.");
        }
    }
}
