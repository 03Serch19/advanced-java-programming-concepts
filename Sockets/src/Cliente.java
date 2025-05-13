import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.awt.event.ActionEvent;


public class Cliente {

	public static void main(String[] args) {
		MarcoCliente mimarco=new MarcoCliente();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}


class MarcoCliente extends JFrame{
	public MarcoCliente(){
		setBounds(600,300,280,350);
		LaminaMarcoCliente milamina=new LaminaMarcoCliente();
		add(milamina);
		setVisible(true);
		}	
}

class LaminaMarcoCliente extends JPanel{
	public LaminaMarcoCliente(){
		JLabel texto=new JLabel("CLIENTE");
		add(texto);
		campo1=new JTextField(20);
		add(campo1);		
		miboton=new JButton("Enviar");
		EnviaTexto mievento=new EnviaTexto();
    miboton.addActionListener(mievento);
		add(miboton);
	}
	
		
		private class EnviaTexto implements ActionListener{
      public void actionPerformed(ActionEvent e) { 
        //System.out.println("El texto es: "+ campo1.getText());
        try {
          //la ip y el puerto deben coincidir con los del servidor
          Socket miSocket=new Socket("192.168.1.3", 9999);
          DataOutputStream flujo_salida= new DataOutputStream(miSocket.getOutputStream());
          flujo_salida.writeUTF(campo1.getText());
          flujo_salida.close();
          miSocket.close();
        } catch (IOException e1) {
          System.out.println(e1.getMessage());
          //e1.printStackTrace();
        } 
      } 
    }
		
	private JTextField campo1;
	
	private JButton miboton;
	
}