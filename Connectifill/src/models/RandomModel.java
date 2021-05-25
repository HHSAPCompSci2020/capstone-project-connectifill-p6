package models;

import graphics.Board;
import graphics.Game;

/**
 * A Random Model randomly chooses moves on the board, this serves as the "easy" mode of the game
 * @author Rushil Jayant
 * @version 5/25/21
 */
public class RandomModel extends Model {
	
	/**
	 * Randomly makes a move, if move is not vaild, try again until it is valid
	 */
	public void makeMove() {
		Board board = Game.getBoard();
		int column = (int) (Math.random() * board.getWidth());
		if (board.addable(column))
		{
			board.add(column, 2);
		}
		else {
			makeMove();
		}
	}
}
