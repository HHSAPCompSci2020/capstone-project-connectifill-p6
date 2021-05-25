package models;

import graphics.Board;
import graphics.Game;

public class RandomModel extends Model {
	
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
