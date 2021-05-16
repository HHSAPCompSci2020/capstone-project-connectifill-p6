package graphics;

import java.awt.Dimension;
import javax.swing.JFrame;

import models.Model;
import models.RandomModel;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class Game extends PApplet
{

	private static Board board;
	private static Model model;

	private int standard;

	private boolean gameState;

	public Game()
	{
		board = new Board(12, 6);
		model = new RandomModel();
		gameState = true;
		standard = 100;
	}

	public void setup()
	{
		ellipseMode(CORNER);
	}

	public void draw()
	{
		if (gameState)
		{
			for (int j = 0; j < board.getHeight(); j++)
			{
				for (int i = 0; i < board.getWidth(); i++)
				{
					fill(255);
					rect(i*standard, j*standard, standard, standard);
					if (board.getValue(j, i) == 1)
					{
						fill(0,255,0);
						ellipse(i*standard, j*standard, standard, standard);
					}
					else if (board.getValue(j, i) == 2)
					{
						fill(255,0,0);
						ellipse(i*standard, j*standard, standard, standard);
					}
				}
			}
		}
		else
		{
			background(255);   // Clear the screen with a white background
			fill(255);
			textAlign(CENTER);
		}
	}

	public void mousePressed() {
		int column = mouseX/standard;

		if(board.add(column, 1))
		{
			model.makeMove();
		}
		System.out.println("Player: " + board.getScore(1) + " | Computer: " + board.getScore(2));
	}
	
	public static Board getBoard()
	{
		return board;
	}
	
	public static Model getModel()
	{
		return model;
	}

	public static void main(String args[])
	{

		Game drawing = new Game();
		PApplet.runSketch(new String[]{""}, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();

		window.setSize(1200, 650); // Fix Dimensions
		window.setMinimumSize(new Dimension(100,100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		window.setVisible(true);
	}

}
