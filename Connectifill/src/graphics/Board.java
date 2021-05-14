package graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

import javax.swing.JFrame;

import processing.core.PApplet;



public class Board extends PApplet 
{

	int width = 6; 
	int height = 7;
	int size = 100;	
	public static final int EMPTY = 0;
	public static final int RED = 1;
	public static final int GREEN = 2;
	int placerHeight;
	int placerWidth;
	int BUFFER = height /7;
	boolean redTurn;
	int[][]board = new int[height][width];
	
	public void settings()
	{
		size(640,480);
	}
	
	Player boardGame;
	public void setup()
	{
		ellipseMode(CORNER);
		board[0][0]=1;
		board[1][1]=2;
		boardGame = new Player();
	}
	
	public void mouseClicked()
	{
		boardGame.mousePressed();
	}
	public void PlacerPiece()
	{
		if(redTurn)
		{
			fill(255,0,0);
			ellipse((mouseX/placerWidth)*placerWidth +placerWidth/2, placerHeight/2,placerHeight-5,placerHeight-5);
		}
	}
	public void draw() 
	{
		boardGame.draw();
		//background(255);
		//displayBoard();
		//PlacerPiece();
	}
	/*
	public void displayBoard()
	{
		for(int i = 0; i<height;i++)
		{
			for(int j = 0; j<width;j++)
			{
				fill(255);
				rect(j*placerWidth,i*placerHeight+BUFFER, placerWidth, placerHeight);
				//rect(j*size,i*size,size,size);
				if(board[i][j] == EMPTY)
				{
					fill(255);
					//fill(board[i][j]==1?255:0 , board[i][j]==2?255:0,0);
				}
				if(board[i][j] == RED)
				{
					fill(255, 0, 0);
				}
				if(board[i][j] == GREEN)
				{
					fill(0, 128, 0);
				}
				//ellipse(j*size,i*size,size,size);
				ellipse(j*placerWidth+ placerWidth/2, i*placerHeight+BUFFER+placerHeight/2,placerHeight-5,placerHeight-5);
			}
		}
	}
	*/
		//textAlign(LEFT);
		//textSize(12);
}
