import java.awt.Rectangle;
import javax.swing.ImageIcon;
public class Objeto {

	public int Tipo;
	public boolean walk;
	public int X,Y;
	public int PixX,PixY;
	public Juego juego;
	public ImageIcon imagen;
	
	//-1 = PJ
	//0 = pared
	//1 = nada
	//2 = Pared de Elec
	//3 = electrodo -
	//4 = boton
	//5 = pared invisible
	//6 = esfera
	//7 = escape

	

	public Objeto(int tipo, int x, int y, Juego J) {
		this.Tipo=tipo;
		if(tipo==0)
		{
			walk=false;
			setImage(new ImageIcon(this.getClass().getResource("/pared4_3.png")));
		}
		if(tipo==1)
		{
			walk=true;
			setImage(new ImageIcon(this.getClass().getResource("/piso 2.png")));
		}
		if(tipo==2)
		{
			walk=false;
			setImage(new ImageIcon(this.getClass().getResource("/paredmedio.png")));
		}
		if(tipo==3) walk=false;
		if(tipo==4) 
		{
			walk=false;
			setImage(new ImageIcon(this.getClass().getResource("/boton_sin_apretar.png")));
		}
		if(tipo==5) 
		{
			//setImage(new ImageIcon(this.getClass().getResource("/piso 2.png")));
			walk=false;
		}
		if(tipo==6) 
		{
			walk=false;
			setImage(new ImageIcon(this.getClass().getResource("/Esfera.png")));
		}
		if(tipo==7) 
		{
			walk=true;
		}
		this.X=x;
		this.Y=y;
		juego=J;
		PixX=X*juego.tamañoObj;
		PixY=Y*juego.tamañoObj;
		
	}
	
	public void setImage(ImageIcon imagen)
	{
		this.imagen=imagen;
	}
	
	public Rectangle getBounds() {
		int T = juego.tamañoObj;
		return new Rectangle(PixX, PixY, T, T);
	}
	
	public boolean colision(Personaje P) {
		return P.getBounds().intersects(getBounds());
	}
	
	public int getTopY() {
		return Y*20 - 20 -6;
	}
	public int getBotY() {
		return Y*20 + 20 -6;
	}
	public int getLeftX() {
		return X*20-16;
	}
	public int getRightX() {
		return X*20 + 20;
	}
}
