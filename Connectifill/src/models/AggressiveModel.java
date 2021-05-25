package models;

import java.util.ArrayList;

import graphics.Game;

public class AggressiveModel extends Model {
	
	/**
	 * 
	 */
	public void makeMove() {
		ArrayList<Integer> imminentColumns = getImminent();
		ArrayList<Integer> continuingRows = getContinuingRows();
		ArrayList<Integer> emptyRows = getEmptyRows();
		ArrayList<Integer> validRows = getValidRows();

		if (imminentColumns.size() != 0)
		{
			Game.getBoard().add(imminentColumns.get((int) (Math.random() * (imminentColumns.size()))), 2);
		}
		else if (continuingRows.size() != 0)
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

	/**
	 * 
	 * @return
	 */
	private ArrayList<Integer> getImminent()
	{
		ArrayList<Integer> columns = new ArrayList<Integer>();

		for (int x = 0; x < Game.getBoard().getGrid()[0].length; x++) {
			try
			{
				if (Game.getBoard().getGrid()[Game.getBoard().nextOpenRow(x) + 1][x] == 1 && Game.getBoard().getGrid()[Game.getBoard().nextOpenRow(x) + 2][x] == 1 && Game.getBoard().getGrid()[Game.getBoard().nextOpenRow(x) + 3][x] == 1)
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

	/**
	 * 
	 * @param r
	 * @param i
	 * @return
	 */
	private int checkRight(int[] r , int i)
	{
		int count = 0;
		try
		{
			if (r[i + 1] == 1)
			{
				count++;
			}
			else
			{
				return count;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {}

		try
		{
			if (r[i + 2] == 1)
			{
				count++;
			}
			else
			{
				return count;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {}
		try
		{
			if (r[i + 3] == 1)
			{
				count++;
			}
			else
			{
				return count;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {}

		return count;

	}

	/**
	 * 
	 * @param r
	 * @param i
	 * @return
	 */
	private int checkLeft(int[] r , int i)
	{
		int count = 0;
		try
		{
			if (r[i - 1] == 1)
			{
				count++;
			}
			else
			{
				return count;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {}

		try
		{
			if (r[i - 2] == 1)
			{
				count++;
			}
			else
			{
				return count;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {}
		try
		{
			if (r[i - 3] == 1)
			{
				count++;
			}
			else
			{
				return count;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {}

		return count;

	}

	/**
	 * 
	 * @return
	 */
	private ArrayList<Integer> getContinuingRows()
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

	/**
	 * 
	 * @return
	 */
	private ArrayList<Integer> getEmptyRows()
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
