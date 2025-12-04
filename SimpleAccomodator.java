public class SimpleAccomodator implements Accomodator {

    @Override
    public void accomodate(Symbol[] seq, Symbol nothing) {

        Symbol[] temp = new Symbol[seq.length];
        int pos = seq.length - 1; 


        for (int i = seq.length - 1; i >= 0; i--) {
            if (!seq[i].equals(nothing)) {
                temp[pos] = seq[i];
                pos--;
            }
        }

        while (pos >= 0) {
            temp[pos] = nothing;
            pos--;
        }

        for (int i = 0; i < seq.length; i++) {
            seq[i] = temp[i];
        }
    }
}

