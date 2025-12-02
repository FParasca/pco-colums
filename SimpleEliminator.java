public class SimpleEliminator implements Eliminator {

	public SimpleEliminator() {
	}
	
	@Override
	public int eliminateSequence(Symbol[] seq, int blockSize, Symbol nothing) {
		if (seq == null || seq.length == 0) {
			return 0;
		}
		
		int eliminatedCount = 0;
		int start = 0;
		
		while (start < seq.length) {
			Symbol currentSymbol = seq[start];
			if (currentSymbol == nothing) {
				start++;
				continue;
			}

			int end = start;
			while (end < seq.length && seq[end] == currentSymbol) {
				end++;
			}
			
			int sequenceLength = end - start;
			if (sequenceLength >= blockSize) {
				for (int i = start; i < end; i++) {
					seq[i] = nothing;
					eliminatedCount++;
				}
			}
			start = end;
		}
		
		return eliminatedCount;
	}
}
