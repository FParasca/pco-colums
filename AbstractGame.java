import java.util.Random;


public abstract class AbstractGame implements Game {
	protected PlayArea area;
	protected Piece currentPiece;
	protected Random generator;
	protected Symbol empty;
	protected Symbol[] symbols;
	
	public AbstractGame(int r, int c, int diff, Symbol empty, Symbol[] values, Random gen, Eliminator elim, Accomodator acc) {
		this.area = new PlayArea(r, c, diff, empty, values, gen, elim, acc);
		this.generator = gen;
		this.empty = empty;
		this.symbols = values;
	}
	
	@Override
	public int linesInGrid() {
		return area.gridDimensions()[0];
	}
	
	@Override
	public int colsInGrid() {
		return area.gridDimensions()[1];
	}
	
	@Override
	public void permutatePiece(int n) {
		if (currentPiece != null) {
			currentPiece.permutation(n);
		}
	}
	
	@Override
	public void placePiece(int col) {
		area.placePiece(currentPiece, col - 1);
		registerPlayScore(area.eliminateAccomodateAll(SIZE_OF_PIECE));
	}
	
	@Override
	public void generatePiece() {
		this.currentPiece = new Piece(generator, SIZE_OF_PIECE, empty, symbols);
	}
	
	@Override
	public int spaceInColumn(int col) {
		return area.spaceInColumn(col - 1);
	}
	
	@Override
	public Piece currentPiece() {
		return currentPiece;
	}
	
	@Override
	public boolean finished() {
		return !area.hasEnoughSpace(SIZE_OF_PIECE);
	}
	
	@Override
	public String toString() {
		return area.currentGrid();
	}
}
