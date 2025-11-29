package elimination;

import java.util.List;
import components.Symbol;


public class PatternEliminator implements Eliminator {
	private List<Symbol[]> patterns;
	
	public PatternEliminator(List<Symbol[]> patterns) {
		this.patterns = patterns;
	}
	
	@Override
	public int eliminateSequence(Symbol[] seq, int blockSize, Symbol nothing) {
		// TODO: Implement pattern-based elimination logic
		return 0;
	}
}
