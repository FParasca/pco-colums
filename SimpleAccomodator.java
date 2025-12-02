public class SimpleAccomodator implements Accomodator {
    
    public SimpleAccomodator() {
    }
    
    @Override
    public void accomodate(Symbol[] seq, Symbol nothing) {
        if (seq == null || seq.length == 0) {
            return;
        }


        int wIndex = 0;
        
        for (int rIndex = 0; rIndex < seq.length; rIndex++) {
            if (seq[rIndex] != nothing) {
                seq[wIndex] = seq[rIndex];
                wIndex++;
            }
        }
        
        for (int i = wIndex; i < seq.length; i++) {
            seq[i] = nothing;
        }
    }
}