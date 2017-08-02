import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import java.util.Random;

public class Enemigo extends Personaje {
	public static int VELOCIDAD_SEGUIR = 20;
	public static int VELOCIDAD_PEGAR = 150;
	
	
	
	public static int MovX = 1;
	public static int MovY = 1;
	public static int CordX = 200;
	public static int CordY = 100;
	private int k;
	private Image Imagen_Enemigo;
	private static int fuerza = 1;
	public static String enemigo = "Enemigo1";
	public static int Vida = 3;
	private static final int ALTURA = 26;
	private static final int ANCHO = 26;
	private static final int RANGOVISION = 650;
	public static String Enemigo_Movimiento = "";
	public static boolean pegaenemigo = false;
	
	public static String img_enemigo = "/"+enemigo+"Abajo_Quieto.png";
	private int j = 0;
	
	private static Random Random = new Random();
	
	public Enemigo () {
		super(enemigo, MovX, Vida, fuerza);
	}
	public boolean seguir(int PosX, int PosY)
		{	
		//Cuanto mas pequeño sea el Random mas rapido se mueve
		//this.Cord/Y = Donde esta el Enemigo |||| PosX/Y = Donde esta el Jugador//
		if (((this.CordX - 20 > PosX) && (this.CordY - 20 > PosY) && (this.CordX - RANGOVISION <= PosX) && (this.CordY - RANGOVISION <= PosY)) ||
			((this.CordX - 20 > PosX) && (this.CordY - 20 < PosY) && (this.CordX - RANGOVISION <= PosX) && (this.CordY + RANGOVISION >= PosY)) ||
			((this.CordX - 20 < PosX) && (this.CordY - 20 > PosY) && (this.CordX + RANGOVISION >= PosX) && (this.CordY - RANGOVISION <= PosY)) ||
			((this.CordX - 20 < PosX) && (this.CordY - 20 < PosY) && (this.CordX + RANGOVISION >= PosX) && (this.CordY + RANGOVISION >= PosY)))
			{	
		if (Random.nextInt(VELOCIDAD_SEGUIR) == 1){
			if (DibujarPersonaje.NivelJugando == 3){
			MovX = 1;
			MovY = 1;
			}
			else if (DibujarPersonaje.NivelJugando == 6){
				MovX = 2;
				MovY = 2;
			}
			else if (DibujarPersonaje.NivelJugando == 9){
				MovX = 3;
				MovY = 3;
			}
		if (this.CordX+20 < PosX)
		{
			if (DibujarPersonaje.NivelJugando == 3){
				MovX = 1;
				MovY = 0;
				}
				else if (DibujarPersonaje.NivelJugando == 6){
					MovX = 2;
					MovY = 0;
				}
				else if (DibujarPersonaje.NivelJugando == 9){
					MovX = 3;
					MovY = 0;
				}

			this.CordX += MovX;
		}
		
		else if (this.CordX-20 > PosX)
		{
			if (DibujarPersonaje.NivelJugando == 3){
				MovX = -1;
				MovY = 0;
				}
				else if (DibujarPersonaje.NivelJugando == 6){
					MovX = -2;
					MovY = 0;
				}
				else if (DibujarPersonaje.NivelJugando == 9){
					MovX = -3;
					MovY = 0;
				}

				this.CordX += MovX;
		}
		if (this.CordY+20 < PosY)
		{
			if (DibujarPersonaje.NivelJugando == 3){
				MovX = 0;
				MovY = 1;
				}
				else if (DibujarPersonaje.NivelJugando == 6){
					MovX = 0;
					MovY = 2;
				}
				else if (DibujarPersonaje.NivelJugando == 9){
					MovX = 0;
					MovY = 3;
				}	

			this.CordY += MovY;
		}
		else if (this.CordY-20 > PosY)
		{
			if (DibujarPersonaje.NivelJugando == 3){
				MovX = 0;
				MovY = -1;
				}
				else if (DibujarPersonaje.NivelJugando == 6){
					MovX = 0;
					MovY = -2;
				}
				else if (DibujarPersonaje.NivelJugando == 9){
					MovX = 0;
					MovY = -3;
				}
			this.CordY += MovY;
		}
		}
		
		else {
			MovX = 0;
			MovY = 0;
		}
	return (true);	
	}
		else{
			return (false);
		}
	
		//System.out.println("Enemigo X = "+this.PosX+"\tEnemigo Y = "+this.PosY);
		//System.out.println("Jugador X = "+PosX+"\tJugador Y = "+PosY);
		}
	public boolean pega(int PosX, int PosY){
		
				if ((((this.CordX <= PosX) && (this.CordX >= PosX -28) && (this.CordY <= PosY) && (this.CordY >= PosY -28)) || 
				((this.CordX >= PosX) && (this.CordX -28 <= PosX) && (this.CordY >= PosY) && (this.CordY -28 <= PosY)) || 
				((this.CordX >= PosX) && (this.CordX -28 <= PosX) && (this.CordY <= PosY) && (this.CordY >= PosY -28)) ||
				((this.CordX <= PosX) && (this.CordX >= PosX -28) && (this.CordY >= PosY) && (this.CordY -28 <= PosY))) && (Random.nextInt(VELOCIDAD_PEGAR) == 1)) {
			if ((MenuPrincipal.Sonido == "Con")&&(DibujarPersonaje.curo == false)) Sonidos.Golpe.play();
			pegaenemigo = true;
        	return (true);
		}
		else{
		return (false);	
	}
	}
	public Image getImageEnemigoQuieto(){
	//if (pegaenemigo == false){
		if (j == 0){
			 img_enemigo = "/"+enemigo+"_Derecha_Quieto.png";
			 }
			 if (j == 1){
				 img_enemigo = "/"+enemigo+"_Derecha_Quieto.png";
				 }
				 if (j == 2){
					 img_enemigo = "/"+enemigo+"_Izquierda_Quieto.png";
				}
				 if (j == 3){
					 img_enemigo = "/"+enemigo+"_Abajo_Quieto.png";
					 }
				 if (j == 4){
					 img_enemigo = "/"+enemigo+"_Arriba_Quieto.png";
					 }
		/*}
		else{
				 if (Jugador_Movimiento == "Derecha"){
						img_enemigo = "/"+enemigo+"_Derecha_Pegar_1.png"; 
					 }
					 else if (Jugador_Movimiento == "Izquierda"){
						 img_enemigo = "/"+enemigo+"_Izquierda_Pegar_2.png"; 
						 }
					 else if (Jugador_Movimiento == "Abajo"){
						 img_enemigo = "/"+enemigo+"_Abajo_Pegar_"+ random_pega +".png"; 
						 }
					 else if (Jugador_Movimiento == "Arriba"){
						 img_enemigo = "/"+enemigo+"_Arriba_Pegar_"+ random_pega +".png"; 
						 }
					 if(Random.nextInt(100) == 50){
						 pegaenemigo = false;
					 }
		}*/

	ImageIcon image_icon = new ImageIcon(this.getClass().getResource(img_enemigo));
	 Imagen_Enemigo = image_icon.getImage();
	 return (Imagen_Enemigo);
	}
	public Image getImageEnemigo(){
		//img_enemigo = img_enemigo;
		//if (pegaenemigo == false){
		if (MovX > 0){
			img_enemigo = "/"+enemigo+"_Derecha.gif";
			Enemigo_Movimiento = "Derecha";
			j = 1;
		}
		else if (MovX < 0){
			img_enemigo = "/"+enemigo+"_Izquierda.gif";
			Enemigo_Movimiento = "Izquierda";
			j = 2;
		}
		else if (MovY > 0){
			img_enemigo = "/"+enemigo+"_Abajo.gif";
			Enemigo_Movimiento = "Abajo";
			j = 3;
		}
		else if (MovY < 0){
			img_enemigo = "/"+enemigo+"_Arriba.gif";
			Enemigo_Movimiento = "Arriba";
			j = 4;
		}
		else{
			if (j == 0){
				 img_enemigo = "/"+enemigo+"_Derecha.gif";
				 Enemigo_Movimiento = "Derecha";
				 }
				 if (j == 1){
					 img_enemigo = "/"+enemigo+"_Derecha.gif";
					 Enemigo_Movimiento = "Derecha";
					 }
					 if (j == 2){
						 img_enemigo = "/"+enemigo+"_Izquierda.gif";
						 Enemigo_Movimiento = "Izquierda";
					}
					 if (j == 3){
						 img_enemigo = "/"+enemigo+"_Abajo.gif";
						 Enemigo_Movimiento = "Abajo";
						 }
					 if (j == 4){
						 img_enemigo = "/"+enemigo+"_Arriba.gif";
						 Enemigo_Movimiento = "Arriba";
						 }
		}
		/*}
		else{
			 if (Jugador_Movimiento == "Derecha"){
					img_enemigo = "/"+enemigo+"_Derecha_Pegar_1.png"; 
				 }
				 else if (Jugador_Movimiento == "Izquierda"){
					 img_enemigo = "/"+enemigo+"_Izquierda_Pegar_2.png"; 
					 }
				 else if (Jugador_Movimiento == "Abajo"){
					 img_enemigo = "/"+enemigo+"_Abajo_Pegar_"+ random_pega +".png"; 
					 }
				 else if (Jugador_Movimiento == "Arriba"){
					 img_enemigo = "/"+enemigo+"_Arriba_Pegar_"+ random_pega +".png"; 
					 }
				 if(Random.nextInt(100) == 50){
					 pegaenemigo = false;
				 }
	}*/
		ImageIcon image_icon = new ImageIcon(this.getClass().getResource(img_enemigo));
		 Imagen_Enemigo = image_icon.getImage();
		 return (Imagen_Enemigo);
	}
	
	public int getPosiX()
	 {
	 return CordX;
	 }
	 public int getPosiY()
	 {
	 return CordY;
	 }
	 
	 public static String Direccion_Enemigo (){
		 return (Enemigo_Movimiento);
	 }
	 public Rectangle obtenerChoqueEnemigo() {
			return new Rectangle(CordX, CordY, ANCHO, ALTURA);
		}
	 public Image getImageCaraEnemigo(){
		 String img_cara = "/"+enemigo+"_Cara.png";
		 ImageIcon image_cara = new ImageIcon(getClass().getResource(img_cara));
		 Image Imagen_Cara = image_cara.getImage(); 
		 return Imagen_Cara;
	 }
	 
}
