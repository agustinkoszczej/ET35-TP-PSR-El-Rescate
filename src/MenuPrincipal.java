
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


	public class MenuPrincipal extends JPanel implements EstadoJuego {
		
	private ImageIcon image_icon;
	private String fondo = "/Introv3.gif";
	 private int i = 0, j = 0, k = 0, l = 0, c = 0;
	 private String Accion;
	 public static String Sonido = "Con";
	 public Main main;
	 
	 public String Personaje_Elegido;
	 
	 public MenuPrincipal(){
		 setFocusable(true);
		 setBackground(Color.BLACK);
		 setDoubleBuffered(true);     
		 image_icon = new ImageIcon(this.getClass().getResource(fondo));
		 }
	 
	    public void draw(Graphics2D g2d){
		    g2d.drawImage(image_icon.getImage(), 0, 0, null);   
		    Toolkit.getDefaultToolkit().sync();
		    g2d.dispose();
	    }

	    public void keyPressed(KeyEvent e){
	   	 int key = e.getKeyCode();
	   	if (key == 65){
	   		 key = 37;
	   	 }
	   	if (key == 87){
	   		 key = 38;
	   	 }	 
	   	if (key == 68){
	   		 key = 39;
	   	 }
	   	if (key == 83){
	   		 key = 40;
	   	 }
	   	


	   	 //Intro del Juego
	   	 if ((key == 10)&&(fondo == "/Introv3.gif")){
	   		i=0;
   			k=0;
   			j=0;
	   		if (Sonido == "Con") Sonidos.Intro.play();
	   		fondo = "/Menu_NoCont_Opc1.gif";
	   		image_icon = new ImageIcon(this.getClass().getResource(fondo));
	   		 repaint();
	   	 }
	   	 //Intro del Juego
	   	 
	   	 
	   //Abajo en Menu Principal
	   	 if ((key == 38) && ((fondo == "/Menu_NoCont_Opc1.gif") || (fondo == "/Menu_NoCont_Opc2.gif") || (fondo == "/Menu_NoCont_Opc3.gif"))){
	   		 i--;
	   		j=0;
   			k=0;

	   			if ((i==0)||(i==3)){
	   				fondo = "/Menu_NoCont_Opc1.gif";
	   				image_icon = new ImageIcon(this.getClass().getResource(fondo));
	   				 repaint();
	   				 i=0;
	   			}
	   			if (i==1){
	   				fondo = "/Menu_NoCont_Opc2.gif";
	   				image_icon = new ImageIcon(this.getClass().getResource(fondo));
	   				 repaint();
	   			}
	   			if ((i==2)||(i==-1)){
	   				fondo = "/Menu_NoCont_Opc3.gif";
	   				image_icon = new ImageIcon(this.getClass().getResource(fondo));
	   				 repaint();
	   				 i=2;
	   			}
	   			if (Sonido == "Con") Sonidos.Opciones.play();
	   		}
	   //Abajo en Menu Principal
	   	 
	   	 
	   //Arriba en Menu Principal
	   	 if ((key == 40) && ((fondo == "/Menu_NoCont_Opc1.gif") || (fondo == "/Menu_NoCont_Opc2.gif") || (fondo == "/Menu_NoCont_Opc3.gif"))){
	   		 i++;
	   		j=0;
   			k=0;

   			if ((i==0)||(i==3)){
	   				fondo = "/Menu_NoCont_Opc1.gif";
	   				image_icon = new ImageIcon(this.getClass().getResource(fondo));
	   				 repaint();
	   				 i=0;
	   			}
	   			if (i==1){
	   				fondo = "/Menu_NoCont_Opc2.gif";
	   				image_icon = new ImageIcon(this.getClass().getResource(fondo));
	   				 repaint();
	   			}
	   			if (i==2){
	   				fondo = "/Menu_NoCont_Opc3.gif";
	   				image_icon = new ImageIcon(this.getClass().getResource(fondo));
	   				 repaint();
	   			}
	   		if (Sonido == "Con") Sonidos.Opciones.play();
	   	} 	 
	   	 //Arriba en Menu Principal
	   	 
	   	 
	   	 //Izquierda en Seleccion Personaje
	   	if ((key == 37) && ((fondo == "/AdamSelecc.png") || (fondo == "/BruceSelecc.png") || (fondo == "/MattSelecc.png") || (fondo == "/XaviSelecc.png") || (fondo == "/SpideySelecc.png"))){
	   		 i--;
	   		j=0;
   			k=0;


	   		   			if ((i==0)||(i==5)){
	   				fondo = "/AdamSelecc.png";
	   				image_icon = new ImageIcon(this.getClass().getResource(fondo));
	   				 repaint();
	   				 i=0;
	   			}
	   			if (i==1){
	   				fondo = "/BruceSelecc.png";
	   				image_icon = new ImageIcon(this.getClass().getResource(fondo));
	   				 repaint();
	   			}
	   			if (i==2){
	   				fondo = "/MattSelecc.png";
	   				image_icon = new ImageIcon(this.getClass().getResource(fondo));
	   				 repaint();
	   			}
	   			if (i==3){
	   				fondo = "/XaviSelecc.png";
	   				image_icon = new ImageIcon(this.getClass().getResource(fondo));
	   				 repaint();
	   			}
	   			if ((i==4)||(i==-1)){
	   				fondo = "/SpideySelecc.png";
	   				image_icon = new ImageIcon(this.getClass().getResource(fondo));
	   				 repaint();
	   				 i=4;	
	   			}
	   			if (Sonido == "Con") Sonidos.Opciones.play();
	   	}
	  //Izquierda en Seleccion Personaje
	   	
	   	

	  //Derecha en Seleccion Personaje
	   	 if ((key == 39)	&& ((fondo == "/AdamSelecc.png") || (fondo == "/BruceSelecc.png") || (fondo == "/MattSelecc.png") || (fondo == "/XaviSelecc.png") || (fondo == "/SpideySelecc.png"))){
	   		 i++;
	   		j=0;
   			k=0;
	   		   			if ((i==0) || (i==5)){
	   				fondo = "/AdamSelecc.png";
	   				image_icon = new ImageIcon(this.getClass().getResource(fondo));
	   				 repaint();
	   				 i=0;
	   			}
	   			if (i==1){
	   				fondo = "/BruceSelecc.png";
	   				image_icon = new ImageIcon(this.getClass().getResource(fondo));
	   				 repaint();
	   			}
	   			if (i==2){
	   				fondo = "/MattSelecc.png";
	   				image_icon = new ImageIcon(this.getClass().getResource(fondo));
	   				 repaint();
	   			}
	   			if (i==3){
	   				fondo = "/XaviSelecc.png";
	   				image_icon = new ImageIcon(this.getClass().getResource(fondo));
	   				 repaint();
	   			}
	   			if (i==4){
	   				fondo = "/SpideySelecc.png";
	   				image_icon = new ImageIcon(this.getClass().getResource(fondo));
	   				 repaint();
	   			}
	   			if (Sonido == "Con") Sonidos.Opciones.play();
	   		}
	   //Derecha en Seleccion Personaje
	   	 
	 	if ((key == 10)&&((fondo == "/Introv2_Adam.gif") || (fondo == "/Introv2_Bruce.gif") || (fondo == "/Introv2_Matt.gif") || (fondo == "/Introv2_Xavi.gif") || (fondo == "/Introv2_Spidey_v2.gif"))){
	   		if (Sonido == "Con") Sonidos.Intro.play();
	   		Estados.currentState = GameState.Jugando;
	   		if (Personaje_Elegido == "Adam") Estados.jugando = new DibujarPersonaje("Adam");
	   		if (Personaje_Elegido == "Bruce") Estados.jugando = new DibujarPersonaje("Bruce");
	   		if (Personaje_Elegido == "Matt") Estados.jugando = new DibujarPersonaje("Matt");
	   		if (Personaje_Elegido == "Xavi") Estados.jugando = new DibujarPersonaje("Xavi");
	   		if (Personaje_Elegido == "Spidey") Estados.jugando = new DibujarPersonaje("Spidey");
	   	}
	   	 
	 	
	   	if ((key == 10)&&(fondo == "/AdamSelecc.png")){
	   		if (Sonido == "Con") Sonidos.Intro.play();
	   		Personaje_Elegido = "Adam";
	   		fondo = "/Introv2_Adam.gif";
			image_icon = new ImageIcon(this.getClass().getResource(fondo));
			repaint();
	   	//Estados.currentState = GameState.Jugando;
	   	//Estados.jugando = new DibujarPersonaje("Adam");	
	   	}
	   	else if ((key == 10)&&(fondo == "/SpideySelecc.png")){
	   		if (Sonido == "Con") Sonidos.Intro.play();
	   		Personaje_Elegido = "Spidey";
	   		fondo = "/Introv2_Spidey_v2.gif";
			image_icon = new ImageIcon(this.getClass().getResource(fondo));
			repaint();
	   	//Estados.currentState = GameState.Jugando;
	   	//Estados.jugando = new DibujarPersonaje("Spidey");	
	   	}
	   	else if((key == 10)&&(fondo == "/BruceSelecc.png")){
	   		if (Sonido == "Con") Sonidos.Intro.play();
	   		Personaje_Elegido = "Bruce";
	   		fondo = "/Introv2_Bruce.gif";
			image_icon = new ImageIcon(this.getClass().getResource(fondo));
			repaint();
	   		
	   		//Estados.currentState = GameState.Jugando;
	   		//Estados.jugando = new DibujarPersonaje("Bruce");
	   	}
	   	else if((key == 10)&&(fondo == "/MattSelecc.png")){
	   		if (Sonido == "Con") Sonidos.Intro.play();
	   		Personaje_Elegido = "Matt";
	   		fondo = "/Introv2_Matt.gif";
			image_icon = new ImageIcon(this.getClass().getResource(fondo));
			repaint();
	   		//Estados.currentState = GameState.Jugando;
	   		//Estados.jugando = new DibujarPersonaje("Matt");
	   	}
	   	else if((key == 10)&&(fondo == "/XaviSelecc.png")){
	   		if (Sonido == "Con") Sonidos.Intro.play();
	   		Personaje_Elegido = "Xavi";
	   		fondo = "/Introv2_Xavi.gif";
			image_icon = new ImageIcon(this.getClass().getResource(fondo));
			repaint();
	   		//Estados.currentState = GameState.Jugando;
	   		//Estados.jugando = new DibujarPersonaje("Xavi");
	   	} 	   	
	   	
	   	 if ((key == 10)&&(fondo == "/Menu_NoCont_Opc1.gif")){
	   			if (Sonido == "Con") Sonidos.Intro.play();		
	   			l++;
	   			i=0;
	   			k=0;

	   			if (l == 2){
	   		/*		Accion = "NuevaPartida";*/
	   				i = 0;
	   				fondo = "/AdamSelecc.png";
	   				image_icon = new ImageIcon(this.getClass().getResource(fondo));
	   				 repaint();
	  
	   			}
	   		 }
	   	 
	   	 //Acerca de
	   	 if ((key == 10)&&((fondo == "/Opciones_Opc2_Con.gif")||(fondo == "/Opciones_Opc2_Sin.gif"))){
	   		i=0;
	   		j=0;
	   		k=0;

	   		 if (Sonido == "Con") Sonidos.Intro.play();
	   		 key = 0;
	   		 fondo = "/Acerca_de.gif";
				image_icon = new ImageIcon(this.getClass().getResource(fondo));
				 repaint();
	   	 }
	   	 //Acerca de
	   	if ((key == 10)&&(fondo == "/Acerca_de.gif")){
	   		i=0;
	   		j=0;
	   		k=0;

	   		 if (Sonido == "Con") Sonidos.Intro.play();
	   		 fondo = "/Opciones_Opc1_Con.gif";
				image_icon = new ImageIcon(this.getClass().getResource(fondo));
				 repaint();
	   	 }
	   	 
	   	 
	   //Arriba en Opciones
	   	

	   	 
		 if ((key == 38) && ((fondo == "/Opciones_Opc1_Con.gif") || (fondo == "/Opciones_Opc2_Con.gif") || (fondo == "/Opciones_Opc3_Con.gif") || (fondo == "/Opciones_Opc1_Sin.gif") ||(fondo == "/Opciones_Opc2_Sin.gif") || (fondo == "/Opciones_Opc3_Sin.gif"))){
			   
	   		 k--;
	   		 i=0;
	   		 j=0;

	   			if ((k==0)||(k==3)){
	   				if (Sonido == "Con") fondo = "/Opciones_Opc1_Con.gif";
	   				else  fondo = "/Opciones_Opc1_Sin.gif";
	   				image_icon = new ImageIcon(this.getClass().getResource(fondo));
	   				 repaint();
	   				 k=0;
	   			}
	   			if (k==1){
	   				if (Sonido == "Con") fondo = "/Opciones_Opc2_Con.gif";
	   				else  fondo = "/Opciones_Opc2_Sin.gif";
	   				image_icon = new ImageIcon(this.getClass().getResource(fondo));
	   				 repaint();
	   			}
	   			if ((k==2)||(k==-1)){
	   				if (Sonido == "Con") fondo = "/Opciones_Opc3_Con.gif";
	   				else  fondo = "/Opciones_Opc3_Sin.gif";
	   				image_icon = new ImageIcon(this.getClass().getResource(fondo));
	   				 repaint();
	   				 k=2;
	   			}
	   			if (Sonido == "Con") Sonidos.Opciones.play();
	   		}
	   //Arriba en Opciones
	   	 
	   	 
	   //Abajo en Opciones 
	   	 if ((key == 40) && ((fondo == "/Opciones_Opc1_Con.gif") || (fondo == "/Opciones_Opc2_Con.gif") || (fondo == "/Opciones_Opc3_Con.gif") || (fondo == "/Opciones_Opc1_Sin.gif") ||(fondo == "/Opciones_Opc2_Sin.gif") || (fondo == "/Opciones_Opc3_Sin.gif"))){
	   		 k++;
	   		 i=0;
	   		 j=0;

   			if ((k==0)||(k==3)){
   					
	   				if (Sonido == "Con") fondo = "/Opciones_Opc1_Con.gif";
	   				else  fondo = "/Opciones_Opc1_Sin.gif";
	   				image_icon = new ImageIcon(this.getClass().getResource(fondo));
	   				 repaint();
	   				 k=0;
	   			}
	   			if (k==1){
	   				if (Sonido == "Con") fondo = "/Opciones_Opc2_Con.gif";
	   				else  fondo = "/Opciones_Opc2_Sin.gif";
	   				image_icon = new ImageIcon(this.getClass().getResource(fondo));
	   				 repaint();
	   			}
	   			if (k==2){
	   				if (Sonido == "Con") fondo = "/Opciones_Opc3_Con.gif";
	   				else  fondo = "/Opciones_Opc3_Sin.gif";
	   				image_icon = new ImageIcon(this.getClass().getResource(fondo));
	   				 repaint();
	   			}
	   		if (Sonido == "Con") Sonidos.Opciones.play();
	   	} 	 
	   	 //Abajo Opciones
	   	 
	   //Izquierda en Sonido
	   	 if (((key == 37)||(key == 39)) && ((fondo == "/Opciones_Opc1_Con.gif") || (fondo == "/Opciones_Opc1_Sin.gif"))){
	   		 k=0;
	   		 i=0;
	   		 j=0;
	   		 if (Sonido == "Con"){
	   		 Sonido = "Sin";
	   		 Sonidos.Fondo.stop();
	   		 Sonidos.Intro = null;
	   		 Sonidos.Golpe = null;
	   		 Sonidos.Lastimado = null;
	   		 Sonidos.Opciones = null;
	   		 Sonidos.Fondo = null;
	   		 Sonidos.Intro = null;
	   		 Sonidos.Golpe = null;
	   		 Sonidos.Lastimado = null;
	   		 Sonidos.Opciones = null;
	   		 Sonidos.Pega_Aire = null;
	   		 Sonidos.Fin = null;
	   		 
	   		 Sonidos.Adam = null;
	   		 Sonidos.Bruce = null;
	   		 Sonidos.Matt = null;
	   		 Sonidos.Xavi = null;	   		 
	   		 Sonidos.Spidey = null;
	   		 }
	   		 else{
	   			 Sonido = "Con";
	   			Sonidos.Fondo = Applet.newAudioClip(Sonidos.class.getResource("Fondo.wav"));
	   			Sonidos.Intro = Applet.newAudioClip(Sonidos.class.getResource("Intro.wav"));
	   			Sonidos.Opciones = Applet.newAudioClip(Sonidos.class.getResource("Opciones.wav"));
	   			Sonidos.Golpe = Applet.newAudioClip(Sonidos.class.getResource("Golpe.wav"));
	   			Sonidos.Pega_Aire = Applet.newAudioClip(Sonidos.class.getResource("Pega_Aire.wav"));
	   			Sonidos.Lastimado = Applet.newAudioClip(Sonidos.class.getResource("Lastimado.wav"));	   			
	   			Sonidos.Fin = Applet.newAudioClip(Sonidos.class.getResource("Fin.wav"));

	   			Sonidos.Adam = Applet.newAudioClip(Sonidos.class.getResource("Adam.wav"));
	   			Sonidos.Bruce = Applet.newAudioClip(Sonidos.class.getResource("Bruce.wav"));
	   			Sonidos.Matt = Applet.newAudioClip(Sonidos.class.getResource("Matt.wav"));
	   			Sonidos.Xavi = Applet.newAudioClip(Sonidos.class.getResource("Xavi.wav"));
	   			Sonidos.Spidey = Applet.newAudioClip(Sonidos.class.getResource("Spidey.wav"));
	   			Sonidos.Fondo.play();
	   		 }
	   		if (Sonido == "Con") fondo = "/Opciones_Opc1_Con.gif";
				else  fondo = "/Opciones_Opc1_Sin.gif";
	   				image_icon = new ImageIcon(this.getClass().getResource(fondo));
	   				 repaint();
	   		if (Sonido == "Con") if (Sonido == "Con") Sonidos.Opciones.play();
	   	} 	 
	   	 //Arriba Opciones
	   	

	   	 
	   	if ((key == 10)&&((fondo == "/Opciones_Opc3_Con.gif")||(fondo == "/Opciones_Opc3_Sin.gif"))){
	   		i=0;
   			k=0;
   			j=0;

	   		if (Sonido == "Con") Sonidos.Intro.play();
	   		fondo = "/Menu_NoCont_Opc1.gif";
	   		image_icon = new ImageIcon(this.getClass().getResource(fondo));
				 repaint();
	   	}
	   	 
	   	 
	   	 if ((key == 10)&&(fondo == "/Menu_NoCont_Opc2.gif")){
	   		i=0;
   			k=0;
   			j=0;

	   			if (Sonido == "Con") Sonidos.Intro.play();
	   			if (Sonido == "Con" )fondo = "/Opciones_Opc1_Con.gif";
	   			else fondo = "/Opciones_Opc1_Sin.gif";
	   			image_icon = new ImageIcon(this.getClass().getResource(fondo));
  				 repaint();
	   		/*	Accion = "Opciones";	*/
	   		 }
	   	 if ((key == 10)&&(fondo == "/Menu_NoCont_Opc3.gif")){
	   			if (Sonido == "Con") Sonidos.Intro.play();
	   		/*	Accion = "Salir";	*/
	   			System.exit(i);
	   		 }

	    }
	 /*   public void actionPerformed(ActionEvent e) {
	   	if (Accion == "NuevaPartida"){
	   		System.out.println("Seleccionaste Nueva Partida");
	   		Board.currentState = GameState.Playing;
	   	}
	   	if (Accion == "Salir"){
	   		System.exit(i);
	   	}
	   	
	   }*/
	}

