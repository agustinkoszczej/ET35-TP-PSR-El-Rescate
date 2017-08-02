import javax.swing.ImageIcon;


public class Elec extends Objeto{
	public boolean estado;
	
	public Elec(int tipo, int x, int y, boolean est, Juego j) {
		super(3,x,y,j);
	
		estado=est;
		if(this.estado==true) this.setImage(new ImageIcon(this.getClass().getResource("/led_verde2.png")));
		else this.setImage(new ImageIcon(this.getClass().getResource("/led_rojo2.png")));
	}
	
	public void Activar()
	{
		Class clase;
		String Sclase;
		boolean arriba=false;
		boolean abajo=false;
		boolean derecha=false;
		boolean izquierda=false;
		
		if(this.estado==true) this.estado=false;
		else this.estado=true;
		
		if(Y-1>=0 && arriba==false){	
			clase=juego.Mapa.Map[X][Y-1].getClass();
			Sclase=clase.getName();
			if(Sclase.equals("Elec"))
			{
				arriba=true;
			}
			}
			if(Y+1<juego.Mapa.Map[X].length && abajo==false){
			clase=juego.Mapa.Map[X][Y+1].getClass();
			Sclase=clase.getName();
			if(Sclase.equals("Elec"))
			{
				abajo=true;
			}
			}
			if(X-1>=0 && izquierda==false){
			clase=juego.Mapa.Map[X-1][Y].getClass();
			Sclase=clase.getName();
			if(Sclase.equals("Elec"))
			{
				izquierda=true;
			}
			}
			if(X+1<juego.Mapa.Map.length && derecha==false)
			{
				
			clase=juego.Mapa.Map[X+1][Y].getClass();
			Sclase=clase.getName();
			if(Sclase.equals("Elec"))
			{
				derecha=true;
			}
			}
		//----------------------
		if(Y-2>=0 && arriba==false){	
			clase=juego.Mapa.Map[X][Y-2].getClass();
			Sclase=clase.getName();
			if(Sclase.equals("Elec"))
			{
				if(((Elec)juego.Mapa.Map[X][Y-2]).estado!=this.estado)
				{
					juego.Mapa.Map[X][Y-1]=new Objeto(2,X,Y-2,juego);
				}
				else
				{
					juego.Mapa.Map[X][Y-1]=new Objeto(1,X,Y-1,juego);
				}
				arriba=true;
			}
		}
			if(Y+2<juego.Mapa.Map[X].length && abajo==false){
			clase=juego.Mapa.Map[X][Y+2].getClass();
			Sclase=clase.getName();
			if(Sclase.equals("Elec"))
			{
				if(((Elec)juego.Mapa.Map[X][Y+2]).estado!=this.estado)
				{
					juego.Mapa.Map[X][Y+1]=new Objeto(2,X,Y+1,juego);
				}
				else
				{
					juego.Mapa.Map[X][Y+1]=new Objeto(1,X,Y+1,juego);
				}
				abajo=true;
			}
			}
			if(X-2>=0 && izquierda==false){
			clase=juego.Mapa.Map[X-2][Y].getClass();
			Sclase=clase.getName();
			if(Sclase.equals("Elec"))
			{
				if(((Elec)juego.Mapa.Map[X-2][Y]).estado!=this.estado)
				{
					juego.Mapa.Map[X-1][Y]=new Objeto(2,X-1,Y,juego);
				}
				else
				{
					juego.Mapa.Map[X-1][Y]=new Objeto(1,X-1,Y,juego);
				}
				izquierda=true;
			}
			}
			if(X+2<juego.Mapa.Map.length && derecha==false){
			clase=juego.Mapa.Map[X+2][Y].getClass();
			Sclase=clase.getName();
			if(Sclase.equals("Elec"))
			{
				if(((Elec)juego.Mapa.Map[X+2][Y]).estado!=this.estado)
				{
					juego.Mapa.Map[X+1][Y]=new Objeto(2,X+1,Y,juego);
				}
				else
				{
					juego.Mapa.Map[X+1][Y]=new Objeto(1,X+1,Y,juego);
				}
				derecha=true;
			}
			}
			//------------------------------------------------
		
		if(Y-3>=0& arriba==false){	
		clase=juego.Mapa.Map[X][Y-3].getClass();
		Sclase=clase.getName();
		if(Sclase.equals("Elec"))
		{
			if(((Elec)juego.Mapa.Map[X][Y-3]).estado!=this.estado)
			{
				juego.Mapa.Map[X][Y-2]=new Objeto(2,X,Y-2,juego);
				juego.Mapa.Map[X][Y-1]=new Objeto(2,X,Y-1,juego);
			}
			else
			{
				juego.Mapa.Map[X][Y-2]=new Objeto(1,X,Y-2,juego);
				juego.Mapa.Map[X][Y-1]=new Objeto(1,X,Y-1,juego);
			}
			arriba=true;
		}
		}
		if(Y+3<juego.Mapa.Map[X].length&&abajo==false){
		clase=juego.Mapa.Map[X][Y+3].getClass();
		Sclase=clase.getName();
		if(Sclase.equals("Elec"))
		{
			if(((Elec)juego.Mapa.Map[X][Y+3]).estado!=this.estado)
			{
				juego.Mapa.Map[X][Y+2]=new Objeto(2,X,Y+2,juego);
				juego.Mapa.Map[X][Y+1]=new Objeto(2,X,Y+1,juego);
			}
			else
			{
				juego.Mapa.Map[X][Y+2]=new Objeto(1,X,Y+2,juego);
				juego.Mapa.Map[X][Y+1]=new Objeto(1,X,Y+1,juego);
			}
			abajo=true;
		}
		}
		if(X-3>=0 && izquierda==false){
		clase=juego.Mapa.Map[X-3][Y].getClass();
		Sclase=clase.getName();
		if(Sclase.equals("Elec"))
		{
			if(((Elec)juego.Mapa.Map[X-3][Y]).estado!=this.estado)
			{
				juego.Mapa.Map[X-2][Y]=new Objeto(2,X-2,Y,juego);
				juego.Mapa.Map[X-1][Y]=new Objeto(2,X-1,Y,juego);
			}
			else
			{
				juego.Mapa.Map[X-2][Y]=new Objeto(1,X-2,Y,juego);
				juego.Mapa.Map[X-1][Y]=new Objeto(1,X-1,Y,juego);
			}
			izquierda=true;
		}
		}
		if(X+3<juego.Mapa.Map.length&&derecha==false){
		clase=juego.Mapa.Map[X+3][Y].getClass();
		Sclase=clase.getName();
		if(Sclase.equals("Elec"))
		{
			if(((Elec)juego.Mapa.Map[X+3][Y]).estado!=this.estado)
			{
				juego.Mapa.Map[X+2][Y]=new Objeto(2,X+2,Y,juego);
				juego.Mapa.Map[X+1][Y]=new Objeto(2,X+1,Y,juego);
			}
			else
			{
				juego.Mapa.Map[X+2][Y]=new Objeto(1,X+2,Y,juego);
				juego.Mapa.Map[X+1][Y]=new Objeto(1,X+1,Y,juego);
			}
			derecha=true;
		}
		}
		//------------------------------------------------
		if(Y-4>=0 && arriba==false){	
		clase=juego.Mapa.Map[X][Y-4].getClass();
		Sclase=clase.getName();
		if(Sclase.equals("Elec"))
		{
			if(((Elec)juego.Mapa.Map[X][Y-4]).estado!=this.estado)
			{
				juego.Mapa.Map[X][Y-3]=new Objeto(2,X,Y-3,juego);
				juego.Mapa.Map[X][Y-2]=new Objeto(2,X,Y-2,juego);
				juego.Mapa.Map[X][Y-1]=new Objeto(2,X,Y-1,juego);
			}
			else
			{
				juego.Mapa.Map[X][Y-3]=new Objeto(1,X,Y-3,juego);
				juego.Mapa.Map[X][Y-2]=new Objeto(1,X,Y-2,juego);
				juego.Mapa.Map[X][Y-1]=new Objeto(1,X,Y-1,juego);
			}
			arriba=true;
		}
		}
		if(Y+4<juego.Mapa.Map[X].length && abajo==false){
		clase=juego.Mapa.Map[X][Y+4].getClass();
		Sclase=clase.getName();
		if(Sclase.equals("Elec"))
		{
			if(((Elec)juego.Mapa.Map[X][Y+4]).estado!=this.estado)
			{
				juego.Mapa.Map[X][Y+3]=new Objeto(2,X,Y+3,juego);
				juego.Mapa.Map[X][Y+2]=new Objeto(2,X,Y+2,juego);
				juego.Mapa.Map[X][Y+1]=new Objeto(2,X,Y+1,juego);
			}
			else
			{
				juego.Mapa.Map[X][Y+3]=new Objeto(1,X,Y+3,juego);
				juego.Mapa.Map[X][Y+2]=new Objeto(1,X,Y+2,juego);
				juego.Mapa.Map[X][Y+1]=new Objeto(1,X,Y+1,juego);
			}
			abajo=true;
		}
		}
		if(X-4>=0 & izquierda==false){
		clase=juego.Mapa.Map[X-4][Y].getClass();
		Sclase=clase.getName();
		if(Sclase.equals("Elec"))
		{
			if(((Elec)juego.Mapa.Map[X-4][Y]).estado!=this.estado)
			{
				juego.Mapa.Map[X-3][Y]=new Objeto(2,X-3,Y,juego);
				juego.Mapa.Map[X-2][Y]=new Objeto(2,X-2,Y,juego);
				juego.Mapa.Map[X-1][Y]=new Objeto(2,X-1,Y,juego);
			}
			else
			{
				juego.Mapa.Map[X-3][Y]=new Objeto(1,X-3,Y,juego);
				juego.Mapa.Map[X-2][Y]=new Objeto(1,X-2,Y,juego);
				juego.Mapa.Map[X-1][Y]=new Objeto(1,X-1,Y,juego);
			}
			izquierda=true;
		}
		}
		if(X+4<juego.Mapa.Map.length && derecha==false){
		clase=juego.Mapa.Map[X+4][Y].getClass();
		Sclase=clase.getName();
		if(Sclase.equals("Elec"))
		{
			if(((Elec)juego.Mapa.Map[X+4][Y]).estado!=this.estado)
			{
				juego.Mapa.Map[X+3][Y]=new Objeto(2,X+3,Y,juego);
				juego.Mapa.Map[X+2][Y]=new Objeto(2,X+2,Y,juego);
				juego.Mapa.Map[X+1][Y]=new Objeto(2,X+1,Y,juego);
			}
			else
			{
				juego.Mapa.Map[X+3][Y]=new Objeto(1,X+3,Y,juego);
				juego.Mapa.Map[X+2][Y]=new Objeto(1,X+2,Y,juego);
				juego.Mapa.Map[X+1][Y]=new Objeto(1,X+1,Y,juego);
			}
			derecha=true;
		}
		}
		//------------------------------------
		if(Y-5>=0 && arriba==false){
		clase=juego.Mapa.Map[X][Y-5].getClass();
		Sclase=clase.getName();
		if(Sclase.equals("Elec"))
		{
			if(((Elec)juego.Mapa.Map[X][Y-5]).estado!=this.estado)
			{
				juego.Mapa.Map[X][Y-4]=new Objeto(2,X,Y-4,juego);
				juego.Mapa.Map[X][Y-3]=new Objeto(2,X,Y-3,juego);
				juego.Mapa.Map[X][Y-2]=new Objeto(2,X,Y-2,juego);
				juego.Mapa.Map[X][Y-1]=new Objeto(2,X,Y-1,juego);
			}
			else
			{
				juego.Mapa.Map[X][Y-4]=new Objeto(1,X,Y-4,juego);
				juego.Mapa.Map[X][Y-3]=new Objeto(1,X,Y-3,juego);
				juego.Mapa.Map[X][Y-2]=new Objeto(1,X,Y-2,juego);
				juego.Mapa.Map[X][Y-1]=new Objeto(1,X,Y-1,juego);
			}
			arriba=true;
		}
		}
		if(Y+5<juego.Mapa.Map[X].length && abajo==false){
		clase=juego.Mapa.Map[X][Y+5].getClass();
		Sclase=clase.getName();
		if(Sclase.equals("Elec"))
		{
			if(((Elec)juego.Mapa.Map[X][Y+5]).estado!=this.estado)
			{
				juego.Mapa.Map[X][Y+4]=new Objeto(2,X,Y+4,juego);
				juego.Mapa.Map[X][Y+3]=new Objeto(2,X,Y+3,juego);
				juego.Mapa.Map[X][Y+2]=new Objeto(2,X,Y+2,juego);
				juego.Mapa.Map[X][Y+1]=new Objeto(2,X,Y+1,juego);
			}
			else
			{
				juego.Mapa.Map[X][Y+4]=new Objeto(1,X,Y+4,juego);
				juego.Mapa.Map[X][Y+3]=new Objeto(1,X,Y+3,juego);
				juego.Mapa.Map[X][Y+2]=new Objeto(1,X,Y+2,juego);
				juego.Mapa.Map[X][Y+1]=new Objeto(1,X,Y+1,juego);
			}
			abajo=true;
		}
		}
		if(X-5>=0 && izquierda==false){
		clase=juego.Mapa.Map[X-5][Y].getClass();
		Sclase=clase.getName();
		if(Sclase.equals("Elec"))
		{
			if(((Elec)juego.Mapa.Map[X-5][Y]).estado!=this.estado)
			{
				juego.Mapa.Map[X-4][Y]=new Objeto(2,X-4,Y,juego);
				juego.Mapa.Map[X-3][Y]=new Objeto(2,X-3,Y,juego);
				juego.Mapa.Map[X-2][Y]=new Objeto(2,X-2,Y,juego);
				juego.Mapa.Map[X-1][Y]=new Objeto(2,X-1,Y,juego);
			}
			else
			{
				juego.Mapa.Map[X-4][Y]=new Objeto(1,X-4,Y,juego);
				juego.Mapa.Map[X-3][Y]=new Objeto(1,X-3,Y,juego);
				juego.Mapa.Map[X-2][Y]=new Objeto(1,X-2,Y,juego);
				juego.Mapa.Map[X-1][Y]=new Objeto(1,X-1,Y,juego);
			}
			izquierda=true;
		}
		}
		if(X+5<juego.Mapa.Map.length && derecha==false){
		clase=juego.Mapa.Map[X+5][Y].getClass();
		Sclase=clase.getName();
		if(Sclase.equals("Elec"))
		{
			if(((Elec)juego.Mapa.Map[X+5][Y]).estado!=this.estado)
			{
				juego.Mapa.Map[X+4][Y]=new Objeto(2,X+4,Y,juego);
				juego.Mapa.Map[X+3][Y]=new Objeto(2,X+3,Y,juego);
				juego.Mapa.Map[X+2][Y]=new Objeto(2,X+2,Y,juego);
				juego.Mapa.Map[X+1][Y]=new Objeto(2,X+1,Y,juego);
			}
			else
			{
				juego.Mapa.Map[X+4][Y]=new Objeto(1,X+4,Y,juego);
				juego.Mapa.Map[X+3][Y]=new Objeto(1,X+3,Y,juego);
				juego.Mapa.Map[X+2][Y]=new Objeto(1,X+2,Y,juego);
				juego.Mapa.Map[X+1][Y]=new Objeto(1,X+1,Y,juego);
			}
			derecha=true;
		}
		}
		if(this.estado==true) this.setImage(new ImageIcon(this.getClass().getResource("/led_verde2.png")));
		else this.setImage(new ImageIcon(this.getClass().getResource("/led_rojo2.png")));
	}
	
}
