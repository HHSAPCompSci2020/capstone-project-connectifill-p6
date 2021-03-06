package models;

import graphics.Game;

public class MiniMaxModel extends Model {

	private int[][] grid;
	private int depth; 

	/**
	 * Constructor for class initializing grid and depth
	 */
	public MiniMaxModel() {
		grid = Game.getBoard().getGrid();
		depth = 2;
	}
	/**
	 * Makes a certain move
	 */
	public void makeMove() 
	{
		grid = Game.getBoard().getGrid();
		int[] minimax = minimax(1, depth, grid);
		int location = 0;
		int max = 0;
		for (int i = 0; i < minimax.length; i++)
		{
			if (minimax[i] >= max)
			{
				max = minimax[i];
				location = i;
			}
		}
		Game.getBoard().add(location, 2);
		grid = Game.getBoard().getGrid();
	}

	/**
	 * 
	 * @param state
	 * @param depth
	 * @param grid
	 * @return
	 */
	public int[] minimax(int state, int depth, int[][] grid)
	{
		int[] weights = new int[grid[0].length];
		for (int i = 0; i < grid[0].length; i++)
		{
			if (depth == 0)
			{
				if (addable(i, grid))
				{
					if (state == 1)
					{
						weights[i] = getScore(2, add(i, 2, grid));
					}
					if (state == 0)
					{
						weights[i] = getScore(1, add(i, 1, grid));
					}
				}
				else
				{
					weights[i] = -1;
				}
			}
			else 
			{
				if (addable(i, grid))
				{
					if (state == 1)
					{
						weights[i] = maximize(minimax(0, depth - 1, add(i, 2, grid)));
					}
					if (state == 0)
					{
						weights[i] = minimize(minimax(1, depth - 1, add(i, 1, grid)));
					}
				}
				else
				{
					weights[i] = -1;
				}
			}

		}
		return weights;
	}

	/**
	 * 
	 * @param weights
	 * @return
	 */
	private int minimize(int[] weights)
	{
		int min = Integer.MAX_VALUE;
		for (int i : weights)
		{
			if (i != -1)
			{
				if (i < min)
				{
					min = i;
				}
			}
		}

		return min;
	}

	/**
	 * 
	 * @param weights
	 * @return
	 */
	private int maximize(int[] weights)
	{
		int max = Integer.MIN_VALUE;
		for (int i : weights)
		{
			if (i != -1)
			{
				if (i > max)
				{
					max = i;
				}
			}
		}

		return max;
	}

	/**
	 * 
	 * @param oldGrid
	 * @return
	 */
	private int[][] clone(int[][] oldGrid)
	{
		int[][] grid = new int[oldGrid.length][oldGrid[0].length];
		for (int i = 0; i < grid.length; i++)
		{
			for (int j = 0; j < grid[0].length; j++)
			{
				grid[i][j] = oldGrid[i][j];
			}
		}

		return grid;
	}

	/**
	 * 
	 * @param column
	 * @param player
	 * @param oldGrid
	 * @return
	 */
	private int[][] add(int column, int player, int[][] oldGrid)
	{
		int[][] grid = clone(oldGrid);

		grid[nextOpenRow(column, grid)][column] = player;

		return grid;
	}

	/**
	 * 
	 * @param column
	 * @param grid
	 * @return
	 */
	private boolean addable(int column, int[][] grid)
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
	 * @param grid
	 * @return
	 */
	private int nextOpenRow(int column, int[][] grid)
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
	 * @param grid
	 * @return
	 */
	private int getScore(int player, int[][] grid)
	{
		return getHorizontalScore(player, grid) + getVerticalScore(player, grid) + getDiagonalScore(player, grid);
	}

	/**
	 * 
	 * @param player
	 * @param grid
	 * @return
	 */
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

	/**
	 * 
	 * @param player
	 * @param grid
	 * @return
	 */
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

	/**
	 * 
	 * @param player
	 * @param grid
	 * @return
	 */
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
