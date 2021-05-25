package models;

import java.util.ArrayList;
import graphics.Game;

/**
 * This is an abstract class representing a model
 * @author Rushil Jayant
 * @version 5/25/21
 */
public abstract class Model {
	
	/**
	 * Makes the next move based on method's methodology
	 */
	public void makeMove() {}
	
	/**
	 * @return Number of Valid Rows
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
