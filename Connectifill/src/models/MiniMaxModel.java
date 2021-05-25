package models;

import graphics.Game;

public class MiniMaxModel extends Model {

	private int[][] grid;

	public MiniMaxModel() {
		grid = Game.getBoard().getGrid();
	}

	public void makeMove() {
	}

	public int minimize(int[] weights)
	{
		int min = Integer.MAX_VALUE;
		for (int i : weights)
		{
			if (i < min)
			{
				min = i;
			}
		}
		
		return min;
	}

	public int maximize(int[] weights)
	{
		int max = Integer.MIN_VALUE;
		for (int i : weights)
		{
			if (i > max)
			{
				max = i;
			}
		}
		
		return max
	}

	public int[][] add(int column, int player, int[][] oldGrid)
	{
		int[][] grid = new int[oldGrid.length][oldGrid[0].length];
		for (int i = 0; i < grid.length; i++)
		{
			for (int j = 0; j < grid[0].length; j++)
			{
				grid[i][j] = oldGrid[i][j];
			}
		}
		
		grid[nextOpenRow(column, grid)][column] = player;
		
		return grid;
	}
	
	public boolean addable(int column, int[][] grid)
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
	
	public int nextOpenRow(int column, int[][] grid)
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
	
	public int getScore(int player, int[][] grid)
	{
		return getHorizontalScore(player, grid) + getVerticalScore(player, grid) + getDiagonalScore(player, grid);
	}

	private int getHorizontalScore(int player, int[][] grid)
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

	private int getVerticalScore(int player, int[][] grid)
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

	private int getDiagonalScore(int player, int[][] grid)
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
}
