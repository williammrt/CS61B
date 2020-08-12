import org.junit.Test;

import static org.junit.Assert.*;


public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualchars() {

        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('b', 'c'));
        assertTrue(offByOne.equalChars('y', 'x'));
        assertTrue(offByOne.equalChars('=', '<'));
        assertTrue(offByOne.equalChars('2', '3'));
        assertTrue(offByOne.equalChars('@', 'A'));
        assertTrue(offByOne.equalChars('F', 'G'));
        assertTrue(offByOne.equalChars('Y', 'Z'));
        assertTrue(offByOne.equalChars('@', 'A'));
        assertTrue(offByOne.equalChars('*', '+'));


        assertFalse(offByOne.equalChars('x', 'x'));
        assertFalse(offByOne.equalChars('a', 'A'));
        assertFalse(offByOne.equalChars('<', '>'));
        assertFalse(offByOne.equalChars('a', 'B'));
        assertFalse(offByOne.equalChars('C', 'd'));
        assertFalse(offByOne.equalChars('A', 'z'));


    }


}
