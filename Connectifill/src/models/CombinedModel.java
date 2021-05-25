package models;

/**
 * The Combined Model is a combination of the AggressiveModel and DefensiveModel, simulating how real life decisions are made
 * @author Rushil Jayant
 * @version 5/25/21
 */
public class CombinedModel extends Model {

	private AggressiveModel aggressiveModel;
	private DefensiveModel defensiveModel;

	/**
	 * CombinedModel Class Constructor
	 */
	public CombinedModel() {
		aggressiveModel = new AggressiveModel();
		defensiveModel = new DefensiveModel();
	}

	/**
	 * Makes the next move based on method's methodology
	 */
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
