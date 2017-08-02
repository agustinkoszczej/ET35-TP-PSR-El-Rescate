
public class Mapa6  extends Mapa{
	
	public Mapa6(Juego J)
	{
		juego=J;
		juego.tamañoObj=20;
		Map= new Objeto[30][30];
		int i=0;
		Map[i][0]= new Objeto(0,i,0,juego);
		Map[i][1]= new Objeto(0,i,1,juego);
		Map[i][2]= new Objeto(0,i,2,juego);
		Map[i][3]= new Objeto(0,i,3,juego);
		Map[i][4]= new Objeto(0,i,4,juego);
		Map[i][5]= new Objeto(0,i,5,juego);
		Map[i][6]= new Objeto(0,i,6,juego);
		Map[i][7]= new Objeto(0,i,7,juego);
		Map[i][8]= new Objeto(0,i,8,juego);
		Map[i][9]= new Objeto(0,i,9,juego);
		Map[i][10]= new Objeto(0,i,10,juego);
		Map[i][11]= new Objeto(0,i,11,juego);
		Map[i][12]= new Objeto(0,i,12,juego);
		Map[i][13]= new Objeto(0,i,13,juego);
		Map[i][14]= new Objeto(0,i,14,juego);
		Map[i][15]= new Objeto(0,i,15,juego);
		Map[i][16]= new Objeto(0,i,16,juego);
		Map[i][17]= new Objeto(0,i,17,juego);
		Map[i][18]= new Objeto(0,i,18,juego);
		Map[i][19]= new Objeto(0,i,19,juego);
		Map[i][20]= new Objeto(0,i,20,juego);
		Map[i][21]= new Objeto(0,i,21,juego);
		Map[i][22]= new Objeto(0,i,22,juego);
		Map[i][23]= new Objeto(0,i,23,juego);
		Map[i][24]= new Objeto(0,i,24,juego);
		Map[i][25]= new Objeto(0,i,25,juego);
		Map[i][26]= new Objeto(0,i,26,juego);
		Map[i][27]= new Objeto(0,i,27,juego);
		Map[i][28]= new Objeto(0,i,28,juego);
		Map[i][29]= new Objeto(0,i,29,juego);
		for(i=1;i<29;i++)
		{
			for(int j=0;j<30;j++)
			{
				if(j==0||j==29)
				{
					Map[i][j]= new Objeto(0,i,j,juego);
				}else
				{
					Map[i][j]= new Objeto(1,i,j,juego);
				}
			}
		}
		i=29;
		Map[i][0]= new Objeto(0,i,0,juego);
		Map[i][1]= new Objeto(0,i,1,juego);
		Map[i][2]= new Objeto(0,i,2,juego);
		Map[i][3]= new Objeto(0,i,3,juego);
		Map[i][4]= new Objeto(0,i,4,juego);
		Map[i][5]= new Objeto(0,i,5,juego);
		Map[i][6]= new Objeto(0,i,6,juego);
		Map[i][7]= new Objeto(0,i,7,juego);
		Map[i][8]= new Objeto(0,i,8,juego);
		Map[i][9]= new Objeto(0,i,9,juego);
		Map[i][10]= new Objeto(0,i,10,juego);
		Map[i][11]= new Objeto(0,i,11,juego);
		Map[i][12]= new Objeto(0,i,12,juego);
		Map[i][13]= new Objeto(0,i,13,juego);
		Map[i][14]= new Objeto(0,i,14,juego);
		Map[i][15]= new Objeto(0,i,15,juego);
		Map[i][16]= new Objeto(0,i,16,juego);
		Map[i][17]= new Objeto(0,i,17,juego);
		Map[i][18]= new Objeto(0,i,18,juego);
		Map[i][19]= new Objeto(0,i,19,juego);
		Map[i][20]= new Objeto(0,i,20,juego);
		Map[i][21]= new Objeto(0,i,21,juego);
		Map[i][22]= new Objeto(0,i,22,juego);
		Map[i][23]= new Objeto(0,i,23,juego);
		Map[i][24]= new Objeto(0,i,24,juego);
		Map[i][25]= new Objeto(0,i,25,juego);
		Map[i][26]= new Objeto(0,i,26,juego);
		Map[i][27]= new Objeto(0,i,27,juego);
		Map[i][28]= new Objeto(0,i,28,juego);
		Map[i][29]= new Objeto(0,i,29,juego);
		
		juego.personaje.PosX=15; juego.personaje.PosY=27; 
		juego.personaje.PixX=300; juego.personaje.PixY=540;
	}

}
