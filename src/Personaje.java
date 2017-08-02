import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.util.Random;

public class Personaje{
	 private  String personaje;
	 private  int MovX;
	 private  int MovY;
	 private  int veloc;
	 public int PosX;
	 public int PosY;
	 public int PixX,PixY;
	 private  Image Imagen_Personaje;
	 private  int i = 0, j = 0;
	 private String Jugador;
	 private static final int ALTURA = 26;
	 private static final int ANCHO = 26;
	 private boolean agarrado = false;
	 public Juego juego;
	 public int mirando;
	 public static String Jugador_Movimiento = "";
	 public static boolean Pega = false;
	 public static int random_pega = 1;
	 private static int DistanciaEmpuje;
	 private static Random Random = new Random();
	 public int Vida, Fuerza;
	 private static int NroAleatorio = 0;
	
	 		public Personaje(String personaje, int Vel, int Vida, int Fuerza)
	 		{ 
	 			Jugador = personaje;
	 			this.veloc = Vel;
	 			PosX = 40;
	 			PosY = 60;
	 			this.Vida = Vida;
	 			this.Fuerza = Fuerza;
	 		}
	 		
	 		public void setJuego(Juego j)
	 		{
	 			juego=j;
	 		}

	 		public void move()
	 			{
	 
	 			if ((MovX > 0 && PixX <= 800 - 38) && (colisionEnemigo() == false)){
	 				PixX += MovX;
	 				//PixY=PixY-5;
	 				if(juego.Mapa.Map[getPosX()][getPosY()].walk==false)//||(juego.Mapa.Map[getPosX()][getPosY()+1].walk==false&&juego.Mapa.Map[getPosX()][getPosY()+1].colision(this)))
	 				{
	 					PixX -= MovX;
	 				}
	 				//PixY=PixY+5;
	 				PosX=getPosX();
	 				agarrado = false;
	 			}
	 			else
	 				if ((MovX < 0 && PixX >= 2) && (colisionEnemigo() == false)){
	 					PixX += MovX;
	 					int Pos=PixX/20;
	 					//PixY=PixY-5;
		 				if(juego.Mapa.Map[Pos][getPosY()].walk==false)//|| (juego.Mapa.Map[getPosX()][getPosY()+1].walk==false&&juego.Mapa.Map[getPosX()][getPosY()+1].colision(this)))
		 				{
		 					PixX -= MovX;				
		 				}
		 				//PixY=PixY+5;
		 				PosX=getPosX();
		 				agarrado = false;
	 				}

	 			if ((MovY > 0 && PixY <= 700 - 50) && (colisionEnemigo() == false)){
	 				PixY += MovY;
	 				int Pos = PixY/20;
	 				if(juego.Mapa.Map[getPosX()][Pos+1].walk==false)
	 				{
	 					PixY -= MovY;
	 				}
	 				PosY=getPosY();
	 				agarrado = false;
	 			}
	 			else
	 				if ((MovY < 0 && PixY >= 2) && (colisionEnemigo() == false)){
	 					PixY += MovY;
		 				if(juego.Mapa.Map[getPosX()][getPosY()].walk==false)
		 				{
		 					PixY -= MovY;
		 				}
		 				PosY=getPosY();
		 				agarrado = false;
	 				}

	 			Class clase;
	 			clase=juego.Mapa.Map[PosX][PosY].getClass();
	 			if(clase.getName().equals("Escape"))
	 			{
	 				juego.SigNivel();
	 			}
	 		}

	 		
	 		public void danio(String danio){
	 			
				  if (danio == "Jugador"){

				   //if ((Enemigo.img_enemigo == "/"+Enemigo.enemigo+"_Izquierda.gif") ||(Enemigo.img_enemigo == "/"+Enemigo.enemigo+"_Izquierda_Quieto.png")){
				  if (Enemigo.Direccion_Enemigo() == "Izquierda"){
				   NroAleatorio = -1;
				   }
				   //if ((Enemigo.img_enemigo == "/"+Enemigo.enemigo+"_Derecha.gif") ||(Enemigo.img_enemigo == "/"+Enemigo.enemigo+"_Derecha_Quieto.png")){
				  if (Enemigo.Direccion_Enemigo() == "Derecha"){
				  	   NroAleatorio = -2;
					   }
				   //if ((Enemigo.img_enemigo == "/"+Enemigo.enemigo+"_Arriba.gif") ||(Enemigo.img_enemigo == "/"+Enemigo.enemigo+"_Arriba_Quieto.png")){
				  if (Enemigo.Direccion_Enemigo() == "Arriba"){
					   NroAleatorio = 1;
					   }
				   //if ((Enemigo.img_enemigo == "/"+Enemigo.enemigo+"_Abajo.gif") ||(Enemigo.img_enemigo == "/"+Enemigo.enemigo+"_Abajo_Quieto.png")){
				  if (Enemigo.Direccion_Enemigo() == "Abajo"){
					   NroAleatorio = 2;
					   }

				if (NroAleatorio == -1){
		 		//PosX = PosX + ((Random.nextInt(10)+22)*-1);
					DistanciaEmpuje = (Random.nextInt(10)+22)*-1;
					if (PixX + DistanciaEmpuje >= 20){
						PixX = PixX + DistanciaEmpuje;
					}
					else{
						NroAleatorio = -2;
					}
				}
				else if (NroAleatorio == -2){
					DistanciaEmpuje = (Random.nextInt(10)+22)*1;
					if (PixX + DistanciaEmpuje <= 560){
					PixX = PixX + DistanciaEmpuje;
					}
					else{
						NroAleatorio = 1;
					}
				}
				else if (NroAleatorio == 1){
					DistanciaEmpuje = (Random.nextInt(10)+22)*-1;
					if (PixY + DistanciaEmpuje >= 15){
					PixY = PixY + DistanciaEmpuje;
					}
					else{
						NroAleatorio = 2;
					}
				}
				else if (NroAleatorio == 2){
					DistanciaEmpuje = (Random.nextInt(10)+22)*1;
					if (PixY + DistanciaEmpuje <= 560){
					PixY = PixY + DistanciaEmpuje;
					}
					else{
						NroAleatorio = 3;
					}
				}
				DibujarPersonaje.personaje.Vida -=DibujarPersonaje.enemigo.Fuerza;
			   }
			   
			   else{
				   //if ((personaje == "/"+Jugador+"_Izquierda.gif") ||(personaje == "/"+Jugador+"_Izquierda_Quieto.png")){
				   if (Direccion_Jugador() == "Izquierda"){
					   NroAleatorio = -1;
					   }
				   //if ((personaje == "/"+Jugador+"_Derecha.gif") ||(personaje == "/"+Jugador+"_Derecha_Quieto.png")){
				   if (Direccion_Jugador() == "Derecha"){
					   NroAleatorio = -2;
					   }
				   //if ((personaje == "/"+Jugador+"_Arriba.gif") ||(personaje == "/"+Jugador+"_Arriba_Quieto.png")){
				   if (Direccion_Jugador() == "Arriba"){
					   NroAleatorio = 1;
					   }
				  // if ((personaje == "/"+Jugador+"_Abajo.gif") ||(personaje == "/"+Jugador+"_Arriba_Quieto.png")){
				   if (Direccion_Jugador() == "Abajo"){
					   NroAleatorio = 2;
					   }
				   if (NroAleatorio == -1){
				 		//PosX = PosX + ((Random.nextInt(10)+22)*-1);
							DistanciaEmpuje = (Random.nextInt(10)+22)*-1;
							if (Enemigo.CordX + DistanciaEmpuje >= 20){
								Enemigo.CordX = Enemigo.CordX + DistanciaEmpuje;
							}
							else{
								NroAleatorio = -2;
							}
						}
						else if (NroAleatorio == -2){
							DistanciaEmpuje = (Random.nextInt(10)+22)*1;
							if (Enemigo.CordX + DistanciaEmpuje <= 560){
								Enemigo.CordX = Enemigo.CordX + DistanciaEmpuje;
							}
							else{
								NroAleatorio = 1;
							}
						}
						else if (NroAleatorio == 1){
							DistanciaEmpuje = (Random.nextInt(10)+22)*-1;
							if (Enemigo.CordY + DistanciaEmpuje >= 15){
								Enemigo.CordY = Enemigo.CordY + DistanciaEmpuje;
							}
							else{
								NroAleatorio = 2;
							}
						}
						else if (NroAleatorio == 2){
							DistanciaEmpuje = (Random.nextInt(10)+22)*1;
							if (Enemigo.CordY + DistanciaEmpuje <= 560){
								Enemigo.CordY = Enemigo.CordY + DistanciaEmpuje;
							}
							else{
								NroAleatorio = 3;
							} 
						}
				   DibujarPersonaje.enemigo.Vida -=DibujarPersonaje.personaje.Fuerza;
			   }
		 		/*if (Random.nextInt(2) == 0) NroAleatorio = -1;
				else NroAleatorio = 1;*/
		 		
		 		
		 		
		 		if (MenuPrincipal.Sonido == "Con" )Sonidos.Lastimado.play();
		 }
	
