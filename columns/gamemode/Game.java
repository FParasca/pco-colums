package gamemode;

import components.Piece;
import java.util.List;


public interface Game {
	static final int SIZE_OF_PIECE = 3;
	
	int linesInGrid();
	int colsInGrid();
	void permutatePiece(int n);
	void placePiece(int column);
	void generatePiece();
	int spaceInColumn(int column);
	boolean finished();
	Piece currentPiece();
	void registerPlayScore(List<Integer> eliminated);
	int score();
	String toString();
}

