

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.Timer;

//import EstadoJuego.GameState;



public class DibujarPersonaje extends JFrame implements EstadoJuego,ActionListener {
	
    private Timer timer;
    public static Personaje personaje;
    public static Enemigo enemigo;
    private int PosXVida = 100;
    private boolean seguir;
    public Juego juego;
    public String Seleccion;
    public static boolean Pausa = false;
    public static boolean pelea = false;
    public static int NivelJugando;
    public static boolean Jefe1 = false, Jefe2 = false, Jefe3 = false, curo = false, SeCuro = false, sonido_ganar = false;
    public static boolean muerte = false, ganar = false;
	private static Random Random = new Random();
	public int tecla;

    
    public DibujarPersonaje(String Personaje_Selecc){
    	this.Seleccion=Personaje_Selecc;
    	if (Seleccion == "Adam"){
    		personaje = new Adam();
    		if (MenuPrincipal.Sonido == "Con") Sonidos.Adam.loop();
    	}
    	else if (Seleccion == "Bruce"){
    		personaje = new Bruce();
    		if (MenuPrincipal.Sonido == "Con") Sonidos.Bruce.loop();
    	}
    	if (Seleccion == "Matt"){
    		personaje = new Matt();
    		if (MenuPrincipal.Sonido == "Con") Sonidos.Matt.loop();
    	}
    	if (Seleccion == "Xavi"){
    		personaje = new Xavi();
    		if (MenuPrincipal.Sonido == "Con") Sonidos.Xavi.loop();
    	}
    	if (Seleccion == "Spidey"){
    		personaje = new Spidey();
    		if (MenuPrincipal.Sonido == "Con") Sonidos.Spidey.loop();
    	}

    	 setFocusable(true);
    	 setBackground(Color.BLACK);
    	 //setDoubleBuffered(true);


    	 
    	 //personaje.PosX=10; personaje.PosY=16; personaje.PixX=200; personaje.PixY=320;
    	 juego= new Juego(personaje,this);
    	 personaje.setJuego(juego);


    
    	 timer = new Timer(15, this);
    	 timer.start();   
    }

