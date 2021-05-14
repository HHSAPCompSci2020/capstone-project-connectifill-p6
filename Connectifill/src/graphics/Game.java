package graphics;

import java.awt.Dimension;
import javax.swing.JFrame;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class Game extends PApplet
{

	private Menu menu;
	private Board board;

	private int h;
	private int w;
	private int standard;

	private int[][] grid;

	private boolean gameState;

	public Game()
	{
		menu = new Menu();
		board = new Board();
		gameState = true;
		h = 6;
		w = 12;
		standard = 100;
		grid = new int[6][12];
	}

	public Menu getMenu()
	{
		return menu;
	}

	public Board getBoard()
	{
		return board;
	}

	public void setup()
	{
		ellipseMode(CORNER);
	}

	public void draw()
	{
		if (gameState)
		{
			for (int j = 0; j < h; j++)
			{
				for (int i = 0; i < w; i++)
				{
					fill(255);
					rect(i*standard, j*standard, standard, standard);
					if (grid[j][i] == 1)
					{
						fill(0,255,0);
						ellipse(i*standard, j*standard, standard, standard);
					}
					else if (grid[j][i] == 2)
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

		if(add(column, 1))
		{
			pickRandom();
		}
		System.out.println("Player: " + getScore(1) + " | Computer: " + getScore(2));
	}

	public boolean add(int column, int player)
	{
		if (addable(column))
		{
			grid[nextOpenRow(column)][column] = player;
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean addable(int column)
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

	// Do diagonal scoring
	public int getScore(int player)
	{
		int score = 0;
		for (int i = 0; i <= grid[0].length-4; i++)
		{
			for (int j = 0; j < grid.length; j++)
			{
				if (grid[j][i] == player && grid[j][i + 1] == player && grid[j][i + 2] == player && grid[j][i + 3] == player)
				{
					score++;
				}
			}
		}
		for (int x = 0; x < grid[0].length; x++)
		{
			for (int y = 0; y < grid.length-3; y++)
			{
				if (grid[y][x] == player && grid[y + 1][x] == player && grid[y + 2][x] == player && grid[y + 3][x] == player)
				{
					score++;
				}
			}
		}
		return score;
	}

	public int nextOpenRow(int column)
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

	public void pickRandom() {
		int column = (int) (Math.random() * 12);
		if (addable(column))
		{
			add(column, 2);
		}
		else {
			pickRandom();
		}
	}
	public static void main(String args[])
	{

		Game drawing = new Game();
		PApplet.runSketch(new String[]{""}, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();

		window.setSize(1200, 650);
		window.setMinimumSize(new Dimension(100,100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		window.setVisible(true);
	}

}
