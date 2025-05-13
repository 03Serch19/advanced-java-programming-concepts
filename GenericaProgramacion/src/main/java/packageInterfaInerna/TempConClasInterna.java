package packageInterfaInerna;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class TempConClasInterna {
    public static void main(String[] args) {
         // Reloj miReloj=new Reloj(3000, true);
          Reloj miReloj=new Reloj();
          miReloj.enMarcha(3000,true);
          JOptionPane.showMessageDialog(null, "gasgasgasgsdsfsafs");
          System.exit(0);
    }
}
class Reloj{
    
   // private int intervalo;
    //private boolean sonido;
    
   /*public Reloj(int intervalo, boolean sonido){
        this.intervalo=intervalo;
        this.sonido=sonido;
    }*/                                 //aunque si el final me funciono a mi pero bueno
    public void enMarcha(int intervalo,final boolean sonido){//intervalo no es final ya que la intenra local no esta accdiendo a la variable del metodo
      class DameLaHora2 implements ActionListener{//las cases internas si pueden dtener modificador private
        @Override                       //pero si son internas locales no pueden llevar ningun modificador, solo el defauklt
        public void actionPerformed(ActionEvent evento){//las internas locales solo si se va a usar una sola vez la calse
            Date  ahora =new Date();//la intenra local puede acceder a la externa y alas variables del metodo donde esta pero la calse externa nop uede acceder, a menos que use el metodo al que pertenece
            System.out.println("la hora "+ahora);             //pero al acceder a variables del metodo estas deben ser final
            if(sonido){//puedo acceder a sonido, incluso estando encapsulado, nos evitamos de crear los setters y getters,las calses internas tienen ventajas
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
        ActionListener oyente = new DameLaHora2();
        Timer timer = new Timer(intervalo, oyente);
        timer.start();
        
    }
   /* private class DameLaHora2 implements ActionListener{//las cases internas si pueden dtener modificador private
        @Override                       //pero si son internas locales no pueden llevar ningun modificador, solo el defauklt
        public void actionPerformed(ActionEvent evento){
            Date  ahora =new Date();
            System.out.println("la hora "+ahora);
            if(sonido){//puedo acceder a sonido, incluso estando encapsulado, nos evitamos de crear los setters y getters,las calses internas tienen ventajas
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }*/
}