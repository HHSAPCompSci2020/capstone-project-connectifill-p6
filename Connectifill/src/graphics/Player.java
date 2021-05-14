package graphics;

public class Player {
	boolean redTurn;
	int[][] board;
	public static final int EMPTY = 0;
	public static final int RED = 1;
	public static final int GREEN = 2;
	int Rows = 12;
	int Columns = 6;

	public boolean horizontalWin() {
		boolean result = false;
		// code for horizontal win
		return result;
	}

	public boolean verticalWin() {
		boolean result = false;
		// code for vertical win
		return result;
	}

	public boolean diagonalWin() {
		boolean result = false;
		// code for diagonal win
		return result;
	}

	public boolean Win()
	{
		if(horizontalWin())
		{
			return true;
		}
		if(verticalWin())
		{
			return true;
		}
		if(diagonalWin())
		{
			return true;
		}
		return false;
	}
}
