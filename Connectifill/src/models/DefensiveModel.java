package models;

import java.util.ArrayList;

import graphics.Game;

public class DefensiveModel extends Model {

	public DefensiveModel() {
		// TODO Auto-generated constructor stub
	}

	public void makeMove() {
		ArrayList<Integer> defensiveRows = getDefensiveRows();
		ArrayList<Integer> defensiveColumns = getDefensiveColumns();
		ArrayList<Integer> aggressiveRows = getContinuingRows();
		ArrayList<Integer> validRows = getValidRows();
		if (defensiveRows.size() != 0)
		{
			Game.getBoard().add(defensiveRows.get((int) (Math.random() * defensiveRows.size())), 2);
		}
		else if (defensiveColumns.size() != 0)
		{
			Game.getBoard().add(defensiveColumns.get((int) (Math.random() * defensiveColumns.size())), 2);
		}
		else if (aggressiveRows.size() != 0)
		{
			Game.getBoard().add(aggressiveRows.get((int) (Math.random() * aggressiveRows.size())), 2);
		}
		else if (validRows.size() != 0)
		{
			Game.getBoard().add(validRows.get((int) (Math.random() * validRows.size())), 2);
		}
	}

	public ArrayList<Integer> getDefensiveRows()
	{
		ArrayList<Integer> columns = new ArrayList<Integer>();

		for (int i : getValidRows())
		{
			try{
				if (Game.getBoard().getGrid()[Game.getBoard().nextOpenRow(i)+1][i] == 1)
				{
					columns.add(i);
				}
			} catch (ArrayIndexOutOfBoundsException ex){}
		}

		return columns;
	}

	public ArrayList<Integer> getImminent()
	{
		ArrayList<Integer> columns = new ArrayList<Integer>();
		
		int enemies = 0;
		
		for (int[] r : Game.getBoard().getGrid())
		{
			for (int i = 0; i < r.length; i++)
			{
				if (r[i] == 0)
				{
					// Check Left
					
					// Check Right
				}
			}
		}
		
		return columns;
	}
	public ArrayList<Integer> getDefensiveColumns()
	{
		ArrayList<Integer> columns = new ArrayList<Integer>();

		for (int i : getValidRows())
		{
			try{
				if (Game.getBoard().getGrid()[Game.getBoard().nextOpenRow(i)+1][i] == 1 && (Game.getBoard().getGrid()[Game.getBoard().nextOpenRow(i)+1][i + 1] == 1) || Game.getBoard().getGrid()[Game.getBoard().nextOpenRow(i)+1][i - 1] == 1)
				{
					columns.add(i);
				}
			} catch (ArrayIndexOutOfBoundsException ex){}
		}

		return columns;
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
}
