

public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> chars = new LinkedListDeque<>();
        for (char ch : word.toCharArray()) {
            chars.addLast(ch);
        }

        return chars;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> chars = wordToDeque(word);
        while (chars.size() > 1) {
            char leftChar = chars.removeFirst();
            char rightChar = chars.removeLast();
            if (leftChar != rightChar) {
                return false;
            }

        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> chars = wordToDeque(word);

        while (chars.size() > 1) {
            char leftChar = chars.removeFirst();
            char rightChar = chars.removeLast();
            if (!cc.equalChars(leftChar, rightChar)) {
                return false;
            }

        }
        return true;


    }
}
