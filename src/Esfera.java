
public class Esfera extends Objeto{

	public int cantMov;
	public Esfera(int tipo, int x, int y, int CM, Juego J)
	{ 
		super(6,x,y,J);
		cantMov=CM;
	}
	
	public void Empujar()
	{
		int Fpos;
		Class clase;
		if(juego.personaje.mirando==87 || juego.personaje.mirando==119)//w
		{
			Fpos=Y;
			for(int i = 0; i<cantMov;i++)
			{
				clase=juego.Mapa.Map[X][Y-(i+1)].getClass();
				if(juego.Mapa.Map[X][Y-(i+1)].walk==false||clase.getName()=="Escape")
				{
					break;
				}
				else
				{
					Fpos=Y-(i+1);
				}
			}
			
			/*do
			{
				juego.Mapa.Map[X][Y].PixY--;
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}while(juego.Mapa.Map[X][Y].PixY>Fpos*juego.Mapa.Map[X][Y].juego.tamañoObj);
			*/
			juego.Mapa.Map[X][Y]=new Objeto(1,X,Y,juego);
			this.Y=Fpos;
			juego.Mapa.Map[X][Y]=new Esfera(6,X,Y,cantMov,juego);
		}
		if(juego.personaje.mirando==68 || juego.personaje.mirando==100)//d
		{
			Fpos=X;
			for(int i = 0; i<cantMov;i++)
			{
				if(juego.Mapa.Map[X+(i+1)][Y].walk==false)
				{
					break;
				}
				else
				{
					Fpos=X+(i+1);
				}
			}
			/*
			do
			{
				juego.Mapa.Map[X][Y].PixX++;
			}while(juego.Mapa.Map[X][Y].PixX<Fpos*juego.Mapa.Map[X][Y].juego.tamañoObj);
			*/
			juego.Mapa.Map[X][Y]=new Objeto(1,X,Y,juego);
			this.X=Fpos;
			juego.Mapa.Map[X][Y]=new Esfera(6,X,Y,cantMov,juego);
		}
		if(juego.personaje.mirando==65 || juego.personaje.mirando==97)//a
		{
			Fpos=X;
			for(int i = 0; i<cantMov;i++)
			{
				if(juego.Mapa.Map[X-(i+1)][Y].walk==false)
				{
					break;
				}
				else
				{
					Fpos=X-(i+1);
				}
			}
			/*do
			{
				juego.Mapa.Map[X][Y].PixX--;
			}while(juego.Mapa.Map[X][Y].PixX>Fpos*juego.Mapa.Map[X][Y].juego.tamañoObj);
			*/
			juego.Mapa.Map[X][Y]=new Objeto(1,X,Y,juego);
			this.X=Fpos;
			juego.Mapa.Map[X][Y]=new Esfera(6,X,Y,cantMov,juego);
		}
		if(juego.personaje.mirando==83 || juego.personaje.mirando==115)//s
		{
			Fpos=Y;
			for(int i = 0; i<cantMov;i++)
			{
				if(juego.Mapa.Map[X][Y+(i+1)].walk==false)
				{
					break;
				}
				else
				{
					Fpos=Y+(i+1);
				}
			}
			/*do
			{
				juego.Mapa.Map[X][Y].PixY++;
			}while(juego.Mapa.Map[X][Y].PixY<Fpos*juego.Mapa.Map[X][Y].juego.tamañoObj);
			*/
			juego.Mapa.Map[X][Y]=new Objeto(1,X,Y,juego);
			this.Y=Fpos;
			juego.Mapa.Map[X][Y]=new Esfera(6,X,Y,cantMov,juego);
		}
	}
}