	public int getPosX()
	{
		int Pos;
		int rest= PixX%20;
		if(rest==0)
		{
			Pos=PixX/20;
			
		}
		else
		{
			if(rest<10)
			{
				Pos= (PixX-rest)/20;
			}
			else
			{
				rest = 20-rest;
				int aux=PixX+rest;
				Pos=aux/20;
			}
		}
		return Pos;
	}
	public int getPosY()
	{
		int Pos;
		int rest= PixY%20;
		if(rest==0)
		{
			Pos=PixY/20;
			
		}
		else
		{
			if(rest<10)
			{
				Pos= (PixY-rest)/20;
			}
			else
			{
				rest = 20-rest;
				int aux=PixY+rest;
				Pos=aux/20;
			}
		}
		return Pos;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(PixX, PixY, 16, 20);
		
	}
	
	 public Image getImage()
	 {
		 if (Pega == false){
			 random_pega = Random.nextInt(2)+1;
		 if (MovX==0){
			 if (i == 0){
			 personaje = "/"+Jugador+"_Derecha_Quieto.png";
			 Jugador_Movimiento = "Derecha";
			 }
			 if (i == 1){
				 personaje = "/"+Jugador+"_Derecha_Quieto.png";
				 Jugador_Movimiento = "Derecha";
				 }
				 if (i == 2){
					 personaje = "/"+Jugador+"_Izquierda_Quieto.png";
					 Jugador_Movimiento = "Izquierda";
				}
				 if (i == 3){
					 personaje = "/"+Jugador+"_Abajo_Quieto.png";
					 Jugador_Movimiento = "Abajo";
					 }
				 if (i == 4){
					 personaje = "/"+Jugador+"_Arriba_Quieto.png";
					 Jugador_Movimiento = "Arriba";
					 }
			 
			 ImageIcon image_icon = new ImageIcon(this.getClass().getResource(personaje));
			 Imagen_Personaje = image_icon.getImage();
		 }
		 if (MovY==0){
			 if (i == 0){
				 personaje = "/"+Jugador+"_Abajo_Quieto.png";
				 Jugador_Movimiento = "Abajo";
			 }
			 if (i == 1){
				 personaje = "/"+Jugador+"_Derecha_Quieto.png";
				 Jugador_Movimiento = "Derecha";
			 }
			 if (i == 2){
				 personaje = "/"+Jugador+"_Izquierda_Quieto.png";
				 Jugador_Movimiento = "Izquierda";
			}
			 if (i == 3){
				 personaje = "/"+Jugador+"_Abajo_Quieto.png";
				 Jugador_Movimiento = "Abajo";
				 }
			 if (i == 4){
				 personaje = "/"+Jugador+"_Arriba_Quieto.png";
				 Jugador_Movimiento = "Arriba";
				 }
			 ImageIcon image_icon = new ImageIcon(this.getClass().getResource(personaje));
			 Imagen_Personaje = image_icon.getImage();
		 }
		 
		 if (MovX>0){
			 personaje = "/"+Jugador+"_Derecha.gif";
			 Jugador_Movimiento = "Derecha";
			 ImageIcon image_icon = new ImageIcon(this.getClass().getResource(personaje));
			 Imagen_Personaje = image_icon.getImage();
			 i = 1;
		 }
		 else if (MovX<0){
			 personaje = "/"+Jugador+"_Izquierda.gif";
			 Jugador_Movimiento = "Izquierda";
			 ImageIcon image_icon = new ImageIcon(this.getClass().getResource(personaje));
			 Imagen_Personaje = image_icon.getImage(); 
			 i = 2;
		 }
		 if (MovY>0){
			 personaje = "/"+Jugador+"_Abajo.gif";
			 Jugador_Movimiento = "Abajo";
			 ImageIcon image_icon = new ImageIcon(this.getClass().getResource(personaje));
			 Imagen_Personaje = image_icon.getImage();
			 i = 3;
		 }
		 else if (MovY<0){
			 personaje = "/"+Jugador+"_Arriba.gif";
			 Jugador_Movimiento = "Arriba";
			 ImageIcon image_icon = new ImageIcon(this.getClass().getResource(personaje));
			 Imagen_Personaje = image_icon.getImage(); 
			 i = 4;
		 }
	 }
		 if (Pega == true){

			 if (Jugador_Movimiento == "Derecha"){
				personaje = "/"+Jugador+"_Derecha_Pegar_1.png"; 
				ImageIcon image_icon = new ImageIcon(this.getClass().getResource(personaje));
				 Imagen_Personaje = image_icon.getImage();
			 }
			 else if (Jugador_Movimiento == "Izquierda"){
					personaje = "/"+Jugador+"_Izquierda_Pegar_2.png"; 
					ImageIcon image_icon = new ImageIcon(this.getClass().getResource(personaje));
					 Imagen_Personaje = image_icon.getImage();
				 }
			 else if (Jugador_Movimiento == "Abajo"){
					personaje = "/"+Jugador+"_Abajo_Pegar_"+ random_pega +".png"; 
					ImageIcon image_icon = new ImageIcon(this.getClass().getResource(personaje));
					 Imagen_Personaje = image_icon.getImage();
				 }
			 else if (Jugador_Movimiento == "Arriba"){
					personaje = "/"+Jugador+"_Arriba_Pegar_"+ random_pega +".png"; 
					ImageIcon image_icon = new ImageIcon(this.getClass().getResource(personaje));
					 Imagen_Personaje = image_icon.getImage();
				 }
			 if(Random.nextInt(100) == 50){
				 Pega = false;
			 }
		 }
		 return Imagen_Personaje;
		}
	 	 
