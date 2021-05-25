package graphics;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import models.AggressiveModel;
import models.CombinedModel;
import models.DefensiveModel;
import models.MiniMaxModel;
import models.Model;
import models.RandomModel;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
import processing.core.PFont;

public class Game extends PApplet
{

	private static Board board;
	private static Model model;

	private int standard;

	private boolean gameState;

	public Game()
	{
		board = new Board(24, 12);
		gameState = true;
		standard = 50;
	}

	public void setup()
	{
		ellipseMode(CORNER);
	}

	public void draw()
	{
		PFont scoreboard;
		scoreboard = createFont("SansSerif",100,true);
		textFont(scoreboard,32); 
		background(255);
		fill(0);

		text("Player: " + board.getScore(1) +" | Computer: " + board.getScore(2),452,650);

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

	public void mousePressed() 
	{
		int column = mouseX/standard;

		if(board.add(column, 1))
		{
			model.makeMove();
		}
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
		String[] options = {"Random Model", "MiniMax Model", "Defensive Model", "Combined Model", "Aggressive Model"};
		String n = (String)JOptionPane.showInputDialog(null, "What model do you want to play against?", 
				"Connectifill", JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
		if (n.equals(options[0]))
		{
			model = new RandomModel();
		}
		if (n.equals(options[1]))
		{
			model = new MiniMaxModel();
		}
		if (n.equals(options[2]))
		{
			model = new DefensiveModel();
		}
		if (n.equals(options[3]))
		{
			model = new CombinedModel();
		}
		if (n.equals(options[4]))
		{
			model = new AggressiveModel();
		}

		Game drawing = new Game();
		PApplet.runSketch(new String[]{""}, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();

		window.setSize(1200, 750); // Fix Dimensions
		window.setMinimumSize(new Dimension(100,100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		window.setVisible(true);
	}

}
