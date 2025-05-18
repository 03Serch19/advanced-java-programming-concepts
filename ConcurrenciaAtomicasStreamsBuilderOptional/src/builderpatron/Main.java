package builderpatron;

import static builderpatron.Persona.Builder.asPersona;

public class Main {


    public static void main(String[] args) {
     /*  Persona persona1= Persona.Builder.asPersona()
               .name("andres")
               .edad(59)
               .build();
        System.out.println(persona1);*/
        Persona persona1= asPersona()
                .name("andres")
                .edad(59)
                .build();
        System.out.println(persona1);

    }
}