	 public Image getImageVida(){
		 String img_vida = "/Vida.png";
		 ImageIcon image_icon = new ImageIcon(getClass().getResource(img_vida));
		 Image Imagen_Vida = image_icon.getImage(); 
		 return Imagen_Vida;
	 }
	 public Image getImageCara(){
		 String img_cara = "/"+Jugador+"_Cara.png";
		 ImageIcon image_cara = new ImageIcon(getClass().getResource(img_cara));
		 Image Imagen_Cara = image_cara.getImage(); 
		 return Imagen_Cara;
	 }
	 	
	 public void keyPressed(KeyEvent e)
	 {
		 if (DibujarPersonaje.Pausa == false){
		 Class clase;
		 
		 int key = e.getKeyCode();
		 
		 if (key == 38){
			 e.setKeyCode(e.VK_W);
		 }
		 if (key == 40){
			 e.setKeyCode(e.VK_S);
		 }
		 if (key == 37){
			 e.setKeyCode(e.VK_A);
		 }
		 if (key == 39){
			 e.setKeyCode(e.VK_D);
		 }

		 
			int colcont=0;
			int col1=0,col2=0;
			PosX=getPosX();
			PosY=getPosY();
			if(e.getKeyCode()==e.VK_W)//W
			{
				PixY=PixY-veloc;
				int a;
				if(getPosY()-1<0) a=0;
				else a=1;
				if(juego.Mapa.Map[getPosX()][getPosY()-a].colision(this)==true)
				{
					if(juego.Mapa.Map[getPosX()][getPosY()-a].walk==true)
					{
						MovY = -(veloc);
						PosY=getPosY();
					}
				}
				else
				{
					MovY = -(veloc);
					PosY=getPosY();
				}
				PixY=PixY+veloc;
				mirando=e.getKeyCode();
			}
			
			if(e.getKeyCode()==e.VK_A)//A
			{
				PixX=PixX-veloc;
				int a;
				int Pos=PixX/20;
				if(Pos-1<0) a=0;
				else a=1;
				if(juego.Mapa.Map[Pos-a][getPosY()].colision(this)==true)
				{
					if(juego.Mapa.Map[Pos-a][getPosY()].walk==true)
					{
						MovX = -(veloc);
						PosX=getPosX();
					}
				}
				else
				{
					MovX = -(veloc);
					PosX=getPosX();
				}
				PixX=PixX+veloc;
				mirando=e.getKeyCode();
			}
			
			if(e.getKeyCode()==e.VK_S)//s
			{
				PixY=PixY+veloc;
				
				if(juego.Mapa.Map[getPosX()][getPosY()+1].colision(this)==true)
				{
					if(juego.Mapa.Map[getPosX()][getPosY()+1].walk==true)
					{
						MovY = (veloc);
						PosY=getPosY();
					}
				}
				else
				{
					MovY = (veloc);
					PosY=getPosY();
				}
				PixY=PixY-veloc;
				mirando=e.getKeyCode();
			}
			
			if(e.getKeyCode()==e.VK_D)//d
			{
				PixX=PixX+veloc;
				int a;
				PosX=getPosX();
				if(PosX+1>=juego.Mapa.Map.length) a=0;
				else a=1;
				if(juego.Mapa.Map[getPosX()+a][getPosY()].colision(this)==true)
				{
					if(juego.Mapa.Map[getPosX()+a][getPosY()].walk==true)
					{
						MovX = (veloc);
						PosX=getPosX();
					}
				}
				else
				{
					MovX = (veloc);
					PosX=getPosX();
				}
				PixX=PixX-veloc;
				mirando=e.getKeyCode();
			}
	//-----------------------------------------------------------------------------------------
			if(e.getKeyCode()==e.VK_E)//e
			{
				if(mirando==87)//w W
				{
					clase= juego.Mapa.Map[PosX][PosY-1].getClass();
					
					if(clase.getName()=="Boton")
					{
						((Boton) juego.Mapa.Map[PosX][PosY-1]).Interactuar();
					}
					if(clase.getName()=="Esfera")
					{
						((Esfera) juego.Mapa.Map[PosX][PosY-1]).Empujar();
					}
				}
				if(mirando==68) // d D
				{
					clase= juego.Mapa.Map[PosX+1][PosY].getClass();
					
					if(clase.getName()=="Boton")
					{
						((Boton) juego.Mapa.Map[PosX+1][PosY]).Interactuar();
					}
					if(clase.getName()=="Esfera")
					{
						((Esfera) juego.Mapa.Map[PosX+1][PosY]).Empujar();
					}
				}
				if(mirando==65) // a A
				{
					clase= juego.Mapa.Map[PosX-1][PosY].getClass();
					
					if(clase.getName()=="Boton")
					{
						((Boton) juego.Mapa.Map[PosX-1][PosY]).Interactuar();
					}
					if(clase.getName()=="Esfera")
					{
						((Esfera) juego.Mapa.Map[PosX-1][PosY]).Empujar();
					}
				}
				if(mirando==83) // s S
				{
					clase= juego.Mapa.Map[PosX][PosY+1].getClass();
					
					if(clase.getName()=="Boton")
					{
						((Boton) juego.Mapa.Map[PosX][PosY+1]).Interactuar();
					}
					if(clase.getName()=="Esfera")
					{
						((Esfera) juego.Mapa.Map[PosX][PosY+1]).Empujar();
					}
				}
			}
			//---------------------------------------------------------------------------
			if(e.getKeyCode()==e.VK_P)//p
			{
				if (DibujarPersonaje.pelea == false) juego.loadMap();
			}
	 
	 }
			
	 }

