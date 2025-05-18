package webscrapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainClass {

    public static void main(String[] args) throws IOException {
        List<String> direcciones=new ArrayList<>();
        direcciones.add("https://www.ues.edu.sv/");
        direcciones.add("https://www.agronomia.ues.edu.sv/");
        direcciones.add("https://www.fce.ues.edu.sv/");
        direcciones.add("https://naturales.ues.edu.sv/");
        direcciones.add("https://humanidades.ues.edu.sv/");
        direcciones.add("https://www.fia.ues.edu.sv/");
        direcciones.add("https://jurisprudencia.ues.edu.sv/sitio/");
        direcciones.add("https://medicina.ues.edu.sv/");
        direcciones.add("https://www.odontologia.ues.edu.sv/");
        direcciones.add("https://quimicayfarmacia.ues.edu.sv/");
        long timeInit=System.nanoTime();
        direcciones.stream().forEach(d-> {
            try {
                Websrappe2.mostrarSitios(d);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        long timeFin=System.nanoTime();
        System.out.println(timeFin-timeInit);
        long timeInit2=System.nanoTime();
        direcciones.stream().parallel().forEach(d-> {
            try {
                Websrappe2.mostrarSitios(d);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        long timeFin2=System.nanoTime();
        System.out.println(timeFin2-timeInit2);

        //codigo apra cuando era solo una pagina web
       // String uri="https://www.ues.edu.sv/";
       // URI url=new URI(uri);//despues quise probar esto con los mismo metodos de abajo pero no funciono
        /*  URL url = new URL(uri);//este si funciono jaja con lo de abajo
          long timeInit=System.nanoTime();
        HttpURLConnection conexion= (HttpURLConnection) url.openConnection();
        String enconding= conexion.getContentEncoding();

        InputStream input =conexion.getInputStream();
        String result = new BufferedReader(new InputStreamReader(input)).lines().collect(Collectors.joining());
        long timeFin=System.nanoTime();
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
        System.out.println(timeFin-timeInit);*/
    }
}
