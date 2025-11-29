package gamemode;

import java.util.List;
import java.util.Random;
import components.Symbol;
import elimination.Eliminator;
import acomodator.Accomodator;

/**
 * Multiple reward game implementation.
 * Games whose score is calculated with multiple rewards (multipliers for each elimination phase).
 * Games end when there is no column where a piece can still fit.
 * 
 * @author PCO Team
 */
public class MultipleRewardGame extends AbstractGame {
	private int score;

	public MultipleRewardGame(int r, int c, int diff, Symbol empty,
	                          Symbol[] values, Random gen, Eliminator elim, Accomodator acc) {
		super(r, c, diff, empty, values, gen, elim, acc);
		this.score = 0;
	}
	
	
	@Override
	public void registerPlayScore(List<Integer> eliminated) {
		int multiplier = 1;
		for (Integer count : eliminated) {
			score += count * multiplier;
			multiplier++;
		}
	}
	
	
	@Override
	public int score() {
		return score;
	}
	

	@Override
	public String toString() {
		return area.currentGrid();
	}
}
