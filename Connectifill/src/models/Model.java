package models;

import java.util.ArrayList;
import graphics.Game;

public abstract class Model {
	
	/**
	 * 
	 */
	public void makeMove() {}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Integer> getValidRows()
	{
		ArrayList<Integer> validRows = new ArrayList<Integer>();
		
		for (int i = 0; i < Game.getBoard().getWidth(); i++)
		{
			if (Game.getBoard().addable(i))
			{
				validRows.add(i);
			}
		}
		
		return validRows;
	}
}
