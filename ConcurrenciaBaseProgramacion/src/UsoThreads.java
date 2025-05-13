import java.awt.geom.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class UsoThreads {
	public static void main(String[] args) {
		
		JFrame marco=new MarcoRebote();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);
	}
}

class PelotaHilos implements Runnable{
 private Pelota pelota;
 private Component componente;
  public PelotaHilos(Pelota unaPelota,Component unComponent){
    pelota=unaPelota;
    componente=unComponent;
  }
  @Override
  public void run() {
    System.out.println("Estado del hilo al comenzar "+Thread.currentThread().isInterrupted());
    //for (int i=1; i<=3000; i++){
			//while (!Thread.interrupted()) {
			while (!Thread.currentThread().isInterrupted()) {//en este ejemplo esto hace lo mismo que el isinterrupted
        
      pelota.mueve_pelota(componente.getBounds());
      
      componente.paint(componente.getGraphics());
      try {              
        Thread.sleep(4);//el void interupt por si solo llora con la exepcion ya que este sleep mientras esta dormido esta bloqueado  este hilo y no e sposible iterrumpirlo por ende lo que pongamos en el catch pues suscedere pero el hilo conitnuara a menos que en rel catch se colo que un System.exit
      } catch (InterruptedException e) {
  
       // e.printStackTrace();
       //System.out.println("Hilo bloqueado, imposible su interrupcion");
      Thread.currentThread().interrupt();
      }
    }
    System.out.println("Estado del hilo al terminar "+Thread.currentThread().isInterrupted());
  }
}



//Movimiento de la pelota-----------------------------------------------------------------------------------------
class Pelota{
	// Mueve la pelota invirtiendo posicion si choca con limites
	public void mueve_pelota(Rectangle2D limites){
		x+=dx;
		y+=dy;
		
		if(x<limites.getMinX()){	
			x=limites.getMinX();
			dx=-dx;
		}
		
		if(x + TAMX>=limites.getMaxX()){
			x=limites.getMaxX() - TAMX;
			dx=-dx;
		}
		
		if(y<limites.getMinY()){
			y=limites.getMinY();
			dy=-dy;
		}
		
		if(y + TAMY>=limites.getMaxY()){
			y=limites.getMaxY()-TAMY;
			dy=-dy;
		}
		
	}
	
	//Forma de la pelota en su posicion inicial
	public Ellipse2D getShape(){
		return new Ellipse2D.Double(x,y,TAMX,TAMY);
	}	
	private static final int TAMX=15;
	private static final int TAMY=15;
	private double x=0;
	private double y=0;
	private double dx=1;
	private double dy=1;
}

// Lamina que dibuja las pelotas----------------------------------------------------------------------
class LaminaPelota extends JPanel{
	//Añadimos pelota a la lamina
	public void add(Pelota b){
		pelotas.add(b);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		for(Pelota b: pelotas){
			g2.fill(b.getShape());
		}
	}
	private ArrayList<Pelota> pelotas=new ArrayList<Pelota>();
}


//Marco con lamina y botones------------------------------------------------------------------------------
class MarcoRebote extends JFrame{
	public MarcoRebote(){
		setBounds(600,300,600,350);
		setTitle ("Rebotes");
		lamina=new LaminaPelota();
		add(lamina, BorderLayout.CENTER);
		JPanel laminaBotones=new JPanel();


    arranca1=new JButton("Hilo 1");
		arranca1.addActionListener(new ActionListener(){		
			public void actionPerformed(ActionEvent evento){			
				comienza_el_juego(evento);
			}
		});
    laminaBotones.add(arranca1);

    arranca2=new JButton("Hilo 2");
		arranca2.addActionListener(new ActionListener(){		
      public void actionPerformed(ActionEvent evento){			
        comienza_el_juego(evento);
			}
		});
    laminaBotones.add(arranca2);
    
    arranca3=new JButton("Hilo 3");
		arranca3.addActionListener(new ActionListener(){		
      public void actionPerformed(ActionEvent evento){			
        comienza_el_juego(evento);
			}
		});
    laminaBotones.add(arranca3);

    detener1=new JButton("Detener 1");
		detener1.addActionListener(new ActionListener(){		
      public void actionPerformed(ActionEvent evento){			
        detener(evento);
			}
		});
    laminaBotones.add(detener1);

    detener2=new JButton("Detener 2");
		detener2.addActionListener(new ActionListener(){		
      public void actionPerformed(ActionEvent evento){			
        detener(evento);
			}
		});
    laminaBotones.add(detener2);

    detener3=new JButton("Detener 3");
		detener3.addActionListener(new ActionListener(){		
      public void actionPerformed(ActionEvent evento){			
        detener(evento);
			}
		});
    laminaBotones.add(detener3);


		/*ponerBoton(laminaBotones, "Dale!", new ActionListener(){
			public void actionPerformed(ActionEvent evento){
				comienza_el_juego();
			}
		});

		ponerBoton(laminaBotones, "Salir", new ActionListener(){
			public void actionPerformed(ActionEvent evento){
				System.exit(0);
			}
		});
    ponerBoton(laminaBotones, "Detener", new ActionListener(){	
			public void actionPerformed(ActionEvent evento){
				detener();
			}
		});*/
		
		add(laminaBotones, BorderLayout.SOUTH);
	}


	private void detener(ActionEvent e) {
    //t.stop();//hoy 2025 en definitiva esto ya al ,menos esta jvm ya no soporta a este metodo
   // System.out.println("fasfas");
   //t.interrupt();
   if (e.getSource().equals(detener1)) {
    t1.interrupt();
   }else if (e.getSource().equals(detener2)) {
    t2.interrupt();
   }else if (e.getSource().equals(detener3)) {
    t3.interrupt();
   }
  }
	
	//Ponemos botones
	/*public void ponerBoton(Container c, String titulo, ActionListener oyente){
		JButton boton=new JButton(titulo);
		c.add(boton);
		boton.addActionListener(oyente);
	}*/

	//Añade pelota 
	public void comienza_el_juego (ActionEvent e){
			Pelota pelota=new Pelota();
			lamina.add(pelota);
			/*for (int i=1; i<=3000; i++){
				pelota.mueve_pelota(lamina.getBounds());
				lamina.paint(lamina.getGraphics());
				try {
          Thread.sleep(4);
        } catch (InterruptedException e) {
    
          e.printStackTrace();
        }
			}*/

      Runnable r = new PelotaHilos(pelota, lamina);
    if (e.getSource().equals(arranca1)) {
      t1= new Thread(r);
      t1.start();
     }else if (e.getSource().equals(arranca2)) {
      t2= new Thread(r);
      t2.start();
     }else if (e.getSource().equals(arranca3)) {
      t3= new Thread(r);
      t3.start();
     }

			/*t= new Thread(r);
      t.start();*/
		//en cada llamda a este boton esto crear othro nuevo hilo pero co  el mismo nombre por tanto, los anteorrires solo existen pero pierden su nombre porque ahora este nombre pertenece a este nuevo hilo, por ende al detener a t on interrupt, solo interrumpe el hilo t, pero los otros ya no los podra detenetr por quer no hay fomra que acceda a ellos por asi decirlo
	}
	
	private LaminaPelota lamina;
	//Thread t;
  Thread t1,t2,t3;
  JButton arranca1,arranca2,arranca3,detener1,detener2,detener3;
	
}

