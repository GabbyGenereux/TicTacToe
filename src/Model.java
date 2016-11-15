
public class Model {
	
	int count;
	Player player;
	Player[][] yolo;
	Player winner;
	View v;
	
	public Model(View v)
	{
		this.v = v;
		yolo = new Player[3][3];
		count = 0;
		winner = null;
	}
	
	public void play(int i, int j)
	{
		yolo[i][j] = player;
		Player p = determineWinner();
		if(p != null)
		{
			winner = p;
			v.winner();
		}
	}

	public void reset()
	{
		yolo = new Player[3][3];
		count = 0;
		winner = null;
	}
	
	
	public Player determineWinner()
	{
		for(int k = 0; k<3;k++)
		{
			if(yolo[k][0] == yolo[k][1] && yolo[k][1] == yolo[k][2])
			{
				return yolo[k][k];
			}
		}
		
		for(int l = 0; l<3; l++)
		{
			if(yolo[0][l] == yolo[1][l] && yolo[1][l] == yolo[2][l])
			{
				return yolo[l][l];
			}
		}
		
		if(yolo[0][0] == yolo[1][1] && yolo[1][1] == yolo[2][2])
		{
			return yolo[0][0];
		}
		
		return null;
	}
	public Player getPlayerTurn()
	{
		//if count is even it's x, else it's o
		if(count%2 == 0)
		{
			//even
			player = Player.O;
		}
		else
		{
			//odd
			player = Player.X;
		}
		
		count++;
		return player;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player[][] getYolo() {
		return yolo;
	}

	public void setYolo(Player[][] yolo) {
		this.yolo = yolo;
	}

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

}