    public void draw(Graphics2D g){

    	
    	
NivelJugando = juego.lvl;


    	
    	Font F = new Font("Times New Roman",Font.BOLD,12);
    	setBackground(Color.BLACK);
    	int T=juego.tamañoObj;
		for(int i=0;i<juego.Mapa.Map.length;i++)
		{
			
			for(int j=0;j<juego.Mapa.Map[0].length;j++)
			{
				
				switch(juego.Mapa.Map[i][j].Tipo)
				{
					case 0:
						if(juego.Mapa.Map[i][j].imagen==null)
						{	
							g.setColor(Color.black);
							g.fillRect(juego.Mapa.Map[i][j].PixX, juego.Mapa.Map[i][j].PixY, T, T);
						}else
						{	g.drawImage(((ImageIcon)juego.Mapa.Map[i][j].imagen).getImage(),juego.Mapa.Map[i][j].PixX, juego.Mapa.Map[i][j].PixY,T,T,null);
						}
					break;
					
					case 1:
						if(juego.Mapa.Map[i][j].imagen==null)
						{	
							g.setColor(Color.white);
							g.fillRect(juego.Mapa.Map[i][j].PixX, juego.Mapa.Map[i][j].PixY, T, T);
						}else
						{	g.drawImage(((ImageIcon)juego.Mapa.Map[i][j].imagen).getImage(),juego.Mapa.Map[i][j].PixX, juego.Mapa.Map[i][j].PixY,T,T,null);
						}
					break;
		
					case 2:
						if(juego.Mapa.Map[i][j].imagen==null)
						{	
							g.setColor(Color.black);
							g.fillRect(juego.Mapa.Map[i][j].PixX, juego.Mapa.Map[i][j].PixY, T, T);
						}else
						{	g.drawImage(((ImageIcon)juego.Mapa.Map[i][j].imagen).getImage(),juego.Mapa.Map[i][j].PixX, juego.Mapa.Map[i][j].PixY,T,T,null);
						}
					break;
					
					case 3:
						if(juego.Mapa.Map[i][j].imagen==null)
						{	
							g.setColor(Color.red);
							g.fillOval(juego.Mapa.Map[i][j].PixX, juego.Mapa.Map[i][j].PixY, T, T);
							g.setColor(Color.black);
						}else
						{	g.drawImage(((ImageIcon)juego.Mapa.Map[i][j].imagen).getImage(),juego.Mapa.Map[i][j].PixX, juego.Mapa.Map[i][j].PixY,T,T,null);
						}
					break;
					
					case 4:
						if(juego.Mapa.Map[i][j].imagen==null)
						{	
							g.setColor(Color.gray);
							g.fillRect(juego.Mapa.Map[i][j].PixX, juego.Mapa.Map[i][j].PixY, T, T);
							g.setColor(Color.WHITE);
							g.drawRect(juego.Mapa.Map[i][j].PixX, juego.Mapa.Map[i][j].PixY, T, T);
						}else
						{	g.drawImage(((ImageIcon)juego.Mapa.Map[i][j].imagen).getImage(),juego.Mapa.Map[i][j].PixX, juego.Mapa.Map[i][j].PixY,T,T,null);
						}
					break;
					
					case 6:
						//if(juego.Mapa.Map[i][j].imagen==null)
						//{	
							g.setColor(Color.ORANGE);
							g.fillOval(juego.Mapa.Map[i][j].PixX, juego.Mapa.Map[i][j].PixY, T, T);
						//}else
						//{	g.drawImage(((ImageIcon)juego.Mapa.Map[i][j].imagen).getImage(),juego.Mapa.Map[i][j].PixX, juego.Mapa.Map[i][j].PixY,T,T,null);
						//}
					break;
					
					case 7:
						g.setColor(Color.green);
						g.fillRect(juego.Mapa.Map[i][j].PixX, juego.Mapa.Map[i][j].PixY, T, T);
						g.setColor(Color.black);
						g.drawRect(juego.Mapa.Map[i][j].PixX, juego.Mapa.Map[i][j].PixY, T, T);
					break;	
					
				}
				
			}
		}
		String piso = "/piso 2.png";
		ImageIcon piso_img = new ImageIcon(getClass().getResource(piso));
		if (NivelJugando == 1){
		for (int i = 380; i <= 540; i = i+ 20){
		g.drawImage(piso_img.getImage(), 220, i, null);
		}
		}
		if (personaje.Vida >0){
        g.drawImage(personaje.getImage(), juego.personaje.PixX, juego.personaje.PixY, null);
		}
      //	}
    	

		

    	if (((juego.lvl == 3)||(juego.lvl == 6)||(juego.lvl == 9))&&(pelea == false)){
    	pelea = true;
    	if ((juego.lvl == 3)&&(Jefe1 == false)){
    		if (enemigo == null) enemigo = new Enemigo();
    		Enemigo.CordX = 200;
    		Enemigo.CordY = 100;
    		Enemigo.enemigo = "Enemigo1";
    		enemigo.Vida = 3;
    		enemigo.Fuerza = 1;
    		enemigo.MovX = 1;
    		enemigo.MovY = 1;
    		Enemigo.VELOCIDAD_PEGAR = 15;
    		Enemigo.VELOCIDAD_SEGUIR = 2;
    	}
    	else if ((juego.lvl == 6)&&(Jefe2 == false)){
    		if (enemigo == null) enemigo = new Enemigo();
    		Enemigo.CordX = 200;
    		Enemigo.CordY = 100;
    		Enemigo.enemigo = "Enemigo2";
    		enemigo.Vida = 5;
    		enemigo.Fuerza = 3;
    		Enemigo.MovX = 2;
    		Enemigo.MovY = 2;
    		Enemigo.VELOCIDAD_PEGAR = 13;
    		Enemigo.VELOCIDAD_SEGUIR = 2;    	
    		}
    	else if ((juego.lvl == 9)&&(Jefe3 == false)){
    		if (enemigo == null) enemigo = new Enemigo();
    		Enemigo.CordX = 200;
    		Enemigo.CordY = 100;
    		Enemigo.enemigo = "Yasky";
    		enemigo.Vida = 10;
    		if (Seleccion != "Matt") enemigo.Fuerza = 5;
    		else enemigo.Fuerza = 3;
    		Enemigo.MovX = 3;
    		Enemigo.MovY = 3;
    		Enemigo.VELOCIDAD_PEGAR = 14;
    		Enemigo.VELOCIDAD_SEGUIR = 3;
    	}
    	}
    	if ((enemigo.Vida > 0)&&(pelea == true)){
        	if (seguir == true){
        	g.drawImage(enemigo.getImageEnemigo(), enemigo.getPosiX(), enemigo.getPosiY(), null);
        	}
        	else{
        		g.drawImage(enemigo.getImageEnemigoQuieto(), enemigo.getPosiX(), enemigo.getPosiY(), null);
        	}
        	g.drawImage(enemigo.getImageCaraEnemigo(), 650, 350, null);
        	if (juego.lvl == 3){
        		PosXVida = 665;
        	}
        	else if (juego.lvl == 6){
        		PosXVida = 650;
        	}
        	else if (juego.lvl == 9){
        		PosXVida = 615;
        	}
        	for (int i = 0; i<enemigo.Vida; i++){
        		g.drawImage(enemigo.getImageVida(), PosXVida, 425, null);
        	PosXVida +=15;
        	}
    	}
        	else if ((enemigo.Vida <=0)){
        		enemigo.CordX  = 900;
        		enemigo.CordY = 800;
        	}
 
    	if ((personaje.Vida >0)&&(pelea == true)){
        	if ((enemigo.pega(personaje.getX(), personaje.getY()) == true) && (curo == false)){
        		personaje.danio("Jugador");
        		g.drawImage(personaje.getImage(), personaje.getX(), personaje.getY(), null);	
           	}
        	else{
            g.drawImage(personaje.getImage(), personaje.getX(), personaje.getY(), null);
            
          	}
        	}

    	if ((enemigo.Vida > 0) && (personaje.Vida > 0)&&(pelea == true)&&(Pausa == false)){
        	if (NivelJugando != 9) seguir = enemigo.seguir(personaje.getX(), personaje.getY());
        	else{
            	if ((enemigo.Vida <= 5)&& (pelea == true) && (SeCuro == false) && ( (Random.nextInt(5) == 1) || (curo == true) ) ){
            		seguir = enemigo.seguir(325, - 100);
            		curo = true;	
            	}
            	else if (curo == false) seguir = enemigo.seguir(personaje.getX(), personaje.getY());
            	
            	if (enemigo.CordY - 30 <= -100){
            		enemigo.Vida = 10;
            		SeCuro = true;
            		Enemigo.VELOCIDAD_PEGAR = 18;
            		curo = false;
            	}
        	}
        	}
        	else seguir = false;


    	
    	if ((enemigo.Vida <= 0)&&(pelea == true)){
    		if (juego.lvl == 3 ){
    			Jefe1 = true;
    		}
    		if (juego.lvl == 6){
    			Jefe2 = true;
    		}
    		if (juego.lvl == 9){
    			Jefe3 = true;
    		}
    		if (NivelJugando != 9) juego.Mapa.Map[0][6]= new Escape(7,0,6,juego);
    		pelea = false;
    	}
    	if (pelea == true){
    		if(Seleccion == "Adam"){
    		PosXVida = 615;
    		}
    		else if (Seleccion == "Bruce"){
    			PosXVida = 630;
    		}
    		else if (Seleccion == "Matt"){
    			PosXVida = 650;
    		}
    		else if (Seleccion == "Xavi"){
    			PosXVida = 640;
    		}
    		else if (Seleccion == "Spidey"){
    			PosXVida = 615;
    		}
    		g.drawImage(personaje.getImageCara(), 650, 20, null);
        	for (int i = 0; i<personaje.Vida; i++){
        	g.drawImage(personaje.getImageVida(), PosXVida, 100, null);
        	PosXVida +=15;
        	}
    	}
    	
    	if (personaje.Vida <= 0){
    		ImageIcon Muerte = new ImageIcon(this.getClass().getResource("/Muerte.png"));
    		g.drawImage(Muerte.getImage(), 0, 0, null);
    		muerte = true;
    	}
    	if ((personaje.Vida <= 0)&&(muerte == true)){
    		if (Random.nextInt(50)==1){
    		 try {

 				Thread.sleep(3000);

 			} catch (InterruptedException e) {
 				e.printStackTrace();
 			}
    		if (juego.lvl == 3){
    		juego.lvl = 1;
    		juego.Mapa=new Mapa1(juego);
    		}
    		else if (juego.lvl == 6){
        		juego.lvl = 4;
        		juego.Mapa=new Mapa4(juego);
        		}
    		else if (juego.lvl == 9){
        		juego.lvl = 7;
        		juego.Mapa=new Mapa7(juego);
        		}
    		
    		if (Seleccion == "Adam") personaje.Vida = 10;
    		else if (Seleccion == "Bruce") personaje.Vida = 7;
    		else if (Seleccion == "Matt") personaje.Vida = 5;
    		else if (Seleccion == "Xavi") personaje.Vida = 6;
    		else if (Seleccion == "Spidey") personaje.Vida = 10;
    		
    		muerte = false;
    		pelea = false;
    	}	   		
    	}
    	

    	if ((pelea == false)&&(Jefe3 == true)){
    		if (MenuPrincipal.Sonido == "Con") Sonidos.Fin.play();
    		ImageIcon Ganar = null;
    		if (Seleccion == "Adam"){
    			Ganar = new ImageIcon(this.getClass().getResource("/Fin_Historia_Adam.gif"));
    			if (MenuPrincipal.Sonido == "Con") Sonidos.Adam.stop();
    		}
    		else if (Seleccion == "Bruce"){
    			Ganar = new ImageIcon(this.getClass().getResource("/Fin_Historia_Bruce.gif"));
    			if (MenuPrincipal.Sonido == "Con") Sonidos.Bruce.stop();
    		}
    		else if (Seleccion == "Matt"){
    			Ganar = new ImageIcon(this.getClass().getResource("/Fin_Historia_Matt.gif"));
    			if (MenuPrincipal.Sonido == "Con") Sonidos.Matt.stop();
    		}
    		else if (Seleccion == "Xavi"){
    			Ganar = new ImageIcon(this.getClass().getResource("/Fin_Historia_Xavi.gif"));
    			if (MenuPrincipal.Sonido == "Con") Sonidos.Xavi.stop();
    		}
    		else if (Seleccion == "Spidey"){
    			Ganar = new ImageIcon(this.getClass().getResource("/Fin_Historia_Spidey.gif"));
    			if (MenuPrincipal.Sonido == "Con") Sonidos.Spidey.stop();
    		}
    		g.drawImage(Ganar.getImage(), 0, 0, null);
    		ganar = true;
    	}
    	
    	
    	
if ((ganar == true)&&(tecla == 10)){
    		
    		if ((MenuPrincipal.Sonido == "Con")&&(sonido_ganar == false)) Sonidos.Intro.play();
    		ImageIcon Fin = new ImageIcon(this.getClass().getResource("/Fin.png"));
    		g.drawImage(Fin.getImage(), 0, 0, null);
    		sonido_ganar = true;
    		if (MenuPrincipal.Sonido == "Con"){
    		if (Seleccion == "Adam") Sonidos.Adam.stop();
    		else if (Seleccion == "Bruce") Sonidos.Bruce.stop();
    		else if (Seleccion == "Matt") Sonidos.Matt.stop();
    		else if (Seleccion == "Xavi") Sonidos.Xavi.stop();
    		else if (Seleccion == "Spidey") Sonidos.Spidey.stop();
    		}
    	}
if (Pausa == true){
	ImageIcon Pausa = new ImageIcon(this.getClass().getResource("/Pausa.png"));
	g.drawImage(Pausa.getImage(), 0, 0, null);
	if (Random.nextInt(10) == 1){
	try {

			Thread.sleep(10);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

    	if ((sonido_ganar == true)&&(Random.nextInt(25) == 1)){
    		try {

 				Thread.sleep(57000);

 			} catch (InterruptedException e) {
 				e.printStackTrace();
 			}
    		System.exit(0);
    	}
    	
        Toolkit.getDefaultToolkit().sync();
        g.dispose();

    }


    public void update(){   	

    }

   
    public void actionPerformed(ActionEvent e){
    	 juego.personaje.move();
    	 repaint();
    	 }


    	 public void keyReleased(KeyEvent e){
    		 if (tecla == 27){
    			 if (Pausa == false) Pausa = true;
    			 else if (Pausa == true) Pausa = false;
    		 }
    		 juego.personaje.keyReleased(e);
    	 }
    	 public void keyPressed(KeyEvent e){
    		 tecla = e.getKeyCode();
    		 juego.personaje.keyPressed(e);
    	 }
}














	
