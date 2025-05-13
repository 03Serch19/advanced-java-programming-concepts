import javax.swing.*;

import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor{

	public static void main(String[] args) {
		MarcoServidor mimarco=new MarcoServidor();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
}

class MarcoServidor extends JFrame implements Runnable{
	public MarcoServidor(){
		setBounds(1200,300,280,350);				
		JPanel milamina= new JPanel();
		milamina.setLayout(new BorderLayout());
		areatexto=new JTextArea();
		milamina.add(areatexto,BorderLayout.CENTER);
		add(milamina);
		setVisible(true);
		Thread mihilo=new Thread(this);
    mihilo.start();
		}


  @Override
  public void run() {
  //  System.out.println("Estoy a la espera de conexiones");
  ServerSocket servidor = null;
  try {
    servidor = new ServerSocket(9999);
    while (true) {
      Socket misocket = servidor.accept();
      DataInputStream flujoentrada = new DataInputStream(misocket.getInputStream());
       String mensaje = flujoentrada.readUTF();
      areatexto.append(mensaje + "\n");
      misocket.close();
      flujoentrada.close();
     // servidor.close();//de poco seriviria ya que el ciclo envetua.mente volveria a abiir la conexxion en caso la tuvieron dentro del while, osea sii necesaria para cerrar la conxion y abriliar de nuevo y sai este diumponilbe, pero pues en ultima instacia quedara abuerta, y la otra forma pues es eta que la comcexion sieemrpe ete aberata en ese puerto y semrpe est a la exucha y por eso se edeja afuera, pero lo mismo no hay foram de cerra el servidorr y la nca forma de controlarlo es mediante una atomicidad usando volatile
    }
   // areatexto.append("Cliente conectado\n");
   // areatexto.append("IP: " + misocket.getInetAddress() + "\n");
   // areatexto.append("Puerto: " + misocket.getPort() + "\n");
  //  areatexto.append("Puerto local: " + misocket.getLocalPort() + "\n");
   
  } catch (IOException e) {
    e.printStackTrace();
  }
  }
  private	JTextArea areatexto;
}
