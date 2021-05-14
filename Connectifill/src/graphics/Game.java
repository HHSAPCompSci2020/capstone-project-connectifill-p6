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
						fill(255,0,0);
						ellipse(i*standard, j*standard, standard, standard);
					}
					else if (grid[j][i] == 2)
					{
						fill(0,255,0);
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
