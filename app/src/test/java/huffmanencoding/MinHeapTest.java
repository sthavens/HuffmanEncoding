package huffmanencoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MinHeapTest {
    MinHeap<ResizeableArray<Character>> testHeap;

    @Test
    void testGetLeftChild() {
        assertEquals(3, testHeap.getLeftChild(1));
    }

    @BeforeEach
    void setUp() {
        testHeap = new MinHeap<>();    
    }

    @Test
    void testGetParent() {
        assertEquals(1, testHeap.getParent(3));
        assertEquals(1, testHeap.getParent(4));
    }

    @Test
    void testGetRightChild() {
        assertEquals(4, testHeap.getRightChild(1));
    }

    @Test
    void testPop() {
        for (char character = 'c'; character >= 'a'; character--) {
            testHeap.push((int) character, new ResizeableArray<Character>(new Character[]{character}));
        }
        assertEquals("a", testHeap.pop().getData().toString());
        assertEquals("b", testHeap.pop().getData().toString());
        assertEquals("c", testHeap.pop().getData().toString());
    }

    @Test
    void testOrdering() {
        testHeap.push((int) '1', new ResizeableArray<Character>(new Character[]{'A'}));
        testHeap.push((int) '4', new ResizeableArray<Character>(new Character[]{'D'}));
        testHeap.push((int) '3', new ResizeableArray<Character>(new Character[]{'C'}));
        testHeap.push((int) '5', new ResizeableArray<Character>(new Character[]{'E'}));
        testHeap.push((int) '2', new ResizeableArray<Character>(new Character[]{'B'}));
        assertEquals("A", testHeap.pop().getData().toString());
        assertEquals("B", testHeap.pop().getData().toString());
        assertEquals("C", testHeap.pop().getData().toString());
        assertEquals("D", testHeap.pop().getData().toString());
        assertEquals("E", testHeap.pop().getData().toString());
    }

    @Test
    void testPush() {
        testHeap.push((int) '1', new ResizeableArray<Character>(new Character[]{'A'}));
        assertEquals(1, testHeap.length());
    }
}
