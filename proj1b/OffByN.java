public class OffByN implements CharacterComparator {
    private int charDifferenceN;

    public OffByN(int N) {
        charDifferenceN = N;

    }

    @Override
    public boolean equalChars(char x, char y) {
        int difference = x - y;
        return difference == charDifferenceN || difference == -charDifferenceN;

    }

}
