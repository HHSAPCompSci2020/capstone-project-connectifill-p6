package models;

import graphics.Board;
import graphics.Game;

public class RandomModel extends Model {

	public RandomModel() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void makeMove() {
		Board board = Game.getBoard();
		int column = (int) (Math.random() * 12);
		if (board.addable(column))
		{
			board.add(column, 2);
		}
		else {
			makeMove();
		}
	}
}
