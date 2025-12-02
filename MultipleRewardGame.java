import java.util.List;
import java.util.Random;


public class MultipleRewardGame extends AbstractGame {
	private static final int BASE_SEQUENCE_POINTS = 200;
	private static final int EXTRA_SYMBOL_POINTS = 50;
	private static final int BASE_SEQUENCE_SIZE = 3;
	private int score;

	public MultipleRewardGame(int r, int c, int diff, Symbol empty, Symbol[] values, Random gen, Eliminator elim, Accomodator acc) {
		super(r, c, diff, empty, values, gen, elim, acc);
		this.score = 0;
	}
	
	@Override
	public void registerPlayScore(List<Integer> eliminated) {
		this.score += 10;
		if (eliminated == null || eliminated.isEmpty()) {
			return;
		}

		int multiplier = 1;
		for (Integer count : eliminated) {
			if (count == null || count < BASE_SEQUENCE_SIZE) {
				multiplier++;
				continue;
			}
			int sequencePoints = BASE_SEQUENCE_POINTS + EXTRA_SYMBOL_POINTS * (count - BASE_SEQUENCE_SIZE);
			this.score += sequencePoints * multiplier;
			multiplier++;
		}
	}
	

	@Override
	public int score() {
		return this.score;
	}
	

	@Override
	public String toString() {
		return area.currentGrid();
	}
}