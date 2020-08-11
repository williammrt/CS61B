public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char a, char b) {
        int difference = a - b;
        return a == 1 || a == -1;
    }
}
