
public class Boton extends Objeto{

	private Elec[] Conectados;
	private int cantElec;
	
	public Boton(int tipo,int X,int Y,Juego j) {
		super(4,X,Y,j);
		cantElec=0;
		// TODO Auto-generated constructor stub
	}
	
	public void conectar (Elec A)
	{
		
		if(cantElec!=0)
		{
			Elec[] aux = new Elec[cantElec];
			for(int i=0;i<cantElec;i++)
			{
				aux[i]=Conectados[i];
			}
			
			Conectados = new Elec[cantElec+1];
			for(int i=0;i<cantElec;i++)
			{
				Conectados[i]=aux[i];
			}
		}
		else
		{
			Conectados = new Elec[1];
		}
		Conectados[cantElec]=A;
		cantElec++;
		
		
		
	}
	public void Interactuar()
	{
		for(int i=0;i<cantElec;i++)
		{
			((Elec)juego.Mapa.Map[Conectados[i].X][Conectados[i].Y]).Activar();
		}
	}

}
