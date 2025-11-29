package gamemode;

import java.util.List;
import java.util.Random;
import components.Symbol;
import elimination.Eliminator;
import acomodator.Accomodator;


public class SingleScoreGame extends AbstractGame {
	private int score;

	public SingleScoreGame(int r, int c, int diff, Symbol empty, Symbol[] values, Random gen, Eliminator elim, Accomodator acc) {
		super(r, c, diff, empty, values, gen, elim, acc);
		this.score = 0;
	}

	@Override
	public void registerPlayScore(List<Integer> eliminated) {
		score += 10;
	}

	@Override
	public int score() {
		return score;
	}
	

	@Override
	public boolean finished() {
		if (isAreaEmpty()) {
			return true;
		}
		return !area.hasEnoughSpace(SIZE_OF_PIECE);
	}
	

	@Override
	public String toString() {
		return area.currentGrid();
	}
	private boolean isAreaEmpty() {
		int rows = area.gridDimensions()[0];
		int cols = area.gridDimensions()[1];	
		if (rows == 0 || cols == 0) {
			return true;
		}
		
		for (int col = 0; col < cols; col++) {
			if (area.spaceInColumn(col) != rows) {
				return false;
			}
		}
		return true;
	}
}
