package models;

import java.util.ArrayList;

import graphics.Game;

public class AggressiveModel extends Model {

	public AggressiveModel() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void makeMove() {
		ArrayList<Integer> continuingRows = getContinuingRows();
		ArrayList<Integer> emptyRows = getEmptyRows();
		ArrayList<Integer> validRows = getValidRows();
		if (continuingRows.size() != 0)
		{
			Game.getBoard().add(continuingRows.get((int) (Math.random() * continuingRows.size())), 2);
		}
		else if (emptyRows.size() != 0)
		{
			Game.getBoard().add(emptyRows.get((int) (Math.random() * emptyRows.size())), 2);
		}
		else if (validRows.size() != 0)
		{
			Game.getBoard().add(validRows.get((int) (Math.random() * validRows.size())), 2);
		}
	}

	public ArrayList<Integer> getContinuingRows()
	{
		ArrayList<Integer> rows = new ArrayList<Integer>();

		for (int i : getValidRows())
		{
			try
			{
				if (Game.getBoard().getGrid()[Game.getBoard().nextOpenRow(i)+1][i] == 2)
				{
					rows.add(i);
				}
			} catch (ArrayIndexOutOfBoundsException ex)
			{

			}
		}

		return rows;
	}
	
	// COMPLETE THIS METHOD
	public ArrayList<Integer> getContinuingColumns()
	{
		ArrayList<Integer> rows = new ArrayList<Integer>();

		return rows;
	}

	public ArrayList<Integer> getEmptyRows()
	{
		ArrayList<Integer> rows = new ArrayList<Integer>();

		for (int i : getValidRows())
		{
			if (Game.getBoard().getGrid()[Game.getBoard().getGrid().length-1][i] == 0)
			{
				rows.add(i);
			}
		}

		return rows;
	}
}
