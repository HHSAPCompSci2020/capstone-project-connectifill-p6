package models;

import graphics.Board;
import graphics.Game;

public abstract class Model {
	
	private Board board;

	public Model() {
	}
	
	public abstract void makeMove();
	
	public int[] getValidMoves;
	{
		for (int i = 0; i < board.getWidth(); i++)
		{
			
		}
	}
}
