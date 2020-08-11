import org.junit.Test;

import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testPalindromeWord() {
        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("abab"));
        assertFalse(palindrome.isPalindrome("aaaaab"));
        assertFalse(palindrome.isPalindrome("=caw"));


        assertTrue(palindrome.isPalindrome("abba"));
        assertTrue(palindrome.isPalindrome("qaq"));
        assertTrue(palindrome.isPalindrome("wwwww"));
        assertTrue(palindrome.isPalindrome("hahahahahah"));
        assertTrue(palindrome.isPalindrome("n"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("=q="));


    }

    @Test
    public void testOverloadedPalindrome() {
        assertTrue(palindrome.isPalindrome("", new OffByOne()));
        assertTrue(palindrome.isPalindrome("n", new OffByOne()));
        assertTrue(palindrome.isPalindrome("abab", new OffByOne()));
        assertTrue(palindrome.isPalindrome("aabb", new OffByOne()));
        assertTrue(palindrome.isPalindrome("detrude", new OffByOne()));
        assertTrue(palindrome.isPalindrome("", new OffByOne()));
        assertTrue(palindrome.isPalindrome("<=", new OffByOne()));
        assertTrue(palindrome.isPalindrome("AB", new OffByOne()));


        assertFalse(palindrome.isPalindrome("aaaaab", new OffByOne()));
        assertFalse(palindrome.isPalindrome("qaq", new OffByOne()));
        assertFalse(palindrome.isPalindrome("apple", new OffByOne()));
        assertFalse(palindrome.isPalindrome("abba", new OffByOne()));
        assertFalse(palindrome.isPalindrome("=<=", new OffByOne()));
        assertFalse(palindrome.isPalindrome("aB", new OffByOne()));


    }

}
