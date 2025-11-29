package elimination;

import components.Symbol;


public interface Eliminator {
	int eliminateSequence(Symbol[] seq, int blockSize, Symbol nothing);
}
