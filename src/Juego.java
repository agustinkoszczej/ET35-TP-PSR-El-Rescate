public class Juego {
	public int lvl;
	// public Objeto[][] Map;
	public Personaje personaje;
	public int tamañoObj;
	public Mapa Mapa;
	public DibujarPersonaje DP;

	public Juego(Personaje p, DibujarPersonaje Dp) {
		lvl = 1;
		personaje = p;
		DP=Dp;
		Mapa = new Mapa1(this);

	}

	public void SigNivel() {
		lvl++;
		loadMap();
	}

	public void loadMap() {
		switch (lvl) {
		case 1:
			Mapa = new Mapa1(this);
			break;
		case 2:
			Mapa = new Mapa2(this);
			break;
		case 3:
			Mapa = new Mapa3(this);
			break;
		case 4:
			Mapa = new Mapa4(this);
			break;
		case 5:
			Mapa = new Mapa5(this);
			break;
		case 6:
			Mapa = new Mapa6(this);
			break;
		case 7:
			Mapa = new Mapa7(this);
			break;
		case 8:
			Mapa = new Mapa8(this);
			break;
		case 9:
			Mapa = new Mapa9(this);
			break;
		}
	}
}
