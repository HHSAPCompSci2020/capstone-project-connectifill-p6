package models;

import graphics.Game;

public class MiniMaxModel extends Model {
	
	private int[][] gridCopy;

	public MiniMaxModel() {
		gridCopy = Game.getBoard().getGrid();
	}

	public void makeMove() {
	}
	
	public int minimize(int[] weights)
	{
		return (Integer) null;
	}
	
	public int maximize(int[] weights)
	{
		return (Integer) null;
	}

}
