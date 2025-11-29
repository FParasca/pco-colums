package acomodator;

import components.Symbol;

/**
 * Fatal fall implementation of Accomodator
 */
public class FatalFallAccomodator implements Accomodator {
	private int threshold;
	
	public FatalFallAccomodator(int threshold) {
		this.threshold = threshold;
	}
	
	@Override
	public void accomodate(Symbol[] seq, Symbol nothing) {
		// TODO: Implement fatal fall accommodation logic
	}
}
