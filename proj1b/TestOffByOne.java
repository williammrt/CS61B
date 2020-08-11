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


        assertFalse(offByOne.equalChars('x', 'x'));
        assertFalse(offByOne.equalChars('a', 'A'));
        assertFalse(offByOne.equalChars('<', '>'));

    }


}
