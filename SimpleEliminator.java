public class SimpleEliminator implements Eliminator {

    @Override
    public int eliminateSequence(Symbol[] seq, int blockSize, Symbol nothing) {

        int eliminated = 0;
        int i = 0;

        while (i < seq.length) {

            Symbol current = seq[i];
            int start = i;
            int count = 1;

            i++;
            while (i < seq.length && seq[i].equals(current)) {
                count++;
                i++;
            }

            if (!current.equals(nothing) && count >= blockSize) {
                for (int k = start; k < start + count; k++) {
                    seq[k] = nothing;
                }
                eliminated += count;
            }
        }

        return eliminated;
    }
}