	 public void keyReleased(KeyEvent e)
	 {
	 int key = e.getKeyCode();
	 if (key == 17){
		 if (Jugador != "Spidey") Pega = true;
			if (colisionEnemigo() == true){
				DibujarPersonaje.enemigo.danio("Enemigo");				
			}
			else{ 
				if ((MenuPrincipal.Sonido == "Con")&&(DibujarPersonaje.muerte == false)&&(DibujarPersonaje.ganar == false)&&(DibujarPersonaje.Pausa == false)) Sonidos.Pega_Aire.play();
			}
	 }
	 else Pega = false;
	 
	 if ((key == KeyEvent.VK_RIGHT)||(key == 68))
	 {
	 MovX = 0;
	 }
	 if ((key == KeyEvent.VK_LEFT)||(key == 65))
	 {
	 MovX = 0;
	 }
	 if ((key == KeyEvent.VK_UP)||(key == 87))
	 {
	 MovY = 0;
	 }
	 if ((key == KeyEvent.VK_DOWN)||(key == 83))
	 {
	 MovY = 0;
	 }     
	 }
	 
	 
	 public boolean colisionEnemigo() {
		 if (DibujarPersonaje.pelea == true) return DibujarPersonaje.enemigo.obtenerChoqueEnemigo().intersects(obtenerChoqueJugador());
		 else return false;
	 }
	 public Rectangle obtenerChoqueJugador() {
			return new Rectangle(PixX, PixY, ANCHO, ALTURA);
		}
	 public String Direccion_Jugador(){
		 return (Jugador_Movimiento);
	 }
	 public int getX()
	 {
	 return PixX;
	 }
	 public int getY()
	 {
	 return PixY;
	 }

	}
