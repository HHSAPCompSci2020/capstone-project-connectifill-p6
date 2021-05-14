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
	int Rows = 6;
	int Columns = 7;
	//int width = 5; 
	//int height = 6;
	int placerHeight;
	int placerWidth;
	int BUFFER = height /7;

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
		redTurn = false;
		placerHeight = (height - BUFFER)/Rows;
		placerWidth = width / Columns;
	}
	public void draw() 
	{
		background(255);
		displayBoard();
		PlacerPiece();
	}
	public void displayBoard()
	{
		for(int i = 0; i<height;i++)
		{
			for(int j = 0; j<width;j++)
			{
				fill(255);
				rect(j*placerWidth,i*placerHeight+BUFFER, placerWidth, placerHeight);
				rect(j*size,i*size,size,size);
				//if(board[i][j] == EMPTY)
			//	{
					fill(255);
				//	fill(board[i][j]==1?255:0 , board[i][j]==2?255:0,0);
					ellipse(j*placerWidth+ placerWidth/2, i*placerHeight+BUFFER+placerHeight/2,placerHeight-5,placerHeight-5);
			}
				//if(board[i][j] == RED)
				//{
					//fill(255, 0, 0);
				//}
				//if(board[i][j] == GREEN)
				//{
					//fill(0, 128, 0);
				//}
				//ellipse(j*size,i*size,size,size);
				//ellipse(j*placerWidth+ placerWidth/2, i*placerHeight+BUFFER+placerHeight/2,placerHeight-5,placerHeight-5);
			//}
		}
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
			if(column<Columns && board[row][column]==0)
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
