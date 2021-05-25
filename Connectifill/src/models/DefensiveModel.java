package models;

import java.util.ArrayList;

import graphics.Game;

public class DefensiveModel extends Model {

	public DefensiveModel() {
		// TODO Auto-generated constructor stub
	}

	public void makeMove() {
		ArrayList<Integer> imminentColumns = getImminent();
		ArrayList<Integer> defensiveRows = getDefensiveRows();
		ArrayList<Integer> defensiveColumns = getDefensiveColumns();
		ArrayList<Integer> aggressiveRows = getContinuingRows();
		ArrayList<Integer> validRows = getValidRows();
		
		if (imminentColumns.size() != 0)
		{
			Game.getBoard().add(imminentColumns.get((int) (Math.random() * imminentColumns.size())), 2);
		}
		else if (defensiveRows.size() != 0)
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

		for (int x = 0; x < Game.getBoard().getGrid()[0].length; x++) {
			try
			{
				if (Game.getBoard().getGrid()[Game.getBoard().nextOpenRow(x) + 1][x] == 1 && Game.getBoard().getGrid()[Game.getBoard().nextOpenRow(x) + 2][x] == 1)
				{
					columns.add(x);
					return columns;
				}
			} catch (ArrayIndexOutOfBoundsException ex) {}
		}

		for (int[] r : Game.getBoard().getGrid())
		{
			for (int i = 0; i < r.length; i++)
			{
				if (r[i] == 0)
				{
					if (checkRight(r, i) + checkLeft(r, i) >= 2)
					{
						columns.add(i);
					}
				}
			}
		}

		return columns;
	}
	
	private int checkRight(int[] r , int i)
	{
		int count = 0;
		try
		{
			if (r[i + 1] == 1)
			{
				count++;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {}
		
		try
		{
			if (r[i + 2] == 1)
			{
				count++;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {}
		try
		{
			if (r[i + 3] == 1)
			{
				count++;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {}
	
		return count;
	
	}
	
	private int checkLeft(int[] r , int i)
	{
		int count = 0;
		try
		{
			if (r[i - 1] == 1)
			{
				count++;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {}
		
		try
		{
			if (r[i - 2] == 1)
			{
				count++;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {}
		try
		{
			if (r[i - 3] == 1)
			{
				count++;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {}
	
		return count;
	
	}
	
	{
		Game.getBoard();
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
