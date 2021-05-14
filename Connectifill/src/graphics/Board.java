package graphics;

public class Board 
{
	private static int row=12;
	private static int column = 6;
	Piece [][]grid = new Piece[row][column];
	
	public Display()
	{
		for(int r = 0; r < row;r++)
		{
			
		}
	}
	public Board()
	{
		for(int r = 0; r<row; r++)
		{
			for(int c = 0; c<column; c++)
			{
				grid[r][c] = null;
			}
		}
	}
}
