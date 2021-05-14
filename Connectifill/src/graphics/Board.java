package graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

import javax.swing.JFrame;

import processing.core.PApplet;



public class Board extends PApplet {

	int width = 12; 
	int height = 6;
	int size = 100;	
	int[][]board = new int[height][width];
	public void setup()
	{
		size(1200,600);
		ellipseMode(CORNER);
	}
	public void draw() { 
		//background(255);
		for(int i = 0; i<height;i++)
		{
			for(int j = 0; j<width;j++)
			{
				fill(255);
				rect(j*size,i*size,size,size);
				if(board[i][j]>0)
				{
					fill(board[i][j]==1?255:0 , board[i][j]==2?255:0,0);
					ellipse(j*size,i*size,size,size);
				}
			}
		}
		//textAlign(LEFT);
		//textSize(12);
	
		
	}
}
