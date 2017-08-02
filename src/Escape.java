
public class Escape extends Objeto{

	public Escape(int tipo, int x, int y, Juego J) {
		super(7, x, y, J);
		// TODO Auto-generated constructor stub
	}
	public void Escapar()
	{
		juego.SigNivel();
	}

}
