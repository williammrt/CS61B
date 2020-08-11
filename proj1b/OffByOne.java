public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char a, char b) {
        int difference = a - b;

        return difference == 1 || difference == -1;
    }
}
