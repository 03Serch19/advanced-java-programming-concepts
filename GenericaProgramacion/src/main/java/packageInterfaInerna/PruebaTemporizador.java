package packageInterfaInerna;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class PruebaTemporizador {
    public static void main(String[] args) {
        DameLaHora oyente=new DameLaHora();
        //ActionListener oyente = new DameLaHora();//funciionaria, por el principio de sustitucion en java
        Timer timer= new Timer(9000, oyente);
        timer.start();
        JOptionPane.showMessageDialog(null, "Pulsa aceptar para detener");
        System.exit(0);
    }
}
class DameLaHora implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Date ahora = new Date();
        System.out.println("Hora "+ahora);
        //especie de puente a recursos del sistema
        Toolkit.getDefaultToolkit().beep();
    }
    
}
