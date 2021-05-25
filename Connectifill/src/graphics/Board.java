package graphics;

public class Board 
{
	private int[][] grid;
	private int w;
	private int h;
	
	
	/**
	 * 
	 * @param width
	 * @param height
	 */
	public Board(int width, int height)
	{
		w = width;
		h = height;
		grid = new int[height][width];
	}
	
	/**
	 * 
	 * @return
	 */
	public int getWidth()
	{
		return w;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getHeight()
	{
		return h;
	}
	
	/**
	 * 
	 * @return
	 */
	public int[][] getGrid()
	{
		return grid;
	}
	
	/**
	 * 
	 * @param c
	 * @param r
	 * @return
	 */
	public int getValue(int c, int r)
	{
		return grid[c][r];
	}
	
	/**
	 * 
	 * @param player
	 * @return
	 */
	public int getScore(int player)
	{
		return getHorizontalScore(player) + getVerticalScore(player) + getDiagonalScore(player);
	}
	
	/**
	 * 
	 * @param column
	 * @param player
	 * @return
	 */
	public boolean add(int column, int player)
	{
		if (addable(column))
		{
			grid[nextOpenRow(column)][column] = player;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * 
	 * @param column
	 * @return
	 */
	public boolean addable(int column)
	{
		int filled = 0;
		for (int i = grid.length - 1; i >= 0; i--)
		{
			if (grid[i][column] != 0)
			{
				filled++;
			}
		}
		if (filled == grid.length)
		{
			return false;
		}
		return true;
	} 
	
	/**
	 * 
	 * @param column
	 * @return
	 */
	public int nextOpenRow(int column)
	{
		int filled = 1;
		for (int i = grid.length - 1; i >= 0; i--)
		{
			if (grid[i][column] == 0)
			{
				return (grid.length-filled);
			}
			if (grid[i][column] != 0)
			{
				filled++;
			}
		}
		return grid.length-1;
	}
	
	/**
	 * 
	 * @param player
	 * @return
	 */
	private int getHorizontalScore(int player)
	{
		int score = 0;
		for (int i = 0; i < grid[0].length-3; i++) // Hardcoded Need to fix
		{
			for (int j = 0; j < grid.length; j++)
			{
				if (grid[j][i] == player && grid[j][i + 1] == player && grid[j][i + 2] == player && grid[j][i + 3] == player)
				{
					score++;
				}
			}
		}
		return score;
	}
	
	/**
	 * 
	 * @param player
	 * @return
	 */
	private int getVerticalScore(int player)
	{
		int score = 0;
		for (int i = 0; i < grid[0].length; i++)
		{
			for (int j = 0; j < grid.length-3; j++) // Hardcoded Need to fix
			{
				if (grid[j][i] == player && grid[j + 1][i] == player && grid[j + 2][i] == player && grid[j + 3][i] == player)
				{
					score++;
				}
			}
		}
		return score;
	}
	
	/**
	 * 
	 * @param player
	 * @return
	 */
	private int getDiagonalScore(int player)
	{
		int score = 0;
		for (int i = 0; i < grid.length-3; i++) // Hardcoded Need to fix
		{
			for (int j = 0; j < grid[0].length-3; j++)
			{
				if (grid[i][j] == player && grid[i + 1][j + 1] == player && grid[i + 2][j + 2] == player && grid[i + 3][j + 3] == player)
				{
					score++;
				}
			}
		}
		for (int x = 3; x < grid[0].length; x++) // Hardcoded Need to fix
		{
			for (int y = 0; y < grid.length-3; y++)
			{
				if (grid[y][x] == player && grid[y + 1][x - 1] == player && grid[y + 2][x - 2] == player && grid[y + 3][x - 3] == player)
				{
					score++;
				}
			}
		}
		return score;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isFull()
	{
		for (int[] r : grid)
		{
			for (int c : r)
			{
				if (c == 0)
				{
					return false;
				}
			}
		}
		return true;
	}
}
