package models;

public class CombinedModel extends Model {

	private AggressiveModel aggressiveModel;
	private DefensiveModel defensiveModel;

	/**
	 * 
	 */
	public CombinedModel() {
		aggressiveModel = new AggressiveModel();
		defensiveModel = new DefensiveModel();
	}

	public void makeMove() {
		int random = (int) Math.random() * 2;
		if (random == 0)
		{
			aggressiveModel.makeMove();
		}
		else
		{
			defensiveModel.makeMove();
		}
	}

}
