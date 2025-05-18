package webscrapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
    public class Websrappe2{
   //si le agregamo un sicnronize aca, pues estariamo degrando la veloidad de lectura y entonces incluso la tara paralela ahora sera mas lenta que la que no es paralela
       //y aprte igual aparecen en orden istinto ya que la orden a que ser haga en apralelo se manda simepre, por ende
        //ya estan a la espéra y segun se desbloquea uno, entra el pximo que est mas listo, y por eso hay el
        //orden diufernte en cada llamda pero aun asi su renfi iento se degra en la esprra cuando esta sincrinizado

        //y se pierde el benficio de conurrenia
        //para este caso no es necesario un sincronize aca, pero si lo ha de ser en un caso hiptotetico como el que esta abajo, o si esta fuera la funcion la cual se encarafgariad e otra tarea concurrente que demanda tiempo
        public static void mostrarSitios(String uri) throws IOException {
            System.out.println("ini");
            System.out.println(uri);
            URL url = new URL(uri);
            HttpURLConnection conexion= (HttpURLConnection) url.openConnection();
            String enconding= conexion.getContentEncoding();

            InputStream input =conexion.getInputStream();
            String result = new BufferedReader(new InputStreamReader(input)).lines().collect(Collectors.joining());
             guardarEnBd(result);
            //System.out.println(result);
            // Expresión regular para encontrar el título dentro de las etiquetas <title>
            Pattern pattern = Pattern.compile("<title>(.*?)</title>", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(result);
            String title = "";

            if (matcher.find()) {
                title = matcher.group(1).trim(); // Obtener el texto dentro de las etiquetas <title> y eliminar espacios en blanco
                System.out.println("Título de la página: " + title);
            } else {
                System.out.println("\nNo se encontró el título de la página.");
            }
            System.out.println("fin\n");
        }

        //por ejemplo el sicronizado nos ayudaria a manterner la tarea anterior siemore veloz, osea eso
        //no lo sincronizariamos asi no perderiamos el beneifcio de la velocidad del parelelismo, y la conurrencia
        /// /pero a lo mejro esta ytarea qu e es concurrente si requiere que por seguridad y evitar condiciones de carrear
        /// //o algun tipo de vbloqueo segun la logica del gestor de base de datos
        /// //debanmos contrllar la asicnronia y asi solo hacer una tarea a la vez,pero sin operder el benficio de obtnera
        /// //a gran velocidad los datos
     public synchronized static void guardarEnBd(String dato){

     }

    }


