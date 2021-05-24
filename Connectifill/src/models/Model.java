package models;

import java.util.ArrayList;

import graphics.Board;
import graphics.Game;

public abstract class Model {

	public Model() 
	{
		
	}
	
	public void makeMove()
	{
		
	}
	
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
