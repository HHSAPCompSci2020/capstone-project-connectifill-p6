package graphics;
import processing.core.PApplet;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
public class Player extends Board
{
	boolean redTurn;
	int[][] board;
	public static final int EMPTY = 0;
	public static final int RED = 1;
	public static final int GREEN = 2;
	int Rows = 12;
	int Columns = 6;
	int width = 12; 
	int height = 6;

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
	public Player()
	{
		board = new int[Rows][Columns];
	}
	public int getRow(int column)
	{
		int row =0;
		if(column < Columns && board[row][column] ==0)
		{
			while(row<board.length && board[row][column] == 0)
			{
				row++;
			}
		}
		return row-1;
	}
	public void mousePressed()
	{

		if(!Win() && redTurn)
		{
			int column = mouseX/(width / Columns);
			int row = 0;
			if(column<Columns)
			{
				while(row < board.length && board[row][column] ==0)
				{
					row++;
				}
				row--;
				if(redTurn)  board[row][column] = RED;
				if(!redTurn)  board[row][column] = GREEN;
				redTurn = !redTurn;
			}
		}
	}
}
